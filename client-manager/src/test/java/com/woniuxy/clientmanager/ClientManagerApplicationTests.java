package com.woniuxy.clientmanager;

import com.woniuxy.clientmanager.mapper.ClientMapper;
import com.woniuxy.clientmanager.service.ClientService;
import com.woniuxy.wuye.common.entity.TbClient;
import com.woniuxy.wuye.common.utils.PageBean;
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
    @Test
    void contextLoads() {
        TbClient tbClient = new TbClient();
        tbClient.setHouseNumber("No200001");
        tbClient.setClientName("lee");
        tbClient.setWorkAddress("成都市高新区孵化园");
        tbClient.setPhone("13185236456");
        tbClient.setCard("511920199923468546");
        clientMapper.insertClient(tbClient);
    }

}
