package com.itbuddy.security.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class CommonController {

    private static Logger logger = LoggerFactory.getLogger(CommonController.class);

    @RequestMapping(value="/accessError")
    public void list(Authentication auth, Model model) {
        logger.info("access Denied : " + auth);

        model.addAttribute("msg","Access Denied");
    }
    

}