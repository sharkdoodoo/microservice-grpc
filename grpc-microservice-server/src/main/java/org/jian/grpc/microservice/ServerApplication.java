package org.jian.grpc.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ServerApplication.class, args);


    }

    /**
     * 传统的grpc server 启动方式
     * @param context
     */
    private static void traditional(ApplicationContext context) {
        ServerGrpc server = context.getBean(ServerGrpc.class);
        try {
            server.start();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}
