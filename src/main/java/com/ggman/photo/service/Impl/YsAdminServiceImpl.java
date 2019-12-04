package com.ggman.photo.service.Impl;

import com.ggman.photo.bean.YsAdmin;
import com.ggman.photo.mapper.YsAdminMapper;
import com.ggman.photo.service.YsAdminService;
import org.springframework.beans.factory.annotation.Autowired;

public class YsAdminServiceImpl implements YsAdminService {

    @Autowired
    YsAdminMapper ysAdminMapper;

    @Override
    public YsAdmin getYsAdmin(Integer id) {
        return ysAdminMapper.getYsAdminById(id);
    }

    @Override
    public YsAdmin getYsAdmin(String name,String password) {
        return ysAdminMapper.getYsAdminByName(name ,password);
    }
}
