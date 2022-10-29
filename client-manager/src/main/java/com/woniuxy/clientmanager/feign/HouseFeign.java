package com.woniuxy.clientmanager.feign;

import com.woniuxy.wuye.common.entity.TbHouse;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/house")
@FeignClient("house-manager")
public interface HouseFeign {

    @RequestMapping("/addHoouse")
    public ResponseEntity addHouse(TbHouse tbHouse);
}
