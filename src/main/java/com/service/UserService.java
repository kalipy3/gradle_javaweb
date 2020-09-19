/*
 * UserService.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */
package com.service;

import com.bean.User;

public interface UserService
{
    public User login(User user);
    public boolean regist(User user);
}

