package com.test;

import org.apache.commons.beanutils.BeanUtils;

import org.junit.Test;

import com.bean.User;
/*
 * UserDaoTest.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class BeanUtilsTest
{
    @Test 
    public void test() {
        //setProperty(bean, name, value);
        //bean代表要给哪个对象设置属性值
        //name代表要设置的属性名
        //value要设置的值
        User user = new User();
        System.out.println("未设置值之前："+user);
        try {
            BeanUtils.setProperty(user, "username", "小明");
            System.out.println("设置值之后："+user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

