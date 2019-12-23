package com.ggman.photo.service;

import com.ggman.photo.bean.YsAdmin;
import org.springframework.context.annotation.Bean;


public interface YsAdminService {

    YsAdmin getYsAdmin(Integer id);

    YsAdmin getYsAdmin(String name,String password);
}
