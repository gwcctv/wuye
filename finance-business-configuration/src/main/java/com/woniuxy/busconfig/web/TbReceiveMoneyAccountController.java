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
    public List<TbReceiveMoneyAccount> getByCondition(@RequestBody TbReceiveMoneyAccount tbReceiveMoneyAccount){
     return  tbReceiveMoneyAccountService.getByCondition(tbReceiveMoneyAccount);
    }
    public ResponseEntity add(@RequestBody TbReceiveMoneyAccount tbReceiveMoneyAccount,String ids){
         int[] id=StringChuLi.chuLi(ids);
         tbReceiveMoneyAccountService.add(tbReceiveMoneyAccount,id);
         return ResponseEntity.SUCCESS;
    }

}
