package com.wzh.paper.controller;

import com.sun.xml.internal.ws.util.ReadAllStream;
import com.wzh.paper.entity.Menu;
import com.wzh.paper.entity.Result;
import com.wzh.paper.entity.Role;
import com.wzh.paper.entity.User;
import com.wzh.paper.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    //增加角色
    @ResponseBody
    @RequestMapping(value = "/saveRole", method = RequestMethod.POST)
    public Result saveRole(@RequestBody Role role){
        if(role.getName().length() > 10){
            return new Result(Result.ResultCode.FAIL_CODE, "角色名称必须少于10个字符");
        }
        return roleService.saveRole(role);
    }

    //建立用户角色关系
    @ResponseBody
    @RequestMapping(value = "/saveUsersRole", method = RequestMethod.POST)
    public Result saveUsersRole(@RequestBody Role role){
        return roleService.saveUsersRole(role);
    }

    //建立角色菜单关系
    @ResponseBody
    @RequestMapping(value = "/saveMenusRole", method = RequestMethod.POST)
    public Result saveMenusRole(@RequestBody Role role){
        return roleService.saveMenusRole(role);
    }

    //列出是某用户下的角色
    @ResponseBody
    @RequestMapping(value = "/listRolesByUser", method = RequestMethod.POST)
    public Result listRolesByUser(@RequestBody User user){
        return roleService.listRolesUserSelect(user, true);
    }

    //列出不是某用户下的角色
    @ResponseBody
    @RequestMapping(value = "/listRolesNotByUser", method = RequestMethod.POST)
    public Result listRolesNotByUser(@RequestBody User user){
        return roleService.listRolesUserSelect(user, false);
    }

    //列出是某菜单下的角色
    @ResponseBody
    @RequestMapping(value = "/listRolesByMenu", method = RequestMethod.POST)
    public Result listRolesByMenu(@RequestBody Menu menu){
        return roleService.listRolesMenuSelect(menu, true);
    }

    //列出不是某菜单下的角色
    @ResponseBody
    @RequestMapping(value = "/listRolesNotByMenu", method = RequestMethod.POST)
    public Result listRolesNotByMenu(@RequestBody Menu menu){
        return roleService.listRolesMenuSelect(menu, false);
    }
}
