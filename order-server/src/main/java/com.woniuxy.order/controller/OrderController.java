package com.woniuxy.order.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.woniuxy.order.service.OrderService;
import com.woniuxy.wuye.common.entity.Order;
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

    @PostMapping("/create")
    public ResponseResult createDepartment(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PostMapping("/page")
    public ResponseResult getPage(@RequestParam Integer currentPage,
                                  @RequestParam Integer pageSize,
                                  @RequestBody Order order){
        IPage<Order> page=orderService.getPage(currentPage,pageSize,order);
        if (currentPage > page.getPages()){
            page=orderService.getPage((int) page.getPages(),pageSize,order);
        }
        return new ResponseResult(200,"ok",page);
    }

}
