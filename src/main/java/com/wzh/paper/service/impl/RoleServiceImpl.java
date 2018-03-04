package com.wzh.paper.service.impl;

import com.wzh.paper.dao.RoleDAO;
import com.wzh.paper.entity.Result;
import com.wzh.paper.entity.Role;
import com.wzh.paper.service.RoleService;
import com.wzh.paper.util.CalendarUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleServiceImpl implements RoleService{

    @Resource
    private RoleDAO roleDAO;

    @Override
    public Result saveRole(Role role) {
        Result result = new Result();
        try {
            role.setUpdateDate(CalendarUtil.getDate());
            roleDAO.saveRole(role);
            result = new Result(Result.SUCCESS_CODE, "添加成功");
        } catch (Exception e) {
            result = new Result(Result.FAIL_CODE, "添加失败");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result saveUsersByRole(Role role) {
        Result result = new Result();
        try {
            roleDAO.saveUsersByRole(role);
            result = new Result(Result.SUCCESS_CODE, "添加成功");
        } catch (Exception e) {
            result = new Result(Result.FAIL_CODE, "添加失败");
            e.printStackTrace();
        }
        return result;
    }
}
