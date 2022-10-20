package com.woniuxy.wuye.common.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * 滞纳金管理表
 * @author 魏锦鹏
 */
@Data
@TableName("tb_latefee_management")
public class TbLatefeeManagement  {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 滞纳金费项编号
     */
    @TableField(value = "latefee_num",condition = SqlCondition.EQUAL)
    private String latefeeNum;

    /**
     * 滞纳金费项名称
     */
    @TableField(value = "latefee_name",condition = SqlCondition.LIKE)
    private String latefeeName;

    /**
     * 计期标准
     */
    @TableField(value = "data_standard",condition = SqlCondition.LIKE)
    private String dataStandard;

    /**
     * 滞纳金比例
     */
    @TableField(value = "latefee_proportion",condition = SqlCondition.EQUAL)
    private String latefeeProportion;

    /**
     * 状态
     */
    @TableField(value = "situation",condition = SqlCondition.EQUAL)
    private String situation;

    /**
     * 最新启用日期
     */
    @TableField(value = "new_startdata",condition = SqlCondition.EQUAL)
    private String newStartdata;

}
