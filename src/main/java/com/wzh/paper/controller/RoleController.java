package com.wzh.paper.controller;

import com.sun.xml.internal.ws.util.ReadAllStream;
import com.wzh.paper.entity.Result;
import com.wzh.paper.entity.Role;
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
            return new Result(Result.FAIL_CODE, "角色名称必须少于10个字符");
        }
        return roleService.saveRole(role);
    }

    //批量添加用户到角色
    @ResponseBody
    @RequestMapping(value = "/saveUsersByRole", method = RequestMethod.POST)
    public Result saveUsersByRole(@RequestBody Role role){
        if(role.getName().length() > 10){
            return new Result(Result.FAIL_CODE, "角色名称必须少于10个字符");
        }
        return roleService.saveUsersByRole(role);
    }

}
