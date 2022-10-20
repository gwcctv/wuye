package com.woniuxy.order.service.impl;

import com.woniuxy.order.mapper.OrderMapper;
import com.woniuxy.order.service.OrderService;
import com.woniuxy.wuye.common.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

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

    @Test
    void test02(){

        Order order = new Order();
//        order.setAccepter("SS");
//        order.setDescription("wwww");
//        order.setPlanType("计划");
//        order.setLocation("cahngku");
//        order.setProjectName("寻金");
//        order.setReporter("ll");
        order.setState("已超时");
//        order.setOrderNum("ord123456");
//        order.setOrderId(22);
//        order.setReportDate(new Date());
//        orderService.createOrder(order);
        System.out.println(orderService.getPage(1, 2, order));
    }

}
