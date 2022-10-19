package com.woniuxy.wuye.common.entity;

import java.io.Serializable;
import java.util.Date;

public class Equipment implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * <pre>
     *
     * </pre>
     */
    private Integer equipmentId;

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