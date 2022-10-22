package com.woniuxy.busconfig.web;

import com.woniuxy.busconfig.service.TbReceiveMoneyAccountService;
import com.woniuxy.wuye.common.entity.TbReceiveMoneyAccount;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import com.woniuxy.wuye.common.utils.StringChuLi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("receiveMoneyAccount")
@Transactional(rollbackFor = Exception.class)
public class TbReceiveMoneyAccountController {
    @Autowired
    TbReceiveMoneyAccountService tbReceiveMoneyAccountService;
    @RequestMapping("getByCondition")
    public List<TbReceiveMoneyAccount> getByCondition(@RequestBody TbReceiveMoneyAccount tbReceiveMoneyAccount) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
     return  tbReceiveMoneyAccountService.getByCondition(tbReceiveMoneyAccount);
    }

    /**
     * 添加收款账户及绑定项目 项目可以为空
     *
     * */
    @RequestMapping("add")
    public ResponseEntity add(@RequestBody TbReceiveMoneyAccount tbReceiveMoneyAccount,String ids){
         int[] id=StringChuLi.chuLi(ids);
         tbReceiveMoneyAccountService.add(tbReceiveMoneyAccount,id);
         return ResponseEntity.SUCCESS;
    }
    /**
     * 根据用户id删除相关绑定项目
     * 参数为用户id+项目ids拼接字符串
     * */
    @RequestMapping("deleteBangDingProjects")
    public ResponseEntity deleteBangDingProjects(String mixIds){
        tbReceiveMoneyAccountService.deleteBangDingProjects(mixIds);
        return ResponseEntity.SUCCESS;
    }

    /**
     * 删除收款用户
     * */
    @RequestMapping("deleteAccount")
   public ResponseEntity deleteAccount(int accountId){
       tbReceiveMoneyAccountService.deleteAccount(accountId);
       return ResponseEntity.SUCCESS;
   }

}
