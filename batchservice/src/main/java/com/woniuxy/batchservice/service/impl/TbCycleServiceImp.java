package com.woniuxy.batchservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniuxy.batchservice.dao.TbCycleMapper;

import com.woniuxy.batchservice.service.TbCycleService;

import com.woniuxy.wuye.common.entity.TbCycle;
import com.woniuxy.wuye.common.utils.PageBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class TbCycleServiceImp extends ServiceImpl<TbCycleMapper, TbCycle> implements TbCycleService {
    @Autowired
    private TbCycleMapper tbCycleMapper;


    @Override
    public PageBean<TbCycle> getByConditionByPage(TbCycle tbCycle,int page) {

        PageBean<TbCycle> pageBean = new PageBean<>();
        pageBean.setPageSzie(20);//分页大小
        pageBean.setCurrPage(page);    //设置当前页数
        Page p = PageHelper.startPage(pageBean.getCurrPage(), pageBean.getPageSzie());
        List<TbCycle> list = tbCycleMapper.getByCondition(tbCycle);
        pageBean.setTotalNums((int) p.getTotal());//设置总数量
        pageBean.setTotalPage(p.getPages());
        pageBean.setData(list);//设置当前页数的数据
        pageBean.setCurrpageSzie(pageBean.getData().size());//当前页数据数量
         return pageBean;
    }
}
