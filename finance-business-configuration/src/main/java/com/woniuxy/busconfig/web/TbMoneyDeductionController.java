package com.woniuxy.busconfig.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woniuxy.busconfig.service.TbMoneyDeductionService;
import com.woniuxy.wuye.common.entity.TbDocumentConfiguration;
import com.woniuxy.wuye.common.entity.TbMoneyDeduction;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("zdjmlx")
@RestController
public class TbMoneyDeductionController {
    @Autowired
   private TbMoneyDeductionService tbMoneyDeductionService;
    @RequestMapping("add")
    public ResponseEntity add(@RequestBody TbMoneyDeduction tbMoneyDeduction){
        tbMoneyDeductionService.save(tbMoneyDeduction);
        return ResponseEntity.SUCCESS;
    }
    @RequestMapping("delete")
    public ResponseEntity delete(Integer id){
        QueryWrapper<TbMoneyDeduction> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("id",id);
        tbMoneyDeductionService.remove(queryWrapper);
        return ResponseEntity.SUCCESS;
    }
    @RequestMapping("update")
    public ResponseEntity update(@RequestBody TbMoneyDeduction tbMoneyDeduction){
        tbMoneyDeductionService.updateById(tbMoneyDeduction);
        return ResponseEntity.SUCCESS;
    }
    @RequestMapping("getll")
    public ResponseEntity getAll(){
        List<TbMoneyDeduction> list = tbMoneyDeductionService.list();
        return new ResponseEntity("200","ok",list);
    }
}
