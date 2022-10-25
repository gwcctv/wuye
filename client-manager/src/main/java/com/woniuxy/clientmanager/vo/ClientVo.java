package com.woniuxy.clientmanager.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author li
 * @data 2022/10/25{} 17:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientVo {
    /**
     *  客户id
     */
    private int clientId;
    /**
     * 房号
     */
    private String houseNumber;
    /**
     * 楼栋号
     */
    private String buildingNumber;
    /**
     * 单元号
     */
    private String unit;
    /**
     * 层号
     */
    private String layer;
    /**
     * 项目名
     */
    private String projectName;
}
