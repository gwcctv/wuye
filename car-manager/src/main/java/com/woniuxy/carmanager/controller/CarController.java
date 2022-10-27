package com.woniuxy.carmanager.controller;


import com.woniuxy.carmanager.service.CarService;
import com.woniuxy.wuye.common.entity.TbCar;
import com.woniuxy.wuye.common.entity.TbClient;
import com.woniuxy.wuye.common.utils.PageBean;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lee
 * @since 2022-10-21
 */
@Controller
@RequestMapping("/tb_car")
public class CarController {
    @Resource
    private CarService carService;

    /**
     * 添加车辆
     * @param tbCar
     * @return
     */
    @PostMapping("/insertCar")
    public ResponseEntity insertClient(@RequestBody TbCar tbCar) {
        Boolean flag = carService.insertCar(tbCar);
        ResponseEntity responseEntity = new ResponseEntity<>();
        if(flag=false){
            responseEntity.setCode("201");
            responseEntity.setMsg("添加失败");
        }else {
            responseEntity.setCode("200");
            responseEntity.setMsg("添加成功");
        }
        return responseEntity;
    }

    /**
     * 分页查询车辆及其房产
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/findCarAndHouse/{currentPage}/{pageSize}")
    public ResponseEntity findCarAndHouse(@PathVariable int currentPage,@PathVariable int pageSize){
        PageBean<TbCar> carAndHouse = carService.findCarAndHouse(currentPage, pageSize);
        ResponseEntity responseEntity = new ResponseEntity<>();
        if(carAndHouse!=null){
            responseEntity.setCode("200");
            responseEntity.setMsg("查询成功");
            responseEntity.setData(carAndHouse);
        }else {
            responseEntity.setCode("201");
            responseEntity.setMsg("查询失败");
        }
        return responseEntity;
    }

    /**
     * 条件查询车辆
     * @param tbCar
     * @return
     */
    @PostMapping("/selectCarByCondition")
    public ResponseEntity selectCarByCondition(@RequestBody TbCar tbCar){
        TbCar car = carService.selectCarByCondition(tbCar);
        ResponseEntity responseEntity = new ResponseEntity<>();
        if(car!=null){
            responseEntity.setCode("200");
            responseEntity.setMsg("查询成功");
            responseEntity.setData(car);
        }else {
            responseEntity.setCode("201");
            responseEntity.setMsg("没有符合条件的车辆");
        }
        return responseEntity;
    }

    /**
     * 修改车辆信息
     * @param tbCar
     * @return
     */
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody TbCar tbCar) {
        int flag = carService.update(tbCar);
        ResponseEntity responseEntity = new ResponseEntity<>();
        if(flag==0){
            responseEntity.setCode("201");
            responseEntity.setMsg("修改失败");
        }else {
            responseEntity.setCode("200");
            responseEntity.setMsg("修改成功");
        }
        return responseEntity;
    }

    @PostMapping("deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable int id){
        int i = carService.deleteById(id);
        ResponseEntity responseEntity = new ResponseEntity<>();
        if(i==1){
            responseEntity.setCode("200");
            responseEntity.setMsg("删除成功");
        }else {
            responseEntity.setCode("201");
            responseEntity.setMsg("删除失败");
        }
        return responseEntity;
    }
}

