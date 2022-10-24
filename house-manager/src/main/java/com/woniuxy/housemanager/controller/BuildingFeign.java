package com.woniuxy.housemanager.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@RequestMapping("/building")
@FeignClient("building-manager")
public interface BuildingFeign {

    @RequestMapping("/number")
    public  int getByNumber(@RequestParam("buildingNumber") int buildingNumber);
}
