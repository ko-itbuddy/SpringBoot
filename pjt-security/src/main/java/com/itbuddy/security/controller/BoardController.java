package com.itbuddy.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;




@RequestMapping("/board")
@Controller
public class BoardController {

    private static Logger logger = LoggerFactory.getLogger(BoardController.class);

    @RequestMapping(value="/list")
    public void list() {
        logger.info("list : acces to all");
    }
    
    @RequestMapping(value="/register")
    public void registerFOrm() {
        logger.info("registerForm : access to member");
    }
    
}