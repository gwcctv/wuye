package com.woniuxy.busconfig.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.wuye.common.entity.TbDocumentConfiguration;
import com.woniuxy.wuye.common.entity.TbMeasure;
import com.woniuxy.wuye.common.utils.PageBean;

public interface TbDocumentConfigurationService  extends IService<TbDocumentConfiguration>  {
    PageBean<TbDocumentConfiguration> getByPage(TbDocumentConfiguration tbDocumentConfiguration,int page);
}
