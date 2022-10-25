package com.woniuxy.parkingmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.woniuxy.parkingmanager.mapper")
public class ParkingManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkingManagerApplication.class, args);
    }

}
