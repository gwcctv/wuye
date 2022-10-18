package com.woniuxy.wuye.common.entity;

import lombok.Data;

/**
 * 计量表
 * @author 魏锦鹏
 */
@Data
public class TbMeasure  {

    private String id;

    /**
     * 计量表编号
     */
    private String measureNum;

    /**
     * 倍率
     */
    private String magnification;

    /**
     * 计量表名称
     */
    private String measureName;

    /**
     * 计量表种类
     */
    private String machineType;

    /**
     * 计量表类型
     */
    private String measureType;

    /**
     * 损耗
     */
    private String wastage;

    /**
     * 所属项目名称
     */
    private String projectName;

    /**
     * 收费项目
     */
    private String moneyFrom;

    /**
     * 关联房产
     */
    private String relevantHouse;

    /**
     * 状态
     */
    private String situation;

    /**
     * 最后抄表时间
     */
    private String lastRead;

}
