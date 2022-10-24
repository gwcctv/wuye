package com.woniuxy.housemanager.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/client")
@FeignClient("client-manager")
public interface ClientFeign {
    @RequestMapping("/name")
    public int getByname(@RequestParam("clientName") String clientName);
}
