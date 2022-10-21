package com.woniuxy.wuye.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 巡检工单
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("tb_inspection")
public class Inspection{

    /**
     * 巡检工单id
     */
    @TableId(value = "inspection_id")
    private long inspectionId;

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
