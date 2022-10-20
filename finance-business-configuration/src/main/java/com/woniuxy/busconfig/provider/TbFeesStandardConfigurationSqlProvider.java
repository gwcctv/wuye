package com.woniuxy.busconfig.provider;

import com.woniuxy.wuye.common.entity.TbChargeableItems;
import com.woniuxy.wuye.common.entity.TbFeesStandardConfiguration;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author baobo
 * @date 2022-08-27-16:31
 */
public class TbFeesStandardConfigurationSqlProvider {
	/**
	 * 用户可修改字段
	 * @魏锦鹏
	 *
	 */
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
					FROM("(SELECT a.*,b.project_name FROM( SELECT*FROM tb_fees_standard_configuration tfc LEFT JOIN tb_projectfsc  tbp ON tfc.id =tbp.fsc_id) a LEFT JOIN tb_project b ON a.project_id= b.project_id) xwp");}
			}.toString();
		}else {
			return new SQL() {
				{
					SELECT("*");
					FROM("(SELECT a.*,b.project_name FROM( SELECT*FROM tb_fees_standard_configuration tfc LEFT JOIN tb_projectfsc  tbp ON tfc.id =tbp.fsc_id) a LEFT JOIN tb_project b ON a.project_id= b.project_id) xwp");
					if (tbFeesStandardConfiguration.getStandardName() != null && !"".equals(tbFeesStandardConfiguration.getStandardName())) {
						WHERE("standard_name like concat('%',#{standardName},'%')");
					}
					if (tbFeesStandardConfiguration.getSituation() != null) {
						WHERE("situation=#{situation}");
					}
					if (tbFeesStandardConfiguration.getBillingMethod()!= null) {
						WHERE("billing_method=#{feesItem}");
					}
					if (tbFeesStandardConfiguration.getProjectName()!= null) {
						WHERE("project_name=#{projectName}");
					}
				}
			}.toString();
		}
	}
}