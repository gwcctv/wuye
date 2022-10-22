package com.woniuxy.busconfig.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woniuxy.busconfig.service.TbDocumentConfigurationService;
import com.woniuxy.wuye.common.entity.TbDocumentConfiguration;
import com.woniuxy.wuye.common.entity.TbFeesStandardConfiguration;
import com.woniuxy.wuye.common.entity.TbMeasure;
import com.woniuxy.wuye.common.entity.vo.TbDocumentConfigurationVo;
import com.woniuxy.wuye.common.entity.vo.TbFeesStandardConfigurationVo;
import com.woniuxy.wuye.common.utils.PageBean;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("djpz")
@RestController
@Transactional(rollbackFor = Exception.class)
public class TbDocumentConfigurationController {

    @Autowired
   private TbDocumentConfigurationService tbDocumentConfigurationService;
    @RequestMapping("add")
    public ResponseEntity add(@RequestBody TbDocumentConfiguration tbDocumentConfiguration){
        tbDocumentConfigurationService.save(tbDocumentConfiguration);
        return ResponseEntity.SUCCESS;
    }
    @RequestMapping("delete")
    public ResponseEntity delete(Integer id){
        QueryWrapper<TbDocumentConfiguration> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("id",id);
        tbDocumentConfigurationService.remove(queryWrapper);
        return ResponseEntity.SUCCESS;
    }
    @RequestMapping("update")
    public ResponseEntity update(@RequestBody TbDocumentConfiguration tbDocumentConfiguration){
        tbDocumentConfigurationService.updateById(tbDocumentConfiguration);
        return ResponseEntity.SUCCESS;
    }
    @RequestMapping("/getByPage")
    public ResponseEntity getByPage(@RequestBody TbDocumentConfigurationVo tbDocumentConfigurationVo){
        PageBean<TbDocumentConfiguration> pageDate = tbDocumentConfigurationService.getByPage(tbDocumentConfigurationVo.getTbDocumentConfiguration()==null?new TbDocumentConfiguration():tbDocumentConfigurationVo.getTbDocumentConfiguration(), tbDocumentConfigurationVo.getPage()==null?1:tbDocumentConfigurationVo.getPage());
        return new ResponseEntity("200","ok",pageDate);
    }
}
