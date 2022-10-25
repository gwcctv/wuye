package com.woniuxy.carmanager.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniuxy.carmanager.mapper.CarMapper;
import com.woniuxy.carmanager.service.CarService;
import com.woniuxy.wuye.common.entity.TbCar;
import com.woniuxy.wuye.common.entity.TbClient;
import com.woniuxy.wuye.common.utils.PageBean;
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
    public PageBean<TbCar> findCarAndHouse(int currentPage,int pageSize) {
        //设置分页
        PageBean<TbCar> pageBean = new PageBean<>();
        pageBean.setPageSzie(pageSize); //分页大小
        pageBean.setCurrPage(currentPage); //当前页码
        Page<TbClient> page = PageHelper.startPage(pageBean.getCurrPage(), pageBean.getPageSzie());
        List<TbCar> allCar = carMapper.findCarAndHouse();
        pageBean.setTotalNums((int) page.getTotal()); //总条数
        pageBean.setTotalPage(page.getPages()); //总页数
        pageBean.setData(allCar);   //设置数据
        pageBean.setCurrpageSzie(pageBean.getData().size()); //当前页展示数据条数
        return pageBean;
    }

    @Override
    public TbCar selectCarByCondition(TbCar tbCar) {
        return carMapper.selectCarByCondition(tbCar);
    }

    @Override
    public int update(TbCar tbCar) {
        return carMapper.update(tbCar);
    }

    @Override
    public int deleteById(int id) {
        return carMapper.deleteById(id);
    }
}
