package com.woniuxy.busconfig.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woniuxy.wuye.common.entity.TbMeasure;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TbMeasureTest {
    @Autowired
   private TbMeasureMapper tbMeasureMapper;
    @Test
    public void getBycondition(){
        TbMeasure tbMeasure = new TbMeasure();
        tbMeasure.setMeasureName("任文");
        QueryWrapper<TbMeasure> queryWrapper =new QueryWrapper<>();
        queryWrapper.setEntity(tbMeasure);
        tbMeasureMapper.selectList(queryWrapper).forEach(System.out::println);
    }
    @Test
    public void update(){
        TbMeasure tbMeasure = new TbMeasure();
        tbMeasure.setMeasureName("小文鹏");
        QueryWrapper<TbMeasure> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("id","1");
        tbMeasureMapper.update(tbMeasure,queryWrapper);
    }
    @Test
    public void getByCondition (){
        TbMeasure tbMeasure = new TbMeasure();
       tbMeasure.setThisProjectName("jdgWo");
        tbMeasureMapper.getTbMeasure(tbMeasure).forEach(System.out::println);
    }
}
