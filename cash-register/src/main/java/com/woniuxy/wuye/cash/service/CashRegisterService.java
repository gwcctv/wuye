package com.woniuxy.wuye.cash.service;

import com.woniuxy.wuye.cash.utils.ConditionVo;
import com.woniuxy.wuye.common.entity.*;
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
     * 分页查询多条件所有的未付账单
     * @return
     */
    PageBean<TbUnpaidBills> selectUnpaidBillsPageByCondition(Integer pageNum, Integer pageSize, ConditionVo conditionVo);

    /**
     * 分页多条件查询预存表单
     * @param pageNum
     * @param pageSize
     * @param conditionVo
     * @return
     */
    PageBean<TbDepositedFees> selectDepositedFeesPageByCondition(Integer pageNum, Integer pageSize, ConditionVo conditionVo);

    /**
     * 新增未支付单
     * @param tbUnpaidBills
     * @return
     */
    Integer addUnpaidBills(TbUnpaidBills tbUnpaidBills);

    /**
     * 作废未支付单
     * @param id
     */
    void invalidUnpaidBills(Integer id);

    /**
     * 未支付账单减免操作
     * @param id
     * @param tbCheckReduce
     */
    void billsReduce(Integer id, TbCheckReduce tbCheckReduce);

    /**
     * 返回给前端收款单的单据号
     * @param tbPaidBills
     * @return
     */
    String crediting(TbPaidBills tbPaidBills);
}
