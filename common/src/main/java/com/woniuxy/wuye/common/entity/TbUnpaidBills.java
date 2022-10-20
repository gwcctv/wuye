package com.woniuxy.wuye.common.entity;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/19
 **/

import lombok.Data;

import java.io.Serializable;

/**
 * 未支付的账单
 */
@Data
public class TbUnpaidBills implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
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
     * 外键关联客户
     */
    private TbClient houseOwner;

    /**
     * 外键--收费项目
     */
    private TbChargeableItems feesItem;

    /**
     * 外键--收费标准
     */
    private TbFeesStandardConfiguration feesStandard;

    /**
     * 账单开始时间
     */
    private String billStartTime;

    /**
     * 账单结束时间
     */
    private String billEndTime;

    /**
     * 计费数量
     */
    private String number;

    /**
     * 单价
     */
    private String price;

    /**
     * 应收金额
     */
    private String received;

    /**
     * 账单减免金额
     */
    private String relief;

    /**
     * 冲抵金额
     */
    private String offset;

    /**
     * 未收金额
     */
    private String notReceived;

    /**
     * 滞纳金
     */
    private String lateFees;

    /**
     * 滞纳金减免
     */
    private String lateFeesRelief;

    /**
     * 应收日期
     */
    private String shouldReceivedTime;

    /**
     * 是否作废,初始值0表示不作废,1表示作废，2表示已交
     */
    private Integer status;

    /**
     * 后关联收款单id
     */
    private Integer tbPaidBillsId;

}
