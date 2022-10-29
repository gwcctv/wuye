package com.woniuxy.clientmanager.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniuxy.clientmanager.mapper.ClientMapper;
import com.woniuxy.clientmanager.service.ClientService;
import com.woniuxy.clientmanager.vo.ClientVo;
import com.woniuxy.wuye.common.entity.TbClient;
import com.woniuxy.wuye.common.entity.TbHouse;
import com.woniuxy.wuye.common.utils.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author li
 * @data 2022/10/19{} 10:57
 */
@Service
@Slf4j
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientMapper clientMapper;

    /**
     * 查询所有用户
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageBean<TbClient> findAll(int page, int size) {
        //设置分页
        PageBean<TbClient> pageBean = new PageBean<>();
        pageBean.setPageSzie(size); //分页大小
        pageBean.setCurrPage(page); //当前页码
        Page<TbClient> pages = PageHelper.startPage(pageBean.getCurrPage(), pageBean.getPageSzie());
        List<TbClient> allClients = clientMapper.findAll();
        pageBean.setTotalNums((int) pages.getTotal()); //总条数
        pageBean.setTotalPage(pages.getPages()); //总页数
        pageBean.setData(allClients);   //设置数据
        pageBean.setCurrpageSzie(pageBean.getData().size()); //当前页展示数据条数
        return pageBean;
    }

    /**
     * 查询所有用户及其房产、项目
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageBean<TbClient> myClient(int page, int size) {
        //设置分页
        PageBean<TbClient> pageBean = new PageBean<>();
        pageBean.setPageSzie(size); //分页大小
        pageBean.setCurrPage(page); //当前页码
        Page<TbClient> pages = PageHelper.startPage(pageBean.getCurrPage(), pageBean.getPageSzie());
        List<TbClient> client = clientMapper.myClient();
        pageBean.setTotalNums((int) pages.getTotal()); //总条数
        pageBean.setTotalPage(pages.getPages()); //总页数
        pageBean.setData(client);   //设置数据
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

    @Override
    public boolean updateById(TbClient tbClient) {
        return clientMapper.updateById(tbClient);
    }

    @Override
    public int getByName(String clientName) {
        return clientMapper.getByName(clientName);
    }

    @Override
    public ClientVo findClientVoByName(String clientName) {
        return clientMapper.findClientVoByName(clientName);
    }

    @Override
    public PageBean<TbClient> findClientByPName(String projectName, int page,int size) {
        PageBean<TbClient> pageBean = new PageBean<>();
        pageBean.setPageSzie(size); //分页大小
        pageBean.setCurrPage(page); //当前页码
        Page<TbClient> pages = PageHelper.startPage(pageBean.getCurrPage(), pageBean.getPageSzie());
        List<TbClient> client = clientMapper.findClientByPName(projectName);
        pageBean.setTotalNums((int) pages.getTotal()); //总条数
        pageBean.setTotalPage(pages.getPages()); //总页数
        pageBean.setData(client);   //设置数据
        pageBean.setCurrpageSzie(pageBean.getData().size()); //当前页展示数据条数
        return pageBean;
    }

    @Override
    public List<TbClient> findClientByPId(int projectId) {
        return clientMapper.findClientByPId(projectId);
    }

    @Override
    public List<TbHouse> findHouseByCId(int clientID) {
        return clientMapper.findHouseByCId(clientID);
    }

    @Override
    public TbClient selectById(int id) {
        return clientMapper.selectById(id);
    }


}
