package com.woniuxy.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author：liangliang
 * @date:2022/10/19/19:18
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.woniuxy.order.mapper")
public class OrderServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServerApplication.class, args);
    }


}
