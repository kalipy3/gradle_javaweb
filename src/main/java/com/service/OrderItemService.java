package com.service;

import java.util.List;
import com.bean.OrderItem;
/*
 * OrderItemService.java
 * Copyright (C) 2020 2020-12-03 18:52 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public interface OrderItemService
{
    //保存订单项
    public void saveItem(OrderItem orderItem);

    //获取订单的所有订单项
    public List<OrderItem> getOrderItems(String orderid);
}

