package com.utils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

/*
 * JDBCUtils.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 * 获取和释放数据库连接
 */

public class JDBCUtils
{
    private static DataSource ds = new ComboPooledDataSource("webDataSource");
    
    /*获取数据库连接
     * */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /*释放数据库连接
     * */
    public static void releaseConnection(Connection connection) {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public JDBCUtils() {
		
	}
}

