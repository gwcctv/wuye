package com.woniuxy.housemanager.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/project")
@FeignClient("project-manager")
public interface ProjectFeign {
    @RequestMapping("/name")
    int getByName(@RequestParam("name") String name);//这里注意参数问题
}
