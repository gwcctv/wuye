package com.woniuxy.housemanager.controller;

import com.woniuxy.housemanager.service.HouseService;
import com.woniuxy.housemanager.vo.HouseVo;
import com.woniuxy.wuye.common.annotation.AutoLog;
import com.woniuxy.wuye.common.entity.TbBuilding;
import com.woniuxy.wuye.common.entity.TbClient;
import com.woniuxy.wuye.common.entity.TbHouse;
import com.woniuxy.wuye.common.utils.PageBean;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import io.seata.spring.annotation.GlobalTransactional;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/house")
public class HouseController {
    @Autowired
    HouseService houseService;
    @Autowired
    BuildingFeign buildingFeign;
    @Autowired
    ProjectFeign projectFeign;
    @Autowired
    ClientFeign clientFeign;

    /**
     * 查出所有房产
     * @return
     */
    @RequestMapping("/all")
    public  ResponseEntity getAll(){
        List<TbHouse> all = houseService.getAll();
        return new ResponseEntity("200","ok",all);
    }

    @RequestMapping("/addHoouse")
    public ResponseEntity addHouse(TbHouse tbHouse){
        ResponseEntity responseEntity = new ResponseEntity<>();
        houseService.add(tbHouse);
        responseEntity.setData(tbHouse.getHouseId());
        return  responseEntity;
    }
    /**
     * 根据客户id和项目id查房产
     * @param projectId
     * @param clientId
     * @return
     */
    @RequestMapping("/pcid/{projectId}/{clientId}")
    public  ResponseEntity ByProAndClient(@PathVariable("projectId") Integer projectId,@PathVariable("clientId") Integer clientId){
        TbHouse tbHouse=new TbHouse();
        tbHouse.setClientId(clientId);
        tbHouse.setProjectId(projectId);
        List<TbHouse> houseList = houseService.getByCondition(tbHouse);
        return new ResponseEntity("200","ok",houseList);
    }

    /**
     * 多条件分页查询。默认首页，条件为空
     * @param houseVo
     * @return
     */
    @RequestMapping("/list")
    public ResponseEntity list(@RequestBody HouseVo houseVo){
        PageBean<TbHouse> byCondition
                = houseService.getByCondition(houseVo.getTbHouse(), houseVo.getPageSize(), houseVo.getPage());
        return new ResponseEntity("200","ok",byCondition);
    }
//    增加房产 同时也需要增加房产所属项目，所属楼栋，所属客户
//    管理员在增加房产，需要填写项目名，楼栋号，客户名字
    @RequestMapping("/add")
//    @GlobalTransactional
//    @Transactional
    public ResponseEntity add(@RequestBody TbHouse tbHouse){
        //int clientId = clientFeign.getByname(tbHouse.getClientName());//通过客户名得到客户id
        TbClient tbClient = tbHouse.getTbClient();
        ResponseEntity responseEntity= clientFeign.insertClient(tbClient);
        tbClient.setClientId((Integer) responseEntity.getData());
        Integer clientId = tbClient.getClientId();//获取客户id
        int projectId = projectFeign.getByName(tbHouse.getProjectName());//通过项目名得到项目id
        int buildingId = buildingFeign.getByNumber(tbHouse.getBuildingNumber());//通过楼栋号得到楼栋id
        tbHouse.setProjectId(projectId);
        tbHouse.setClientId(clientId);
        tbHouse.setBuildingId(buildingId);
        houseService.add(tbHouse);
        return ResponseEntity.SUCCESS;
    }

    /**
     * 通过id删除房产
     * @param houseId
     * @return
     */
    @RequestMapping("/delete/{houseId}")
    public ResponseEntity delete(@PathVariable int houseId){
        houseService.delete(houseId);
        return ResponseEntity.SUCCESS;
    }

    /**
     * 点击修改，弹窗显示先展示修改列的全部数据
     * @param houseId
     * @return
     */
    @RequestMapping("/update/{houseId}")
    public ResponseEntity update(@PathVariable int houseId){
        TbHouse tbHouse=new TbHouse();
        tbHouse.setHouseId(houseId);
        List<TbHouse> byCondition = houseService.getByCondition(tbHouse);
        return new ResponseEntity("200","ok",byCondition);
    }

    /**
     * 执行修改操作
     * @param tbHouse
     * @return
     */
    @RequestMapping("/doupdate")
    public  ResponseEntity doUpdate(@RequestBody TbHouse tbHouse){
        Integer clientId = tbHouse.getClientId();//先得到传过来的客户id
        ResponseEntity responseEntity = clientFeign.selectById(clientId);//通过客户id查到该客户信息
        TbClient tbClient =(TbClient) responseEntity.getData();
        tbClient.setClientName(tbHouse.getClientName());//把该客户的名字进行更改
        clientFeign.update(tbClient);
        houseService.update(tbHouse);
        return ResponseEntity.SUCCESS;
    }

    @RequestMapping("/getById")
    public  TbHouse getById(@RequestBody Integer id){
        TbHouse tbHouse=new TbHouse();
        tbHouse.setHouseId(id);
 tbHouse=houseService.getByCondition(tbHouse).get(0);
        return   tbHouse;

    }
}
