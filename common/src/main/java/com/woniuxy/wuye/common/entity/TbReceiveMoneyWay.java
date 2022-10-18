package com.woniuxy.wuye.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 收款方式实体类
 */
@Data
public class TbReceiveMoneyWay implements Serializable {

    /**
     * 主键
     */
    private String id;

    /**
     * 收款方式名称 如支付宝微信现金
     */
    private String wayName;

    /**
     * 收款类型 线上线下
     */
    private String TYPE;

    /**
     * 结算账户ID
     */
    private String receiveMoneyAccountId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态
     */
    private String STATUS;

}