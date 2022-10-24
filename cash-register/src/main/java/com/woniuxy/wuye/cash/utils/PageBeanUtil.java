package com.woniuxy.wuye.cash.utils;


import com.github.pagehelper.Page;
import com.woniuxy.wuye.common.utils.PageBean;

import java.util.List;

/**
 * @Description:
 * @Author: baobo
 * @Date: 2022/10/20
 **/
public class PageBeanUtil {

    public static <T> PageBean<T> getPageBean(Page<Object> page, List<T> list){

        PageBean<T> pageBean=new PageBean<>();
        //        private int currPage;//当前页数
        pageBean.setCurrPage(page.getPageNum());
        //        private int pageSzie;//分页大小
        pageBean.setPageSzie(page.getPageSize());
        //        private int totalPage;//总页数
        pageBean.setTotalPage(page.getPages());
        //        private List<T> data;//数据
        pageBean.setData(list);
        //        private int totalNums;//总数量
        pageBean.setTotalNums((int)page.getTotal());
        //        private int currpageSzie;//当前页数据数量
        pageBean.setCurrpageSzie(list.size());
     return pageBean;
    }
}
