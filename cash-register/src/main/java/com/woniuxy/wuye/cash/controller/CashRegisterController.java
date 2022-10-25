package com.woniuxy.wuye.cash.controller;

import com.woniuxy.wuye.cash.map.TbDepositedFeesMapper;
import com.woniuxy.wuye.cash.openfeign.HouseOpenFeign;
import com.woniuxy.wuye.cash.service.CashRegisterService;
import com.woniuxy.wuye.cash.utils.ConditionVo;
import com.woniuxy.wuye.common.entity.*;
import com.woniuxy.wuye.common.utils.PageBean;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/20
 **/
@RestController
@RequestMapping("/cashregister")
public class CashRegisterController {
    @Value("${web.pageSize}")
    private Integer pageSize;
    @Autowired
    private CashRegisterService cashRegisterService;

    /**
     * 多条件分页查询所有,不带条件初始化查询，带条件多条件查询
     * @param pageNum
     * @param conditionVo
     * @return
     */
    @RequestMapping("/unpaidbills/querypagecondition")
    public ResponseEntity queryUnpaidBillsPageCondition(Integer pageNum,ConditionVo conditionVo){
        PageBean<TbUnpaidBills> pageBean = cashRegisterService.selectUnpaidBillsPageByCondition(pageNum, pageSize,conditionVo);
        return new ResponseEntity("200","ok",pageBean);
    }

    /**
     * 新增未支付账单返回主键
     * @param tbUnpaidBills
     * @return
     */
    @RequestMapping("/unpaidbills/addunpaidbills")
    public ResponseEntity addUnpaidBills(@RequestBody TbUnpaidBills tbUnpaidBills){
        Integer id = cashRegisterService.addUnpaidBills(tbUnpaidBills);
        return new ResponseEntity("200","ok",id);
    }

    /**
     * 作废未支付账单
     * @param id
     * @return
     */
    @RequestMapping("/unpaidbills/invalidunpaidbills")
    public ResponseEntity invalidUnpaidBills(Integer id){

       cashRegisterService.invalidUnpaidBills(id);
        return ResponseEntity.SUCCESS;
    }

    /**
     * 减免未支付账单，
     * 前端带来未支付账单的id，和一个减免的详细账单
     * @param id
     * @return
     */
    @RequestMapping("/unpaidbills/billsreduce")
    public ResponseEntity billsReduce(Integer id,TbCheckReduce TbCheckReduce){
        //将数据传输到业务层；
       cashRegisterService.billsReduce(id,TbCheckReduce);
       //减免成功刷新前端
        return ResponseEntity.SUCCESS;
    }

    /**
     * 收款，前端传入收款单数据，创建收款单初始状态为支付失败
     * @return 收款单的id
     */
    @RequestMapping("/unpaidbills/crediting")
    public ResponseEntity crediting(TbPaidBills tbPaidBills){
        String payBillId = cashRegisterService.crediting(tbPaidBills);
        return new ResponseEntity("200","ok",payBillId);
    }

    /**
     * 分页查询预存表数据
     * @param pageNum
     * @param conditionVo
     * @return
     */
    @RequestMapping("/depositedfees/querypagecondition")
    public ResponseEntity queryDepositedFeesPageByCondition(Integer pageNum,ConditionVo conditionVo){
        PageBean<TbDepositedFees> tbDepositedFeesPageBean = cashRegisterService.selectDepositedFeesPageByCondition(pageNum, pageSize, conditionVo);

        return new ResponseEntity("200","ok",null);
    }

}