package com.woniuxy.batchservice.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woniuxy.wuye.common.entity.TbCycle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BatchServiceMapperTest {
    @Autowired
    TbCycleMapper batchServiceMapper;
    @Test
    public void testSelecter(){
        TbCycle tbCycle=new TbCycle();
        tbCycle.setProduceName("龙子轩");
//        tbCycle.setNumber("555");
        tbCycle.setFailureProduceReason("哈");
        QueryWrapper<TbCycle> queryWrapper=new QueryWrapper<>();
        queryWrapper.setEntity(tbCycle);
       List<TbCycle> tbCycles= batchServiceMapper.selectList(queryWrapper);
        System.out.println(tbCycles.size());
    }
    @Test
    public void testUpdate(){
        TbCycle tbCycle=new TbCycle();
//       tbCycle.setFailureProduceReason("宁夏");
        tbCycle.setProduceName("龙子轩");
//        QueryWrapper<TbCycle> queryWrapper=new QueryWrapper<>();
//        queryWrapper.eq("id","9");
//
//        batchServiceMapper.update(tbCycle,queryWrapper);
 List<TbCycle> tbCycles=batchServiceMapper.getByCondition(tbCycle);
        System.out.println("111");
    }
}
