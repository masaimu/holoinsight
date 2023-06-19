/*
 * Copyright 2022 Holoinsight Project Authors. Licensed under Apache-2.0.
 */
package io.holoinsight.server.home.web.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.unfbx.chatgpt.entity.chat.ChatChoice;
import com.unfbx.chatgpt.entity.chat.ChatCompletion;
import com.unfbx.chatgpt.entity.chat.ChatCompletionResponse;
import com.unfbx.chatgpt.entity.chat.FunctionCall;
import com.unfbx.chatgpt.entity.chat.Message;
import io.holoinsight.server.common.J;
import io.holoinsight.server.common.JsonResult;
import io.holoinsight.server.home.common.util.scope.AuthTargetType;
import io.holoinsight.server.home.common.util.scope.PowerConstants;
import io.holoinsight.server.home.web.common.TokenUrls;
import io.holoinsight.server.home.web.interceptor.MonitorScopeAuth;
import io.holoinsight.server.home.web.openai.FunctionRegistry;
import io.holoinsight.server.home.web.openai.OpenAiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MethodInvoker;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author masaimu
 * @version 2023-06-15 20:37:00
 */
@Slf4j
@RestController
@RequestMapping("/webapi/gpt")
@TokenUrls("/webapi/gpt")
public class GPTFacadeImpl extends BaseFacade {

  @Autowired
  private FunctionRegistry functionRegistry;

  @PostMapping("/console")
  @ResponseBody
  @MonitorScopeAuth(targetType = AuthTargetType.TENANT, needPower = PowerConstants.EDIT)
  public JsonResult<String> save(@RequestBody Map<String, Object> request)
      throws JsonProcessingException, ClassNotFoundException, NoSuchMethodException,
      InvocationTargetException, IllegalAccessException {
    String content = (String) request.get("content");
    Message message = Message.builder().role(Message.Role.USER).content(content).build();

    ChatCompletion chatCompletion = ChatCompletion.builder().messages(Arrays.asList(message))
        .functions(this.functionRegistry.getFunctions()).functionCall("auto")
        .model(ChatCompletion.Model.GPT_3_5_TURBO_16K_0613.getName()).build();
    log.info("First chatCompletion {}", J.toJson(chatCompletion));
    ChatCompletionResponse chatCompletionResponse =
        OpenAiService.getInstance().getClient().chatCompletion(chatCompletion);

    ChatChoice chatChoice = chatCompletionResponse.getChoices().get(0);
    Message msg = chatChoice.getMessage();
    FunctionCall functionCallResult = msg.getFunctionCall();
    if (functionCallResult == null) {
      return JsonResult.createSuccessResult(msg.getContent());
    }
    String functionName = functionCallResult.getName();
    String arguments = functionCallResult.getArguments();
    log.info("FunctionCall {}", functionCallResult);
    log.info("functionName {}", functionName);
    log.info("arguments {}", arguments);
    Map<String, Object> paramMap =
        J.toMap(chatChoice.getMessage().getFunctionCall().getArguments());

    MethodInvoker invoker = new MethodInvoker();
    invoker.setTargetObject(this.functionRegistry);
    invoker.setTargetMethod(functionName);
    invoker.setArguments(paramMap);
    invoker.prepare();
    String result = (String) invoker.invoke();

    log.info("invoke result {}", result);

    if (StringUtils.isEmpty(result)) {
      result = "The execution of function calling failed because the execution result is empty.";
    }

    FunctionCall functionCall = FunctionCall.builder() //
        .arguments(arguments) //
        .name(functionName) //
        .build();
    Message message2 = Message.builder().role(Message.Role.ASSISTANT).content("方法参数")
        .functionCall(functionCall).build();
    Message message3 =
        Message.builder().role(Message.Role.FUNCTION).name(functionName).content(result).build();
    List<Message> messageList = Arrays.asList(message, message2, message3);
    ChatCompletion chatCompletionV2 = ChatCompletion.builder().messages(messageList)
        .model(ChatCompletion.Model.GPT_3_5_TURBO_16K_0613.getName()).build();
    ChatCompletionResponse chatCompletionResponseV2 =
        OpenAiService.getInstance().getClient().chatCompletion(chatCompletionV2);
    log.info("chatCompletionResponseV2 {}",
        chatCompletionResponseV2.getChoices().get(0).getMessage().getContent());
    return JsonResult.createSuccessResult(
        chatCompletionResponseV2.getChoices().get(0).getMessage().getContent());
  }
}
