package com.woniuxy.batchservice.dao;

import com.woniuxy.wuye.common.entity.TbCheckReduce;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TbcheckReduceMapperTest {
    @Autowired
    TbCheckReduceMapper tbCheckReduceMapper;
    @Test
    public void testGetByCondition(){

        TbCheckReduce tbCheckReduce=new TbCheckReduce();
       tbCheckReduce.setReduceWay("曹思");
        List<TbCheckReduce>tbCheckReduces= tbCheckReduceMapper.getByCondition(tbCheckReduce);
        System.out.println("111");
    }
}
