package com.woniuxy.busconfig.provider;

import com.woniuxy.wuye.common.entity.TbChargeableItems;
import com.woniuxy.wuye.common.entity.TbFeesStandardConfiguration;
import org.apache.ibatis.jdbc.SQL;
/**
 * 用户可修改字段
 * @魏锦鹏
 *
 */
public class TbFeesStandardConfigurationSqlProvider {

	public String update(TbFeesStandardConfiguration tbFeesStandardConfiguration) {
		return  new SQL() {
			{
				UPDATE("tb_fees_standard_configuration");
				if(tbFeesStandardConfiguration.getStandardName()!=null){
					SET("standard_name=#{standardName}");
				}
				if(tbFeesStandardConfiguration.getStandardNum()!=null){
					SET("standard_num=#{standardNum}");
				}
				if(tbFeesStandardConfiguration.getFeesItem()!=null){
					SET("fees_item=#{feesItem}");
				}
				if(tbFeesStandardConfiguration.getBillingMethod()!=null){
					SET("billing_method=#{billingMethod}");
				}
				if(tbFeesStandardConfiguration.getPrice()!=null){
					SET("price=#{price}");
				}if(tbFeesStandardConfiguration.getSituation()!=null){
				SET("situation=#{situation}");
			}
				WHERE("id=#{id}");
			}
		}.toString();
	}
	public String getByCondition(TbFeesStandardConfiguration tbFeesStandardConfiguration) {
		if(tbFeesStandardConfiguration==null){
			return  new SQL(){
				{
					SELECT("*");
					FROM("(SELECT d.* , tbi.item_name feesItemName FROM (SELECT a.*,b.project_name FROM( SELECT*FROM tb_fees_standard_configuration tfc LEFT JOIN tb_projectfsc  tbp ON tfc.id =tbp.fsc_id) a LEFT JOIN tb_project b ON a.project_id= b.project_id) d LEFT JOIN tb_chargeable_items tbi ON d.fees_item = tbi.id) hhh");}
			}.toString();
		}else {
			return new SQL() {
				{
					SELECT("*");
					FROM("(SELECT d.* , tbi.item_name feesItemName FROM (SELECT a.*,b.project_name FROM( SELECT*FROM tb_fees_standard_configuration tfc LEFT JOIN tb_projectfsc  tbp ON tfc.id =tbp.fsc_id) a LEFT JOIN tb_project b ON a.project_id= b.project_id) d LEFT JOIN tb_chargeable_items tbi ON d.fees_item = tbi.id) hhh");
					if (tbFeesStandardConfiguration.getStandardName() != null && !"".equals(tbFeesStandardConfiguration.getStandardName())) {
						WHERE("standard_name like concat('%',#{standardName},'%')");
					}
					if (tbFeesStandardConfiguration.getSituation() != null&& !"".equals(tbFeesStandardConfiguration.getSituation())){
						WHERE("situation=#{situation}");
					}
					if (tbFeesStandardConfiguration.getBillingMethod()!= null&& !"".equals(tbFeesStandardConfiguration.getBillingMethod())) {
						WHERE("billing_method=#{feesItem}");
					}
					if (tbFeesStandardConfiguration.getProjectName()!= null&& !"".equals(tbFeesStandardConfiguration.getProjectName())) {
						WHERE("project_name=#{projectName}");
					}
					if (tbFeesStandardConfiguration.getProjectId()!= null&& !"".equals(tbFeesStandardConfiguration.getProjectId())) {
						WHERE("project_id=#{projectId}");
					}
					if (tbFeesStandardConfiguration.getFeesItem()!= null&& !"".equals(tbFeesStandardConfiguration.getFeesItem())) {
						WHERE("fees_item=#{feesItem}");
					}
					if (tbFeesStandardConfiguration.getFeesItemName()!= null&& !"".equals(tbFeesStandardConfiguration.getFeesItemName())) {
						WHERE("feesItemName=#{feesItemName}");
					}
				}
			}.toString();
		}
	}
}