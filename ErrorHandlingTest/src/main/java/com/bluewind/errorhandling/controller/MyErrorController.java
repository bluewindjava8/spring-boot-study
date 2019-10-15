package com.bluewind.errorhandling.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * If and exception is already handled by @ControllerAdvice class (BookErrorHandler in my case),
 * it will not be considered as an "error". As a result, the handleError() method in ErrorController class (MyErrorController) will not be executed at all.
 * 
 */
@Controller
public class MyErrorController implements ErrorController  {
 
    @RequestMapping("/error")
    public String handleError() {
        //do something like logging
    	System.out.println("xxxxxxxxxxxxxxxx in handlerError() /error");
        return "error";
    }
 
    @RequestMapping("/errorpath")
    public String handleErrorPath() {
        //do something like logging
    	System.out.println("xxxxxxxxxxxxxxxx in handlerError() /errorpath");
        return "error";
    }
    
    /*
     * It seems that overriding this getErrorPath() method doesn't work.
     * Only handleError() method mapping to "/error" works in my case. 
     * (Still need to investigate.
     */
    @Override
    public String getErrorPath() {
    	System.out.println("yyyyyyyyyyyyyyyy in getErrorPath()");
        return "/errorpath";
    }
}