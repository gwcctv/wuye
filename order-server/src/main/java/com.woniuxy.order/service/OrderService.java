package com.woniuxy.order.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.woniuxy.wuye.common.entity.Order;
import com.woniuxy.wuye.common.entity.ResponseResult;

import java.util.List;

/**
 * @author：liangliang
 * @date:2022/10/19/19:13
 **/
public interface OrderService {
    /**
     * 根据orderId查询order
     * @param orderId
     * @return
     */
    ResponseResult  getOrderById(long orderId);

    /**
     * 查询所有
     * @param order
     * @return
     */
    ResponseResult getAllOrder(Order order);

    /**
     * 添加工单
     * @param order
     * @return
     */
    ResponseResult createOrder(Order order);

    /**
     * 分页
     * @param currentPage
     * @param pageSize
     * @return
     */
    IPage<Order> getPage(int currentPage,int pageSize);

    /**
     * 条件分页
     * @param currentPage
     * @param pageSize
     * @param order
     * @return
     */
    IPage<Order> getPage(int currentPage,int pageSize,Order order);

}
