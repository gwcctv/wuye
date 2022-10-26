package com.woniuxy.busconfig.web;


import com.alibaba.fastjson.JSONObject;
import com.woniuxy.busconfig.service.TbChargeTypeService;
import com.woniuxy.wuye.common.entity.TbChargeType;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 收费项类型
 */
@RestController
@RequestMapping("sfxlx")
@Slf4j
public class TbChargeTypeController {
    @Autowired
    private TbChargeTypeService tbChargeTypeService;
    //引入redis
    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping("/getAll")
    public ResponseEntity getTbChargeType(){
        List<TbChargeType> listAll =null;
        ListOperations<String,TbChargeType> listOps = redisTemplate.opsForList();
        //ValueOperations<String,TbChargeType> listOps = redisTemplate.opsForValue();
        //判断redis里有没有这个key
        if(!redisTemplate.hasKey("tbChargeTypeList")){
            //获得所有类型
             listAll =tbChargeTypeService.getAll();
           // String sList = JSONObject.toJSON(listAll).toString();
            listOps.leftPushAll("tbChargeTypeList",listAll);
            //listOps.append("tbChargeTypeList",sList);
        }
            //存在的条件下从redis里哪数据
            listAll  = (List<TbChargeType>) redisTemplate.opsForList().range("tbChargeTypeList",0,-1);
           log.debug("tbChargeTypeList:这个东西已经有了，进redis喽");

        //筛选出父类型
        List<TbChargeType> fatherList = listAll;

       //筛选出子类型
        List<TbChargeType> childList = listAll.stream().filter(e -> e.getFather() != null).collect(Collectors.toList());
      //将子类型放在他的父中
        for (int i = 0; i < fatherList.size(); i++) {
            int finalI = i;
            List<TbChargeType> thisChildMenus= childList.stream().filter(e->e.getFather()==fatherList.get(finalI).getId()).collect(Collectors.toList());
            fatherList.get(i).setSubMenus(thisChildMenus);
        }
        List<TbChargeType> collect = listAll.stream().filter(e -> e.getFather() == null&&e.getSubMenus()!=null).collect(Collectors.toList());
        return new ResponseEntity<>("200","ok",collect);
    }
    @RequestMapping("/update")
    public ResponseEntity updateTbChargeType(@RequestBody TbChargeType tbChargeType){
        tbChargeTypeService.updateChargeType(tbChargeType);
        List<TbChargeType>    list  = (List<TbChargeType>) redisTemplate.opsForList().range("tbChargeTypeList",0,-1);
       int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId()==tbChargeType.getId()){
                index=i;
            }
        }
        redisTemplate.opsForList().set("tbChargeTypeList",index,tbChargeType);
        return ResponseEntity.SUCCESS;
    }
    @RequestMapping("add")
    public ResponseEntity addTbChargeType(@RequestBody TbChargeType tbChargeType){
        tbChargeTypeService.addChargeType(tbChargeType);
        redisTemplate.opsForList().leftPush("tbChargeTypeList",tbChargeType);
        return ResponseEntity.SUCCESS;
    }
    @RequestMapping("delete")
    public ResponseEntity deleteTbChargeType(Integer id){

        //获取redis里的集合数据
        List<TbChargeType>    list  = (List<TbChargeType>) redisTemplate.opsForList().range("tbChargeTypeList",0,-1);
        int index = 0;

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId()==id){
                index=i;
            }
        }
        //对集合数据进行处理
        Iterator<TbChargeType> iterator = list.iterator();
        while(iterator.hasNext()){
            TbChargeType tbChargeType=iterator.next();
            if(tbChargeType.getFather()==id||tbChargeType.getId()==id){
                iterator.remove();
            }
        }
        //删除原来的
        redisTemplate.delete("tbChargeTypeList");
        //放入筛选过后的
        redisTemplate.opsForList().leftPushAll("tbChargeTypeList",list);
        tbChargeTypeService.deleteChargeType(id);
        return ResponseEntity.SUCCESS;
    }
    @RequestMapping("addList")
    public ResponseEntity addList(){
        List<TbChargeType> list= (List<TbChargeType>) redisTemplate.opsForList().range("tbChargeTypeList",0,-1);
        return new ResponseEntity("200","ok",list);
    }
    @RequestMapping("getById")
    public ResponseEntity addList(Integer id){
        return new ResponseEntity("200","ok",tbChargeTypeService.getById(id));
    }
}
