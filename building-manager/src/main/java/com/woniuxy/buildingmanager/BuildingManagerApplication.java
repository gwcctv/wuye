package com.woniuxy.buildingmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan(basePackages = "com.woniuxy.buildingmanager.mapper")
@EnableDiscoveryClient
@EnableFeignClients
public class BuildingManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuildingManagerApplication.class, args);
    }

}
