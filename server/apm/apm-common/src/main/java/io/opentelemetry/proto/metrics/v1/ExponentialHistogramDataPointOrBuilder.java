/*
 * Copyright 2022 Holoinsight Project Authors. Licensed under Apache-2.0.
 */
// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: opentelemetry/proto/metrics/v1/metrics.proto

package io.opentelemetry.proto.metrics.v1;

public interface ExponentialHistogramDataPointOrBuilder extends
    // @@protoc_insertion_point(interface_extends:opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The set of key/value pairs that uniquely identify the timeseries from
   * where this point belongs. The list may be empty (may contain 0 elements).
   * Attribute keys MUST be unique (it is not allowed to have more than one
   * attribute with the same key).
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.common.v1.KeyValue attributes = 1;</code>
   */
  java.util.List<io.opentelemetry.proto.common.v1.KeyValue> getAttributesList();

  /**
   * <pre>
   * The set of key/value pairs that uniquely identify the timeseries from
   * where this point belongs. The list may be empty (may contain 0 elements).
   * Attribute keys MUST be unique (it is not allowed to have more than one
   * attribute with the same key).
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.common.v1.KeyValue attributes = 1;</code>
   */
  io.opentelemetry.proto.common.v1.KeyValue getAttributes(int index);

  /**
   * <pre>
   * The set of key/value pairs that uniquely identify the timeseries from
   * where this point belongs. The list may be empty (may contain 0 elements).
   * Attribute keys MUST be unique (it is not allowed to have more than one
   * attribute with the same key).
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.common.v1.KeyValue attributes = 1;</code>
   */
  int getAttributesCount();

  /**
   * <pre>
   * The set of key/value pairs that uniquely identify the timeseries from
   * where this point belongs. The list may be empty (may contain 0 elements).
   * Attribute keys MUST be unique (it is not allowed to have more than one
   * attribute with the same key).
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.common.v1.KeyValue attributes = 1;</code>
   */
  java.util.List<? extends io.opentelemetry.proto.common.v1.KeyValueOrBuilder> getAttributesOrBuilderList();

  /**
   * <pre>
   * The set of key/value pairs that uniquely identify the timeseries from
   * where this point belongs. The list may be empty (may contain 0 elements).
   * Attribute keys MUST be unique (it is not allowed to have more than one
   * attribute with the same key).
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.common.v1.KeyValue attributes = 1;</code>
   */
  io.opentelemetry.proto.common.v1.KeyValueOrBuilder getAttributesOrBuilder(int index);

  /**
   * <pre>
   * StartTimeUnixNano is optional but strongly encouraged, see the
   * the detailed comments above Metric.
   * Value is UNIX Epoch time in nanoseconds since 00:00:00 UTC on 1 January
   * 1970.
   * </pre>
   *
   * <code>fixed64 start_time_unix_nano = 2;</code>
   */
  long getStartTimeUnixNano();

  /**
   * <pre>
   * TimeUnixNano is required, see the detailed comments above Metric.
   * Value is UNIX Epoch time in nanoseconds since 00:00:00 UTC on 1 January
   * 1970.
   * </pre>
   *
   * <code>fixed64 time_unix_nano = 3;</code>
   */
  long getTimeUnixNano();

  /**
   * <pre>
   * count is the number of values in the population. Must be
   * non-negative. This value must be equal to the sum of the "bucket_counts"
   * values in the positive and negative Buckets plus the "zero_count" field.
   * </pre>
   *
   * <code>fixed64 count = 4;</code>
   */
  long getCount();

  /**
   * <pre>
   * sum of the values in the population. If count is zero then this field
   * must be zero.
   * Note: Sum should only be filled out when measuring non-negative discrete
   * events, and is assumed to be monotonic over the values of these events.
   * Negative events *can* be recorded, but sum should not be filled out when
   * doing so.  This is specifically to enforce compatibility w/ OpenMetrics,
   * see: https://github.com/OpenObservability/OpenMetrics/blob/main/specification/OpenMetrics.md#histogram
   * </pre>
   *
   * <code>double sum = 5;</code>
   */
  double getSum();

  /**
   * <pre>
   * scale describes the resolution of the histogram.  Boundaries are
   * located at powers of the base, where:
   *   base = (2^(2^-scale))
   * The histogram bucket identified by `index`, a signed integer,
   * contains values that are greater than (base^index) and
   * less than or equal to (base^(index+1)).
   * The positive and negative ranges of the histogram are expressed
   * separately.  Negative values are mapped by their absolute value
   * into the negative range using the same scale as the positive range.
   * scale is not restricted by the protocol, as the permissible
   * values depend on the range of the data.
   * </pre>
   *
   * <code>sint32 scale = 6;</code>
   */
  int getScale();

  /**
   * <pre>
   * zero_count is the count of values that are either exactly zero or
   * within the region considered zero by the instrumentation at the
   * tolerated degree of precision.  This bucket stores values that
   * cannot be expressed using the standard exponential formula as
   * well as values that have been rounded to zero.
   * Implementations MAY consider the zero bucket to have probability
   * mass equal to (zero_count / count).
   * </pre>
   *
   * <code>fixed64 zero_count = 7;</code>
   */
  long getZeroCount();

  /**
   * <pre>
   * positive carries the positive range of exponential bucket counts.
   * </pre>
   *
   * <code>.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint.Buckets positive = 8;</code>
   */
  boolean hasPositive();

  /**
   * <pre>
   * positive carries the positive range of exponential bucket counts.
   * </pre>
   *
   * <code>.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint.Buckets positive = 8;</code>
   */
  io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint.Buckets getPositive();

  /**
   * <pre>
   * positive carries the positive range of exponential bucket counts.
   * </pre>
   *
   * <code>.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint.Buckets positive = 8;</code>
   */
  io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint.BucketsOrBuilder getPositiveOrBuilder();

  /**
   * <pre>
   * negative carries the negative range of exponential bucket counts.
   * </pre>
   *
   * <code>.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint.Buckets negative = 9;</code>
   */
  boolean hasNegative();

  /**
   * <pre>
   * negative carries the negative range of exponential bucket counts.
   * </pre>
   *
   * <code>.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint.Buckets negative = 9;</code>
   */
  io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint.Buckets getNegative();

  /**
   * <pre>
   * negative carries the negative range of exponential bucket counts.
   * </pre>
   *
   * <code>.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint.Buckets negative = 9;</code>
   */
  io.opentelemetry.proto.metrics.v1.ExponentialHistogramDataPoint.BucketsOrBuilder getNegativeOrBuilder();

  /**
   * <pre>
   * Flags that apply to this specific data point.  See DataPointFlags
   * for the available flags and their meaning.
   * </pre>
   *
   * <code>uint32 flags = 10;</code>
   */
  int getFlags();

  /**
   * <pre>
   * (Optional) List of exemplars collected from
   * measurements that were used to form the data point
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.metrics.v1.Exemplar exemplars = 11;</code>
   */
  java.util.List<io.opentelemetry.proto.metrics.v1.Exemplar> getExemplarsList();

  /**
   * <pre>
   * (Optional) List of exemplars collected from
   * measurements that were used to form the data point
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.metrics.v1.Exemplar exemplars = 11;</code>
   */
  io.opentelemetry.proto.metrics.v1.Exemplar getExemplars(int index);

  /**
   * <pre>
   * (Optional) List of exemplars collected from
   * measurements that were used to form the data point
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.metrics.v1.Exemplar exemplars = 11;</code>
   */
  int getExemplarsCount();

  /**
   * <pre>
   * (Optional) List of exemplars collected from
   * measurements that were used to form the data point
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.metrics.v1.Exemplar exemplars = 11;</code>
   */
  java.util.List<? extends io.opentelemetry.proto.metrics.v1.ExemplarOrBuilder> getExemplarsOrBuilderList();

  /**
   * <pre>
   * (Optional) List of exemplars collected from
   * measurements that were used to form the data point
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.metrics.v1.Exemplar exemplars = 11;</code>
   */
  io.opentelemetry.proto.metrics.v1.ExemplarOrBuilder getExemplarsOrBuilder(int index);

  /**
   * <pre>
   * min is the minimum value over (start_time, end_time].
   * </pre>
   *
   * <code>double min = 12;</code>
   */
  double getMin();

  /**
   * <pre>
   * max is the maximum value over (start_time, end_time].
   * </pre>
   *
   * <code>double max = 13;</code>
   */
  double getMax();
}
