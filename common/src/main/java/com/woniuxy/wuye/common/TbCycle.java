package com.woniuxy.wuye.common;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 循环周期业务实体类
 */
@Data
public class TbCycle implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 项目ID
     */
    private Integer projectId;

    /**
     * 收费项目ID
     */
    private Integer feetypeId;

    /**
     * 房产ID
     */
    private Integer houseId;

    /**
     * 收费周期
     */
    private Integer feecycle;

    /**
     * 周期收费开始时间
     */
    private Date start;

    /**
     * 周期收费停止时间
     */
    private Date end;

    /**
     * 创建状态
     */
    private String produceStatus;

    /**
     * 创建人
     */
    private String produceName;

    /**
     * 创建时间
     */
    private Date produceTime;

    /**
     * 业务批次号
     */
    private String number;

    /**
     * 单价
     */
    private String price;

    /**
     * 应收    单价*周期
     */
    private String totalMoney;

    /**
     * 生成失败的原因 比如逻辑问题 截止时间早于起始时间
     */
    private String failureProduceReason;

}
