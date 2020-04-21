package com.itbuddy.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@RequestMapping("/notice")
@Controller
public class NoticeController {

    private static Logger logger = LoggerFactory.getLogger(NoticeController.class);
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public void list() {
        logger.info("list : acces to all");

    }

    @RequestMapping(value="/register", method=RequestMethod.GET)
    public void register() {
        logger.info("registerForm : access to admin");

    }
    

}