package com.woniuxy.wuye.cash.service;

import com.alipay.api.AlipayApiException;
import com.woniuxy.wuye.cash.utils.AlipayBean;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/23
 **/
/*支付服务*/
public interface PayService {
    /*支付宝*/
    String aliPay(String num) throws AlipayApiException;
}
