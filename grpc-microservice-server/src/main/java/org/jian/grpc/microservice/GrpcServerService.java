package org.jian.grpc.microservice;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.jian.grpc.proto.HelloReply;
import org.jian.grpc.proto.HelloRequest;
import org.jian.grpc.proto.SimpleGrpc;

@GrpcService
public class GrpcServerService extends SimpleGrpc.SimpleImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("[GRPC Spring Starter Eureka] ==> " + request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
