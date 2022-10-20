package com.woniuxy.order.service.impl;

import com.woniuxy.order.mapper.OrderMapper;
import com.woniuxy.order.service.OrderService;
import com.woniuxy.wuye.common.entity.Order;
import com.woniuxy.wuye.common.entity.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author：liangliang
 * @date:2022/10/19/19:16
 **/
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public ResponseResult getOrderById(long orderId) {
        Order order=orderMapper.selectById(orderId);
        if (order == null) {
            throw new RuntimeException("根据id查询订单失败");
        }
        return new ResponseResult<Order>(200, "查询成功", order);

    }

    @Override
    public List<Order> getAllOrder() {
        List<Order> orderList=orderMapper.selectList(null);

        return orderList;
    }

}
