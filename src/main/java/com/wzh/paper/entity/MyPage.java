package com.wzh.paper.entity;

import java.util.List;

public class MyPage<T> {
    private Integer currentPage;//当前页数
    private Integer itemSize;//条目总数
    private Integer pageSize;//页数总数
    private Integer pageItems;//每页条数
    private List<T> itemList;

    public MyPage(int currentPage, int pageItems) {
        this.currentPage = currentPage;
        this.pageItems = pageItems;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getItemSize() {
        return itemSize;
    }

    public void setItemSize(Integer itemSize) {
        this.itemSize = itemSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageItems() {
        return pageItems;
    }

    public void setPageItems(Integer pageItems) {
        this.pageItems = pageItems;
    }

    public List<T> getItemList() {
        return itemList;
    }

    public void setItemList(List<T> itemList) {
        this.itemList = itemList;
    }
}
