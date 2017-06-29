package com.salt.api.reportmanage.db;

import java.util.Properties;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;

@Configuration
@AutoConfigureAfter(MybatisConfiguration.class)
public class MyBatisMapperScannerConfig {
    
	@Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.salt.api.reportmanage.dao");//每张表对应的XXMapper.java interface类型的Java文件
        mapperScannerConfigurer.setMarkerInterface(IMysqlBaseMapper.class);
        
   /*     Properties properties = new Properties();
       properties.setProperty("mappers", "tk.mybatis.springboot.util.MyMapper");
        properties.setProperty("notEmpty", "false");
        properties.setProperty("IDENTITY", "MYSQL");
        properties.setProperty("style", "camelhump");
        mapperScannerConfigurer.setProperties(properties);*/
        return mapperScannerConfigurer;
    }
}
