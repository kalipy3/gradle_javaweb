/*
 * UserServiceImpl.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */
package com.service;
import com.bean.User;
import com.dao.*;
import com.dao.UserDao;
import com.service.UserService;

public class UserServiceImpl implements UserService
{
   private UserDao ud = new UserDaoImpl();

    @Override 
    public User login(User user) {
        return ud.getUserByUserNameAndPassWord(user);
    }

    @Override 
    public boolean regist(User user) {
        return ud.registUser(user);

    }
}

