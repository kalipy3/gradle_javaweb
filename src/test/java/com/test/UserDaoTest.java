package com.dao;

import org.junit.Test;

import com.bean.User;
import com.dao.UserDao;
import com.dao.UserDaoImpl;

/*
 * UserDaoTest.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class UserDaoTest
{
    @Test 
    public void test() {
        UserDao ud = new UserDaoImpl();
        User user = ud.getUserByUserNameAndPassWord(new User(1, "username", "password", "3069087972@qq.com"));
        System.out.println(user);
    }

	public UserDaoTest() {
		
	}
}

