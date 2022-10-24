package com.woniuxy.carmanager.service.impl;

import com.woniuxy.carmanager.mapper.CarMapper;
import com.woniuxy.carmanager.service.CarService;
import com.woniuxy.wuye.common.entity.TbCar;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lee
 * @since 2022-10-21
 */
@Service
public class CarServiceImpl implements CarService {
    @Resource
    private CarMapper carMapper;

    @Override
    public boolean insertCar(TbCar tbCar) {
        return carMapper.insertCar(tbCar);
    }

    @Override
    public List<TbCar> findCarAndHouse() {
        return null;
    }

    @Override
    public List<TbCar> selectCarByCondition(TbCar tbCar) {
        return null;
    }
}
