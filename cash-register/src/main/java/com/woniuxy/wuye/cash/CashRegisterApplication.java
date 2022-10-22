package com.woniuxy.wuye.cash;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/19
 **/
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = "com.woniuxy.wuye.cash.map")
public class CashRegisterApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CashRegisterApplication.class, args);
    }
}
