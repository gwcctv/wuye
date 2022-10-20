package com.woniuxy.busconfig.mapper;

import com.woniuxy.busconfig.provider.TbChargeableItemsSqlProvider;
import com.woniuxy.wuye.common.entity.TbChargeableItems;
import lombok.Data;
import org.apache.ibatis.annotations.*;

import java.util.List;
/**
 * 收费项目表接口
 * @魏锦鹏
 */
public interface TbChargeableItemsMapper {
    @Insert("insert into tb_chargeable_items (item_name,itme_type_id,fees_quality,situation,remark,periodic) " +
            "values(#{itemName},#{itmeTypeId},#{feesQuality},#{situation},#{remark},#{periodic})")
    void addTbChargeableItem(TbChargeableItems tbChargeableItems);
    @SelectProvider(value = TbChargeableItemsSqlProvider.class,method = "getByCondition")
    List<TbChargeableItems> getTbChargeableItemByCondition(TbChargeableItems tbChargeableItems);
    @UpdateProvider(value =TbChargeableItemsSqlProvider.class,method ="update" )
    void updateTbChargeableItem(TbChargeableItems tbChargeableItems);
    @Delete("delete from tb_chargeable_items where id=#{id}")
    void deleteTbChargeableItem(Integer id);
}
