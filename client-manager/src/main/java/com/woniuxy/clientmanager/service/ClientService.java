package com.woniuxy.clientmanager.service;

import com.woniuxy.clientmanager.vo.ClientVo;
import com.woniuxy.wuye.common.entity.TbClient;
import com.woniuxy.wuye.common.utils.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClientService {
    /**
     * 查询所有
     * @return
     */
    PageBean<TbClient> findAll(int page, int size);

    /**
     *  查询客户及房产
     */
    PageBean<TbClient> myClient(int page, int size);

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


    /**
     *  根据id更新客户
     */
    boolean updateById(TbClient tbClient);

    int getByName(String clientName);

    /**
     * 根据客户名查询ClientVo
     * @param clientName
     * @return
     */
    ClientVo findClientVoByName(String clientName);
}
