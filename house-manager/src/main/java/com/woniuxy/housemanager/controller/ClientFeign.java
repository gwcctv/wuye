package com.woniuxy.housemanager.controller;

import com.woniuxy.wuye.common.entity.TbClient;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.apache.ibatis.annotations.Options;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/client")
@FeignClient("client-manager")
public interface ClientFeign {
    @RequestMapping("/name")
    public int getByname(@RequestParam("clientName") String clientName);

    @PostMapping("/insertClient")

    public ResponseEntity insertClient(@RequestBody TbClient tbClient);
}
