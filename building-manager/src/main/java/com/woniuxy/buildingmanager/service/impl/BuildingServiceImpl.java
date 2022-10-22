package com.woniuxy.buildingmanager.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniuxy.buildingmanager.mapper.BuildingMapper;
import com.woniuxy.buildingmanager.service.BuildingService;
import com.woniuxy.wuye.common.entity.TbBuilding;
import com.woniuxy.wuye.common.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    BuildingMapper buildingMapper;
    @Override
    public void insert(TbBuilding tbBuilding) {
        buildingMapper.insert(tbBuilding);
    }

    @Override
    public void delete(Integer id) {
        buildingMapper.delete(id);
    }

    @Override
    public void update(TbBuilding tbBuilding) {
        buildingMapper.update(tbBuilding);
    }

    @Override
    public List<TbBuilding> getByCondition(TbBuilding tbBuilding) {
        return buildingMapper.getByCondition(tbBuilding);
    }

    @Override
    public List<TbBuilding> getAll() {
        return buildingMapper.getAll();
    }

    @Override
    public PageBean<TbBuilding> getByPage(Integer pageSize, Integer page) {
        PageBean<TbBuilding> pageBean=new PageBean<>();
        pageBean.setPageSzie(pageSize);
        pageBean.setCurrPage(page);
        Page p = PageHelper.startPage(page,pageSize);
        List<TbBuilding> list = buildingMapper.getAll();//根据条件
        pageBean.setTotalNums((int) p.getTotal());//设置总数量
        pageBean.setTotalPage(p.getPages());
        pageBean.setData(list);//设置当前页数的数据
        pageBean.setCurrpageSzie(pageBean.getData().size());//当前页数据数量
        return pageBean;
    }

    @Override
    public PageBean<TbBuilding> getByCondition(TbBuilding tbBuilding, Integer pageSize, Integer page) {
        PageBean<TbBuilding> pageBean=new PageBean<>();
        pageBean.setPageSzie(pageSize);
        pageBean.setCurrPage(page);
        Page p = PageHelper.startPage(page,pageSize);
        List<TbBuilding> list = buildingMapper.getByCondition(tbBuilding);//根据条件
        pageBean.setTotalNums((int) p.getTotal());//设置总数量
        pageBean.setTotalPage(p.getPages());
        pageBean.setData(list);//设置当前页数的数据
        pageBean.setCurrpageSzie(pageBean.getData().size());//当前页数据数量
        return pageBean;
    }

}
