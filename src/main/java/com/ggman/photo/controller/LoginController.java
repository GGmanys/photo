package com.ggman.photo.controller;

import com.ggman.photo.bean.YsAdmin;
import com.ggman.photo.bean.YsUser;
import com.ggman.photo.mapper.YsAdminMapper;
import com.ggman.photo.mapper.YsUserMapper;
import com.ggman.photo.service.YsAdminService;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.security.Security;

/**
 * 用户登录注销Controller
 * @author ys
 */
@RequestMapping
@RestController
public class LoginController {

    @Autowired
    YsAdminService ysAdminService;
    @Autowired
    YsUserMapper ysUserMapper;

 /*   //采用redis 存取 session 管理登录
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        YsAdmin ysAdmin = ysAdminService.getYsAdmin(name, password);
        if (ysAdmin.getName().equals(name) && ysAdmin.getPassword().equals(password)) {
            *//*如果已经存在Session的话，直接返回它；没有就创建一个，再返回
             * 当然Session是自动放在response中的Header中的，这里不用做其他处理*//*
            request.getSession();
        } else {
            return "用户名或密码错误";
        }
        return "user/index";
    }*/
    //采用shiro 管理登录
    @RequestMapping(value = "login_1", method = RequestMethod.GET)
    public String login_1(String name , String password, Model model){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name ,password);
        try {
            subject.login(token);
            return "";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户不存在");
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return  "login";
        }
        return "user/index";
    }

    /**
     * 判断用户的session是否有效（在同一个浏览器中，同一个域中，每次Request请求，都会带上Session）
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "isValid", method = RequestMethod.GET)
    public String isSessionValid(HttpServletRequest request) {
        //简化if-else表达式
        return request.isRequestedSessionIdValid() ? "ok" : "no";

    }

    /**
     * 注册
     */
    @GetMapping(value = "register")
    public String register(YsUser ysUser){
        try {
            Integer insert = ysUserMapper.insert(ysUser);
        }catch (Exception e){
            return "出现错误，请重试";
        }
        //注册成功 跳转到登录页面
        return "user/login";

    }

    /**
     * 注销登录
     * @param session
     * @return
     */
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.invalidate();//使Session变成无效，及用户退出
        return "user/login";
    }
}