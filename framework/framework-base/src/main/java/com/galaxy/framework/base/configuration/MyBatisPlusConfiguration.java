package com.galaxy.framework.base.configuration;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.galaxy.framework.base.mapper.CommonMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author aaron.pan
 * @date 2018/5/28
 */
@Configuration
@MapperScan(basePackages = { "com.galaxy.**.mapper" })
public class MyBatisPlusConfiguration {
    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean
    public CommonMapper commonMapper(SqlSessionFactory sqlSessionFactory){
        return new CommonMapper(sqlSessionFactory);
    }
}