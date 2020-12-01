package com.test;

import java.util.UUID;

import org.junit.Test;

/*
 * UUIDTest.java
 * Copyright (C) 2020 2020-12-01 14:33 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class UUIDTest
{
    @Test 
    public void test() {
        UUID uuid = UUID.randomUUID();
        String string = uuid.toString();
        System.out.println(string.toUpperCase());
        String all = string.replaceAll("-", "");
        System.out.println(all.toUpperCase());
    }
}

