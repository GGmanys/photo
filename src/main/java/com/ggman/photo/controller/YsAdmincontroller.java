package com.ggman.photo.controller;

import com.ggman.photo.bean.YsAdmin;
import com.ggman.photo.service.YsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class YsAdmincontroller {
    @Autowired
    YsAdminService ysAdminService;

    @GetMapping("/getAdmin/{id}")
    public YsAdmin getAdmin(@PathParam("id") Integer id){
        return ysAdminService.getYsAdmin(id);
    }


}
