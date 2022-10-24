package com.woniuxy.housemanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan(basePackages = "com.woniuxy.housemanager.mapper")
@EnableDiscoveryClient
@EnableFeignClients
public class HouseManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouseManagerApplication.class, args);
    }

}
