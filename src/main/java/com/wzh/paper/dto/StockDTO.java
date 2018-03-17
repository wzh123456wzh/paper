package com.wzh.paper.dto;

public class StockDTO {
    private String startDate;
    private String endDate;
    private Integer currentPage;
    private Integer pageItems;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageItems() {
        return pageItems;
    }

    public void setPageItems(Integer pageItems) {
        this.pageItems = pageItems;
    }
}
