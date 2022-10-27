package com.woniuxy.housemanager.controller;

import com.woniuxy.wuye.common.entity.TbClient;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.apache.ibatis.annotations.Options;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/client")
@FeignClient("client-manager")
public interface ClientFeign {
    @RequestMapping("/name")
    public int getByname(@RequestParam("clientName") String clientName);

    @PostMapping("/insertClient")

    public ResponseEntity insertClient(@RequestBody TbClient tbClient);

    @GetMapping("/selectById")
    public ResponseEntity<TbClient> selectById(@RequestParam("id") int id);
    @PostMapping("/update")
    public ResponseEntity update(@RequestBody TbClient tbClient);
}
