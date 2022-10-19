package com.woniuxy.wuye.common.entity;

import lombok.Data;

/**
 * 物业车辆实体类
 */
@Data
public class TbCar {
    /**
     * 主键id
     */
    private  Integer id;
    /**
     *车辆编号
     */
    private String CarNumber;
    /**
     * 车辆类型
     */
    private  String CarType;
    /**
     * 车辆状态
     */
    private  String CarState;
    /**
     *所属车位id
     */
    private Integer parkingId;
    /**
     * 所属客户id
     */
    private  Integer clientId;


}
