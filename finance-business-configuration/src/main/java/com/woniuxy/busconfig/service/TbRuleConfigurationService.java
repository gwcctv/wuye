package com.woniuxy.busconfig.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.Page;
import com.woniuxy.wuye.common.entity.TbRuleConfiguration;
import com.woniuxy.wuye.common.utils.PageBean;

import java.util.List;

public interface TbRuleConfigurationService extends IService<TbRuleConfiguration> {
    PageBean<TbRuleConfiguration> getTbRuleConfiguration(TbRuleConfiguration tbRuleConfiguration,int page);
  void   addTbRuleConfiguration(TbRuleConfiguration tbRuleConfiguration);
}
