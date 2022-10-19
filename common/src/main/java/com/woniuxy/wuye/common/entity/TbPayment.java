package com.woniuxy.wuye.common.entity;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/19
 **/
import lombok.Data;

import java.io.Serializable;

/**
 * 付款记录表
 */
@Data
public class TbPayment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 付款单号
     */
    private String paymentNumer;

    /**
     * 付款金额
     */
    private String paymentFees;

    /**
     * 付款方式
     */
    private String paymentStyle;

    /**
     * 付款账户
     */
    private String paymentAccount;

    /**
     * 收款客户关联的外键
     */
    private TbClient acceptUserId;

    /**
     * 收款银行
     */
    private String acceptBank;

    /**
     * 结算账户
     */
    private String acceptAccount;

    /**
     * 收费项目
     */
    private String feesItem;

    /**
     * 账单开始时间
     */
    private String startTime;

    /**
     * 账单截止日期
     */
    private String endTime;

    /**
     * 应付金额
     */
    private String shouldPay;

    /**
     * 实付
     */
    private String realPay;

    /**
     * 剩余未付
     */
    private String remainder;

    /**
     * 付款状态
     */
    private String payStatus;

    /**
     * 创建时间
     */
    private String createTiem;

}
