package com.woniuxy.batchservice.web;

import com.woniuxy.batchservice.jilianutils.entity.Project;
import com.woniuxy.batchservice.jilianutils.service.JilianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("jilian")
public class JiLianController {
    @Autowired
    JilianService jilianService;
    @RequestMapping("get")
    public List<Project> get(){
        return jilianService.getJilLianProject();
    }
}
