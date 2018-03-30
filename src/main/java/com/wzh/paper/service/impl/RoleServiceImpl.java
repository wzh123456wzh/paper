package com.wzh.paper.service.impl;

import com.wzh.paper.dao.RoleDAO;
import com.wzh.paper.entity.Menu;
import com.wzh.paper.entity.Result;
import com.wzh.paper.entity.Role;
import com.wzh.paper.entity.User;
import com.wzh.paper.service.RoleService;
import com.wzh.paper.util.CalendarUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Resource
    private RoleDAO roleDAO;

    @Override
    public Result saveRole(Role role) {
        roleDAO.saveRole(role);
        return new Result();
    }

    @Override
    public Result saveUsersRole(Role role) {
        roleDAO.saveUsersRole(role);
        return new Result();
    }

    @Override
    public Result saveMenusRole(Role role) {
        roleDAO.saveMenusRole(role);
        return new Result();
    }

    //flag=true 列出是某用户下的角色
    //flag=false 列出不是某用户下的角色
    @Override
    public Result listRolesUserSelect(User user, boolean flag) {
        List<Role> roles;
            if(flag){
                roles = roleDAO.listRolesByUser(user);
            } else {
                roles = roleDAO.listRolesNotByUser(user);
            }
        return new Result(roles);
    }

    @Override
    public Result listRolesMenuSelect(Menu menu, boolean flag) {
        List<Role> roles;
        if(flag){
            roles = roleDAO.listRolesByMenu(menu);
        } else {
            roles = roleDAO.listRolesNotByMenu(menu);
        }
        return new Result(roles);
    }


}
