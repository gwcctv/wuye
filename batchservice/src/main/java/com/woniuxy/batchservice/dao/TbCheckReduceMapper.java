package com.woniuxy.batchservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.woniuxy.batchservice.provider.TbCheckReduceProvider;
import com.woniuxy.wuye.common.entity.TbCheckReduce;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
/**
 * 批量减免申请mapper
 * */
public interface TbCheckReduceMapper extends BaseMapper<TbCheckReduce> {
/**
 * 多条件查询
 * */
@SelectProvider(value = TbCheckReduceProvider.class,method = "selectByCondition")
    List<TbCheckReduce> getByCondition(TbCheckReduce tbCheckReduce);
}
