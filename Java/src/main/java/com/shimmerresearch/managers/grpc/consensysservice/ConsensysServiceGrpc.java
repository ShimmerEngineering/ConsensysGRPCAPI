package com.shimmerresearch.managers.grpc.consensysservice;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.32.1)",
    comments = "Source: src/ConsensysService_v0.0.1.proto")
public final class ConsensysServiceGrpc {

  private ConsensysServiceGrpc() {}

  public static final String SERVICE_NAME = "consensysservice.ConsensysService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.shimmerresearch.grpc.ShimmerGRPC.StreamRequest,
      com.shimmerresearch.grpc.ShimmerGRPC.ObjectCluster2> getGetDataStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataStream",
      requestType = com.shimmerresearch.grpc.ShimmerGRPC.StreamRequest.class,
      responseType = com.shimmerresearch.grpc.ShimmerGRPC.ObjectCluster2.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.shimmerresearch.grpc.ShimmerGRPC.StreamRequest,
      com.shimmerresearch.grpc.ShimmerGRPC.ObjectCluster2> getGetDataStreamMethod() {
    io.grpc.MethodDescriptor<com.shimmerresearch.grpc.ShimmerGRPC.StreamRequest, com.shimmerresearch.grpc.ShimmerGRPC.ObjectCluster2> getGetDataStreamMethod;
    if ((getGetDataStreamMethod = ConsensysServiceGrpc.getGetDataStreamMethod) == null) {
      synchronized (ConsensysServiceGrpc.class) {
        if ((getGetDataStreamMethod = ConsensysServiceGrpc.getGetDataStreamMethod) == null) {
          ConsensysServiceGrpc.getGetDataStreamMethod = getGetDataStreamMethod =
              io.grpc.MethodDescriptor.<com.shimmerresearch.grpc.ShimmerGRPC.StreamRequest, com.shimmerresearch.grpc.ShimmerGRPC.ObjectCluster2>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.shimmerresearch.grpc.ShimmerGRPC.StreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.shimmerresearch.grpc.ShimmerGRPC.ObjectCluster2.getDefaultInstance()))
              .setSchemaDescriptor(new ConsensysServiceMethodDescriptorSupplier("GetDataStream"))
              .build();
        }
      }
    }
    return getGetDataStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ConsensysServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConsensysServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConsensysServiceStub>() {
        @java.lang.Override
        public ConsensysServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConsensysServiceStub(channel, callOptions);
        }
      };
    return ConsensysServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConsensysServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConsensysServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConsensysServiceBlockingStub>() {
        @java.lang.Override
        public ConsensysServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConsensysServiceBlockingStub(channel, callOptions);
        }
      };
    return ConsensysServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ConsensysServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConsensysServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConsensysServiceFutureStub>() {
        @java.lang.Override
        public ConsensysServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConsensysServiceFutureStub(channel, callOptions);
        }
      };
    return ConsensysServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ConsensysServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getDataStream(com.shimmerresearch.grpc.ShimmerGRPC.StreamRequest request,
        io.grpc.stub.StreamObserver<com.shimmerresearch.grpc.ShimmerGRPC.ObjectCluster2> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDataStreamMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetDataStreamMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.shimmerresearch.grpc.ShimmerGRPC.StreamRequest,
                com.shimmerresearch.grpc.ShimmerGRPC.ObjectCluster2>(
                  this, METHODID_GET_DATA_STREAM)))
          .build();
    }
  }

  /**
   */
  public static final class ConsensysServiceStub extends io.grpc.stub.AbstractAsyncStub<ConsensysServiceStub> {
    private ConsensysServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConsensysServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConsensysServiceStub(channel, callOptions);
    }

    /**
     */
    public void getDataStream(com.shimmerresearch.grpc.ShimmerGRPC.StreamRequest request,
        io.grpc.stub.StreamObserver<com.shimmerresearch.grpc.ShimmerGRPC.ObjectCluster2> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetDataStreamMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ConsensysServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ConsensysServiceBlockingStub> {
    private ConsensysServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConsensysServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConsensysServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.shimmerresearch.grpc.ShimmerGRPC.ObjectCluster2> getDataStream(
        com.shimmerresearch.grpc.ShimmerGRPC.StreamRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetDataStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ConsensysServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ConsensysServiceFutureStub> {
    private ConsensysServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConsensysServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConsensysServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_DATA_STREAM = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ConsensysServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ConsensysServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_DATA_STREAM:
          serviceImpl.getDataStream((com.shimmerresearch.grpc.ShimmerGRPC.StreamRequest) request,
              (io.grpc.stub.StreamObserver<com.shimmerresearch.grpc.ShimmerGRPC.ObjectCluster2>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ConsensysServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConsensysServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.shimmerresearch.managers.grpc.consensysservice.ShimmerConsensysService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ConsensysService");
    }
  }

  private static final class ConsensysServiceFileDescriptorSupplier
      extends ConsensysServiceBaseDescriptorSupplier {
    ConsensysServiceFileDescriptorSupplier() {}
  }

  private static final class ConsensysServiceMethodDescriptorSupplier
      extends ConsensysServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ConsensysServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ConsensysServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ConsensysServiceFileDescriptorSupplier())
              .addMethod(getGetDataStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
