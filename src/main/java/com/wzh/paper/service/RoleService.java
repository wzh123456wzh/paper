package com.wzh.paper.service;

import com.wzh.paper.entity.Result;
import com.wzh.paper.entity.Role;

public interface RoleService {
    Result saveRole(Role role);

    Result saveUsersByRole(Role role);
}
