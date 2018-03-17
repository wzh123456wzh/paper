package com.wzh.paper.dao;

import com.wzh.paper.dto.UserMenu;
import com.wzh.paper.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDAO {

    long findNextPrimaryKey();

    Menu findMenu(@Param("menuId") long menuId);

    void createMenu(Menu menu);

    List<Menu> listMenus(UserMenu userMenu);
}
