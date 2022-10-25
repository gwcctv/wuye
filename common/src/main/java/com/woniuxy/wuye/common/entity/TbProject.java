package com.woniuxy.wuye.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TbProject
 */
@Data
public class TbProject implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目id
     */
    private Integer projectId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目类型
     */
    private String projectType;

    /**
     * 所属机构
     */
    private String affiliation;

    /**
     * 建设日期
     */
    private String constructionDate;

    /**
     * 建筑面积
     */
    private Double area;

    /**
     * 项目地址
     */
    private String address;

    /**
     * 项目负责人姓名
     */
    private String projectHead;

    /**
     * 项目负责人电话
     */
    private String headPhone;

    /**
     * 接盘日期
     */
    private String takeoverDate;

    /**
     * 状态
     */
    private String state;

}
