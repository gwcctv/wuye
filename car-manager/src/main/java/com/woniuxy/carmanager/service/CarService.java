package com.woniuxy.carmanager.service;


import com.woniuxy.wuye.common.entity.TbCar;
import com.woniuxy.wuye.common.utils.PageBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lee
 * @since 2022-10-21
 */
public interface CarService {
    /**
     * 添加车辆
     */
    boolean insertCar(TbCar tbCar);

    /**
     * 查询所有车辆及所属客户和房产
     */
    PageBean<TbCar> findCarAndHouse(int currentPage,int pageSize);

    /**
     * 条件查询车辆
     * @param tbCar
     * @return
     */
    TbCar selectCarByCondition(TbCar tbCar);

    /**
     * 更新车辆
     */
    int update(TbCar tbCar);

    /**
     * 删除车辆
     */
    int deleteById(int id);

}
