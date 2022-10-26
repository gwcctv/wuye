package com.woniuxy.batchservice.jilianutils.entity;

import lombok.Data;

import java.util.List;

@Data
public class House {
    Integer houseId;
    Integer clientId;
    Integer  buildingId;
    String buildingNumber;
    String unit;
    String houseNumber;
    String clientName;
    List<LouDong>louDongs ;

}
