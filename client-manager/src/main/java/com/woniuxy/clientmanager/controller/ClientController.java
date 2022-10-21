package com.woniuxy.clientmanager.controller;

import com.woniuxy.clientmanager.service.ClientService;
import com.woniuxy.wuye.common.entity.TbClient;
import com.woniuxy.wuye.common.utils.PageBean;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author li
 * @data 2022/10/19{} 14:05
 */
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    /**
     * 查询所有
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/all/{currentPage}/{pageSize}")
    public ResponseEntity findAll(@PathVariable int currentPage,@PathVariable int pageSize) {
        PageBean<TbClient> all = clientService.findAll(currentPage,pageSize);
        ResponseEntity responseEntity = new ResponseEntity<>();
        if(all==null){
           responseEntity.setCode("201");
           responseEntity.setMsg("查询失败");
        }else {
            responseEntity.setCode("200");
            responseEntity.setData(all);
            responseEntity.setMsg("查询成功");
        }
        return responseEntity;
    }
    /**
     * 查询所有客户及楼栋单元
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/clients/{currentPage}/{pageSize}")
    public ResponseEntity findClient(@PathVariable int currentPage,@PathVariable int pageSize) {
        PageBean<TbClient> all = clientService.findClient(currentPage,pageSize);
        ResponseEntity responseEntity = new ResponseEntity<>();
        if(all==null){
            responseEntity.setCode("201");
            responseEntity.setMsg("查询失败");
        }else {
            responseEntity.setCode("200");
            responseEntity.setData(all);
            responseEntity.setMsg("查询成功");
        }
        return responseEntity;
    }

    @PostMapping("/findClientByCondition")
    public ResponseEntity findClientByCondition(@RequestBody TbClient tbClient) {
        List<TbClient> clientByCondition = clientService.findClientByCondition(tbClient);
        ResponseEntity responseEntity = new ResponseEntity<>();
        if(clientByCondition==null){
            responseEntity.setCode("201");
            responseEntity.setMsg("没有符合条件的客户");
        }else {
            responseEntity.setCode("200");
            responseEntity.setData(clientByCondition);
            responseEntity.setMsg("查询成功");
        }
        return responseEntity;
    }


}
