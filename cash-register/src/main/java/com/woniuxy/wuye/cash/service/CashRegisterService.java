package com.woniuxy.wuye.cash.service;

import com.woniuxy.wuye.common.entity.TbUnpaidBills;
import com.woniuxy.wuye.common.utils.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/20
 **/

public interface CashRegisterService {
    /**
     * 分页查询所有的未付账单
     * @return
     */
    PageBean<TbUnpaidBills> selectUnpaidBillsByPage(Integer pageNum, Integer pageSize);
}
