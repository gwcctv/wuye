package com.woniuxy.busconfig.mapper;

import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.busconfig.provider.TbReceiveMoneyAccountMapperProvider;
import com.woniuxy.wuye.common.entity.TbReceiveMoneyAccount;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * 收款账户的mapper
 * */
public interface TbReceiveMoneyAccountMapper extends IService<TbReceiveMoneyAccount> {
@SelectProvider(value = TbReceiveMoneyAccountMapperProvider.class,method = "selectByCondition")
    List<TbReceiveMoneyAccount> getByCondition(TbReceiveMoneyAccount tbReceiveMoneyAccount);

}
