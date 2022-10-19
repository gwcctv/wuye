package com.woniuxy.wuye.common.entity;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/19
 **/
import lombok.Data;

import java.io.Serializable;

/**
 * 预存金额历史
 */
@Data
public class TbDepositedHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 关联用户表用户id
     */
    private TbClient depositedUser;

    /**
     * 本次预存金额
     */
    private String depositedFees;

    /**
     * 预存时间
     */
    private String time;

    /**
     * 可抵项目
     */
    private String offserItem;

    /**
     * 收款方式
     */
    private String acceptStyle;

    /**
     * 收款金额
     */
    private String acceptFees;

    /**
     * 结算账户
     */
    private String acceptAccount;

    /**
     * 本次实收金额
     */
    private String realAcceptFees;

    /**
     * 交款人
     */
    private String payUser;

    /**
     * 收款人
     */
    private String acceptUser;

    /**
     * 收据单号
     */
    private String receiptNumber;

    /**
     * 发票单号
     */
    private String invoiceNumber;

    /**
     * 备注
     */
    private String note;

}
