package com.wzh.paper.controller;

import com.wzh.paper.entity.Result;
import com.wzh.paper.entity.Role;
import com.wzh.paper.entity.User;
import com.wzh.paper.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    //注册
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@RequestBody User user){
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]$";
        if(user.getNickname().length() > 10){
            return new Result(Result.FAIL_CODE, "昵称必须少于10个字符");
        }
        if(user.getPassword().length() < 6 || user.getPassword().length() > 16){
            return new Result(Result.FAIL_CODE, "密码必须在6到16个字符之间 ");
        }

        if(user.getPassword().matches(regex)){
            return new Result(Result.FAIL_CODE, "不能全是数字或字母");
        }
        return userService.register(user);
    }

    //登录
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody User user){
        return userService.login(user);
    }

    @ResponseBody
    @RequestMapping(value = "/saveRolesByUser", method = RequestMethod.POST)
    public Result saveRolesByUser(@RequestBody User user){
        return userService.saveRolesByUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/listUsersByRole/{role_id}", method = RequestMethod.GET)
    public Result<User> listUsersByRole(@PathVariable("role_id") long roldId){
        return userService.listUsersByRole(roldId, true);
    }

    @ResponseBody
    @RequestMapping(value = "/listUsersNotByRole/{role_id}", method = RequestMethod.GET)
    public Result<User> listUsersNotByRole(@PathVariable("role_id") long roldId){
        return userService.listUsersByRole(roldId, false);
    }
}
