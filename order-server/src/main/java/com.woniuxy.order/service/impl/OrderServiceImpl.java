package com.woniuxy.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.order.mapper.OrderMapper;
import com.woniuxy.order.service.OrderService;
import com.woniuxy.wuye.common.entity.Order;
import com.woniuxy.wuye.common.entity.ResponseResult;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Date;

import static org.reflections.Reflections.log;

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
    public ResponseResult getAllOrder(Order order) {
        return null;
    }

    /**
     * 添加工单
     * @param order
     * @return
     */
    @Override
    public ResponseResult createOrder(Order order) {
        //按规则自动生成工单号
        Integer count= Math.toIntExact(orderMapper.selectCount(null) + 1);
        DecimalFormat decimalFormat = new DecimalFormat("000000");
        String orderNum="ord"+decimalFormat.format(count);
        order.setOrderNum(orderNum);
        //生成当前时间
        Date date = new Date(System.currentTimeMillis());//获取当前时间
        log.info(String.valueOf(date));
        order.setReportDate(date);
        int flag=orderMapper.insert(order);
        if (flag==0){
            throw new RuntimeException("添加失败！");
        }
        return new ResponseResult(200, "添加成功！");
    }

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public IPage<Order> getPage(int currentPage, int pageSize) {
        IPage page=new Page(currentPage,pageSize);
        return orderMapper.selectPage(page,null);
    }

    /**
     * 条件分页查询
     * @param currentPage
     * @param pageSize
     * @param order
     * @return
     */
    @Override
    public IPage<Order> getPage(int currentPage, int pageSize, Order order) {
        LambdaQueryWrapper<Order> lqw=new LambdaQueryWrapper<Order>();
        //根据工单状态查询
        lqw.like(Strings.isNotEmpty(order.getState()), Order::getState, order.getState());

        IPage page=new Page(currentPage,pageSize);
        orderMapper.selectPage(page, lqw);
        return page;
    }


}
