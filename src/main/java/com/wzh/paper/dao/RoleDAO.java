package com.wzh.paper.dao;

import com.wzh.paper.entity.Role;

public interface RoleDAO {
    void saveRole(Role role);

    void saveUsersByRole(Role role);
}
