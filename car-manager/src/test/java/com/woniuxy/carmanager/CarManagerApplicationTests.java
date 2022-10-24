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
        TbCar tbCar = new TbCar();
        tbCar.setCarId(1);
        tbCar.setCarNumber("川A123");
        System.out.println(carMapper.update(tbCar));
    }

}
