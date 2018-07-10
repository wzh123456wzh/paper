package com.wzh.paper.service.impl;

import com.wzh.paper.dao.UserDAO;
import com.wzh.paper.entity.Result;
import com.wzh.paper.entity.Role;
import com.wzh.paper.entity.TokenData;
import com.wzh.paper.entity.User;
import com.wzh.paper.service.UserService;
import com.wzh.paper.util.CurrentUserUtil;
import com.wzh.paper.util.JedisUtil;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserSeiviceImpl implements UserService{

    @Resource
    private UserDAO userDAO;

    public User findUserById(long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public Result<User> register(User user) {
        User oldUser = userDAO.getUserByName(user.getNickname());
        Result result;
        if(oldUser != null){
            return new Result<User>(Result.ResultCode.SELECT_FAIL_CODE, "昵称已存在");
        }
        try {
            //对存入数据库的秘密加密
            String password = user.getPassword();
            MessageDigest md = null;
            md = MessageDigest.getInstance("md5");
            byte[] md5 = md.digest(password.getBytes());
            BASE64Encoder be = new BASE64Encoder();
            String base64 = be.encode(md5);
            user.setPassword(base64);
            userDAO.register(user);
            result = new Result(Result.ResultCode.SELECT_SUCCESS_CODE, "注册成功");
        } catch (NoSuchAlgorithmException e){
            result = new Result(Result.ResultCode.SELECT_FAIL_CODE, "注册失败");
            e.printStackTrace();
        } catch (Exception e) {
            result = new Result(Result.ResultCode.SELECT_FAIL_CODE, "注册失败");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result<User> login(User user) {
        Result result;
        try {
            User userIsExist = userDAO.getUserByName(user.getNickname());
            if(userIsExist == null){
                result = new Result(2, "用户不存在");
            } else {
                String password = user.getPassword();
                MessageDigest md;
                md = MessageDigest.getInstance("md5");
                byte[] md5 = md.digest(password.getBytes());
                BASE64Encoder be = new BASE64Encoder();
                String base64 = be.encode(md5);
                user.setPassword(base64);
                User loginUser = userDAO.login(user);
                if (loginUser != null) {
                    String token = CurrentUserUtil.getToken(loginUser);
                    loginUser.setToken(token);
                    TokenData tokenData = userDAO.getTokenData(loginUser.getUserId());
//                    JedisUtil.setTokenData(token, tokenData);
                    result = new Result(Result.ResultCode.SELECT_SUCCESS_CODE, "登录成功", loginUser);
                } else {
                    result = new Result(0, "密码错误");
                }
            }
        } catch (NoSuchAlgorithmException e) {
            result = new Result(Result.ResultCode.SELECT_FAIL_CODE, "登录失败");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result saveRolesUser(User user) {
        userDAO.saveRolesUser(user);
        return new Result();
    }

    //flag = true   列出此角色的用户
    //flag = flase  列出非此角色的用户
    @Override
    public Result<User> listUsersByRoleSelect(long roleId, boolean flag) {
            List<User> users;
            if(flag){
                users = userDAO.listUsersByRole(roleId);
            } else {
                users = userDAO.listUsersNotByRole(roleId);
            }
        if(users.size() == 0){
                users = null;
        }
        return new Result(users);
    }

    @Override
    public Result<User> getUserInfoSelect(String nickname) {
        return null;
    }
}
