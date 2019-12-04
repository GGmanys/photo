package com.ggman.photo.controller;

import com.ggman.photo.bean.YsAdmin;
import com.ggman.photo.service.YsAdminService;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        YsAdmin ysAdmin = ysAdminService.getYsAdmin(name, password);
        if (ysAdmin.getName().equals(name) && ysAdmin.getPassword().equals(password)) {
            /*如果已经存在Session的话，直接返回它；没有就创建一个，再返回
             * 当然Session是自动放在response中的Header中的，这里不用做其他处理*/
            request.getSession();
        } else {
            return "用户名或密码错误";
        }
        return "user/index";
    }

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
        return "";
    }

    /**
     * 判断用户的session是否有效（在同一个浏览器中，同一个域中，每次Request请求，都会带上Session）
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "isValid", method = RequestMethod.GET)
    public String isSessionValid(HttpServletRequest request) {
        //简化if-else表达式（其实很多地方可以简化的，这里为了方便新手朋友可以看得顺畅点，我尽量不简化）
        return request.isRequestedSessionIdValid() ? "ok" : "no";

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