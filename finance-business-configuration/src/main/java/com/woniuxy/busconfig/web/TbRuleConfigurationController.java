package com.woniuxy.busconfig.web;

import com.woniuxy.busconfig.service.TbRuleConfigurationService;
import com.woniuxy.busconfig.service.serviceiml.TbRuleConfigurationServiceimpl;
import com.woniuxy.wuye.common.entity.TbMeasure;
import com.woniuxy.wuye.common.entity.TbMoneyDeduction;
import com.woniuxy.wuye.common.entity.TbRuleConfiguration;
import com.woniuxy.wuye.common.entity.vo.TbMeasureVo;
import com.woniuxy.wuye.common.entity.vo.TbRuleConfigurationVo;
import com.woniuxy.wuye.common.utils.PageBean;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("gzpzb")
@RestController
public class TbRuleConfigurationController {
    @Autowired
   private TbRuleConfigurationService tbRuleConfigurationService;
    @RequestMapping("add")
    public ResponseEntity add(@RequestBody TbRuleConfiguration  tbRuleConfiguration){
        tbRuleConfigurationService.addTbRuleConfiguration(tbRuleConfiguration);
        return ResponseEntity.SUCCESS;
    }
    @RequestMapping("/getByPage")
    public ResponseEntity getByPage(@RequestBody TbRuleConfigurationVo tbRuleConfigurationVo){
        PageBean<TbRuleConfiguration> pageDate = tbRuleConfigurationService.getTbRuleConfiguration(tbRuleConfigurationVo.getTbRuleConfiguration()==null?new TbRuleConfiguration():tbRuleConfigurationVo.getTbRuleConfiguration(), tbRuleConfigurationVo.getPage()==null?1:tbRuleConfigurationVo.getPage());
        return new ResponseEntity("200","ok",pageDate);
    }
    @RequestMapping("update")
    public ResponseEntity update(@RequestBody TbRuleConfiguration  tbRuleConfiguration){
        tbRuleConfigurationService.updateById(tbRuleConfiguration);
        return ResponseEntity.SUCCESS;
    }
}
