package org.jian.grpc.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class Server {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Server.class, args);
        ServerGrpc server = context.getBean(ServerGrpc.class);
        try {
            server.start();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}
