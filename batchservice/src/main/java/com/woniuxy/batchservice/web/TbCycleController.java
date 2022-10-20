package com.woniuxy.batchservice.web;

import com.woniuxy.batchservice.service.TbCycleService;
import com.woniuxy.wuye.common.entity.TbCycle;
import com.woniuxy.wuye.common.exceptions.NoIdInSqlException;
import com.woniuxy.wuye.common.utils.PageBean;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 周期业务接口
 * */
@RequestMapping("cycle")
@RestController
@Transactional( rollbackFor = Exception.class)
public class TbCycleController {
    @Autowired
    TbCycleService tbCycleService;
/**
 * 多条件分页查询
 * */
    @RequestMapping("getByPage")
    public PageBean<TbCycle> getByConditionByPage(@RequestBody TbCycle tbCycle, int page) {

        return tbCycleService.getByConditionByPage(tbCycle, page);
    }
/**
 * 添加周期业务
 * */
    @PostMapping("add")
    public ResponseEntity addCycle(@RequestBody TbCycle tbCycle) {

        tbCycleService.save(tbCycle);


        return ResponseEntity.SUCCESS;
    }
/**
 * 周期业务根据ID删除
 * */
    @RequestMapping("delete")
    public ResponseEntity deleteById(String idsString) throws NoIdInSqlException {
      String[] idsS=  idsString.split(",");
      int[] ids=new int[idsS.length];
      //判断是否删除的参数
      Boolean is=true;
       for(int i=0;i<idsS.length;i++){
           ids[i]=Integer.parseInt(idsS[i]) ;
       }
        if (ids.length == 1) {
          is= tbCycleService.removeById(ids[0]);
        } else {
            for (int id : ids) {
               is= tbCycleService.removeById(id);
               if(is==false){
                   throw new NoIdInSqlException();
               }
            }
        }
        if(is==false){
            throw new NoIdInSqlException();
        }
        return ResponseEntity.SUCCESS;
    }

}