package com.woniuxy.wuye.common.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * TbClient
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TbClient implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户id
     */
    private Integer clientId;

    /**
     * 客户编号
     */
    private String number;

    /**
     * 客户名字
     */
    private String clientName;

    /**
     * 性别
     */
    private String sex;

    /**
     * 身份证号
     */
    private String card;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 工作地址
     */
    private String workAddress;

    /**
     * 备注
     */
    private String description;

    /**
     * 房客关系
     */
    private String relationship;

    /**
     * 房产id
     */
    private Integer houseId;

    /**
     * 客户状态
     */
    private String clientState;

    /**
     * 房产楼层
     */
    private String layer;

    /**
     *  房产单元
     */
    private String unit;

    /**
     *  项目名字
     */
    private String projectName;

    /**
     *  楼栋编号
     */
    private String buildingNumber;

    /**
     *  房产编号
     */
    private String houseNumber;

}
