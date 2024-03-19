package org.example;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.mapper")
public class YanFeiBlogApplication{
    public static void main(String[] args) {
        SpringApplication.run(YanFeiBlogApplication.class,args);
    }
}