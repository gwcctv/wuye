package com.woniuxy.wuye.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 车位表
 */
@Data
@AllArgsConstructor
public class TbParking implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 车位id
     */
    private Integer parkingId;

    /**
     * 车位编号
     */
    private String parkingNumber;

    /**
     * 车位性质
     */
    private String parkingQuality;

    /**
     * 车位状态
     */
    private String parkingState;

    /**
     * 车位大小
     */
    private Double parkingSize;

    /**
     *  车位用途
     */
    private String parkingUse;

    /**
     * 车牌号
     */
    private String parkingCard;

    /**
     *  房产id
     */
    private int houseId;

    /**
     *  项目id
     */
    private int clientId;

    public TbParking() {
    }

    public TbParking(String parkingNumber, String parkingQuality, String parkingState, double parkingSize, String parkingUse, String parkingCard, int houseId, int clientId) {

    }
}
