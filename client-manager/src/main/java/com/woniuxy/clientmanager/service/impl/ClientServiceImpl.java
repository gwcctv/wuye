package com.woniuxy.clientmanager.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniuxy.clientmanager.mapper.ClientMapper;
import com.woniuxy.clientmanager.service.ClientService;
import com.woniuxy.wuye.common.entity.TbClient;
import com.woniuxy.wuye.common.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author li
 * @data 2022/10/19{} 10:57
 */
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientMapper clientMapper;

    /**
     * 查询所有用户
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageBean<TbClient> findAll(int currentPage, int pageSize) {
        //设置分页
        PageBean<TbClient> pageBean = new PageBean<>();
        pageBean.setPageSzie(pageSize); //分页大小
        pageBean.setCurrPage(currentPage); //当前页码
        Page<TbClient> page = PageHelper.startPage(pageBean.getCurrPage(), pageBean.getPageSzie());
        List<TbClient> allClients = clientMapper.findAll();
        pageBean.setTotalNums((int) page.getTotal()); //总条数
        pageBean.setTotalPage(page.getPages()); //总页数
        pageBean.setData(allClients);   //设置数据
        pageBean.setCurrpageSzie(pageBean.getData().size()); //当前页展示数据条数
        return pageBean;
    }

    /**
     * 查询所有用户及其房产、项目
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageBean<TbClient> findClient(int currentPage, int pageSize) {
        //设置分页
        PageBean<TbClient> pageBean = new PageBean<>();
        pageBean.setPageSzie(pageSize); //分页大小
        pageBean.setCurrPage(currentPage); //当前页码
        Page<TbClient> page = PageHelper.startPage(pageBean.getCurrPage(), pageBean.getPageSzie());
        List<TbClient> allClients = clientMapper.findClient();
        pageBean.setTotalNums((int) page.getTotal()); //总条数
        pageBean.setTotalPage(page.getPages()); //总页数
        pageBean.setData(allClients);   //设置数据
        pageBean.setCurrpageSzie(pageBean.getData().size()); //当前页展示数据条数
        return pageBean;
    }

    /**
     *
     * @param tbClient
     * @return
     */
    @Override
    public List<TbClient> findClientByCondition(TbClient tbClient) {
        return clientMapper.findClientByCondition(tbClient);
    }

    @Override
    public int deleteById(int id) {
       return clientMapper.deleteById(id);
    }

    @Override
    public boolean update(TbClient tbClient) {
        return clientMapper.update(tbClient);
    }

    @Override
    public boolean insertClient(TbClient tbClient) {
        return clientMapper.insertClient(tbClient);
    }


}
