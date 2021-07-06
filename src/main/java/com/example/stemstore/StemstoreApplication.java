package com.example.stemstore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//开启缓存
@EnableCaching
@EnableTransactionManagement
//扫描ORM映射包
@MapperScan(basePackages = {"com.example.stemstore.mapper"})
@SpringBootApplication
public class StemstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StemstoreApplication.class, args);
    }

}
