package com.woniuxy.busconfig.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.wuye.common.entity.RuleAndProject;
import com.woniuxy.wuye.common.entity.TbFeesStandardConfiguration;
import com.woniuxy.wuye.common.entity.TbMeasure;
import com.woniuxy.wuye.common.utils.PageBean;

import java.util.List;

public interface TbMeasureService extends IService<TbMeasure> {
    PageBean<TbMeasure> getByPage(TbMeasure TbMeasure, int page);
    void addTbMeasure(TbMeasure TbMeasure);
    void deleteById(Integer id);
}
