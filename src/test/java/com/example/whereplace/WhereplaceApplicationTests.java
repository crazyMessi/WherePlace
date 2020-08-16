package com.example.whereplace;

import com.example.whereplace.entity.MyProps;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class WhereplaceApplicationTests {

    @Autowired
    private MyProps myProps;

    @Test
    void contextLoads() {
    }

    @Test
    public void propsTest() {
        System.out.println(myProps.getSessionExpireTime().get("register"));
    }

}
