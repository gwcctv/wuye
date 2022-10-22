package com.woniuxy.busconfig.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woniuxy.busconfig.service.TbLatefeeManagementService;
import com.woniuxy.wuye.common.entity.TbLatefeeManagement;
import com.woniuxy.wuye.common.entity.TbMeasure;
import com.woniuxy.wuye.common.entity.TbMoneyDeduction;
import com.woniuxy.wuye.common.entity.vo.TbLatefeeManagementVo;
import com.woniuxy.wuye.common.entity.vo.TbMeasureVo;
import com.woniuxy.wuye.common.utils.PageBean;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("znjgl")
public class TbLatefeeManagementController {
    @Autowired
  private  TbLatefeeManagementService tbLatefeeManagementService;
    @RequestMapping("add")
    public ResponseEntity add(@RequestBody TbLatefeeManagement latefeeManagement){
        tbLatefeeManagementService.save(latefeeManagement);
        return ResponseEntity.SUCCESS;
    }
    @RequestMapping("delete")
    public ResponseEntity delete(Integer id){
        QueryWrapper<TbLatefeeManagement> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("id",id);
        tbLatefeeManagementService.remove(queryWrapper);
        return ResponseEntity.SUCCESS;
    }
    @RequestMapping("update")
    public ResponseEntity update(@RequestBody TbLatefeeManagement latefeeManagement){
        tbLatefeeManagementService.updateById(latefeeManagement);
        return ResponseEntity.SUCCESS;
    }
    @RequestMapping("/getByPage")
    public ResponseEntity getByPage(@RequestBody TbLatefeeManagementVo tbLatefeeManagementVo){
        PageBean<TbLatefeeManagement> pageDate = tbLatefeeManagementService.getByPage(tbLatefeeManagementVo.getTbLatefeeManagement()==null?new TbLatefeeManagement():tbLatefeeManagementVo.getTbLatefeeManagement(), tbLatefeeManagementVo.getPage()==null?1:tbLatefeeManagementVo.getPage());
        return new ResponseEntity("200","ok",pageDate);
    }
}
