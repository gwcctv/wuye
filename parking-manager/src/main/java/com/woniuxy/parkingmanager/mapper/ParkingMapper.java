package com.woniuxy.parkingmanager.mapper;

import com.woniuxy.wuye.common.entity.TbParking;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ParkingMapper {
    /**
     * 添加车位
     * @param tbParking
     * @return
     */
    @Insert("INSERT INTO tb_parking (parking_id,parking_number,parking_size,parking_quality,\n" +
            "parking_use,parking_card,parking_state,house_id,client_id)\n" +
            "VALUES(#{parkingId},#{parkingNumber},#{parkingSize},#{parkingQuality},#{parkingUse},#{parkingCard},#{parkingState},#{houseId},#{clientId})")
    boolean insertParking(TbParking tbParking);

    /**
     * 查询车位及客户
     */
    @Select("")
    List<TbParking> findParkingAndHouse();
}
