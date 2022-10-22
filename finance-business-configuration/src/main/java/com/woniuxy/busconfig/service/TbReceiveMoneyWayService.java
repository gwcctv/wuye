package com.woniuxy.busconfig.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.wuye.common.entity.TbReceiveMoneyWay;

import java.util.List;

public interface TbReceiveMoneyWayService extends IService<TbReceiveMoneyWay> {

    List<TbReceiveMoneyWay> getByCondition(TbReceiveMoneyWay tbReceiveMoneyWay);
}
