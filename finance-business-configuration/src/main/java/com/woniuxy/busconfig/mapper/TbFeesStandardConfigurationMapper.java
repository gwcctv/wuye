package com.woniuxy.busconfig.mapper;

import com.woniuxy.busconfig.provider.TbChargeableItemsSqlProvider;
import com.woniuxy.busconfig.provider.TbFeesStandardConfigurationSqlProvider;
import com.woniuxy.wuye.common.entity.TbChargeableItems;
import com.woniuxy.wuye.common.entity.TbFeesStandardConfiguration;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;
/**
 * 收费标准配置表接口
 * @魏锦鹏
 */
public interface TbFeesStandardConfigurationMapper {
    @Insert("insert into tb_fees_standard_configuration (standard_num,standard_name,fees_item,billing_method,price,situation) " +
            "values(#{standardNum},#{standardName},#{feesItem},#{billingMethod},#{price},#{situation})")
    void addTbFeesStandardConfiguration(TbFeesStandardConfiguration tbFeesStandardConfiguration);
    @SelectProvider(value = TbFeesStandardConfigurationSqlProvider.class,method = "getByCondition")
    List<TbFeesStandardConfiguration> getTbFeesStandardConfiguration(TbFeesStandardConfiguration tbFeesStandardConfiguration);
    @UpdateProvider(value =TbChargeableItemsSqlProvider.class,method ="update" )
    void updateTbFeesStandardConfiguration(TbFeesStandardConfiguration tbFeesStandardConfiguration);
    @Delete("delete from tb_fees_standard_configuration where id=#{id}")
    void deleteTbFeesStandardConfiguration(Integer id);
}
