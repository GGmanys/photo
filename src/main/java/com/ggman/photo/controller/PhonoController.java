package com.ggman.photo.controller;

import com.ggman.photo.bean.YsUser;
import com.ggman.photo.service.YsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class PhonoController {

    @Autowired
    YsUserService ysUserService;

    /**
     * 获取当前用户的所有照片
     * @param id
     * @return
     */
    @GetMapping("/getAll/{id}")
    public YsUser getAll(@PathParam("id") Integer id){
        return ysUserService.getAll(id);
    }

}
