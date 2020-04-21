package com.itbuddy.security.config;


import javax.annotation.Resource;
import javax.sql.DataSource;

import com.itbuddy.security.common.security.CustomAccessDeniedHandler;
import com.itbuddy.security.common.security.CustomLoginSuccessHandler;
import com.itbuddy.security.common.security.CustomNoOpPasswordEncoder;
import com.zaxxer.hikari.HikariDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
@EnableAutoConfiguration
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter{
    private static Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);


    @Autowired
    DataSource dataSource;
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //웹 페이지 접근 권한 설정
        

        logger.info("security config...");

        http.authorizeRequests()
        .antMatchers("/board/list")
        .permitAll();

        http.authorizeRequests()
        .antMatchers("/board/register")
        .hasRole("MEMBER");

        http.authorizeRequests()
        .antMatchers("/notice/list")
        .permitAll();

        http.authorizeRequests()
        .antMatchers("/notice/register")
        .hasRole("ADMIN");
        

        http.formLogin()
        .loginPage("/login")
        .successHandler(createAuthenticationSuccessHandler());//로그인 성공 처리

        http.logout()
        .logoutUrl("/logout")
        .invalidateHttpSession(true);



        //접근 거부 처리자의 URI를 지정
        http.exceptionHandling()
        .accessDeniedHandler(createAccessDeniedHandler());

        
        
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 지정된 아이디와 패스워드로 로그인이 가능하도록 한다.

        auth.inMemoryAuthentication()
        .withUser("member")
        .password("{noop}1234")
        .roles("MEMBER");

        auth.inMemoryAuthentication()
        .withUser("admin")
        .password("{noop}1234")
        .roles("ADMIN");

        logger.debug("--------------------------------------", dataSource.getClass().toString());

        //jdbc 인증 제공자
        auth.jdbcAuthentication()
        .dataSource(dataSource)
        .passwordEncoder(createPasswordEncoder());


    }

    @Bean
    public PasswordEncoder createPasswordEncoder(){
        return new CustomNoOpPasswordEncoder();
    }


    @Bean
    public AccessDeniedHandler createAccessDeniedHandler(){
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public AuthenticationSuccessHandler createAuthenticationSuccessHandler(){
        return new CustomLoginSuccessHandler();
    }

}