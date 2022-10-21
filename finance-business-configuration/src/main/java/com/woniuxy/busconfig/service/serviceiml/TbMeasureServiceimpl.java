package com.woniuxy.busconfig.service.serviceiml;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniuxy.busconfig.mapper.RuleAndProjectMapper;
import com.woniuxy.busconfig.mapper.TbMeasureMapper;
import com.woniuxy.busconfig.service.RuleAndProjectService;
import com.woniuxy.busconfig.service.TbMeasureService;
import com.woniuxy.wuye.common.entity.RuleAndProject;
import com.woniuxy.wuye.common.entity.TbFeesStandardConfiguration;
import com.woniuxy.wuye.common.entity.TbMeasure;
import com.woniuxy.wuye.common.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbMeasureServiceimpl extends ServiceImpl<TbMeasureMapper, TbMeasure> implements TbMeasureService {
@Autowired
  private   TbMeasureMapper tbMeasureMapper;

    @Override
    public PageBean<TbMeasure> getByPage(TbMeasure tbMeasure, int page) {
        //根据条件页码分页大小将PageBean中的属性一次设置
        PageBean<TbMeasure> pageBean = new PageBean<>();
        pageBean.setPageSzie(4);//分页大小
        pageBean.setCurrPage(page);    //设置当前页数
        Page p = PageHelper.startPage(pageBean.getCurrPage(), pageBean.getPageSzie());
        List<TbMeasure> list =tbMeasureMapper.getTbMeasure(tbMeasure);
        pageBean.setTotalNums((int) p.getTotal());//设置总数量
        pageBean.setTotalPage(p.getPages());
        pageBean.setData(list);//设置当前页数的数据
        pageBean.setCurrpageSzie(pageBean.getData().size());//当前页数据数量
        return pageBean;
    }
}
