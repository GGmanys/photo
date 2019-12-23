package com.ggman.photo.service.Impl;

import com.ggman.photo.bean.YsUser;
import com.ggman.photo.mapper.YsUserMapper;
import com.ggman.photo.service.YsUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class YsUserServiceImpl implements YsUserService {

    @Autowired
    YsUserMapper ysUserMapper;
    @Override
    public YsUser getAll(Integer id) {
        return ysUserMapper.getAll(id);
    }
}
