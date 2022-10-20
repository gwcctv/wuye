package com.woniuxy.wuye.common.entity;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/19
 **/
import lombok.Data;

import java.io.Serializable;

/**
 * 冲抵记录
 */
@Data
public class TbOffsetHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 自动生成的冲抵记录单号
     */
    private String offsetNumber;

    /**
     * 改冲抵单的状态（）
     */
    private String status;

    /**
     * 外键关联收款单的id
     */
    private TbPaidBills tbPaidBillsId;

    /**
     * 冲抵金额
     */
    private String offsetFees;

    /**
     * 时间
     */
    private String offsetTime;

}
