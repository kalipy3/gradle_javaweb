/*
 * UserDao.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */
package com.dao;

import com.bean.User;

public interface UserDao
{
    //查询
    public User getUserByUserNameAndPassWord(User user);

    //注册 保存用户
    public boolean registUser(User user);
}

