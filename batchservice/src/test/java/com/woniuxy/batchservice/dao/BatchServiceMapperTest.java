package com.woniuxy.batchservice.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woniuxy.batchservice.jilianutils.entity.House;
import com.woniuxy.batchservice.jilianutils.entity.Project;
import com.woniuxy.batchservice.jilianutils.mapper.HouseMapper;
import com.woniuxy.batchservice.jilianutils.mapper.ProjectMapper;
import com.woniuxy.batchservice.jilianutils.service.JilianService;
import com.woniuxy.wuye.common.entity.TbCycle;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BatchServiceMapperTest {
    @Autowired
    TbCycleMapper batchServiceMapper;
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    HouseMapper houseMapper;
    @Autowired
    JilianService jilianService;
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
    @Test
    public void testGetAllProject(){
       List<Project> projects= projectMapper.getAll();
        System.out.println("");
    }
    @Test
    public void testGetByProject(){
        List<House> houses= houseMapper.getByProjectId(1);
        System.out.println("");
    }

    @Test
    public void testGetJiLian(){
        List<Project> projects= jilianService.getJilLianProject();
        System.out.println("");
    }
}
