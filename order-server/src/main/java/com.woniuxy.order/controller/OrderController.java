package com.woniuxy.order.controller;

import com.woniuxy.order.service.OrderService;
import com.woniuxy.wuye.common.entity.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author：liangliang
 * @date:2022/10/20/09:39
 **/
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/{orderId}")
    public ResponseResult getOrderById(@PathVariable("orderId") long orderId){
        return orderService.getOrderById(orderId);
    }

}
