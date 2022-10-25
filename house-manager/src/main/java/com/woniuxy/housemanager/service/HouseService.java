package com.woniuxy.housemanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.wuye.common.entity.TbBuilding;
import com.woniuxy.wuye.common.entity.TbHouse;
import com.woniuxy.wuye.common.utils.PageBean;

import java.util.List;

public interface HouseService extends IService<TbHouse> {
    /**
     * 增加房
     * @param tbHouse
     */
    void add(TbHouse tbHouse);

    /**
     * 删除房屋
     * @param id
     */
    void delete(Integer id);

    /**
     * 多条件修改
     * @param tbHouse
     */
    void update(TbHouse tbHouse);

    /**
     * 多条件查询
     * @param tbHouse
     * @return
     */
    List<TbHouse> getByCondition(TbHouse tbHouse);

    /**
     * 查询全部
     * @return
     */
    List<TbHouse> getAll();

    /**
     * 分页查询所有房产
     */
    PageBean<TbHouse> getByPage(Integer pageSize, Integer page);

    /**
     * 多条件分页
     */
    PageBean<TbHouse> getByCondition(TbHouse tbHouse,Integer pageSize, Integer page);
}
