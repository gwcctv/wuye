package com.woniuxy.admin.service;

import com.woniuxy.wuye.common.entity.TbManager;

public interface ManagerService {
    /**
     * 增加用户
     * @param tbManager
     */
    void insert(TbManager tbManager);

    /**
     *根据账号密码找用户
     * @param account
     * @param password
     * @return
     */
    TbManager getManager(String account, String password);
}
