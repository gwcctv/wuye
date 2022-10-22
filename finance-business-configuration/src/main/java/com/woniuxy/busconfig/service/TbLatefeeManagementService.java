package com.woniuxy.busconfig.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.woniuxy.wuye.common.entity.TbLatefeeManagement;
import com.woniuxy.wuye.common.entity.TbMeasure;
import com.woniuxy.wuye.common.utils.PageBean;

public interface TbLatefeeManagementService extends IService<TbLatefeeManagement> {
    PageBean<TbLatefeeManagement> getByPage(TbLatefeeManagement tbLatefeeManagement, int page);
}
