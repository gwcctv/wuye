package com.woniuxy.batchservice.dao;

import com.woniuxy.wuye.common.entity.TbClock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TbClockMapperTest {
    @Autowired
    TbClockMapper tbClockMapper;
    @Test
    public void testGetByCondition(){
        TbClock tbClock=new TbClock();

        List<TbClock> tbClocks=tbClockMapper.getByCondition(tbClock);
        System.out.println("1111");
    }
}
