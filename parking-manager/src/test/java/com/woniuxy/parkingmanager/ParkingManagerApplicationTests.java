package com.woniuxy.parkingmanager;

import com.woniuxy.parkingmanager.mapper.ParkingMapper;
import com.woniuxy.wuye.common.entity.TbParking;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ParkingManagerApplicationTests {
    @Resource
    private ParkingMapper parkingMapper;
    @Test
    void contextLoads() {
        parkingMapper.insertParking(new TbParking("NO123","人防车位","空置",15.0,"临停车位","空置",0,0));
    }

}
