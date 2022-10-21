package com.woniuxy.batchservice.web;

import com.woniuxy.batchservice.service.TbClockService;
import com.woniuxy.wuye.common.entity.TbClock;
import com.woniuxy.wuye.common.exceptions.NoIdInSqlException;
import com.woniuxy.wuye.common.utils.PageBean;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clock")
@Transactional( rollbackFor = Exception.class)
public class TbClockController {
    @Autowired
    TbClockService tbClockService;

    @RequestMapping("getByPage")
    public PageBean<TbClock> getByConditionByPage(TbClock tbClock,int page){
        return tbClockService.getByCondition(tbClock,page);
    }
    @RequestMapping("add")
    public ResponseEntity add(@RequestBody TbClock tbClock){
        tbClockService.save(tbClock);
        return ResponseEntity.SUCCESS;
    }
    @RequestMapping("delete")
    public ResponseEntity delete(String idsString) throws NoIdInSqlException {
        String[] idsS=  idsString.split(",");
        int[] ids=new int[idsS.length];
        //判断是否删除的参数
        Boolean is=true;
        for(int i=0;i<idsS.length;i++){
            ids[i]=Integer.parseInt(idsS[i]) ;
        }
        if (ids.length == 1) {
            is= tbClockService.removeById(ids[0]);
        } else {
            for (int id : ids) {
                is= tbClockService.removeById(id);
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
