package com.dao;

import com.bean.User;
import com.dao.BaseDao;
import com.dao.UserDao;

/*
 * UserDaoImpl.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class UserDaoImpl extends BaseDao<User> implements UserDao 
{
    @Override 
    public boolean registUser(User user) {
        String sql = "insert into bs_user(username,password,email) values(?,?,?)";
        int update = this.update(sql, user.getUsername(),user.getPassword(),user.getEmail());
        return update > 0;
    }

    @Override 
    public User getUserByUserNameAndPassWord(User user) {
        String sql = "select * from bs_user where username=? and password=?";
        User bean = this.getBean(sql, user.getUsername(),user.getPassword());
        return bean;

    }

    public UserDaoImpl() {

    }
}

