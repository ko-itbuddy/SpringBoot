package com.itbuddy.security.common.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
/*
* 인증 전에 접근을 ㅣ도한 URI로 리다이렉트하는 기능을 가지고 있으며 
*     스프링 시큐리티에서 기본적으로 사용되는 구현 클래스이다
*/
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;


/**
 * AuthenticationSuccessHandler 인테페이스를 직접 구현하여 
 * 인증 전에 접근을 시도한 URL로 리다이렉트 하는 기능을 구현한다. 
 */
public class CustomLoginSuccessHandler2 implements AuthenticationSuccessHandler {

    private static Logger logger = LoggerFactory.getLogger(CustomLoginSuccessHandler2.class);

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication auth) throws ServletException, IOException {
        // TODO Auto-generated method stub
        
        logger.warn("onAuthenticationSuccess");

        User customUser = (User)auth.getPrincipal();
        logger.info("username = "+customUser.getUsername());
        logger.info("password = "+customUser.getPassword());

        clearAuthenticationAttribute(request);

        SavedRequest savedRequest = requestCache.getRequest(request, response);
        String targerUrl = savedRequest.getRedirectUrl();

        logger.warn("Login Sucess targetUrl = "+targerUrl);
        response.sendRedirect(targerUrl);
    }

    private void clearAuthenticationAttribute(HttpServletRequest request){
        
        HttpSession session = request.getSession(false);

        if(session != null){
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        

        
    }



}