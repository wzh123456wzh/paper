package com.wzh.paper.service;

import com.wzh.paper.entity.Result;
import com.wzh.paper.entity.Role;
import com.wzh.paper.entity.User;

import java.util.List;

public interface UserService {

    User findUserById(long id);

    Result<User> register(User user);

    Result<User> login(User user);

    Result saveRolesUser(User user);

    Result<User> listUsersByRole(long roleId, boolean flag);
}
