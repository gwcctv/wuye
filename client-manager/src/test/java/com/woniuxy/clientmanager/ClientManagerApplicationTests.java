package com.woniuxy.clientmanager;

import com.woniuxy.clientmanager.feign.HouseFeign;
import com.woniuxy.clientmanager.mapper.ClientMapper;
import com.woniuxy.clientmanager.service.ClientService;
import com.woniuxy.wuye.common.entity.TbClient;
import com.woniuxy.wuye.common.entity.TbHouse;
import com.woniuxy.wuye.common.utils.PageBean;
import com.woniuxy.wuye.common.utils.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
@Slf4j
@SpringBootTest
class ClientManagerApplicationTests {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private HouseFeign houseFeign;
    @Test
    void contextLoads() {
        List<TbHouse> houseByCId = clientMapper.findHouseByCId(2);
    }

}
