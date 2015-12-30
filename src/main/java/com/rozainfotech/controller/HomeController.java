/*
 *  2014 Roza Infotech Inc. 

 */
package com.rozainfotech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author Akshay Kadu <akshay@rozainfotech.com>
 */
@Controller 
public class HomeController {
 
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView homePage(){
        return new ModelAndView("index");
    }
}
