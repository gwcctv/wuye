package com.woniuxy.wuye.cash.controller;

import com.woniuxy.wuye.cash.service.CashRegisterService;
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
    @RequestMapping("/unpaidbills/querypage")
    public ResponseEntity queryAllUnpaidBills(Integer pageNum, Integer pageSize){
        PageBean<TbUnpaidBills> pageBean = cashRegisterService.selectUnpaidBillsByPage(pageNum, pageSize);
        return new ResponseEntity("200","ok",pageBean);
    }
}
