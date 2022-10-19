package com.woniuxy.wuye.common.entity;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/19
 **/
import lombok.Data;

import java.io.Serializable;

/**
 * 退款记录
 */
@Data
public class TbRefundHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 退款单号
     */
    private String refundNumber;

    /**
     * 退款金额
     */
    private String refundFees;

    /**
     * 收款单编号
     */
    private String paidBillsNum;

    /**
     * 退款人
     */
    private String refundUser;

    /**
     * 退款时间
     */
    private String refundTime;

    /**
     * 退款原因
     */
    private String refundReason ;

}
