package com.woniuxy.busconfig;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = "com.woniuxy.busconfig.mapper")
public class BusConfigApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext =   SpringApplication.run(BusConfigApplication.class, args);

	}

}
