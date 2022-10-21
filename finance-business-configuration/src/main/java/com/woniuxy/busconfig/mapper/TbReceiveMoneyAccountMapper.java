package com.woniuxy.busconfig.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.busconfig.provider.TbReceiveMoneyAccountMapperProvider;
import com.woniuxy.wuye.common.entity.AccountAndProject;
import com.woniuxy.wuye.common.entity.TbReceiveMoneyAccount;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * 收款账户的mapper
 * */
public interface TbReceiveMoneyAccountMapper extends BaseMapper<TbReceiveMoneyAccount> {
    /**
     * 多条件查询收款账户
     * */
@SelectProvider(value = TbReceiveMoneyAccountMapperProvider.class,method = "selectByCondition")
    List<TbReceiveMoneyAccount> getByCondition(TbReceiveMoneyAccount tbReceiveMoneyAccount);
@Insert("insert into tb_receive_money_account_project_middle(account_id,project_id) values(#{accountId},#{projectId})")
void addAccountAndProject(AccountAndProject accountAndProject);

@Delete("delete from tb_receive_money_account_project_middle where account_id=#{accountId} and project_id=#{projectId}")
void  deleteBangDingProjects(AccountAndProject accountAndProject);
    @Delete("delete from tb_receive_money_account_project_middle where account_id=#{accountId}")
void deleteAllBangDingProjects(int accountId);
}
