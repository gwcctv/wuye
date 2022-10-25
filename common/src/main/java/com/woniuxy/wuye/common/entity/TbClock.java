package com.woniuxy.wuye.common.entity;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 抄表实体类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
     * 房子Id
     * */
    Integer houseId;

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
     * 收费项目ID
     */

    private Integer feetypeId;
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

    /**
     * 单元号
     * */
    @TableField(exist = false)
    private String unit;

    /**
     * 楼层
     * */
    @TableField(exist = false)
    private String layer;

    /**
     * 房号
     * */
    @TableField(exist = false)
    private String houseNumber;
    /**
     * 楼栋号
     * */
    @TableField(exist = false)
    private String  buildingNumber;

    /**
     * 周期业务对应的减免账单
     * */
    @TableField(exist = false)
    private List<TbCheckReduce> tbCheckReduceList;
    /**
     * 周期业务对应的减免滞纳金减免
     * */
    @TableField(exist = false)
    private List<TbCheckReduce> tbCheckReduceListForLateMoney;
}
