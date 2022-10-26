package com.woniuxy.wuye.cash.openfeign;

import com.woniuxy.wuye.cash.fallback.BatchServiceFallback;
import com.woniuxy.wuye.common.entity.TbCheckReduce;
import com.woniuxy.wuye.common.entity.TbHouse;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/22
 **/
@RequestMapping
@FeignClient(value = "batch-service",fallback = BatchServiceFallback.class)
public interface BatchServiceOpenFeign {
    /**
     * 通过用户id和项目id查房产
     * @param
     * @return
     */
    @RequestMapping("/reduce/add")
    ResponseEntity add( TbCheckReduce tbCheckReduce);
}
