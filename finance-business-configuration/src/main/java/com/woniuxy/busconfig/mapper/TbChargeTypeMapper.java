package com.woniuxy.busconfig.mapper;

import com.woniuxy.wuye.common.entity.TbChargeType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收费项类型的mapper接口
 * @author 魏锦鹏
 */
public interface TbChargeTypeMapper {
    /**
     *增加类型
     */
    @Insert("insert into tb_charge_type(name) values (#{name})")
    void addChargeType(TbChargeType tbChargeType);
    /**
     * 查找类型
     */
    @Select("select * from tb_charge_type where name like CONCAT('%', #{name}, '%')")
    List<TbChargeType> getChargeType(String name);
    @Select("select * from tb_charge_type")
    List<TbChargeType> getAll();
}
