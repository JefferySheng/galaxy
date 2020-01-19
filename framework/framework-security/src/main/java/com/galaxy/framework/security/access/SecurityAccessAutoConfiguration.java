package com.galaxy.framework.security.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @author aaron.pan
 * @date 2018/5/24
 */
public class SecurityAccessAutoConfiguration {

    @Autowired
    private CacheManager cacheManager;

    @Value("${spring.application.name:}")
    private String serviceId;

    @Bean("securityAccessMetadataSource")
    public FilterInvocationSecurityMetadataSource securityAccessMetadataSource() {
        SecurityAccessMetadataSource securityAccessMetadataSource = new SecurityAccessMetadataSource();
        securityAccessMetadataSource.setCacheManager(cacheManager);
        securityAccessMetadataSource.setServiceId(serviceId);
        return securityAccessMetadataSource;
    }

    @Bean
    public FilterSecurityInterceptor securityAccessInterceptor() {
        FilterSecurityInterceptor securityInterceptor = new FilterSecurityInterceptor();
        securityInterceptor.setAccessDecisionManager(new SecurityAccessDecisionManager());
        securityInterceptor.setSecurityMetadataSource(this.securityAccessMetadataSource());
        return securityInterceptor;
    }

    @Configuration
    @Order(100)
    @Conditional(EnableResourceServerCondition.class)
    private class ResourceServerSecurityAccessConfiguration extends ResourceServerConfigurerAdapter {

        public ResourceServerSecurityAccessConfiguration() {

        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            //排除Swagger文档
            http.authorizeRequests().antMatchers("/v2/api-docs").permitAll().and().csrf().disable()
                    .authorizeRequests().anyRequest().authenticated().filterSecurityInterceptorOncePerRequest(false)
                    .and().addFilterAfter(securityAccessInterceptor(), FilterSecurityInterceptor.class);
        }

    }

    @Configuration
    @EnableWebSecurity
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    @Order(100)
    @Conditional(EnableWebSecurityCondition.class)
    private class WebSecurityAccessConfiguration extends WebSecurityConfigurerAdapter {

        public WebSecurityAccessConfiguration() {

        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            //排除Swagger文档
            http.authorizeRequests().antMatchers("/v2/api-docs").permitAll().and().csrf().disable()
                    .authorizeRequests().anyRequest().authenticated().filterSecurityInterceptorOncePerRequest(false)
                    .and().addFilterAfter(securityAccessInterceptor(), FilterSecurityInterceptor.class);
        }
    }

}

