package com.woniuxy.admin.service.impl;

import com.woniuxy.admin.mapper.ManagerMapper;
import com.woniuxy.admin.service.ManagerService;
import com.woniuxy.wuye.common.entity.TbManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerMapper managerMapper;

    @Override
    public void insert(TbManager tbManager) {
        managerMapper.insert(tbManager);
    }

    @Override
    public TbManager getManager(String account, String password) {
        return managerMapper.getManager(account,password);
    }
}
