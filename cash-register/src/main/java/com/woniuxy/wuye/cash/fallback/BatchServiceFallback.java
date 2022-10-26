package com.woniuxy.wuye.cash.fallback;

import com.woniuxy.wuye.cash.openfeign.BatchServiceOpenFeign;
import com.woniuxy.wuye.common.entity.TbCheckReduce;
import com.woniuxy.wuye.common.utils.ResponseEntity;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/25
 **/
public class BatchServiceFallback implements BatchServiceOpenFeign {
    @Override
    public ResponseEntity add(TbCheckReduce tbCheckReduce) {
        return new ResponseEntity("500","fall","null");
    }
}
