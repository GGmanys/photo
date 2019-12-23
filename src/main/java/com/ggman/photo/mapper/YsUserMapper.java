package com.ggman.photo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ggman.photo.bean.YsUser;

/**
 * 用户
 */
public interface  YsUserMapper  extends BaseMapper<YsUser> {
    YsUser getAll(Integer id );
}
