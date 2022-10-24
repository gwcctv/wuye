package com.woniuxy.carmanager.controller;


import com.woniuxy.carmanager.service.CarService;
import com.woniuxy.wuye.common.entity.TbCar;
import com.woniuxy.wuye.common.entity.TbClient;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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

}

