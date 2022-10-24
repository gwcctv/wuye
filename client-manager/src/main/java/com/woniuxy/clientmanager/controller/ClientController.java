package com.woniuxy.clientmanager.controller;

import com.woniuxy.clientmanager.service.ClientService;
import com.woniuxy.wuye.common.entity.TbClient;
import com.woniuxy.wuye.common.utils.PageBean;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 条件查询客户
     * @param tbClient
     * @return
     */
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

    /**
     * 根据id删除客户
     * @param id
     * @return
     */
    @GetMapping("/deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        int i = clientService.deleteById(id);
        ResponseEntity responseEntity = new ResponseEntity<>();
        if(i==0){
            responseEntity.setCode("201");
            responseEntity.setMsg("删除失败");
        }else {
            responseEntity.setCode("200");
            responseEntity.setData(i);
            responseEntity.setMsg("删除成功");
        }
        return responseEntity;
    }

    /**
     * 修改客户信息
     * @param tbClient
     * @return
     */
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody TbClient tbClient) {
        Boolean flag = clientService.update(tbClient);
        ResponseEntity responseEntity = new ResponseEntity<>();
        if(flag=false){
            responseEntity.setCode("201");
            responseEntity.setMsg("修改失败");
        }else {
            responseEntity.setCode("200");
            responseEntity.setMsg("修改成功");
        }
        return responseEntity;
    }

    @PostMapping("/insertClient")
    public ResponseEntity insertClient(@RequestBody TbClient tbClient) {
        Boolean flag = clientService.insertClient(tbClient);
        ResponseEntity responseEntity = new ResponseEntity<>();
        if(flag=false){
            responseEntity.setCode("201");
            responseEntity.setMsg("添加失败");
        }else {
            responseEntity.setCode("200");
            responseEntity.setMsg("添加成功");
        }
        return responseEntity;
    }
}
