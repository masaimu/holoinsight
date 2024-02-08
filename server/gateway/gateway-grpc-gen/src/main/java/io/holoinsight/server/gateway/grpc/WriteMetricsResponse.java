/*
 * Copyright 2022 Holoinsight Project Authors. Licensed under Apache-2.0.
 */
// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: gateway-for-agent.proto

package io.holoinsight.server.gateway.grpc;

/**
 * Protobuf type {@code io.holoinsight.server.gateway.grpc.WriteMetricsResponse}
 */
public final class WriteMetricsResponse extends com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:io.holoinsight.server.gateway.grpc.WriteMetricsResponse)
    WriteMetricsResponseOrBuilder {
  private static final long serialVersionUID = 0L;

  // Use WriteMetricsResponse.newBuilder() to construct.
  private WriteMetricsResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private WriteMetricsResponse() {}

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new WriteMetricsResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private WriteMetricsResponse(com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            io.holoinsight.server.gateway.grpc.common.CommonResponseHeader.Builder subBuilder =
                null;
            if (header_ != null) {
              subBuilder = header_.toBuilder();
            }
            header_ = input.readMessage(
                io.holoinsight.server.gateway.grpc.common.CommonResponseHeader.parser(),
                extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(header_);
              header_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return io.holoinsight.server.gateway.grpc.GatewayProtos.internal_static_io_holoinsight_server_gateway_grpc_WriteMetricsResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return io.holoinsight.server.gateway.grpc.GatewayProtos.internal_static_io_holoinsight_server_gateway_grpc_WriteMetricsResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.holoinsight.server.gateway.grpc.WriteMetricsResponse.class,
            io.holoinsight.server.gateway.grpc.WriteMetricsResponse.Builder.class);
  }

  public static final int HEADER_FIELD_NUMBER = 1;
  private io.holoinsight.server.gateway.grpc.common.CommonResponseHeader header_;

  /**
   * <code>.io.holoinsight.server.gateway.grpc.common.CommonResponseHeader header = 1;</code>
   * 
   * @return Whether the header field is set.
   */
  @java.lang.Override
  public boolean hasHeader() {
    return header_ != null;
  }

  /**
   * <code>.io.holoinsight.server.gateway.grpc.common.CommonResponseHeader header = 1;</code>
   * 
   * @return The header.
   */
  @java.lang.Override
  public io.holoinsight.server.gateway.grpc.common.CommonResponseHeader getHeader() {
    return header_ == null
        ? io.holoinsight.server.gateway.grpc.common.CommonResponseHeader.getDefaultInstance()
        : header_;
  }

  /**
   * <code>.io.holoinsight.server.gateway.grpc.common.CommonResponseHeader header = 1;</code>
   */
  @java.lang.Override
  public io.holoinsight.server.gateway.grpc.common.CommonResponseHeaderOrBuilder getHeaderOrBuilder() {
    return getHeader();
  }

  private byte memoizedIsInitialized = -1;

  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1)
      return true;
    if (isInitialized == 0)
      return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
    if (header_ != null) {
      output.writeMessage(1, getHeader());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1)
      return size;

    size = 0;
    if (header_ != null) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(1, getHeader());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof io.holoinsight.server.gateway.grpc.WriteMetricsResponse)) {
      return super.equals(obj);
    }
    io.holoinsight.server.gateway.grpc.WriteMetricsResponse other =
        (io.holoinsight.server.gateway.grpc.WriteMetricsResponse) obj;

    if (hasHeader() != other.hasHeader())
      return false;
    if (hasHeader()) {
      if (!getHeader().equals(other.getHeader()))
        return false;
    }
    if (!unknownFields.equals(other.unknownFields))
      return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasHeader()) {
      hash = (37 * hash) + HEADER_FIELD_NUMBER;
      hash = (53 * hash) + getHeader().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.holoinsight.server.gateway.grpc.WriteMetricsResponse parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static io.holoinsight.server.gateway.grpc.WriteMetricsResponse parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static io.holoinsight.server.gateway.grpc.WriteMetricsResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static io.holoinsight.server.gateway.grpc.WriteMetricsResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static io.holoinsight.server.gateway.grpc.WriteMetricsResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static io.holoinsight.server.gateway.grpc.WriteMetricsResponse parseFrom(byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static io.holoinsight.server.gateway.grpc.WriteMetricsResponse parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static io.holoinsight.server.gateway.grpc.WriteMetricsResponse parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input,
        extensionRegistry);
  }

  public static io.holoinsight.server.gateway.grpc.WriteMetricsResponse parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static io.holoinsight.server.gateway.grpc.WriteMetricsResponse parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input,
        extensionRegistry);
  }

  public static io.holoinsight.server.gateway.grpc.WriteMetricsResponse parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static io.holoinsight.server.gateway.grpc.WriteMetricsResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input,
        extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() {
    return newBuilder();
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(
      io.holoinsight.server.gateway.grpc.WriteMetricsResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }

  /**
   * Protobuf type {@code io.holoinsight.server.gateway.grpc.WriteMetricsResponse}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:io.holoinsight.server.gateway.grpc.WriteMetricsResponse)
      io.holoinsight.server.gateway.grpc.WriteMetricsResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return io.holoinsight.server.gateway.grpc.GatewayProtos.internal_static_io_holoinsight_server_gateway_grpc_WriteMetricsResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return io.holoinsight.server.gateway.grpc.GatewayProtos.internal_static_io_holoinsight_server_gateway_grpc_WriteMetricsResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.holoinsight.server.gateway.grpc.WriteMetricsResponse.class,
              io.holoinsight.server.gateway.grpc.WriteMetricsResponse.Builder.class);
    }

    // Construct using io.holoinsight.server.gateway.grpc.WriteMetricsResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {}

    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (headerBuilder_ == null) {
        header_ = null;
      } else {
        header_ = null;
        headerBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return io.holoinsight.server.gateway.grpc.GatewayProtos.internal_static_io_holoinsight_server_gateway_grpc_WriteMetricsResponse_descriptor;
    }

    @java.lang.Override
    public io.holoinsight.server.gateway.grpc.WriteMetricsResponse getDefaultInstanceForType() {
      return io.holoinsight.server.gateway.grpc.WriteMetricsResponse.getDefaultInstance();
    }

    @java.lang.Override
    public io.holoinsight.server.gateway.grpc.WriteMetricsResponse build() {
      io.holoinsight.server.gateway.grpc.WriteMetricsResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.holoinsight.server.gateway.grpc.WriteMetricsResponse buildPartial() {
      io.holoinsight.server.gateway.grpc.WriteMetricsResponse result =
          new io.holoinsight.server.gateway.grpc.WriteMetricsResponse(this);
      if (headerBuilder_ == null) {
        result.header_ = header_;
      } else {
        result.header_ = headerBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }

    @java.lang.Override
    public Builder setField(com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }

    @java.lang.Override
    public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }

    @java.lang.Override
    public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }

    @java.lang.Override
    public Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }

    @java.lang.Override
    public Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.holoinsight.server.gateway.grpc.WriteMetricsResponse) {
        return mergeFrom((io.holoinsight.server.gateway.grpc.WriteMetricsResponse) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.holoinsight.server.gateway.grpc.WriteMetricsResponse other) {
      if (other == io.holoinsight.server.gateway.grpc.WriteMetricsResponse.getDefaultInstance())
        return this;
      if (other.hasHeader()) {
        mergeHeader(other.getHeader());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
      io.holoinsight.server.gateway.grpc.WriteMetricsResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage =
            (io.holoinsight.server.gateway.grpc.WriteMetricsResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private io.holoinsight.server.gateway.grpc.common.CommonResponseHeader header_;
    private com.google.protobuf.SingleFieldBuilderV3<io.holoinsight.server.gateway.grpc.common.CommonResponseHeader, io.holoinsight.server.gateway.grpc.common.CommonResponseHeader.Builder, io.holoinsight.server.gateway.grpc.common.CommonResponseHeaderOrBuilder> headerBuilder_;

    /**
     * <code>.io.holoinsight.server.gateway.grpc.common.CommonResponseHeader header = 1;</code>
     * 
     * @return Whether the header field is set.
     */
    public boolean hasHeader() {
      return headerBuilder_ != null || header_ != null;
    }

    /**
     * <code>.io.holoinsight.server.gateway.grpc.common.CommonResponseHeader header = 1;</code>
     * 
     * @return The header.
     */
    public io.holoinsight.server.gateway.grpc.common.CommonResponseHeader getHeader() {
      if (headerBuilder_ == null) {
        return header_ == null
            ? io.holoinsight.server.gateway.grpc.common.CommonResponseHeader.getDefaultInstance()
            : header_;
      } else {
        return headerBuilder_.getMessage();
      }
    }

    /**
     * <code>.io.holoinsight.server.gateway.grpc.common.CommonResponseHeader header = 1;</code>
     */
    public Builder setHeader(io.holoinsight.server.gateway.grpc.common.CommonResponseHeader value) {
      if (headerBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        header_ = value;
        onChanged();
      } else {
        headerBuilder_.setMessage(value);
      }

      return this;
    }

    /**
     * <code>.io.holoinsight.server.gateway.grpc.common.CommonResponseHeader header = 1;</code>
     */
    public Builder setHeader(
        io.holoinsight.server.gateway.grpc.common.CommonResponseHeader.Builder builderForValue) {
      if (headerBuilder_ == null) {
        header_ = builderForValue.build();
        onChanged();
      } else {
        headerBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }

    /**
     * <code>.io.holoinsight.server.gateway.grpc.common.CommonResponseHeader header = 1;</code>
     */
    public Builder mergeHeader(
        io.holoinsight.server.gateway.grpc.common.CommonResponseHeader value) {
      if (headerBuilder_ == null) {
        if (header_ != null) {
          header_ = io.holoinsight.server.gateway.grpc.common.CommonResponseHeader
              .newBuilder(header_).mergeFrom(value).buildPartial();
        } else {
          header_ = value;
        }
        onChanged();
      } else {
        headerBuilder_.mergeFrom(value);
      }

      return this;
    }

    /**
     * <code>.io.holoinsight.server.gateway.grpc.common.CommonResponseHeader header = 1;</code>
     */
    public Builder clearHeader() {
      if (headerBuilder_ == null) {
        header_ = null;
        onChanged();
      } else {
        header_ = null;
        headerBuilder_ = null;
      }

      return this;
    }

    /**
     * <code>.io.holoinsight.server.gateway.grpc.common.CommonResponseHeader header = 1;</code>
     */
    public io.holoinsight.server.gateway.grpc.common.CommonResponseHeader.Builder getHeaderBuilder() {

      onChanged();
      return getHeaderFieldBuilder().getBuilder();
    }

    /**
     * <code>.io.holoinsight.server.gateway.grpc.common.CommonResponseHeader header = 1;</code>
     */
    public io.holoinsight.server.gateway.grpc.common.CommonResponseHeaderOrBuilder getHeaderOrBuilder() {
      if (headerBuilder_ != null) {
        return headerBuilder_.getMessageOrBuilder();
      } else {
        return header_ == null
            ? io.holoinsight.server.gateway.grpc.common.CommonResponseHeader.getDefaultInstance()
            : header_;
      }
    }

    /**
     * <code>.io.holoinsight.server.gateway.grpc.common.CommonResponseHeader header = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<io.holoinsight.server.gateway.grpc.common.CommonResponseHeader, io.holoinsight.server.gateway.grpc.common.CommonResponseHeader.Builder, io.holoinsight.server.gateway.grpc.common.CommonResponseHeaderOrBuilder> getHeaderFieldBuilder() {
      if (headerBuilder_ == null) {
        headerBuilder_ =
            new com.google.protobuf.SingleFieldBuilderV3<io.holoinsight.server.gateway.grpc.common.CommonResponseHeader, io.holoinsight.server.gateway.grpc.common.CommonResponseHeader.Builder, io.holoinsight.server.gateway.grpc.common.CommonResponseHeaderOrBuilder>(
                getHeader(), getParentForChildren(), isClean());
        header_ = null;
      }
      return headerBuilder_;
    }

    @java.lang.Override
    public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:io.holoinsight.server.gateway.grpc.WriteMetricsResponse)
  }

  // @@protoc_insertion_point(class_scope:io.holoinsight.server.gateway.grpc.WriteMetricsResponse)
  private static final io.holoinsight.server.gateway.grpc.WriteMetricsResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.holoinsight.server.gateway.grpc.WriteMetricsResponse();
  }

  public static io.holoinsight.server.gateway.grpc.WriteMetricsResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<WriteMetricsResponse> PARSER =
      new com.google.protobuf.AbstractParser<WriteMetricsResponse>() {
        @java.lang.Override
        public WriteMetricsResponse parsePartialFrom(com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new WriteMetricsResponse(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<WriteMetricsResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<WriteMetricsResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.holoinsight.server.gateway.grpc.WriteMetricsResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
