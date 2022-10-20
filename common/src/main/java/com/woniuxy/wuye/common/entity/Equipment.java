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
@TableName("tb_equipment")
public class Equipment{
    /**
     * <pre>
     *
     * </pre>
     */
    @TableId(value = "equipment_id")
    private long equipmentId;

    /**
     * <pre>
     * 设备名称
     * </pre>
     */
    private String equipmentName;

    /**
     * <pre>
     * 用户名
     * </pre>
     */
    private String equipmentNum;

    /**
     * <pre>
     * 品牌
     * </pre>
     */
    private String brand;

    /**
     * <pre>
     * 型号
     * </pre>
     */
    private String specification;

    /**
     * <pre>
     * 存放位置
     * </pre>
     */
    private String location;

    /**
     * <pre>
     * 数量
     * </pre>
     */
    private Integer number;

    /**
     * <pre>
     * 单位
     * </pre>
     */
    private String unit;

    /**
     * <pre>
     * 均价
     * </pre>
     */
    private Double averagePrice;

    /**
     * <pre>
     * 出厂编号
     * </pre>
     */
    private String factoryNum;

    /**
     * <pre>
     * 供应商
     * </pre>
     */
    private String factory;

    /**
     * <pre>
     * 购置日期
     * </pre>
     */
    private Date purchaseDate;

    /**
     * <pre>
     * 购置金额
     * </pre>
     */
    private Double purchaseSum;

    /**
     * <pre>
     * 负责人
     * </pre>
     */
    private String functionary;

    /**
     * <pre>
     * 状态
     * </pre>
     */
    private String status;
}