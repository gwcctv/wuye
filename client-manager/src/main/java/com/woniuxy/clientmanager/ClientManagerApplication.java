package com.woniuxy.clientmanager;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@MapperScan("com.woniuxy.clientmanager.mapper")
@ComponentScan("com.woniuxy")
@EnableDiscoveryClient
@EnableFeignClients
public class ClientManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientManagerApplication.class, args);
    }

}
