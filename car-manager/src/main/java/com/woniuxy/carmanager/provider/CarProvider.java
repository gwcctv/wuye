package com.woniuxy.carmanager.provider;

import com.woniuxy.wuye.common.entity.TbCar;
import com.woniuxy.wuye.common.entity.TbClient;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author li
 * @data 2022/10/24{} 14:53
 */
public class CarProvider {
    public String update(TbCar tbCar) {
        return new SQL() {
            {
                UPDATE("tb_car");
                if (tbCar.getCarNumber() != null) {
                    SET("car_number=#{carNumber}");
                }
                if (tbCar.getCarType() != null) {
                    SET("car_type=#{carType}");
                }
                if (tbCar.getCarState() != null) {
                    SET("car_state=#{carState}");
                }
                if (tbCar.getParkingId() != null) {
                    SET("parking_id=#{parkingId}");
                }
                if (tbCar.getClientId() != null) {
                    SET("client_id=#{clientId}");
                }
                WHERE("car_id=#{carId}");
            }
        }.toString();
    }
}
