package com.woniuxy.wuye.common.entity;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/19
 **/

import lombok.Data;

import java.io.Serializable;

/**
 * 收款的账单
 */
@Data
public class TbPaidBills implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private Integer id;

    /**
     * 应收据单号
     */
    private String num;

    /**
     * 房产名称
     */
    private String houseName;

    /**
     * 客户名称
     */
    private TbClient houseOwner;

    /**
     * 应收金额
     */
    private String shouldFees;

    /**
     * 减免金额
     */
    private String reliefFees;

    /**
     * 未收金额
     */
    private String notFees;

    /**
     * 滞纳金
     */
    private String lateFees;

    /**
     * 滞纳金减免金额
     */
    private String reliefLateFees;

    /**
     * 冲抵金额
     */
    private String offsetFees;

    /**
     * 建议收款总金额
     */
    private String adviceSumFees;

    /**
     * 是否冲抵
     */
    private String isOffset;

    /**
     * 是否抹零
     */
    private String isWipeZero;

    /**
     * 是否抹零
     */
    private String wipeZeroFees;

    /**
     * 实际总收金额
     */
    private String realSumFees;

    /**
     * 收款方式
     */
    private String getFeesStyle;

    /**
     * 收款结算账户
     */
    private String feesAccount;

    /**
     * 付款用户
     */
    private String payUser;

    /**
     * 收款人
     */
    private String acceptUser;

    /**
     * 收款时间
     */
    private String acceptTime;

    /**
     * 收款单号
     */
    private String acceptNum;

    /**
     * 发票单号
     */
    private String invoiceNumber;

    /**
     * 备注
     */
    private String note;

    /**
     * 收费项目
     */
    private String feesItems;

    /**
     * 支付状态
     */
    private String payStatus;

    /**
     * 是否删除，默认0未删除，1已删除
     */
    private Integer isDelete;
    /**
     *
     */
    private Integer[] unPaidBillIds;

}
