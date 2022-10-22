package com.woniuxy.busconfig.service;

import com.woniuxy.wuye.common.entity.TbChargeType;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TbChargeTypeService {
    void addChargeType(TbChargeType tbChargeType);
     List<TbChargeType> getChargeType(String name);
    List<TbChargeType> getAll();
}
