package com.woniuxy.busconfig.web;

import com.woniuxy.busconfig.feignclient.FbcFeignClient;
import com.woniuxy.busconfig.feignclient.HouFeignClient;
import com.woniuxy.busconfig.service.TbMeasureService;
import com.woniuxy.busconfig.service.serviceiml.TbMeasureServiceimpl;
import com.woniuxy.wuye.common.entity.TbFeesStandardConfiguration;
import com.woniuxy.wuye.common.entity.TbMeasure;
import com.woniuxy.wuye.common.entity.vo.HouseVo;
import com.woniuxy.wuye.common.entity.vo.TbFeesStandardConfigurationVo;
import com.woniuxy.wuye.common.entity.vo.TbMeasureVo;
import com.woniuxy.wuye.common.utils.PageBean;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jlb")
@Transactional(rollbackFor = Exception.class)
public class TbMeasureController {
    @Autowired
    private TbMeasureService tbMeasureService;
    @Autowired
    private FbcFeignClient fbcFeignClient;
    @Autowired
    private HouFeignClient houFeignClient;
    @RequestMapping("add")
    public ResponseEntity add(@RequestBody TbMeasure tbMeasure){
        tbMeasureService.addTbMeasure(tbMeasure);
        return ResponseEntity.SUCCESS;
    }
    @RequestMapping("delete")
    public ResponseEntity delete(Integer id){
        tbMeasureService.deleteById(id);
        return ResponseEntity.SUCCESS;
    }
    @RequestMapping("update")
    public ResponseEntity update( @RequestBody TbMeasure tbMeasure){
        tbMeasureService.updateById(tbMeasure);
        return ResponseEntity.SUCCESS;
    }
    @RequestMapping("/getByPage")
    public ResponseEntity getByPage(@RequestBody TbMeasureVo tbMeasureVo){
        PageBean<TbMeasure> pageDate = tbMeasureService.getByPage(tbMeasureVo.getTbMeasure()==null?new TbMeasure():tbMeasureVo.getTbMeasure(), tbMeasureVo.getPage()==null?1:tbMeasureVo.getPage());
        return new ResponseEntity("200","ok",pageDate);
    }
    @RequestMapping("/getProject")
    public ResponseEntity getProject(){
     return    fbcFeignClient.projectName();
    }
    @RequestMapping("/getAllMoney")
    public ResponseEntity getAllMoney(){
      return new ResponseEntity("200","ok",tbMeasureService.getMoneyFrom());
    }
    @RequestMapping("/getAllHouse")
    public ResponseEntity getAllHouse(@RequestBody HouseVo houseVo){
        return houFeignClient.getAllHouse(houseVo);
    }
//    @RequestMapping("/test")
//    public void getAllHouse(@RequestBody Integer [] ids){
//        System.out.println("-----------------------------------------");
//        for (int i = 0; i < ids.length; i++) {
//            System.out.println(ids[i]);
//        }
//        System.out.println("-----------------------------------------");
//    }
}
