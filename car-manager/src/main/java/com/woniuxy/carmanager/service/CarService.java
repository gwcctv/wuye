package com.woniuxy.carmanager.service;


import com.woniuxy.wuye.common.entity.TbCar;

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
    List<TbCar> findCarAndHouse();

    /**
     * 条件查询车辆
     * @param tbCar
     * @return
     */
    List<TbCar> selectCarByCondition(TbCar tbCar);

}
