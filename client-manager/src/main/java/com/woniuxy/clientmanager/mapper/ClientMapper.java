package com.woniuxy.clientmanager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.woniuxy.clientmanager.provider.ClientProvider;
import com.woniuxy.clientmanager.vo.ClientVo;
import com.woniuxy.wuye.common.entity.TbClient;
import com.woniuxy.wuye.common.entity.TbHouse;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface ClientMapper extends BaseMapper {
    @Select("select * from tb_client")
    List<TbClient> findAll();

    @Select("select * from tb_client where client_id = #{id}")
    TbClient selectById(int id);

    @Delete("delete from tb_client where client_id = #{id}")
    int deleteById(int id);

    @Select("SELECT h.house_id,h.house_number,h.unit,h.layer,b.building_number,p.project_name\n" +
            "FROM tb_client c,tb_house h,tb_building b,tb_project p\n" +
            "WHERE c.client_name=#{clientName}\n" +
            "AND c.house_id = h.house_id\n" +
            "AND b.building_id=h.building_id\n" +
            "AND p.project_id=b.project_id")
    ClientVo findClientVoByName(String clientName);

    @Select("SELECT cl.*,CONCAT(p.project_name,\"/\",b.building_number,\"/\",h.unit,\"/\",h.layer,\"/\",h.house_number) AS address\n" +
            "FROM tb_house h,tb_building b,tb_project p,tb_client cl\n" +
            "WHERE h.building_id = b.building_id \n" +
            "AND h.project_id = p.project_id\n" +
            "AND cl.house_id = h.house_id ")
    List<TbClient> myClient();


    @Select("SELECT c.*, p.project_name,h.house_number FROM tb_client c, tb_project p, tb_house h \n" +
            "WHERE phone = #{phone} AND \n" +
            "client_name = #{clientName} AND \n" +
            "project_name = #{projectName} AND \n" +
            "c.address = #{address}")
    List<TbClient> findClientByCondition(TbClient tbClient);

    @UpdateProvider(value = ClientProvider.class,method = "update")
    boolean update(TbClient tbClient);

    @Insert("insert into tb_client (number,client_name,sex,card,phone,email,work_address,description,relationship,client_state,house_id) values " +
            "(#{number},#{clientName},#{sex},#{card},#{phone},#{email},#{workAddress},#{description},#{relationship},#{clientState},#{houseId})")
    @Options(useGeneratedKeys=true, keyProperty="clientId",keyColumn="client_id")
    boolean insertClient(TbClient tbClient);

    @Update("update tb_client set number=#{number},client_name=#{clientName},sex=#{sex},card=#{card},\n" +
            "phone=#{phone},email=#{email},work_address=#{workAddress},description=#{description},\n" +
            "relationship=#{relationship},client_state=#{clientState} where client_id = #{clientId}")
    boolean updateById(TbClient tbClient);

    /**
     * ????????????????????????id
     * @param clientName
     * @return
     */
    @Select("select client_id from tb_client where client_name=#{name}")
    int getByName(String clientName);

    /**
     * ???????????????????????????????????????
     */
    @Select("SELECT c.phone,c.client_name, CONCAT(h.house_number,\"/\",h.unit,\"/\",h.layer) AS address\n" +
            "FROM tb_project p,tb_house h ,tb_building b,tb_client c\n" +
            "WHERE p.project_name=#{projectName}\n" +
            "AND c.house_id = h.house_id\n" +
            "AND h.building_id = b.building_id\n" +
            "AND b.project_id = p.project_id")
    List<TbClient> findClientByPName(String projectName);

    /**
     * ????????????Id????????????
     */
    @Select("SELECT c.client_name,p.project_name FROM tb_client c,tb_project p\n" +
            "WHERE p.project_id = #{projectId}")
    List<TbClient> findClientByPId(int projectId);

    /**
     * ????????????ID??????????????????
     */
    @Select("SELECT h.unit,h.layer,h.house_number,b.building_number,c.client_name\n" +
            "FROM tb_building b,tb_house h,tb_client c\n" +
            "WHERE c.client_id = #{clientId}\n" +
            "AND b.building_id = h.building_id")
    List<TbHouse> findHouseByCId(int clientID);

}
