package com.woniuxy.clientmanager.provider;

import com.woniuxy.wuye.common.entity.TbBuilding;
import com.woniuxy.wuye.common.entity.TbClient;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author li
 * @data 2022/10/20{} 14:44
 */
public class ClientProvider {
    public String update(TbClient tbClient){
        return new SQL(){
            {
              UPDATE("tb_client");
              if(tbClient.getNumber()!=null){
                  SET("number=#{number}");
              }
              if(tbClient.getClientName()!=null){
                  SET("client_name=#{clientName}");
              }
              if(tbClient.getSex()!=null){
                  SET("sex=#{sex}");
              }
              if(tbClient.getCard()!=null){
                  SET("card=#{card}");
              }
              if(tbClient.getPhone()!=null){
                  SET("phone=#{phone}");
              }
              if(tbClient.getEmail()!=null){
                  SET("email=#{email}");
              }
              if(tbClient.getWorkAddress()!=null){
                  SET("work_address=#{workAddress}");
              }
              if(tbClient.getDescription()!=null){
                  SET("description=#{Description}");
              }
              if(tbClient.getRelationship()!=null){
                  SET("relationship=#{Relationship}");
              }
              if(tbClient.getHouseId()!=null){
                  SET("house_id=#{houseId}");
              }
              if(tbClient.getClientState()!=null){
                  SET("client_state=#{clientState}");
              }
                WHERE("client_id=#{clientId}");
            }
        }.toString();


    }
}
