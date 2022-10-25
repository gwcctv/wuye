package com.woniuxy.busconfig.mapper;

import com.woniuxy.busconfig.provider.TbChargeTypeSqlProvider;
import com.woniuxy.busconfig.provider.TbChargeableItemsSqlProvider;
import com.woniuxy.wuye.common.entity.TbChargeType;
import lombok.Data;
import org.apache.ibatis.annotations.*;
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
    @Insert("insert into tb_charge_type(name,father) values (#{name},#{father})")
    void addChargeType(TbChargeType tbChargeType);
    /**
     * 查找类型
     */
    @Select("select * from tb_charge_type where name like CONCAT('%', #{name}, '%')")
    List<TbChargeType> getChargeType(String name);
    @Select("select * from tb_charge_type")
@Results( {
        @Result(column = "id",property = "id",id = true),
        @Result(column = "name",property = "name"),
        @Result(column = "father",property = "father")
})
    List<TbChargeType> getAll();

@UpdateProvider(value = TbChargeTypeSqlProvider.class,method = "update")
    void updateChargeType(TbChargeType tbChargeType);
@Delete("delete from tb_charge_type where id = #{id}")
    void deleteChargeType(Integer id);
@Delete("delete from tb_charge_type where farther = #{id}")
    TbChargeType deleteByFather(Integer id);
}
