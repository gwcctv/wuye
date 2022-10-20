package com.woniuxy.batchservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniuxy.batchservice.dao.TbCheckReduceMapper;
import com.woniuxy.batchservice.service.TbCheckReduceService;
import com.woniuxy.wuye.common.entity.TbCheckReduce;
import com.woniuxy.wuye.common.entity.TbClock;
import com.woniuxy.wuye.common.entity.TbCycle;
import com.woniuxy.wuye.common.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TbCheckReduceServiceImp extends ServiceImpl<TbCheckReduceMapper, TbCheckReduce> implements TbCheckReduceService {
    @Autowired
    TbCheckReduceMapper tbCheckReduceMapper;
    @Override
    public PageBean<TbCheckReduce> getByCondition(TbCheckReduce tbCheckReduce,int page) {
        PageBean<TbCheckReduce> pageBean = new PageBean<>();
        pageBean.setPageSzie(4);//分页大小
        pageBean.setCurrPage(page);    //设置当前页数
        Page p = PageHelper.startPage(pageBean.getCurrPage(), pageBean.getPageSzie());
        List<TbCheckReduce> list = tbCheckReduceMapper.getByCondition(tbCheckReduce);
        pageBean.setTotalNums((int) p.getTotal());//设置总数量
        pageBean.setTotalPage(p.getPages());
        pageBean.setData(list);//设置当前页数的数据
        pageBean.setCurrpageSzie(pageBean.getData().size());//当前页数据数量
         return pageBean;

    }
}
