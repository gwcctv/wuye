package com.woniuxy.carmanager;

import com.woniuxy.carmanager.mapper.CarMapper;
import com.woniuxy.wuye.common.entity.TbCar;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CarManagerApplicationTests {

    @Resource
    private CarMapper carMapper;
    @Test
    void contextLoads() {
        System.out.println(carMapper.deleteById(1));
    }

}
