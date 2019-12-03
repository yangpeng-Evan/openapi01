package com.yp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author yangpeng
 */
@SpringBootApplication
@EnableEurekaServer
@EnableWebSecurity
public class EurekaStartApp extends WebSecurityConfigurerAdapter {
    public static void main (String[] args){
        SpringApplication.run(EurekaStartApp.class,args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()//开启请求认证配置
                //符合某个规则的路径
                .antMatchers("/eureka/**")
                .permitAll()//放行
                .antMatchers("/actuator/**")
                .permitAll()//
                .anyRequest()//
                .authenticated()//
                .and()//
                .httpBasic();
    }
}
