package com.ggman.photo.service;

import com.ggman.photo.bean.YsAdmin;

public interface YsAdminService {
    YsAdmin getYsAdmin(Integer id);

    YsAdmin getYsAdmin(String name,String password);
}
