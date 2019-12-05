package com.ggman.photo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ggman.photo.bean.YsAdmin;

/**
 * admin
 */

public interface YsAdminMapper extends BaseMapper<YsAdmin> {

    YsAdmin getYsAdminById(Integer id);
    YsAdmin getYsAdminByName(String name,String password);
}
