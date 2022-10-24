package com.woniuxy.busconfig.service.serviceiml;

import com.woniuxy.busconfig.mapper.TbChargeTypeMapper;
import com.woniuxy.busconfig.service.TbChargeTypeService;
import com.woniuxy.wuye.common.entity.TbChargeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收费项目类型service类
 * @魏锦鹏
 */
@Service
public class TbChargeTypeServiceimpl implements TbChargeTypeService {
    @Autowired
private   TbChargeTypeMapper tbChargeTypeMapper;
    @Override
    public void addChargeType(TbChargeType tbChargeType) {
       tbChargeTypeMapper.addChargeType(tbChargeType);
    }

    @Override
    public List<TbChargeType> getChargeType(String name) {
        return tbChargeTypeMapper.getChargeType(name);
    }

    @Override
    public List<TbChargeType> getAll() {
        return tbChargeTypeMapper.getAll();
    }

    @Override
    public void updateChargeType(TbChargeType tbChargeType) {
        tbChargeTypeMapper.updateChargeType(tbChargeType);
    }

    @Override
    public void deleteChargeType(Integer id) {
        tbChargeTypeMapper.deleteChargeType(id);
        tbChargeTypeMapper.deleteByFather(id);
    }
}
