package com.woniuxy.wuye.cash.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniuxy.wuye.cash.map.TbUnpaidBillsMapper;
import com.woniuxy.wuye.cash.service.CashRegisterService;
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
    @Autowired
    TbUnpaidBillsMapper tbUnpaidBillsMapper;
    @Override
    public PageBean<TbUnpaidBills> selectUnpaidBillsByPage(Integer pageNum, Integer pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<TbUnpaidBills> list = tbUnpaidBillsMapper.getAll();
        PageBean<TbUnpaidBills> pageBean = PageBeanUtil.getPageBean(page, list);
        return pageBean;
    }
}
