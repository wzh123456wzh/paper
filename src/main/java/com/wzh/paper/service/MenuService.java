package com.wzh.paper.service;

import com.wzh.paper.dto.UserMenu;
import com.wzh.paper.entity.Menu;
import com.wzh.paper.entity.Result;

import java.util.List;

public interface MenuService {
    Result saveMenu(Menu menu);

    Result<List<Menu>> listMenusByParentSelect(UserMenu userMenu);

    Result<List<Menu>> listMenusSelect(UserMenu userMenu);
}
