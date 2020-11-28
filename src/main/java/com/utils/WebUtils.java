package com.utils; 
/*
 * WebUtils.java
 * Copyright (C) 2020 2020-11-27 23:55 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */
import java.lang.reflect.Field;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils
{
    public static<T> T param2bean(HttpServletRequest req, T t) {
        //封装对象，并返回
        //1. 获取所有声明的属性
        Field[] fields = t.getClass().getDeclaredFields();
        //2.每个属性都有name值，属性名
        for (Field field : fields) {
            //获取属性名
            String name = field.getName();
            //在request中获取相应的属性值
            String value = req.getParameter(name);
            try {
                BeanUtils.setProperty(t, name, value);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //封装对象setAttrName()
        }
        return t;
    }

    public static<T> T param2bean2(HttpServletRequest req, T t) {
        //populate将map中的键值对，直接映射到javaBean中
        Map map = req.getParameterMap();
        try {
            BeanUtils.populate(t, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}

