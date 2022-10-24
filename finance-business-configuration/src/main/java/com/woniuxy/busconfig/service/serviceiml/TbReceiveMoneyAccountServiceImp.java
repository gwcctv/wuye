package com.woniuxy.busconfig.service.serviceiml;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniuxy.busconfig.mapper.TbReceiveMoneyAccountMapper;
import com.woniuxy.busconfig.service.TbReceiveMoneyAccountService;
import com.woniuxy.wuye.common.entity.AccountAndProject;
import com.woniuxy.wuye.common.entity.TbReceiveMoneyAccount;
import com.woniuxy.wuye.common.utils.ChuLIjiHe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TbReceiveMoneyAccountServiceImp extends ServiceImpl<TbReceiveMoneyAccountMapper, TbReceiveMoneyAccount> implements TbReceiveMoneyAccountService {
   @Autowired
   TbReceiveMoneyAccountMapper tbReceiveMoneyAccountMapper;

   /**
    * 多条件查询收款账户
    * */
    @Override
    public List<TbReceiveMoneyAccount> getByCondition(TbReceiveMoneyAccount tbReceiveMoneyAccount) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        List<TbReceiveMoneyAccount> tbReceiveMoneyAccounts=tbReceiveMoneyAccountMapper.getByCondition(tbReceiveMoneyAccount);
        ChuLIjiHe.get(tbReceiveMoneyAccounts,"id","projectId","projectIds","projectName","projectNames");
        return tbReceiveMoneyAccounts;
    }

    @Override
    public void add(TbReceiveMoneyAccount tbReceiveMoneyAccount, int[] projectIds) {
        int id= tbReceiveMoneyAccountMapper.insert(tbReceiveMoneyAccount);
        AccountAndProject accountAndProject=new AccountAndProject();
        accountAndProject.setAccountId(id);
        if(projectIds.length!=0&&projectIds!=null) {
            for (int i : projectIds) {
                accountAndProject.setProjectId(i);
                tbReceiveMoneyAccountMapper.addAccountAndProject(accountAndProject);
            }
        }
    }

    @Override
    public void deleteBangDingProjects(String mixId) {
        String[] mixIds=mixId.split(",");
        int[] ids=new int[mixIds.length];
        int accountId=Integer.parseInt(mixIds[0]);
        for(int i=1;i<mixIds.length;i++){
            ids[i-1]= Integer.parseInt(mixIds[i]);
        }
        AccountAndProject accountAndProject=new AccountAndProject();
        accountAndProject.setAccountId(accountId);
        for(int j:ids){
            accountAndProject.setProjectId(j);
            tbReceiveMoneyAccountMapper.deleteBangDingProjects(accountAndProject);
        }
    }

    @Override
    public void deleteAccount(int accountId) {
        tbReceiveMoneyAccountMapper.deleteById(accountId);
        tbReceiveMoneyAccountMapper.deleteAllBangDingProjects(accountId);
    }
}
