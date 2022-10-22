package com.woniuxy.busconfig.service.serviceiml;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sun.org.apache.bcel.internal.generic.GETFIELD;
import com.woniuxy.busconfig.mapper.TbDocumentConfigurationMapper;
import com.woniuxy.busconfig.service.TbDocumentConfigurationService;
import com.woniuxy.wuye.common.entity.TbDocumentConfiguration;
import com.woniuxy.wuye.common.entity.TbMeasure;
import com.woniuxy.wuye.common.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 单据配置表service类
 * @魏锦鹏
 */
@Service
public class TbDocumentConfigurationServiceimpl extends ServiceImpl<TbDocumentConfigurationMapper, TbDocumentConfiguration> implements TbDocumentConfigurationService {
    @Autowired
 private    TbDocumentConfigurationMapper tbDocumentConfigurationMapper;
    @Override
    public PageBean<TbDocumentConfiguration> getByPage(TbDocumentConfiguration tbDocumentConfiguration,int page) {
        PageBean<TbDocumentConfiguration> pageBean = new PageBean<>();
        pageBean.setPageSzie(4);//分页大小
        pageBean.setCurrPage(page);    //设置当前页数
        Page p = PageHelper.startPage(pageBean.getCurrPage(), pageBean.getPageSzie());
        List<TbDocumentConfiguration> list =tbDocumentConfigurationMapper.getTbDocumentConfiguration(tbDocumentConfiguration);
        pageBean.setTotalNums((int) p.getTotal());//设置总数量
        pageBean.setTotalPage(p.getPages());
        pageBean.setData(list);//设置当前页数的数据
        pageBean.setCurrpageSzie(pageBean.getData().size());//当前页数据数量
        return pageBean;
    }


}
