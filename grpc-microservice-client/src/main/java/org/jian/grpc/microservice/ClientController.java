package org.jian.grpc.microservice;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.jian.grpc.proto.HelloReply;
import org.jian.grpc.proto.HelloRequest;
import org.jian.grpc.proto.SimpleGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @RequestMapping("/")
    public String printMessage(@RequestParam(defaultValue = "Jian") String name) {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:12345").usePlaintext().build();

        try {
            final SimpleGrpc.SimpleBlockingStub stub = SimpleGrpc.newBlockingStub(channel);
            HelloReply reply = stub.sayHello(HelloRequest.newBuilder().setName(name).build());
            return reply.getMessage();
        } finally {
            channel.shutdown();
        }
    }

    @Autowired
    ClientService client;
    @RequestMapping("/springboot")
    public String springBootGrpc(@RequestParam(defaultValue = "Long") String name) {
       return  client.request(name);
    }

}
