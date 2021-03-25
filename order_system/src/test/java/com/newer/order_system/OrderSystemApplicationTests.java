package com.newer.order_system;

import com.newer.order_system.mapper.TablesMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderSystemApplicationTests {
    @Autowired
    TablesMapper tablesMapper;

    @Test
    void contextLoads() {


    }

}
