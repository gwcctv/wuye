package com.woniuxy.clientmanager;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@MapperScan("com.woniuxy.clientmanager.mapper")
public class ClientManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientManagerApplication.class, args);
    }

}
