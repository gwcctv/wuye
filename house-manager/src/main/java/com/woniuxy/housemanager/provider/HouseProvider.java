package com.woniuxy.housemanager.provider;

import com.woniuxy.wuye.common.entity.TbHouse;
import org.apache.ibatis.jdbc.SQL;

public class HouseProvider {
    /**
     * 多条件修改
     * @param tbHouse
     * @return
     */
    public String update(TbHouse tbHouse){
        return new SQL(){
            {
                UPDATE("tb_house h");
                if(tbHouse.getClientName()!=null){//表示修改客户名字，改变表中的clientId
                    SET("h.client_id=(SELECT c.client_id FROM tb_client c WHERE c.client_name=#{clientName})");
                }
                if(tbHouse.getBuildingNumber()!=null){//这里表示在后台修改楼栋编号，改变house表总的buildingid
                    SET("h.building_id=(select b.building_id from tb_building b where b.building_number=#{buildingNumber})");
                }
                if(tbHouse.getProjectName()!=null){//修改项目名，改变项目id
                    SET("h.project_id=(SELECT p.project_id FROM tb_project p WHERE p.project_name=#{projectName})");
                }
                if(tbHouse.getUnit()!=null){
                    SET("unit=#{unit}");
                }
                if(tbHouse.getLayer()!=null){
                    SET("layer=#{layer}");
                }
                if(tbHouse.getHouseNumber()!=null){
                    SET("house_number=#{houseNumber}");
                }
                if(tbHouse.getHouseType()!=null){
                    SET("house_type=#{houseType}");
                }
                if(tbHouse.getStayState()!=null){
                    SET("stay_state=#{stayState}");
                }
                if(tbHouse.getSellState()!=null){
                    SET("sell_state=#{sellState}");
                }
                if(tbHouse.getArea()!=null){
                    SET("area=#{area}");
                }
                WHERE("house_id=#{houseId}");

            }
        }.toString();
    }

    /**
     * 多条件查询
     * @param tbHouse
     * @return
     */
    public String select(TbHouse tbHouse){
        return new SQL(){
            {
                SELECT("h.*,p.project_name projectName,b.building_number buildingNumber,c.client_name clientName");
                FROM("tb_house h,tb_project p,tb_client c,tb_building b");
                if(tbHouse.getProjectName()!=null&&!"".equals(tbHouse.getProjectName())){
                    //这里需要通过输入项目名，就可以找出属于该项目的房产
                    //tb.project_id IN (SELECT tp.project_id FROM tb_project WHERE tp.project_name=#{projectName})
                    WHERE("h.project_id in (select p.project_id from tb_project  where p.project_name=#{projectName})");
                }
                if(tbHouse.getClientName()!=null && !"".equals(tbHouse.getClientName())){
                    //这里输入客户名字，也可以查出客户的房产
                    WHERE("h.client_id in (select c.client_id from tb_client  where c.client_name=#{clientName})");
                }
                if(tbHouse.getHouseNumber()!=null&& !"".equals(tbHouse.getHouseNumber())){
                    WHERE("house_number=#{houseNumber}");
                }
                if(tbHouse.getHouseType()!=null && !"".equals(tbHouse.getHouseType())){
                    WHERE("house_type=#{houseType}");
                }
                if(tbHouse.getStayState()!=null && !"".equals(tbHouse.getStayState())){
                    WHERE("stay_state=#{stayState}");
                }
                WHERE("h.client_id=c.client_id AND h.building_id=b.building_id AND h.project_id=p.project_id");
            }
        }.toString();
    }
}
