package com.woniuxy.projectmanager.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniuxy.projectmanager.mapper.ProjectMapper;
import com.woniuxy.projectmanager.service.ProjectService;
import com.woniuxy.wuye.common.entity.TbProject;
import com.woniuxy.wuye.common.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectMapper projectMapper;
    @Override
    public void insert(TbProject tbProject) {
        projectMapper.insert(tbProject);
    }

    @Override
    public void delete(Integer id) {
        projectMapper.delete(id);
    }

    @Override
    public void update(TbProject tbProject) {
        projectMapper.updeta(tbProject);
    }

    @Override
    public List<TbProject> getAll() {
        return projectMapper.getAll();
    }

    @Override
    public List<TbProject> getByCondition(TbProject tbProject) {
        return projectMapper.getByCondition(tbProject);
    }

    @Override
    public TbProject getById(Integer id) {
        return projectMapper.getById(id);
    }

    @Override
    public PageBean<TbProject> getByPage(Integer pageSize, Integer page) {
        PageBean<TbProject> pageBean=new PageBean();
        pageBean.setPageSzie(pageSize);
        pageBean.setCurrPage(page);
        Page<TbProject> p = PageHelper.startPage(page,pageSize);
        List<TbProject> list = projectMapper.getAll();
        pageBean.setData(list);
        pageBean.setTotalNums((int)p.getTotal());
        pageBean.setTotalPage(p.getPages());
        pageBean.setCurrpageSzie(pageBean.getData().size());
        return pageBean;
    }

    @Override
    public PageBean<TbProject> getByCondition(TbProject tbProject, Integer pageSize, Integer page) {
        PageBean<TbProject> pageBean=new PageBean();
        pageBean.setPageSzie(pageSize);
        pageBean.setCurrPage(page);
        Page<TbProject> p = PageHelper.startPage( page,pageSize);
        List<TbProject> list = projectMapper.getByCondition(tbProject);
        pageBean.setData(list);
        pageBean.setTotalNums((int)p.getTotal());
        pageBean.setTotalPage(p.getPages());
        pageBean.setCurrpageSzie(pageBean.getData().size());
        return pageBean;
    }

    @Override
    public int getByName(String name) {
        return projectMapper.getByName(name);
    }
}
