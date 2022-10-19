package com.woniuxy.wuye.common.entity;

import lombok.Data;

/**
 * 物业楼栋实体类
 */
@Data
public class TbBuilding {
    /**
     * 楼栋主键id
     */
    private Integer buildingId;
    /**
     * 楼栋编号
     */
    private String number;

    /**
     *楼栋号
     */
    private Integer buildingNumber;

    /**
     * 楼栋类型
     */
    private String buildingType;

    /**
     * 层数
     */
    private String layer;

    /**
     * 单元数
     */
    private String unit;

    /**
     * 备注
     */
    private String description;

    /**
     * 所属项目id
     */
    private Integer projectId;
}
