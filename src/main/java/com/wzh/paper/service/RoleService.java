package com.wzh.paper.service;

import com.wzh.paper.entity.Menu;
import com.wzh.paper.entity.Result;
import com.wzh.paper.entity.Role;
import com.wzh.paper.entity.User;

public interface RoleService {
    Result saveRole(Role role);

    Result saveUsersRole(Role role);

    Result saveMenusRole(Role role);

    Result listRolesUser(User user, boolean flag);

    Result listRolesMenu(Menu menu, boolean flag);
}
