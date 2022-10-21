package com.woniuxy.busconfig.service;

import com.woniuxy.wuye.common.entity.TbChargeableItems;
import com.woniuxy.wuye.common.utils.PageBean;

/**
 * 收费项目表接口
 * @魏锦鹏
 */
public interface TbChargeableItemsService{
    void addTbChargeableItem(TbChargeableItems tbChargeableItems);
    void updateTbChargeableItem(TbChargeableItems tbChargeableItems);
    void deleteTbChargeableItem(Integer id);
    PageBean<TbChargeableItems> getByPage(TbChargeableItems tbChargeableItems , int page);
}
