package com.woniuxy.wuye.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("tb_maintain")
public class Maintain{
    /**
     * <pre>
     *
     * </pre>
     */
    @TableId("maintain_id")
    private long maintainId;

    /**
     * <pre>
     * 保养工单编号
     * </pre>
     */
    private String maintainNum;

    /**
     * <pre>
     * 保养计划
     * </pre>
     */
    private String maintainName;

    /**
     * <pre>
     * 设备编号
     * </pre>
     */
    private String equipmentNum;

    /**
     * <pre>
     * 养护类型
     * </pre>
     */
    private String maintainType;

    /**
     * <pre>
     * 责任人
     * </pre>
     */
    private String functionary;

    /**
     * <pre>
     * 保养周期
     * </pre>
     */
    private String maintainDuration;

    /**
     * <pre>
     * 开始时间
     * </pre>
     */
    private Date startTime;

    /**
     * <pre>
     * 结束时间
     * </pre>
     */
    private Date endTime;

    /**
     * <pre>
     * 状态
     * </pre>
     */
    private String status;
}