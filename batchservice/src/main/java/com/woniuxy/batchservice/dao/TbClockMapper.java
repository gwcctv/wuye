package com.woniuxy.batchservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.woniuxy.batchservice.provider.TbClockProvider;
import com.woniuxy.wuye.common.entity.TbClock;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * 抄表mapper
 * */
public interface TbClockMapper extends BaseMapper<TbClock> {
@SelectProvider(value = TbClockProvider.class,method = "selectByCondition")
    List<TbClock> getByCondition(TbClock tbClock);

}
