package com.woniuxy.wuye.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 物业车辆实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbCar {
    /**
     * 主键id
     */
    private  Integer carId;
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

    /**
     * 所属客户名
     */
    private String ClientName;

    /**
     * 所属车位
     */
    private int parkingNumber;

    public TbCar( String carNumber, String carType, String carState, Integer parkingId, Integer clientId, String clientName, int parkingNumber) {

    }
}
