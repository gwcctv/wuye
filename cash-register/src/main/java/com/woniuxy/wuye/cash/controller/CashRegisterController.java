package com.woniuxy.wuye.cash.controller;

import com.woniuxy.wuye.cash.map.TbDepositedFeesMapper;
import com.woniuxy.wuye.cash.service.CashRegisterService;
import com.woniuxy.wuye.cash.utils.ConditionVo;
import com.woniuxy.wuye.common.entity.TbUnpaidBills;
import com.woniuxy.wuye.common.utils.PageBean;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/20
 **/
@RestController
@RequestMapping("/cashregister")
public class CashRegisterController {
    @Autowired
    CashRegisterService cashRegisterService;

    /**
     * 多条件分页查询所有
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/unpaidbills/querypagecondition")
    public ResponseEntity queryUnpaidBillsPageCondition(Integer pageNum, Integer pageSize, ConditionVo conditionVo){
        PageBean<TbUnpaidBills> pageBean = cashRegisterService.selectUnpaidBillsPageByCondition(pageNum, pageSize,conditionVo);
        return new ResponseEntity("200","ok",pageBean);
    }



    @RequestMapping("/depositedfees/querypagecondition")
    public ResponseEntity queryDepositedFeesPageByCondition(Integer pageNum, Integer pageSize,ConditionVo conditionVo){
        cashRegisterService.selectDepositedFeesPageByCondition(pageNum,pageSize,conditionVo);
        return new ResponseEntity("200","ok",null);
    }
}
