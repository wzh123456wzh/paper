package com.wzh.paper.dao;

import com.wzh.paper.entity.Menu;
import com.wzh.paper.entity.Role;
import com.wzh.paper.entity.User;

import java.util.List;

public interface RoleDAO {
    void saveRole(Role role);

    void saveUsersRole(Role role);

    void saveMenusRole(Role role);

    List<Role> listRolesByUser(User user);

    List<Role> listRolesNotByUser(User user);

    List<Role> listRolesByMenu(Menu menu);

    List<Role> listRolesNotByMenu(Menu menu);
}
