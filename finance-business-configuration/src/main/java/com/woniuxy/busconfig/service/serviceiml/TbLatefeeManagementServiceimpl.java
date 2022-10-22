package com.woniuxy.busconfig.service.serviceiml;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniuxy.busconfig.mapper.TbLatefeeManagementMapper;
import com.woniuxy.busconfig.service.TbLatefeeManagementService;
import com.woniuxy.wuye.common.entity.TbLatefeeManagement;
import com.woniuxy.wuye.common.entity.TbMeasure;
import com.woniuxy.wuye.common.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TbLatefeeManagementServiceimpl extends ServiceImpl<TbLatefeeManagementMapper, TbLatefeeManagement> implements TbLatefeeManagementService {
   @Autowired
 private    TbLatefeeManagementMapper tbLatefeeManagementMapper;
    @Override
    public PageBean<TbLatefeeManagement> getByPage(TbLatefeeManagement tbLatefeeManagement, int page) {
        //根据条件页码分页大小将PageBean中的属性一次设置
        PageBean<TbLatefeeManagement> pageBean = new PageBean<>();
        pageBean.setPageSzie(4);//分页大小
        pageBean.setCurrPage(page);    //设置当前页数
        Page p = PageHelper.startPage(pageBean.getCurrPage(), pageBean.getPageSzie());
        QueryWrapper<TbLatefeeManagement> queryWrapper =new QueryWrapper<>();
        queryWrapper.setEntity(tbLatefeeManagement);
        List<TbLatefeeManagement> list =tbLatefeeManagementMapper.selectList(queryWrapper);
        pageBean.setTotalNums((int) p.getTotal());//设置总数量
        pageBean.setTotalPage(p.getPages());
        pageBean.setData(list);//设置当前页数的数据
        pageBean.setCurrpageSzie(pageBean.getData().size());//当前页数据数量
        return pageBean;
    }
}
