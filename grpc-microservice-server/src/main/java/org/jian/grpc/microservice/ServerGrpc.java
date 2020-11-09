package org.jian.grpc.microservice;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.jian.grpc.proto.HelloReply;
import org.jian.grpc.proto.HelloRequest;
import org.jian.grpc.proto.SimpleGrpc;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ServerGrpc {

    public void start() throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(12345).addService(new SimpleGrpc.SimpleImplBase() {
            @Override
            public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
                HelloReply reply = HelloReply.newBuilder().setMessage("Halo -> daring " + request.getName()).build();
                responseObserver.onNext(reply);
                responseObserver.onCompleted();
            }
        }).build().start();
        server.awaitTermination();
    }
}
