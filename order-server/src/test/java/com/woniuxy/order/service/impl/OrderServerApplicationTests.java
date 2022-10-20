package com.woniuxy.order.service.impl;

import com.woniuxy.order.mapper.OrderMapper;
import com.woniuxy.order.service.OrderService;
import com.woniuxy.wuye.common.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderServerApplicationTests {
    @Autowired
    OrderService orderService;

    @Autowired
    OrderMapper orderMapper;


    @Test
    void contextLoads() {
    }
    @Test
    void test01(){
        System.out.println(orderService.getOrderById(1));
    }


}
