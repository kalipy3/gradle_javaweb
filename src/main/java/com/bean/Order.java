package com.bean;

import java.util.Date;

/*
 * Order.java
 * Copyright (C) 2020 2020-12-03 15:17 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class Order
{
    private String orderId;//订单号 作为主键
    private Date createDate;//创建日期
    private int status;//订单状态
    private double totalMoney;//订单总额
    private Integer userId;//关联的用户

    public Order() {

    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Order(String orderId, Date createDate, int status, double totalMoney, Integer userId) {
        this.orderId = orderId;
        this.createDate = createDate;
        this.status = status;
        this.totalMoney = totalMoney;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
            "orderId = " + getOrderId() +
            ", createDate = " + getCreateDate() +
            ", status = " + getStatus() +
            ", totalMoney = " + getTotalMoney() +
            ", userId = " + getUserId() +
            "}";
    }

}

