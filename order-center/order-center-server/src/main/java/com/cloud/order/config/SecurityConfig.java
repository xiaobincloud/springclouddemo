package com.cloud.order.config;

import com.cloud.order.SerializationBeanFactoryPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * @author xiaobin
 * Created by xiaobin on 2017/9/14
 * Copyright (c) 2016-2019
 */
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        // @formatter:off
        auth.eraseCredentials(false);
        // @formatter:on
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // @formatter:off
        httpSecurity
            .httpBasic().and()
            .logout().and()
            .authorizeRequests()
            .anyRequest().permitAll()
            .and().exceptionHandling()
            .and().csrf()
            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        //关闭csrf 防止循环定向
        httpSecurity.csrf().disable();
        // @formatter:on
    }

    @Bean
    public static RefreshScope refreshScope() {
        RefreshScope refreshScope = new RefreshScope();
        refreshScope.setId(SerializationBeanFactoryPostProcessor.SERIALIZATION_ID);
        return refreshScope;
    }
}
