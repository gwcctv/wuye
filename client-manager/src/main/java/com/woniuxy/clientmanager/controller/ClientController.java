package com.woniuxy.clientmanager.controller;

import com.woniuxy.clientmanager.feign.HouseFeign;
import com.woniuxy.clientmanager.service.ClientService;
import com.woniuxy.clientmanager.vo.ClientVo;
import com.woniuxy.clientmanager.vo.Cvo;
import com.woniuxy.wuye.common.annotation.AutoLog;
import com.woniuxy.wuye.common.entity.TbClient;
import com.woniuxy.wuye.common.entity.TbHouse;
import com.woniuxy.wuye.common.utils.PageBean;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author li
 * @data 2022/10/19{} 14:05
 */
@Slf4j
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Resource
    private HouseFeign houseFeign;
    /**
     * 查询所有
     * @param page
     * @param size
     * @return
     */
    @AutoLog("value=查询所有客户")
    @GetMapping("/all/{page}/{size}")
    public ResponseEntity findAll(@PathVariable int page,@PathVariable int size) {
        PageBean<TbClient> all = clientService.findAll(page,size);
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
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/clients/{page}/{size}")
    public ResponseEntity findClient(@PathVariable int page,@PathVariable int size) {
        PageBean<TbClient> all = clientService.myClient(page,size);
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
            responseEntity.setData(tbClient.getClientId());
        }
        return responseEntity;
    }

    /**
     * 修改客户信息
     * @param tbClient
     * @return
     */
    @PostMapping("/update")
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

    /**
     * 修改客户信息
     * @param tbClient
     * @return
     */
    @PostMapping("/updateById")
    public ResponseEntity updateById(@RequestBody TbClient tbClient) {
        Boolean flag = clientService.updateById(tbClient);
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

    /**
     * 通过客户名查客户id
     * @param clientName
     * @return
     */
    @RequestMapping("/name")
    public int getByname(@RequestParam String clientName){
        return clientService.getByName(clientName);
    }

    /**
     * 根据id查询客户
     */
    @GetMapping("/selectById")
    public ResponseEntity<TbClient> selectById(@RequestParam int id){
        ResponseEntity responseEntity = new ResponseEntity<>();
        TbClient tbClient = clientService.selectById(id);
        if(tbClient==null){
            responseEntity.setCode("201");
            responseEntity.setMsg("查询失败");
        }else{
            responseEntity.setCode("200");
            responseEntity.setMsg("查询成功");
            responseEntity.setData(tbClient);
        }
        return responseEntity;
    }
    /**
     * 通过客户名字查询ClientVo
     */
    @PostMapping("/findClientVoByName/{clientName}")
    public ResponseEntity findClientVoByName(@PathVariable String clientName){
        ResponseEntity responseEntity = new ResponseEntity<>();
        ClientVo clientVo = clientService.findClientVoByName(clientName);
        if(clientVo==null){
            responseEntity.setCode("201");
            responseEntity.setMsg("查询失败");
        }else{
            responseEntity.setCode("200");
            responseEntity.setMsg("查询成功");
            responseEntity.setData(clientVo);
        }
        return responseEntity;
    }
    /**
     * 根据项目名字查询房产
     */
    @PostMapping("/findClientByPName")
    public ResponseEntity findClientByPName(@RequestBody Cvo cvo){
        ResponseEntity responseEntity = new ResponseEntity<>();
        PageBean<TbClient> clientByPName = clientService.findClientByPName(cvo.getProjectName(), cvo.getPage(), cvo.getSize());
        if (clientByPName==null){
            responseEntity.setCode("201");
            responseEntity.setMsg("查询失败");
        }else{
            responseEntity.setCode("200");
            responseEntity.setMsg("查询成功");
            responseEntity.setData(clientByPName);
        }
        return responseEntity;
    }

    @PostMapping("/addClientAndHouse")
    public ResponseEntity addClientAndHouse(@RequestBody TbClient tbClient){
        ResponseEntity responseEntity = houseFeign.addHouse(tbClient.getTbHouse());
        int houseId = (Integer)responseEntity.getData();
        tbClient.setHouseId(houseId);
        boolean b = clientService.insertClient(tbClient);
        return  ResponseEntity.SUCCESS;
    }

    /**
     * 根据项目id查询客户
     * @param projectId
     * @return
     */
    @PostMapping("/findClientByPId")
    public ResponseEntity findClientByPId(@RequestParam int projectId){
        ResponseEntity responseEntity = new ResponseEntity<>();
        List<TbClient> clientByPId = clientService.findClientByPId(projectId);
        if(clientByPId!=null){
            responseEntity.setData(clientByPId);
            responseEntity.setCode("200");
            responseEntity.setMsg("查询成功");
        }else{
            responseEntity.setCode("201");
            responseEntity.setMsg("查询失败");
        }
        return responseEntity;
    }

    /**
     * 根据客户id查询房产
     * @param clientId
     * @return
     */
    @PostMapping("/findClientByCId")
    public ResponseEntity findClientByCId(@RequestParam int clientId){
        ResponseEntity responseEntity = new ResponseEntity<>();
        List<TbHouse> houseByCId = clientService.findHouseByCId(clientId);
        if(houseByCId!=null){
            responseEntity.setData(houseByCId);
            responseEntity.setCode("200");
            responseEntity.setMsg("查询成功");
        }else{
            responseEntity.setCode("201");
            responseEntity.setMsg("查询失败");
        }
        return responseEntity;
    }
}
