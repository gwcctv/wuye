package com.woniuxy.batchservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.wuye.common.entity.TbCheckReduce;
import com.woniuxy.wuye.common.entity.TbCycle;
import com.woniuxy.wuye.common.utils.PageBean;

import java.util.List;

public interface TbCheckReduceService extends IService<TbCheckReduce> {
    PageBean<TbCheckReduce> getByCondition(TbCheckReduce tbCheckReduce,int page);
}
