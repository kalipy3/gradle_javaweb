/*
 * BaseDao.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */
package com.dao;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.utils.JDBCUtils;

public class BaseDao<T>
{
    private QueryRunner runner = new QueryRunner();
    //需要获取实际的type
    private Class<T> type;
	
    public BaseDao() {
        //获取父类类型,父类是带参数的
        ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        System.out.println(superclass.getClass());
        //获取参数的类型
        type = (Class<T>) superclass.getActualTypeArguments()[0];
	}

    /*执行crud*/
    public int update(String sql, Object ...params) {
        int count = 0;
        Connection connection = JDBCUtils.getConnection();
        try {
            count = runner.update(connection, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseConnection(connection);
        }
        return count;
    }


    //获取一个对象
    public T getBean(String sql, Object ...params) {
        Connection connection = JDBCUtils.getConnection();
        T query = null;
        try {
            query = runner.query(connection, sql, new BeanHandler<>(type), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseConnection(connection);
        }
        return query;
    }

    //获取对象集合
    public List<T> getBeanList(String sql, Object ...params) {
        Connection connection = JDBCUtils.getConnection();
        List<T> query = null;
        try {
            //查询一组数据
            query = runner.query(connection, sql, new BeanListHandler<>(type), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseConnection(connection);
        }
        return query;
    }

}

