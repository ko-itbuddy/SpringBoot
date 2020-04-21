package com.itbuddy.security.common.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
/*
* 인증 전에 접근을 ㅣ도한 URI로 리다이렉트하는 기능을 가지고 있으며 
*     스프링 시큐리티에서 기본적으로 사용되는 구현 클래스이다
*/
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private static Logger logger = LoggerFactory.getLogger(CustomLoginSuccessHandler.class);


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication auth) throws ServletException, IOException {
        // TODO Auto-generated method stub
        
        logger.warn("onAuthenticationSuccess");

        User customUser = (User)auth.getPrincipal();
        logger.info("username = "+customUser.getUsername());
        
        super.onAuthenticationSuccess(request, response, auth);

    }


}