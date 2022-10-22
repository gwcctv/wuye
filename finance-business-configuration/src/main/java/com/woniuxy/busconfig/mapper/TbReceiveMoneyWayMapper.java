package com.woniuxy.busconfig.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.woniuxy.busconfig.provider.TbReceiveMoneyWayMapperProvider;
import com.woniuxy.wuye.common.entity.TbReceiveMoneyWay;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface TbReceiveMoneyWayMapper extends BaseMapper<TbReceiveMoneyWay> {
    /**
     * 多条件查询
     * */
@SelectProvider(value = TbReceiveMoneyWayMapperProvider.class,method = "selectByCondition")
    List<TbReceiveMoneyWay> getByCondition(TbReceiveMoneyWay tbReceiveMoneyWay);
}
