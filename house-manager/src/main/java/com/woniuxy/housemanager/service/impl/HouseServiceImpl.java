package com.woniuxy.housemanager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniuxy.housemanager.mapper.HouseMapper;
import com.woniuxy.housemanager.service.HouseService;
import com.woniuxy.wuye.common.entity.TbBuilding;
import com.woniuxy.wuye.common.entity.TbHouse;
import com.woniuxy.wuye.common.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HouseServiceImpl extends ServiceImpl<HouseMapper,TbHouse> implements  HouseService {
    @Autowired
    HouseMapper houseMapper;
    @Override
    public void add(TbHouse tbHouse) {
        houseMapper.add(tbHouse);
    }

    @Override
    public void delete(Integer id) {
        houseMapper.delete(id);
    }

    @Override
    public void update(TbHouse tbHouse) {
        houseMapper.update(tbHouse);
    }

    @Override
    public List<TbHouse> getByCondition(TbHouse tbHouse) {
        return houseMapper.getByCondition(tbHouse);
    }

    @Override
    public List<TbHouse> getAll() {
        return houseMapper.getAll();
    }

    @Override
    public PageBean<TbHouse> getByPage(Integer pageSize, Integer page) {
        PageBean<TbHouse> pageBean=new PageBean<>();
        pageBean.setPageSzie(pageSize);
        pageBean.setCurrPage(page);
        Page p = PageHelper.startPage(page,pageSize);
        List<TbHouse> list = houseMapper.getAll();//根据条件
        pageBean.setTotalNums((int) p.getTotal());//设置总数量
        pageBean.setTotalPage(p.getPages());
        pageBean.setData(list);//设置当前页数的数据
        pageBean.setCurrpageSzie(pageBean.getData().size());//当前页数据数量
        return pageBean;
    }

    @Override
    public PageBean<TbHouse> getByCondition(TbHouse tbHouse, Integer pageSize, Integer page) {
        PageBean<TbHouse> pageBean=new PageBean<>();
        pageBean.setPageSzie(pageSize);
        pageBean.setCurrPage(page);
        Page p = PageHelper.startPage(page,pageSize);
        List<TbHouse> list = houseMapper.getByCondition(tbHouse);//根据条件
        pageBean.setTotalNums((int) p.getTotal());//设置总数量
        pageBean.setTotalPage(p.getPages());
        pageBean.setData(list);//设置当前页数的数据
        pageBean.setCurrpageSzie(pageBean.getData().size());//当前页数据数量
        return pageBean;
    }
}
