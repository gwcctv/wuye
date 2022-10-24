package com.woniuxy.batchservice.web;

import com.woniuxy.batchservice.feign.CashRegister;
import com.woniuxy.batchservice.service.TbCheckReduceService;
import com.woniuxy.wuye.common.entity.TbCheckReduce;
import com.woniuxy.wuye.common.entity.TbClient;
import com.woniuxy.wuye.common.entity.TbUnpaidBills;
import com.woniuxy.wuye.common.exceptions.NoIdInSqlException;
import com.woniuxy.wuye.common.utils.PageBean;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 减免业务申请接口
 * */
@RestController
@RequestMapping("reduce")
@Transactional( rollbackFor = Exception.class)
public class TbCheckReduceController {
    @Autowired
    TbCheckReduceService tbCheckReduceService;
    @Autowired
    CashRegister cashRegister;



    @RequestMapping("getByPage")
    public PageBean<TbCheckReduce> getByCondition(@RequestBody TbCheckReduce tbCheckReduce, int page){

        return  tbCheckReduceService.getByCondition(tbCheckReduce,page);

    }
    @RequestMapping("add")
    public ResponseEntity add(@RequestBody TbCheckReduce tbCheckReduce){
        tbCheckReduceService.save(tbCheckReduce);
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
            is= tbCheckReduceService.removeById(ids[0]);
        } else {
            for (int id : ids) {
                is= tbCheckReduceService.removeById(id);
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
    /**
     * 账单生成时减免申请的使用次数减1
     * */
    @RequestMapping("reduceStatus")
    public ResponseEntity reduceStatus(Integer id){
      TbCheckReduce tbCheckReduce=  tbCheckReduceService.getById(id);
        int satus=Integer.parseInt(tbCheckReduce.getStatus());
        satus=satus-1;
        tbCheckReduce.setStatus(""+satus);
        tbCheckReduceService.updateById(tbCheckReduce);
        return ResponseEntity.SUCCESS;
    }
    /**
     * 账单作废时减免申请的使用次数加1
     * */
    @RequestMapping("addStatus")
    public ResponseEntity addStatus(Integer id){
        TbCheckReduce tbCheckReduce=  tbCheckReduceService.getById(id);
        int satus=Integer.parseInt(tbCheckReduce.getStatus());
        satus=satus+1;
        tbCheckReduce.setStatus(""+satus);
        tbCheckReduceService.updateById(tbCheckReduce);
        return ResponseEntity.SUCCESS;
    }
}
