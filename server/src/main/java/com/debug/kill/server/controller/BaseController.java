package com.debug.kill.server.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {

    @RequestMapping("/welcome")
    public String welcome(String name,ModelMap modelMap){
        if(StringUtils.isBlank(name)){
            name = "张三";
        }
        modelMap.put("name",name);
        return "welcome";
    }
}
