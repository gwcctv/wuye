package com.woniuxy.busconfig.web;

import com.woniuxy.busconfig.service.TbFeesStandardConfigurationService;
import com.woniuxy.busconfig.service.serviceiml.TbFeesStandardConfigurationServiceimpl;
import com.woniuxy.wuye.common.entity.TbChargeableItems;
import com.woniuxy.wuye.common.entity.TbFeesStandardConfiguration;
import com.woniuxy.wuye.common.entity.vo.TbChargeableItemsVo;
import com.woniuxy.wuye.common.entity.vo.TbFeesStandardConfigurationVo;
import com.woniuxy.wuye.common.utils.PageBean;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sfbzpzb")
@Transactional(rollbackFor = Exception.class)
public class TbFeesStandardConfigurationController {
    @Autowired
   private TbFeesStandardConfigurationService tbFeesStandardConfigurationService;
   @RequestMapping("/add")
    public ResponseEntity add(@RequestBody TbFeesStandardConfiguration tbFeesStandardConfiguration){
       tbFeesStandardConfigurationService.addTbFeesStandardConfiguration(tbFeesStandardConfiguration);
        return  ResponseEntity.SUCCESS;
    }
    @RequestMapping("/delete")
    public ResponseEntity delete(Integer id){
        tbFeesStandardConfigurationService.deleteTbFeesStandardConfiguration(id);
        return  ResponseEntity.SUCCESS;
    }
    @RequestMapping("/update")
    public ResponseEntity update(@RequestBody TbFeesStandardConfiguration tbFeesStandardConfiguration){
        tbFeesStandardConfigurationService.updateTbFeesStandardConfiguration(tbFeesStandardConfiguration);
        return  ResponseEntity.SUCCESS;
    }
    @RequestMapping("/getByPage")
    public ResponseEntity getByPage(@RequestBody TbFeesStandardConfigurationVo tbFeesStandardConfigurationVo){
        PageBean<TbFeesStandardConfiguration> pageDate = tbFeesStandardConfigurationService.getByPage(tbFeesStandardConfigurationVo.getTbFeesStandardConfiguration()==null?new TbFeesStandardConfiguration():tbFeesStandardConfigurationVo.getTbFeesStandardConfiguration(), tbFeesStandardConfigurationVo.getPage()==null?1:tbFeesStandardConfigurationVo.getPage());
        return new ResponseEntity("200","ok",pageDate);
    }
    @RequestMapping("/getByCondition")
    public  PageBean<TbFeesStandardConfiguration> getByCondition(@RequestBody TbFeesStandardConfigurationVo tbFeesStandardConfigurationVo){
        PageBean<TbFeesStandardConfiguration> pageDate = tbFeesStandardConfigurationService.getByPage(tbFeesStandardConfigurationVo.getTbFeesStandardConfiguration()==null?new TbFeesStandardConfiguration():tbFeesStandardConfigurationVo.getTbFeesStandardConfiguration(), tbFeesStandardConfigurationVo.getPage()==null?1:tbFeesStandardConfigurationVo.getPage());
        return pageDate;
    }

}
