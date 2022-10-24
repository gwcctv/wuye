package com.woniuxy.busconfig.web;

import com.woniuxy.busconfig.service.TbReceiveMoneyWayService;
import com.woniuxy.wuye.common.entity.TbReceiveMoneyWay;
import com.woniuxy.wuye.common.exceptions.NoIdInSqlException;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("receiveMoneyWay")
@Transactional(rollbackFor = Exception.class)
public class TbReceiveMoneyWayController {
    @Autowired
    TbReceiveMoneyWayService tbReceiveMoneyWayService;
    @RequestMapping("getByCondition")
    public List<TbReceiveMoneyWay> getByCondition(@RequestBody TbReceiveMoneyWay tbReceiveMoneyWay){
        return tbReceiveMoneyWayService.getByCondition(tbReceiveMoneyWay);
    }

    @RequestMapping("add")
    public ResponseEntity add(@RequestBody TbReceiveMoneyWay tbReceiveMoneyWay){
        tbReceiveMoneyWayService.save(tbReceiveMoneyWay);
        return ResponseEntity.SUCCESS;
    }

    @RequestMapping("delete")
    public ResponseEntity delete(int id) throws NoIdInSqlException {
       if( tbReceiveMoneyWayService.removeById(id)){
           return ResponseEntity.SUCCESS;
       }
           throw new NoIdInSqlException();


    }

}
