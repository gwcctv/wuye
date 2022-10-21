package com.woniuxy.clientmanager.service;

import com.woniuxy.wuye.common.entity.TbClient;
import com.woniuxy.wuye.common.utils.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClientService {
    /**
     * 查询所有
     * @return
     */
    PageBean<TbClient> findAll(int currentPage, int pageSize);

    /**
     *  查询客户及房产
     */
    PageBean<TbClient> findClient(int currentPage, int pageSize);

    /**
     *  根据条件查询客户
     */
    List<TbClient> findClientByCondition(TbClient tbClient);
}
