package com.woniuxy.batchservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.wuye.common.entity.TbCycle;
import com.woniuxy.wuye.common.utils.PageBean;

import java.util.List;

public interface TbCycleService extends IService<TbCycle> {
    PageBean<TbCycle> getByConditionByPage(TbCycle tbCycle,int page);
}
