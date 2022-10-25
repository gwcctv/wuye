package com.woniuxy.busconfig.web;

import com.woniuxy.busconfig.service.TbChargeableItemsService;
import com.woniuxy.wuye.common.entity.TbChargeableItems;
import com.woniuxy.wuye.common.entity.vo.TbChargeableItemsVo;
import com.woniuxy.wuye.common.utils.PageBean;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.print.DocFlavor;

@RestController
@RequestMapping("sfxm")
public class TbChargeableItemsController {
    @Autowired
    private TbChargeableItemsService tbChargeableItemsService;

    @RequestMapping("/add")
    public ResponseEntity add(@RequestBody TbChargeableItems tbChargeableItems) {
        tbChargeableItemsService.addTbChargeableItem(tbChargeableItems);
        return ResponseEntity.SUCCESS;
    }

    @RequestMapping("/update")
    public ResponseEntity update(@RequestBody TbChargeableItems tbChargeableItems) {
        tbChargeableItemsService.updateTbChargeableItem(tbChargeableItems);
        return ResponseEntity.SUCCESS;
    }
    @RequestMapping("/getByPage")
    public ResponseEntity getByPage(@RequestBody TbChargeableItemsVo tbChargeableItemsVo){
        PageBean<TbChargeableItems> pageDate = tbChargeableItemsService.getByPage(tbChargeableItemsVo.getTbChargeableItems() == null ? new TbChargeableItems() : tbChargeableItemsVo.getTbChargeableItems(), tbChargeableItemsVo.getPage() == null ? 1 : tbChargeableItemsVo.getPage());
        return new ResponseEntity("200","ok",pageDate);
    }
    @RequestMapping("/delete")
    public ResponseEntity delete(Integer id){
        tbChargeableItemsService.deleteTbChargeableItem(id);
        return  ResponseEntity.SUCCESS;
    }


    @RequestMapping("/getById")
    public TbChargeableItems getById(Integer id){
        return    tbChargeableItemsService.getById(id);

    }
}
