/*
 * Copyright 2022 Holoinsight Project Authors. Licensed under Apache-2.0.
 */
package io.holoinsight.server.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.holoinsight.server.common.dao.entity.AlarmWebhook;
import io.holoinsight.server.common.dao.entity.dto.AlarmWebhookDTO;
import io.holoinsight.server.common.MonitorPageRequest;
import io.holoinsight.server.common.MonitorPageResult;

import java.util.List;

/**
 * @author wangsiyuan
 * @date 2022/6/15 4:56 下午
 */
public interface AlertWebhookService extends IService<AlarmWebhook> {

  AlarmWebhookDTO save(AlarmWebhookDTO AlarmWebhookDTO);

  Boolean updateById(AlarmWebhookDTO AlarmWebhookDTO);

  AlarmWebhookDTO queryById(Long id, String tenant);

  MonitorPageResult<AlarmWebhookDTO> getListByPage(MonitorPageRequest<AlarmWebhookDTO> pageRequest);

  List<AlarmWebhookDTO> getListByKeyword(String keyword, String tenant);
}
