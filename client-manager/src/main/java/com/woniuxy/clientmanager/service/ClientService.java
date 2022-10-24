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

    /**
     *  根据id删除客户
     */
    int deleteById(int id);

    /**
     *  根据id更新客户
     */
    boolean update(TbClient tbClient);

    boolean insertClient(TbClient tbClient);
}
