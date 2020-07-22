package com.example.whereplace;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.whereplace.mapper")
@SpringBootApplication
public class WhereplaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhereplaceApplication.class, args);
    }

}
