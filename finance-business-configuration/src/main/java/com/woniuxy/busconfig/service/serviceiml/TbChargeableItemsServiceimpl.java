package com.woniuxy.busconfig.service.serviceiml;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniuxy.busconfig.mapper.TbChargeableItemsMapper;
import com.woniuxy.busconfig.service.TbChargeableItemsService;
import com.woniuxy.wuye.common.entity.TbChargeableItems;
import com.woniuxy.wuye.common.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收费项目表service类
 * @魏锦鹏
 */
@Service
public class TbChargeableItemsServiceimpl implements TbChargeableItemsService {
    @Autowired
   private TbChargeableItemsMapper tbChargeableItemsMapper;
    @Override
    public void addTbChargeableItem(TbChargeableItems tbChargeableItems) {
tbChargeableItemsMapper.addTbChargeableItem(tbChargeableItems);
    }

    @Override
    public void updateTbChargeableItem(TbChargeableItems tbChargeableItemsId) {
tbChargeableItemsMapper.updateTbChargeableItem(tbChargeableItemsId);
    }

    @Override
    public void deleteTbChargeableItem(Integer id) {
tbChargeableItemsMapper.deleteTbChargeableItem(id);
    }

    @Override
    public PageBean<TbChargeableItems> getByPage(TbChargeableItems tbChargeableItems, int page) {
        //根据条件页码分页大小将PageBean中的属性一次设置
        PageBean<TbChargeableItems> pageBean = new PageBean<>();
        pageBean.setPageSzie(4);//分页大小
        pageBean.setCurrPage(page);    //设置当前页数
        Page p = PageHelper.startPage(pageBean.getCurrPage(), pageBean.getPageSzie());
        List<TbChargeableItems> list = tbChargeableItemsMapper.getTbChargeableItemByCondition(tbChargeableItems);
        pageBean.setTotalNums((int) p.getTotal());//设置总数量
        pageBean.setTotalPage(p.getPages());
        pageBean.setData(list);//设置当前页数的数据
        pageBean.setCurrpageSzie(pageBean.getData().size());//当前页数据数量
        return pageBean;
    }
}
