package com.woniuxy.busconfig.web;

import com.woniuxy.busconfig.service.TbChargeTypeService;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 收费项类型
 */
@RestController
@RequestMapping("sfxlx")
public class TbChargeTypeController {
    @Autowired
    private TbChargeTypeService tbChargeTypeService;
    @RequestMapping("/getAll")
    public ResponseEntity getTbChargeType(){
        return new ResponseEntity<>("200","ok",tbChargeTypeService.getAll());
    }
}
