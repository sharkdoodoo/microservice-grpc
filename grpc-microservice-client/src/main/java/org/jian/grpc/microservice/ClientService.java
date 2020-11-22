package org.jian.grpc.microservice;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.jian.grpc.proto.HelloReply;
import org.jian.grpc.proto.HelloRequest;
import org.jian.grpc.proto.SimpleGrpc;
import org.springframework.stereotype.Service;

@Service
public class ClientService {


    @GrpcClient("cloud-grpc-server")
    private SimpleGrpc.SimpleBlockingStub stub;

    public String request(String name) {
        HelloReply reply = stub.sayHello(HelloRequest.newBuilder().setName("[SpringBoot]"+name).build());
        return reply.getMessage();
    }
}
