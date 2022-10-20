package com.woniuxy.wuye.common.entity;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/19
 **/
import lombok.Data;

import lombok.Data;

import java.io.Serializable;

/**
 * 预存金额总表
 */
@Data
public class TbDepositedFees implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 关联用户表
     */
    private TbClient depositedUser;

    /**
     * 预存总金额
     */
    private String depositedTotal;

    /**
     * 已抵扣金额
     */
    private String alreadyOffsetFees;

    /**
     * 已退款金额
     */
    private String alreadyRefundFees;

    /**
     * 剩余预存金额
     */
    private String remainderDeposited;

    /**
     * 最近预存时间
     */
    private String recentDepositedTime;

    /**
     * 最近抵扣时间
     */
    private String recentOffsetTime;

}
