package com.woniuxy.buildingmanager.service;

import com.woniuxy.wuye.common.entity.TbBuilding;
import com.woniuxy.wuye.common.utils.PageBean;

import java.util.List;

public interface BuildingService {
    /**
     * 增加楼栋
     * @param tbBuilding
     */
    void insert(TbBuilding tbBuilding);

    /**
     * 删除楼楼栋
     * @param id
     */
    void delete(Integer id);

    /**
     * 多条件修改
     * @param tbBuilding
     */
    void update(TbBuilding tbBuilding);

    /**
     * 多条件查询
     * @param tbBuilding
     * @return
     */
    List<TbBuilding> getByCondition(TbBuilding tbBuilding);

    /**
     * 查询所有楼
     * @return
     */
    List<TbBuilding> getAll();
    /**
     * 分页查询所有楼栋
     */
    PageBean<TbBuilding> getByPage(Integer pageSize, Integer page);

    /**
     * 多条件分页
     */
    PageBean<TbBuilding> getByCondition(TbBuilding tbBuilding,Integer pageSize, Integer page);


}
