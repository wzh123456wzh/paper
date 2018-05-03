package com.wzh.paper.controller;

import com.wzh.paper.entity.Result;
import com.wzh.paper.entity.User;
import com.wzh.paper.service.UserService;
import com.wzh.paper.util.CurrentUserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
            return new Result(Result.ResultCode.FAIL_CODE,  "昵称必须少于10个字符");
        }
//        if(user.getPassword().length() < 6 || user.getPassword().length() > 16){
//            return new Result(Result.FAIL_CODE, "密码必须在6到16个字符之间 ");
//        }

        if(user.getPassword().matches(regex)){
            return new Result(Result.ResultCode.FAIL_CODE, "不能全是数字或字母");
        }
        return userService.register(user);
    }

    //登录
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody User user){
        Result<User> result = userService.login(user);
        return result;
    }

    //建立用户角色关系
    @ResponseBody
    @RequestMapping(value = "/saveRolesUser", method = RequestMethod.POST)
    public Result saveRolesUser(@RequestBody User user){
        return userService.saveRolesUser(user);
    }

    //列出此角色下的用户
    @ResponseBody
    @RequestMapping(value = "/listUsersByRole/{role_id}", method = RequestMethod.GET)
    public Result<User> listUsersByRole(@PathVariable("role_id") long roldId){
        return userService.listUsersByRoleSelect(roldId, true);
    }

    //列出不是此角色下的用户
    @ResponseBody
    @RequestMapping(value = "/listUsersNotByRole/{role_id}", method = RequestMethod.GET)
    public Result<User> listUsersNotByRole(@PathVariable("role_id") long roldId){
        return userService.listUsersByRoleSelect(roldId, false);
    }

    //根据用户名查询用户详细信息
    @ResponseBody
    @RequestMapping(value = "/getUserInfo/{nickname}", method = RequestMethod.GET)
    public Result<User> getUserInfoSelect(@PathVariable("nickname") String nickname){
        return userService.getUserInfoSelect(nickname);
    }
}
