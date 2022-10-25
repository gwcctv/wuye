package com.woniuxy.carmanager.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.woniuxy.carmanager.provider.CarProvider;
import com.woniuxy.wuye.common.entity.TbCar;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lee
 * @since 2022-10-21
 */
@Mapper
public interface CarMapper extends BaseMapper<TbCar> {
    /**
     * 添加车辆
     */
    @Insert("insert into tb_car (car_number,car_type,car_state,parking_id,client_id) values " +
            "(#{carNumber},#{carType},#{carState},#{parkingId}),#{clientId}")
     boolean insertCar(TbCar tbCar);
    /**
     * 查询车辆及所属客户和房产
     */
    @Select("select c.* , p.parking_number , h.layer,h.unit, cl.client_name ,pt.project_name  from tb_car c , tb_parking p \n" +
            ", tb_client cl ,tb_house h,tb_project pt")
    List<TbCar> findCarAndHouse();
//    @Select("SELECT c.*,ct.client_name,p.parking_number,h.house_number\n" +
//            "FROM tb_car c,tb_client ct,tb_parking p,tb_house h\n" +
//            "WHERE c.client_id = ct.client_id\n" +
//            "AND c.parking_id = p.parking_id \n" +
//            "AND h.house_id=ct.client_id")
//    List<TbCar> findCarAndHouse();
    /**
     * 条件查询车辆
     * @param tbCar
     * @return
     */
    @Select("select c.* , p.parking_number ,  from tb_car c , tb_parking p , tb_house h where car_number = #{carNumber} and car_type = #{carType} and house_name=#{houseName}" +
            "parking_number = #{parkingNumber} and car_state = #{carState}")
    TbCar selectCarByCondition(TbCar tbCar);

    /**
     * 更新
     * @return
     */
    @UpdateProvider(value = CarProvider.class,method = "update")
    int update(TbCar tbCar);
    /**
     * 根据id删除
     */
    @Delete("delete from tb_car where car_id=#{carId}")
    int deleteById(int id);
}
