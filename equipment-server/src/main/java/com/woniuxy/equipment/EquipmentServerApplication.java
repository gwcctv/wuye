package com.woniuxy.equipment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author：liangliang
 * @date:2022/10/20/17:00
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.woniuxy.equipment.mapper")
public class EquipmentServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EquipmentServerApplication.class, args);
    }
}
