package com.woniuxy.busconfig.provider;

import com.woniuxy.wuye.common.entity.TbChargeableItems;
import org.apache.ibatis.jdbc.SQL;
/**
 * 用户可修改字段
 * @魏锦鹏
 *
 */
public class TbChargeableItemsSqlProvider {

	public String update(TbChargeableItems tbChargeableItems) {
		return  new SQL() {
			{
				UPDATE("tb_chargeable_items");
				if(tbChargeableItems.getItemName()!=null){
					SET("item_name=#{itemName}");
				}
				if(tbChargeableItems.getSituation()!=null){
					SET("situation=#{situation}");
				}
				if(tbChargeableItems.getFeesQuality()!=null){
					SET("fees_quality=#{feesQuality}");
				}
				if(tbChargeableItems.getPeriodic()!=null){
					SET("periodic=#{periodic}");
				}
				if(tbChargeableItems.getRemark()!=null){
					SET("remark=#{remark}");
				}
				WHERE("id=#{id}");
			}
		}.toString();
	}
	public String getByCondition(TbChargeableItems tbChargeableItems) {
		if(tbChargeableItems==null){
			return  new SQL(){
				{
					SELECT("*");
					FROM("tb_chargeable_items");}
			}.toString();
		}else {
			return new SQL() {
				{
					SELECT("*");
					FROM("tb_chargeable_items");
					if (tbChargeableItems.getItemName() != null && !"".equals(tbChargeableItems.getItemName())) {
						WHERE("item_name like concat('%',#{itemName},'%')");
					}
					if (tbChargeableItems.getFeesQuality() != null) {
						WHERE("fees_quality=#{feesQuality}");
					}
					if (tbChargeableItems.getSituation()!= null) {
						WHERE("situation=#{situation}");
					}
				}
			}.toString();
		}
	}
}