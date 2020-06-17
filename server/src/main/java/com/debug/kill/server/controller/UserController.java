package com.debug.kill.server.controller;

import com.debug.kill.model.entity.User;
import com.debug.kill.server.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 用户信息表(User)表控制层
 *
 * @author makejava
 * @since 2020-06-15 17:15:18
 */
@Controller
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/user/selectOne")
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }

    @RequestMapping(value = "/login",method=RequestMethod.POST)
    public String login(String userName, String password, ModelMap modelMap, HttpSession session){
        System.out.println(userName+password);
        if(userName == null || password == null ){
            modelMap.put("errorMsg","用户名或密码为空");
            return "login";
        }
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        User result = this.userService.login(user);
        if(result != null){
            session.setAttribute("uid",result.getId());
            session.setAttribute("username",result.getUserName());
            return "redirect:/index";
        }else{
            modelMap.put("errorMsg","用户名或密码错误");
            return "login";
        }
    }

}