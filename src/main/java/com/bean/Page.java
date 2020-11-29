package com.bean;

import java.util.List;

/*
 * Page.java
 * Copyright (C) 2020 2020-11-29 21:36 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class Page<T>
{
    //当前是第几页 前端传进来的参数
    private int pageNo;

    //总页数 计算得到的
    private int totalPage;

    //总记录数 查询得到
    private int totalCount;

    //每页显示的条数 告诉数据库一次查询4条记录
    private int pageSize = 4;

    //告诉数据库从哪个索引开始查 计算得到
    private int index;

    //是否有下一页
    private boolean hasNext;

    //是否有上一页
    private boolean hasPrev;

    //封装了查询出来的分页数据
    private List<T> pageData;

	public Page() {
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalPage() {
        //计算实际的totalPage
        int t = getTotalCount() / getPageSize();
        if (!(getTotalCount()%getPageSize() == 0)) {
            t = t + 1;
        }
        return t;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    //计算得到索引值
    public int getIndex() {
        //每页显示4条记录
        //页码  开始索引    结束索引
        //1     0           3
        //2     4           7
        //3     8           11
        //4     12          15
        //n     4*(n-1)     4n-1
        int i = (getPageNo()-1)*getPageSize();
        return i;
    }

    //判断是否有下一个，根据当前页面
    public boolean isHasNext() {
        return getPageNo() < getTotalPage();
    }

    //判断是否有上一个
    public boolean isHasPrev() {
        return getPageNo() > 1;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    @Override
    public String toString() {
        return "Page{" +
            "pageNo = " + getPageNo() +
            ", totalPage = " + getTotalPage() +
            ", totalCount = " + getTotalCount() +
            ", pageSize = " + getPageSize() +
            ", index = " + getIndex() +
            ", hasNext = " + isHasNext() +
            ", hasPrev = " + isHasPrev() +
            ", pageData = " + getPageData() +
            "}";
    }

    public Page(int pageNo, int totalPage, int totalCount, int pageSize, int index, boolean hasNext, boolean hasPrev, List<T> pageData) {
        this.pageNo = pageNo;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.index = index;
        this.hasNext = hasNext;
        this.hasPrev = hasPrev;
        this.pageData = pageData;
    }

}

