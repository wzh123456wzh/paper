package com.wzh.paper.dto;

import com.wzh.paper.entity.Menu;
import com.wzh.paper.entity.User;

import java.util.List;

public class ProductionDTO {
    private Long production_id;
    private String productionName;
    private Integer empiryDate;
    private List<Menu> menus;
    private List<User> users;

    public Long getProduction_id() {
        return production_id;
    }

    public void setProduction_id(Long production_id) {
        this.production_id = production_id;
    }

    public String getProductionName() {
        return productionName;
    }

    public void setProductionName(String productionName) {
        this.productionName = productionName;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Integer getEmpiryDate() {
        return empiryDate;
    }

    public void setEmpiryDate(Integer empiryDate) {
        this.empiryDate = empiryDate;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
