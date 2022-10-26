package com.woniuxy.busconfig.service.serviceiml;

import com.woniuxy.busconfig.mapper.TbChargeTypeMapper;
import com.woniuxy.busconfig.service.TbChargeTypeService;
import com.woniuxy.wuye.common.entity.TbChargeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
    @Autowired
    private RedisTemplate redisTemplate;
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

        List<TbChargeType>    list  = (List<TbChargeType>) redisTemplate.opsForList().range("tbChargeTypeList",0,-1);
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getFather()==null){
                tbChargeTypeMapper.deleteByFather(id);
                tbChargeTypeMapper.deleteChargeType(id);
            }else{
                tbChargeTypeMapper.deleteChargeType(id);
            }
        }

    }

    @Override
    public TbChargeType getById(Integer id) {
      return  tbChargeTypeMapper.selectById(id);
    }
}
