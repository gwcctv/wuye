package com.woniuxy.order.service;

import com.woniuxy.wuye.common.entity.Order;
import com.woniuxy.wuye.common.entity.ResponseResult;

import java.util.List;

/**
 * @author：liangliang
 * @date:2022/10/19/19:13
 **/
public interface OrderService {
    ResponseResult  getOrderById(long orderId);

    List<Order> getAllOrder();
}
