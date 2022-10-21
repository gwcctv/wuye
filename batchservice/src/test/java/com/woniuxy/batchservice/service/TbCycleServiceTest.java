package com.woniuxy.batchservice.service;

import com.woniuxy.wuye.common.entity.TbCycle;
import com.woniuxy.wuye.common.utils.PageBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class TbCycleServiceTest {
    @Autowired
    TbCycleService tbCycleService;

    @Test
    public void testGetByConditionByPage(){
        TbCycle tbCycle=new TbCycle();
        PageBean<TbCycle> pageBean=tbCycleService.getByConditionByPage(tbCycle,2);
        System.out.println("111");
    }

    @Test
    public void testAdd(){
        TbCycle tbCycle=new TbCycle();
        tbCycle.setHouseId(1);
        tbCycle.setFeetypeId(1);
        tbCycle.setFeecycle(561651);
     tbCycle.setStartDay("66");
     tbCycle.setEndDay("66");
tbCycle.setProduceName("魏锦鹏");
tbCycle.setProduceStatus("1");
tbCycle.setProduceTime(LocalDateTime.now().toString());
tbCycle.setNumber("123465");
tbCycle.setFailureProduceReason("56165");
tbCycle.setPrice("99.22");
tbCycle.setTotalMoney("100.00");
tbCycleService.save(tbCycle);
    }
}
