package com.woniuxy.wuye.cash.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniuxy.wuye.cash.map.TbDepositedFeesMapper;
import com.woniuxy.wuye.cash.map.TbUnpaidBillsMapper;
import com.woniuxy.wuye.cash.service.CashRegisterService;
import com.woniuxy.wuye.cash.utils.ConditionVo;
import com.woniuxy.wuye.common.entity.TbDepositedFees;
import com.woniuxy.wuye.common.entity.TbUnpaidBills;
import com.woniuxy.wuye.common.utils.PageBean;
import com.woniuxy.wuye.cash.utils.PageBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/20
 **/
@Service
public class CashRegisterServiceImpl implements CashRegisterService {
    @Autowired(required = false)
    TbUnpaidBillsMapper tbUnpaidBillsMapper;
    @Override
    public PageBean<TbUnpaidBills> selectUnpaidBillsPageByCondition(Integer pageNum, Integer pageSize, ConditionVo conditionVo) {
        //获取封装查询条件

        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<TbUnpaidBills> list = tbUnpaidBillsMapper.getByCondition(conditionVo);

        PageBean<TbUnpaidBills> pageBean = PageBeanUtil.getPageBean(page, list);
        return pageBean;
    }


    @Autowired(required = false)
    private TbDepositedFeesMapper tbDepositedFeesMapper;

    /**
     * 分页查出预存列表
     * @param pageNum
     * @param pageSize
     * @param conditionVo
     * @return
     */
    @Override
    public PageBean<TbDepositedFees> selectDepositedFeesPageByCondition(Integer pageNum, Integer pageSize, ConditionVo conditionVo) {
        //分页查出预存总表记录
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<TbDepositedFees> list = tbDepositedFeesMapper.getByCondition(conditionVo);
        return PageBeanUtil.getPageBean(page,list);
    }


}
