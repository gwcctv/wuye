package com.woniuxy.projectmanager.service;

import com.woniuxy.wuye.common.entity.TbProject;
import com.woniuxy.wuye.common.utils.PageBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProjectService {
    /**
     * 增加项目
     * @param tbProject
     */
    void insert(TbProject tbProject);

    /**
     * 根据id删除项目
     * @param id
     */
    void delete(Integer id);

    /**
     * 多条件修改项目字段
     * @param tbProject
     */
    void update(TbProject tbProject);

    /**
     * 查询全部项目
     * @return
     */
    List<TbProject> getAll();

    /**
     * 多条件查询
     * @param tbProject
     * @return
     */
    List<TbProject> getByCondition(TbProject tbProject);

    /**
     * 根据id查询主键
     * @param id
     * @return
     */
    TbProject getById(Integer id);

    /**
     * 分页查询所有项目
     * @param pageSize
     * @param page
     * @return
     */
    PageBean<TbProject> getByPage(Integer pageSize,Integer page);

    /**
     * 多条件分页查询所有项目
     * @param tbProject
     * @param pageSize
     * @param page
     * @return
     */
    PageBean<TbProject> getByCondition(TbProject tbProject,Integer pageSize,Integer page);

    int getByName(String name);
}
