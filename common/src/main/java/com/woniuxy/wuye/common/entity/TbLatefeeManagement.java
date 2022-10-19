package com.woniuxy.wuye.common.entity;

import lombok.Data;

/**
 * 滞纳金管理表
 * @author 魏锦鹏
 */
@Data
public class TbLatefeeManagement  {
    private Integer id;

    /**
     * 滞纳金费项编号
     */
    private String latefeeNum;

    /**
     * 滞纳金费项名称
     */
    private String latefeeName;

    /**
     * 计期标准
     */
    private String dataStandard;

    /**
     * 滞纳金比例
     */
    private String latefeeProportion;

    /**
     * 状态
     */
    private String situation;

    /**
     * 最新启用日期
     */
    private String newStartdata;

}
