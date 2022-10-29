package com.woniuxy.admin.controller;

import com.woniuxy.admin.service.ManagerService;
import com.woniuxy.wuye.common.entity.TbManager;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @PostMapping("/tologin")
    public ResponseEntity login(@RequestBody TbManager tbManager) {
        TbManager manager = managerService.getManager(tbManager.getAccount(), tbManager.getPassword());
        if(manager==null){//如果user为空
            return new ResponseEntity("500","失败","账号或密码错误");
        }else{
            //到这里表示存在用户，在这里对manager是否为管理员进行判断
            //当用户的状态为y的时候 就是管理员
            if(!manager.getState().equals("y")) {
                return new ResponseEntity("400","不合法","不是管理员");
            }else{
                return  ResponseEntity.SUCCESS;
            }
        }
    }

}
