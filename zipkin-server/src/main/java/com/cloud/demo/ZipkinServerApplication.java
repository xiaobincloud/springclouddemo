package com.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import zipkin.server.EnableZipkinServer;
import zipkin.storage.mysql.MySQLStorage;

import javax.sql.DataSource;

/**
 * @author xiaobin
 * Created by xiaobin on 2019/5/10
 * Copyright (c) 2019-2021
 */
@SpringBootApplication
@EnableZipkinServer
@EnableDiscoveryClient
public class ZipkinServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApplication.class, args);
    }

    @Bean
    public MySQLStorage mySQLStorage(DataSource dataSource){
        return MySQLStorage.builder().datasource(dataSource).executor(Runnable::run).build();
    }
}
