package com.woniuxy.busconfig.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.wuye.common.entity.AccountAndProject;
import com.woniuxy.wuye.common.entity.TbReceiveMoneyAccount;

import java.util.List;

public interface TbReceiveMoneyAccountService extends IService<TbReceiveMoneyAccount> {
/**
 * 多条件查询收款账户
 * */
    List<TbReceiveMoneyAccount> getByCondition(TbReceiveMoneyAccount tbReceiveMoneyAccount) throws NoSuchFieldException, IllegalAccessException, InstantiationException;
/**
 * 添加收款账户及绑定项目 项目可以为空
 *
 * */
    void add(TbReceiveMoneyAccount tbReceiveMoneyAccount,int[] projectIds);

    /**
     * 根据用户id删除相关绑定项目
     * 参数为用户id+项目ids拼接字符串
     * */
    void deleteBangDingProjects(String mixId);

    /**
     * 删除收款用户
     * */
    void deleteAccount(int accountId);
}
