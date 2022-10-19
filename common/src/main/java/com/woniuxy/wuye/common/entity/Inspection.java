package com.woniuxy.wuye.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 巡检工单
 */
@Data
public class Inspection implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 巡检工单id
     */
    private Integer inspectionId;

    /**
     * 编号
     */
    private String inspectionNum;

    /**
     * 计划名称
     */
    private String inspectionName;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 状态
     */
    private String status;

}
