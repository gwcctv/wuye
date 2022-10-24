package com.woniuxy.busconfig.web;

import com.woniuxy.busconfig.service.TbChargeTypeService;
import com.woniuxy.wuye.common.entity.TbChargeType;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 收费项类型
 */
@RestController
@RequestMapping("sfxlx")
public class TbChargeTypeController {
    @Autowired
    private TbChargeTypeService tbChargeTypeService;
    @RequestMapping("/getAll")
    public ResponseEntity getTbChargeType(){
        //获得所有类型
        List<TbChargeType> listAll =tbChargeTypeService.getAll();
        //筛选出父类型
        List<TbChargeType> fatherList = listAll.stream().filter(e -> e.getFather() == null).collect(Collectors.toList());
       //筛选出子类型
        List<TbChargeType> childList = listAll.stream().filter(e -> e.getFather() != null).collect(Collectors.toList());
      //将子类型放在他的父中
        for (int i = 0; i < fatherList.size(); i++) {
            int finalI = i;
            List<TbChargeType> thisChildMenus= childList.stream().filter(e->e.getFather()==fatherList.get(finalI).getId()).collect(Collectors.toList());
            fatherList.get(i).setSubMenus(thisChildMenus);
        }
        return new ResponseEntity<>("200","ok",fatherList);
    }
    @RequestMapping("/update")
    public ResponseEntity updateTbChargeType(@RequestBody TbChargeType tbChargeType){
        tbChargeTypeService.updateChargeType(tbChargeType);
        return ResponseEntity.SUCCESS;
    }
    @RequestMapping("add")
    public ResponseEntity addTbChargeType(@RequestBody TbChargeType tbChargeType){
        tbChargeTypeService.addChargeType(tbChargeType);
        return ResponseEntity.SUCCESS;
    }
    @RequestMapping("delete")
    public ResponseEntity deleteTbChargeType(Integer id){
        tbChargeTypeService.deleteChargeType(id);
        return ResponseEntity.SUCCESS;
    }
}
