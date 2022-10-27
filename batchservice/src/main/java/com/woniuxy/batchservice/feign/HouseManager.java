package com.woniuxy.batchservice.feign;

import com.woniuxy.wuye.common.entity.TbHouse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "house-manager",url = "localhost:8003",path = "/house")
public interface HouseManager {
    @RequestMapping("/getById")
    public TbHouse getById(Integer id);
}
