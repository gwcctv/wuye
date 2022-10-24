package com.woniuxy.wuye.cash.utils;

import lombok.Data;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/23
 **/
@Data
public class AlipayBean {
//    out_trade_no、product_code、total_amount、subject

    /*订单名称，必填*/
    private String subject;
    /*付款金额，必填*/
    private String total_amount;
    /*商品描述，可空*/
    private String body;
    /*超时时间参数*/
//    private String timeout_express="10m";
//    private String product_code="FAST_INSTANT_TRADE_PAY";
    /**
     * 值不能为123，否则报错，你还找不到原因
     */
    private  String out_trade_no;
}
