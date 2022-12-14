package com.woniuxy.wuye.cash.openfeign;

import com.woniuxy.wuye.common.entity.TbHouse;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/22
 **/
@RequestMapping
@FeignClient("house-manager")
public interface HouseOpenFeign {
    /**
     * 通过用户id和项目id查房产
     * @param clientId
     * @param projectId
     * @return
     */
    @RequestMapping("/house/pcid/{projectId}/{clientId}")
    ResponseEntity<List<TbHouse>> getHouseNames(@RequestParam("clientId") Integer clientId, @RequestParam("projectId") Integer projectId);
}
