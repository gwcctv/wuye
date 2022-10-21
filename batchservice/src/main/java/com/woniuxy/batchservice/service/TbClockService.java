package com.woniuxy.batchservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.wuye.common.entity.TbClock;
import com.woniuxy.wuye.common.utils.PageBean;

import java.util.List;

public interface TbClockService extends IService<TbClock> {

    PageBean<TbClock> getByCondition(TbClock tbClock,int page);
}
