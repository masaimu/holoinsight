/*
 * Copyright 2022 Holoinsight Project Authors. Licensed under Apache-2.0.
 */
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: trace/Tracing.proto

package io.holoinsight.server.storage.grpc.trace;

public interface SpanObjectOrBuilder extends
    // @@protoc_insertion_point(interface_extends:io.holoinsight.server.storage.grpc.trace.SpanObject)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The number id of the span. Should be unique in the whole segment.
   * Starting at 0.
   * </pre>
   *
   * <code>int32 spanId = 1;</code>
   */
  int getSpanId();

  /**
   * <pre>
   * The number id of the parent span in the whole segment.
   * -1 represents no parent span.
   * Also, be known as the root/first span of the segment.
   * </pre>
   *
   * <code>int32 parentSpanId = 2;</code>
   */
  int getParentSpanId();

  /**
   * <pre>
   * Start timestamp in milliseconds of this span,
   * measured between the current time and midnight, January 1, 1970 UTC.
   * </pre>
   *
   * <code>int64 startTime = 3;</code>
   */
  long getStartTime();

  /**
   * <pre>
   * End timestamp in milliseconds of this span,
   * measured between the current time and midnight, January 1, 1970 UTC.
   * </pre>
   *
   * <code>int64 endTime = 4;</code>
   */
  long getEndTime();

  /**
   * <pre>
   * &lt;Optional&gt;
   * In the across thread and across process, these references targeting the parent segments.
   * The references usually have only one element, but in batch consumer case, such as in MQ or async batch process, it could be multiple.
   * </pre>
   *
   * <code>repeated .io.holoinsight.server.storage.grpc.trace.SegmentReference refs = 5;</code>
   */
  java.util.List<io.holoinsight.server.storage.grpc.trace.SegmentReference> 
      getRefsList();
  /**
   * <pre>
   * &lt;Optional&gt;
   * In the across thread and across process, these references targeting the parent segments.
   * The references usually have only one element, but in batch consumer case, such as in MQ or async batch process, it could be multiple.
   * </pre>
   *
   * <code>repeated .io.holoinsight.server.storage.grpc.trace.SegmentReference refs = 5;</code>
   */
  io.holoinsight.server.storage.grpc.trace.SegmentReference getRefs(int index);
  /**
   * <pre>
   * &lt;Optional&gt;
   * In the across thread and across process, these references targeting the parent segments.
   * The references usually have only one element, but in batch consumer case, such as in MQ or async batch process, it could be multiple.
   * </pre>
   *
   * <code>repeated .io.holoinsight.server.storage.grpc.trace.SegmentReference refs = 5;</code>
   */
  int getRefsCount();
  /**
   * <pre>
   * &lt;Optional&gt;
   * In the across thread and across process, these references targeting the parent segments.
   * The references usually have only one element, but in batch consumer case, such as in MQ or async batch process, it could be multiple.
   * </pre>
   *
   * <code>repeated .io.holoinsight.server.storage.grpc.trace.SegmentReference refs = 5;</code>
   */
  java.util.List<? extends io.holoinsight.server.storage.grpc.trace.SegmentReferenceOrBuilder> 
      getRefsOrBuilderList();
  /**
   * <pre>
   * &lt;Optional&gt;
   * In the across thread and across process, these references targeting the parent segments.
   * The references usually have only one element, but in batch consumer case, such as in MQ or async batch process, it could be multiple.
   * </pre>
   *
   * <code>repeated .io.holoinsight.server.storage.grpc.trace.SegmentReference refs = 5;</code>
   */
  io.holoinsight.server.storage.grpc.trace.SegmentReferenceOrBuilder getRefsOrBuilder(
      int index);

  /**
   * <pre>
   * A logic name represents this span.
   * We don't recommend to include the parameter, such as HTTP request parameters, as a part of the operation, especially this is the name of the entry span.
   * All statistic for the endpoints are aggregated base on this name. Those parameters should be added in the tags if necessary.
   * If in some cases, it have to be a part of the operation name,
   * users should use the Group Parameterized Endpoints capability at the backend to get the meaningful metrics.
   * Read https://github.com/apache/skywalking/blob/master/docs/en/setup/backend/endpoint-grouping-rules.md
   * </pre>
   *
   * <code>string operationName = 6;</code>
   */
  java.lang.String getOperationName();
  /**
   * <pre>
   * A logic name represents this span.
   * We don't recommend to include the parameter, such as HTTP request parameters, as a part of the operation, especially this is the name of the entry span.
   * All statistic for the endpoints are aggregated base on this name. Those parameters should be added in the tags if necessary.
   * If in some cases, it have to be a part of the operation name,
   * users should use the Group Parameterized Endpoints capability at the backend to get the meaningful metrics.
   * Read https://github.com/apache/skywalking/blob/master/docs/en/setup/backend/endpoint-grouping-rules.md
   * </pre>
   *
   * <code>string operationName = 6;</code>
   */
  com.google.protobuf.ByteString
      getOperationNameBytes();

  /**
   * <pre>
   * Remote address of the peer in RPC/MQ case.
   * This is required when spanType = Exit, as it is a part of the SkyWalking STAM(Streaming Topology Analysis Method).
   * For more details, read https://wu-sheng.github.io/STAM/
   * </pre>
   *
   * <code>string peer = 7;</code>
   */
  java.lang.String getPeer();
  /**
   * <pre>
   * Remote address of the peer in RPC/MQ case.
   * This is required when spanType = Exit, as it is a part of the SkyWalking STAM(Streaming Topology Analysis Method).
   * For more details, read https://wu-sheng.github.io/STAM/
   * </pre>
   *
   * <code>string peer = 7;</code>
   */
  com.google.protobuf.ByteString
      getPeerBytes();

  /**
   * <pre>
   * Span type represents the role in the RPC context.
   * </pre>
   *
   * <code>.io.holoinsight.server.storage.grpc.trace.SpanType spanType = 8;</code>
   */
  int getSpanTypeValue();
  /**
   * <pre>
   * Span type represents the role in the RPC context.
   * </pre>
   *
   * <code>.io.holoinsight.server.storage.grpc.trace.SpanType spanType = 8;</code>
   */
  io.holoinsight.server.storage.grpc.trace.SpanType getSpanType();

  /**
   * <pre>
   * Span layer represent the component tech stack, related to the network tech.
   * </pre>
   *
   * <code>.io.holoinsight.server.storage.grpc.trace.SpanLayer spanLayer = 9;</code>
   */
  int getSpanLayerValue();
  /**
   * <pre>
   * Span layer represent the component tech stack, related to the network tech.
   * </pre>
   *
   * <code>.io.holoinsight.server.storage.grpc.trace.SpanLayer spanLayer = 9;</code>
   */
  io.holoinsight.server.storage.grpc.trace.SpanLayer getSpanLayer();

  /**
   * <pre>
   * Component id is a predefinited number id in the SkyWalking.
   * It represents the framework, tech stack used by this tracked span, such as Spring.
   * All IDs are defined in the https://github.com/apache/skywalking/blob/master/oap-server/server-bootstrap/src/main/resources/component-libraries.yml
   * Send a pull request if you want to add languages, components or mapping defintions,
   * all public components could be accepted.
   * Follow this doc for more details, https://github.com/apache/skywalking/blob/master/docs/en/guides/Component-library-settings.md
   * </pre>
   *
   * <code>int32 componentId = 10;</code>
   */
  int getComponentId();

  /**
   * <pre>
   * The status of the span. False means the tracked execution ends in the unexpected status.
   * This affects the successful rate statistic in the backend.
   * Exception or error code happened in the tracked process doesn't mean isError == true, the implementations of agent plugin and tracing SDK make the final decision.
   * </pre>
   *
   * <code>bool isError = 11;</code>
   */
  boolean getIsError();

  /**
   * <pre>
   * String key, String value pair.
   * Tags provides more informance, includes parameters.
   * In the OAP backend analysis, some special tag or tag combination could provide other advanced features.
   * https://github.com/apache/skywalking/blob/master/docs/en/guides/Java-Plugin-Development-Guide.md#special-span-tags
   * </pre>
   *
   * <code>repeated .io.holoinsight.server.storage.grpc.common.KeyStringValuePair tags = 12;</code>
   */
  java.util.List<io.holoinsight.server.storage.grpc.common.KeyStringValuePair> 
      getTagsList();
  /**
   * <pre>
   * String key, String value pair.
   * Tags provides more informance, includes parameters.
   * In the OAP backend analysis, some special tag or tag combination could provide other advanced features.
   * https://github.com/apache/skywalking/blob/master/docs/en/guides/Java-Plugin-Development-Guide.md#special-span-tags
   * </pre>
   *
   * <code>repeated .io.holoinsight.server.storage.grpc.common.KeyStringValuePair tags = 12;</code>
   */
  io.holoinsight.server.storage.grpc.common.KeyStringValuePair getTags(int index);
  /**
   * <pre>
   * String key, String value pair.
   * Tags provides more informance, includes parameters.
   * In the OAP backend analysis, some special tag or tag combination could provide other advanced features.
   * https://github.com/apache/skywalking/blob/master/docs/en/guides/Java-Plugin-Development-Guide.md#special-span-tags
   * </pre>
   *
   * <code>repeated .io.holoinsight.server.storage.grpc.common.KeyStringValuePair tags = 12;</code>
   */
  int getTagsCount();
  /**
   * <pre>
   * String key, String value pair.
   * Tags provides more informance, includes parameters.
   * In the OAP backend analysis, some special tag or tag combination could provide other advanced features.
   * https://github.com/apache/skywalking/blob/master/docs/en/guides/Java-Plugin-Development-Guide.md#special-span-tags
   * </pre>
   *
   * <code>repeated .io.holoinsight.server.storage.grpc.common.KeyStringValuePair tags = 12;</code>
   */
  java.util.List<? extends io.holoinsight.server.storage.grpc.common.KeyStringValuePairOrBuilder> 
      getTagsOrBuilderList();
  /**
   * <pre>
   * String key, String value pair.
   * Tags provides more informance, includes parameters.
   * In the OAP backend analysis, some special tag or tag combination could provide other advanced features.
   * https://github.com/apache/skywalking/blob/master/docs/en/guides/Java-Plugin-Development-Guide.md#special-span-tags
   * </pre>
   *
   * <code>repeated .io.holoinsight.server.storage.grpc.common.KeyStringValuePair tags = 12;</code>
   */
  io.holoinsight.server.storage.grpc.common.KeyStringValuePairOrBuilder getTagsOrBuilder(
      int index);

  /**
   * <pre>
   * String key, String value pair with an accurate timestamp.
   * Logging some events happening in the context of the span duration.
   * </pre>
   *
   * <code>repeated .io.holoinsight.server.storage.grpc.trace.Log logs = 13;</code>
   */
  java.util.List<io.holoinsight.server.storage.grpc.trace.Log> 
      getLogsList();
  /**
   * <pre>
   * String key, String value pair with an accurate timestamp.
   * Logging some events happening in the context of the span duration.
   * </pre>
   *
   * <code>repeated .io.holoinsight.server.storage.grpc.trace.Log logs = 13;</code>
   */
  io.holoinsight.server.storage.grpc.trace.Log getLogs(int index);
  /**
   * <pre>
   * String key, String value pair with an accurate timestamp.
   * Logging some events happening in the context of the span duration.
   * </pre>
   *
   * <code>repeated .io.holoinsight.server.storage.grpc.trace.Log logs = 13;</code>
   */
  int getLogsCount();
  /**
   * <pre>
   * String key, String value pair with an accurate timestamp.
   * Logging some events happening in the context of the span duration.
   * </pre>
   *
   * <code>repeated .io.holoinsight.server.storage.grpc.trace.Log logs = 13;</code>
   */
  java.util.List<? extends io.holoinsight.server.storage.grpc.trace.LogOrBuilder> 
      getLogsOrBuilderList();
  /**
   * <pre>
   * String key, String value pair with an accurate timestamp.
   * Logging some events happening in the context of the span duration.
   * </pre>
   *
   * <code>repeated .io.holoinsight.server.storage.grpc.trace.Log logs = 13;</code>
   */
  io.holoinsight.server.storage.grpc.trace.LogOrBuilder getLogsOrBuilder(
      int index);

  /**
   * <pre>
   * Force the backend don't do analysis, if the value is TRUE.
   * The backend has its own configurations to follow or override this.
   * Use this mostly because the agent/SDK could know more context of the service role.
   * </pre>
   *
   * <code>bool skipAnalysis = 14;</code>
   */
  boolean getSkipAnalysis();
}
