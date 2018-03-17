package com.wzh.paper.service;

import com.wzh.paper.dto.UserMenu;
import com.wzh.paper.entity.Menu;
import com.wzh.paper.entity.Result;

import java.util.List;

public interface MenuService {
    Result createMenu(Menu menu);

    Result<List<Menu>> listMenusByParent(UserMenu userMenu);

    Result<List<Menu>> listMenus(UserMenu userMenu);
}
