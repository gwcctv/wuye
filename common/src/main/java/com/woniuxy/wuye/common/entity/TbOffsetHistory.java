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
     * 改冲抵单的状态（正常0，冻结1，已失效2，已使用3）
     */
    private String status;

    /**
     * 外键关联收款单的id
     */
    private Integer tbPaidBillsId;

    /**
     * 冲抵金额
     */
    private String offsetFees;

    /**
     * 时间
     */
    private String offsetTime;

    /**
     * 是否删除，默认0未删除，1已删除
     */
    private Integer isDelete;
    /**
     * 外键关联预存金额表id
     */
    private TbDepositedFees tbDepositedFeesId;
}
