package com.woniuxy.busconfig.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woniuxy.wuye.common.entity.TbMoneyDeduction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TbMoneyDeductionMapperTest {
    @Autowired
  private   TbMoneyDeductionMapper tbMoneyDeductionMapper;
    @Test
    public void add(){
        TbMoneyDeduction tbMoneyDeduction = new TbMoneyDeduction();
        tbMoneyDeduction.setDeductionName("账单减免");
        tbMoneyDeduction.setSituation("y");
        tbMoneyDeductionMapper.insert(tbMoneyDeduction);
    }
    @Test
    public void select(){
        TbMoneyDeduction tbMoneyDeduction = new TbMoneyDeduction();
        tbMoneyDeduction.setDeductionName("单减");
        QueryWrapper<TbMoneyDeduction> queryWrapper =new QueryWrapper();
        queryWrapper.setEntity(tbMoneyDeduction);
        tbMoneyDeductionMapper.selectList(queryWrapper).forEach(System.out::println);
    }
}
