package com.woniuxy.clientmanager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.woniuxy.wuye.common.entity.TbClient;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClientMapper extends BaseMapper {
    @Select("select * from tb_client")
    List<TbClient> findAll();

    @Delete("delete from tb_client where client_id = #{id}")
    int deleteById(int id);

    @Select("SELECT c.*,h.unit,h.layer , b.building_number,project_name \n" +
            "FROM tb_house h,tb_building b,tb_project p,tb_client c\n" +
            "WHERE h.building_id = b.building_id \n" +
            "AND h.project_id = p.project_id\n" +
            "AND c.house_id = h.house_id ")
    List<TbClient> findClient();

    @Select("SELECT c.*, p.project_name,h.house_number FROM tb_client c, tb_project p, tb_house h \n" +
            "WHERE phone = #{phone} AND \n" +
            "client_name = #{clientName} AND \n" +
            "project_name = #{projectName} AND \n" +
            "house_number = #{houseNumber}")
    List<TbClient> findClientByCondition(TbClient tbClient);

    @Update("update tb_client set number=#{number},client_name=#{clientName},sex=#{sex},card=#{card},\n" +
            "phone=#{phone},email=#{email},work_address=#{workAddress},description=#{description},\n" +
            "relationship=#{relationship},client_state=#{clientState} where client_id = #{clientId}")
    boolean updateById(TbClient tbClient);

    /**
     * 通过客户名查客户id
     * @param clientName
     * @return
     */
    @Select("select client_id from tb_client where client_name=#{name}")
    int getByName(String clientName);


}
