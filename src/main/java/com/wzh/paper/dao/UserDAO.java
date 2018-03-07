package com.wzh.paper.dao;

import com.wzh.paper.entity.Role;
import com.wzh.paper.entity.TokenData;
import com.wzh.paper.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDAO {
    User getUserById(@Param("id") long id);

    User getUserByName(@Param("nickname") String nickname);

    void register(User user);

    User login(User user);

    void saveRolesUser(User user);

    List<User> listUsersByRole(@Param("roleId") long roleId);

    List<User> listUsersNotByRole(@Param("roleId") long roleId);

    TokenData getTokenData(@Param("userId") long userId);
}
