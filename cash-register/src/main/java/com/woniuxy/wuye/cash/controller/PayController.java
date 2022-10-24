package com.woniuxy.wuye.cash.controller;

import com.alipay.api.AlipayApiException;
import com.woniuxy.wuye.cash.service.PayService;
import com.woniuxy.wuye.cash.utils.AlipayBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/23
 **/
/* 订单接口 */
@RestController()
@RequestMapping("/order")
public class PayController {
    @Resource
    private PayService payService;//调用支付服务
    /*阿里支付*/
    @RequestMapping(value = "/alipay")
    public String alipay(String no) throws AlipayApiException {
        //        return  "ok";
       return payService.aliPay(no);
       //支付成功后的参数不知道会不会带过去；
    }

    /**
     * 支付成功后调用
     * @param no
     * @return
     */
    @RequestMapping(value = "/alipay/suc")
    public String suc(String no){
        //调用服务，修改收款单的状态

        return "支付成功";
    }

    /**
     * 支付失败后调用
     * @param no
     * @return
     */
    @RequestMapping(value = "/alipay/fail")
    public String fail(String no){
        return "fail";
    }
}
