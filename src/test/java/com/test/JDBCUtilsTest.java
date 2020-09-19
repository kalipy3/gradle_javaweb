package com.utils;
//package com.test;
import java.sql.Connection;

import org.junit.Test;

/*
 * JDBCUtilsTest.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class JDBCUtilsTest
{
    @Test 
    public void getConnection() {
        Connection connection = JDBCUtils.getConnection();
        System.out.println(connection);
        JDBCUtils.releaseConnection(connection);
    }
	public JDBCUtilsTest() {
		
	}
}

