package com.woniuxy.busconfig.service;

import com.woniuxy.wuye.common.entity.TbChargeableItems;
import com.woniuxy.wuye.common.entity.TbFeesStandardConfiguration;
import com.woniuxy.wuye.common.utils.PageBean;

import java.util.List;

public interface TbFeesStandardConfigurationService {
    void addTbFeesStandardConfiguration(TbFeesStandardConfiguration tbFeesStandardConfiguration);
    PageBean<TbFeesStandardConfiguration> getByPage(TbFeesStandardConfiguration tbFeesStandardConfiguration,int page);
    void updateTbFeesStandardConfiguration(TbFeesStandardConfiguration tbFeesStandardConfiguration);
    void deleteTbFeesStandardConfiguration(Integer id);
}

