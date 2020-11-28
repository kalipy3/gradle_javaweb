package com.test;
/*
 * Student.java
 * Copyright (C) 2020 2020-11-28 14:37 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class Student
{
    private Integer id;
    private String username2;
    private String password;
    private String email;
    private int age;

	public Student() {
		
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username2;
    }

    public void setUsername(String username) {
        this.username2 = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
            "id = " + id +
            ", username = " + username2 +
            ", password = " + password +
            ", email = " + email +
            ", age = " + age +
            "}";
    }

    public Student(Integer id, String username, String password, String email, int age) {
        this.id = id;
        this.username2 = username;
        this.password = password;
        this.email = email;
        this.age = age;
    }

}

