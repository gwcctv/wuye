package com.woniuxy.busconfig.service.serviceiml;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniuxy.busconfig.mapper.RuleAndProjectMapper;
import com.woniuxy.busconfig.mapper.TbMeasureHouMapper;
import com.woniuxy.busconfig.mapper.TbMeasureMapper;
import com.woniuxy.busconfig.service.RuleAndProjectService;
import com.woniuxy.busconfig.service.TbMeasureService;
import com.woniuxy.wuye.common.entity.*;
import com.woniuxy.wuye.common.utils.ChuLIjiHe;
import com.woniuxy.wuye.common.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 计量表service类
 * @魏锦鹏
 */
@Service
public class TbMeasureServiceimpl extends ServiceImpl<TbMeasureMapper, TbMeasure> implements TbMeasureService {
@Autowired
  private   TbMeasureMapper tbMeasureMapper;
@Autowired
private TbMeasureHouMapper tbMeasureHouMapper;
    @Override
    public void addTbMeasure(TbMeasure entity) {
        tbMeasureMapper.insert(entity);
        List<Integer> relevantHouse = entity.getRelevantHouse();
        for (Integer integer : relevantHouse) {
            TbMeasureHou tbMeasureHou = new TbMeasureHou();
            tbMeasureHou.setHouseId(integer);
            tbMeasureHou.setMeasureId(entity.getId());
            tbMeasureHouMapper.insert(tbMeasureHou);
        }
    }

    @Override
    public PageBean<TbMeasure> getByPage(TbMeasure tbMeasure, int page) {
        //根据条件页码分页大小将PageBean中的属性一次设置
        PageBean<TbMeasure> pageBean = new PageBean<>();
        pageBean.setPageSzie(10);//分页大小
        pageBean.setCurrPage(page);    //设置当前页数
        Page p = PageHelper.startPage(pageBean.getCurrPage(), pageBean.getPageSzie());
        List<TbMeasure> list =tbMeasureMapper.getTbMeasure(tbMeasure);
        list.forEach(r->r.setAllName(r.getBuildingId()+"栋"+r.getUnit()+r.getLayer()+r.getHouseNumber()));
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j <list().size();j++) {
                if(j<list.size()&&list.get(i).getId()==list.get(j).getId()){
                    list.get(i).setAllName(list.get(i).getAllName()+","+list.get(j).getAllName());
                    list.remove(j);
j--;
                }

            }
        }

        pageBean.setTotalNums((int) p.getTotal());//设置总数量
        pageBean.setTotalPage(p.getPages());
        pageBean.setData(list);//设置当前页数的数据
        pageBean.setCurrpageSzie(pageBean.getData().size());//当前页数据数量
        return pageBean;
    }

    @Override
    public void deleteById(Integer id) {
        QueryWrapper<TbMeasure> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        tbMeasureMapper.delete(wrapper);
        QueryWrapper<TbMeasureHou> wrapperMeasure = new QueryWrapper<>();
        wrapperMeasure.eq("measure_id",id);
        tbMeasureHouMapper.delete(wrapperMeasure);

    }
}
