package com.woniuxy.wuye.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 抄表实体类
 */
@Data
public class TbClock implements Serializable {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 项目ID
     */
    private String projectId;

    /**
     * 表类型
     */
    private String clockType;

    /**
     * 账单计算状态
     */
    private String calculateStatus;

    /**
     * 账单入账状态
     */
    private String enterStatus;

    /**
     * 创建人
     */
    private String produceName;

    /**
     * 创建时间
     */
    private String produceTime;

    /**
     * 批次号
     */
    private String number;

    /**
     * 表ID
     */
    private String clockId;

    /**
     * 本次表计数
     */
    private String thisTimeCount;

    /**
     * 本次抄表时间
     */
    private String thisRecordTime;

    /**
     * 项目名
     */
    private String projectName;
    /**
     * 表种类 水表 电表
     */
    private String machineType;
    /**
     * 表类型 公区表 房间表
     */
    private String measureType;
    /**
     * 计量表名称
     */
    private String measureName;
    /**
     * 客户ID
     */
    private Integer clientId;
    /**
     * 客户名称
     */
    private String clientName;

}
