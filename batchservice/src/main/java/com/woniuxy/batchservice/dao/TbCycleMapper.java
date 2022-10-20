package com.woniuxy.batchservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.woniuxy.batchservice.provider.TbcycleProvider;
import com.woniuxy.wuye.common.entity.TbCycle;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
/**
 * 批量周期任务mapper
 * */
public interface TbCycleMapper extends BaseMapper<TbCycle> {
    /**
     * 多条件查询
     * */
    @SelectProvider(value = TbcycleProvider.class,method = "selectByCondition")
    List<TbCycle> getByCondition(TbCycle tbCycle);
}
