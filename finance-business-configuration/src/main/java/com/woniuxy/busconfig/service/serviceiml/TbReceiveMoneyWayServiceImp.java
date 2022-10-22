package com.woniuxy.busconfig.service.serviceiml;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.busconfig.mapper.TbReceiveMoneyWayMapper;
import com.woniuxy.busconfig.service.TbReceiveMoneyWayService;
import com.woniuxy.wuye.common.entity.TbReceiveMoneyWay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TbReceiveMoneyWayServiceImp extends ServiceImpl<TbReceiveMoneyWayMapper, TbReceiveMoneyWay> implements TbReceiveMoneyWayService {
   @Autowired
   TbReceiveMoneyWayMapper tbReceiveMoneyWayMapper;

    @Override
    public List<TbReceiveMoneyWay> getByCondition(TbReceiveMoneyWay tbReceiveMoneyWay) {
        return tbReceiveMoneyWayMapper.getByCondition(tbReceiveMoneyWay);
    }
}
