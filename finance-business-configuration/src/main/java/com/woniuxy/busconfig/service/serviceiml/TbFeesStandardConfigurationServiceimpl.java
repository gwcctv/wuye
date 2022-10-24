package com.woniuxy.busconfig.service.serviceiml;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniuxy.busconfig.mapper.TbFeesStandardConfigurationMapper;
import com.woniuxy.busconfig.mapper.TbProjectfscMapper;
import com.woniuxy.busconfig.service.TbFeesStandardConfigurationService;
import com.woniuxy.wuye.common.entity.TbChargeableItems;
import com.woniuxy.wuye.common.entity.TbFeesStandardConfiguration;
import com.woniuxy.wuye.common.entity.TbProjectfsc;
import com.woniuxy.wuye.common.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.util.List;

/**
 * 收费标准配置表类
 * @魏锦鹏
 */
@Service
public class TbFeesStandardConfigurationServiceimpl implements TbFeesStandardConfigurationService {
@Autowired
 private TbFeesStandardConfigurationMapper tbFeesStandardConfigurationMapper;
@Autowired
private TbProjectfscMapper tbProjectfscMapper;
    @Override
    public void addTbFeesStandardConfiguration(TbFeesStandardConfiguration tbFeesStandardConfiguration) {
        List<Integer> projectNameList = tbFeesStandardConfiguration.getProjectNameList();
        tbFeesStandardConfigurationMapper.addTbFeesStandardConfiguration(tbFeesStandardConfiguration);
        for (Integer id:projectNameList) {
            TbProjectfsc tbProjectfsc = new TbProjectfsc();
            tbProjectfsc.setProject_id(id);
            tbProjectfsc.setFscId(tbFeesStandardConfiguration.getId());
            tbProjectfscMapper.insert(tbProjectfsc);
        }

    }

    @Override
    public PageBean<TbFeesStandardConfiguration> getByPage(TbFeesStandardConfiguration tbFeesStandardConfiguration,int page) {
        //根据条件页码分页大小将PageBean中的属性一次设置
        PageBean<TbFeesStandardConfiguration> pageBean = new PageBean<>();
        pageBean.setPageSzie(10);//分页大小
        pageBean.setCurrPage(page);    //设置当前页数
        Page p = PageHelper.startPage(pageBean.getCurrPage(), pageBean.getPageSzie());
        List<TbFeesStandardConfiguration> list = tbFeesStandardConfigurationMapper.getTbFeesStandardConfiguration(tbFeesStandardConfiguration);
        pageBean.setTotalNums((int) p.getTotal());//设置总数量
        pageBean.setTotalPage(p.getPages());
        pageBean.setData(list);//设置当前页数的数据
        pageBean.setCurrpageSzie(pageBean.getData().size());//当前页数据数量
        return pageBean;
    }

    @Override
    public void updateTbFeesStandardConfiguration(TbFeesStandardConfiguration tbFeesStandardConfiguration) {
        tbFeesStandardConfigurationMapper.updateTbFeesStandardConfiguration(tbFeesStandardConfiguration);
    }

    @Override
    public void deleteTbFeesStandardConfiguration(Integer id) {
        tbFeesStandardConfigurationMapper.deleteTbFeesStandardConfiguration(id);
        QueryWrapper<TbProjectfsc> wrapper = new QueryWrapper<>();
        wrapper.eq("fsc_id",id);
        tbProjectfscMapper.delete(wrapper);
    }
}
