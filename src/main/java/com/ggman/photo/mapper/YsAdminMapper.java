package com.ggman.photo.mapper;

import com.ggman.photo.bean.YsAdmin;

public interface YsAdminMapper {

    YsAdmin getYsAdminById(Integer id);
    YsAdmin getYsAdminByName(String name,String password);
}
