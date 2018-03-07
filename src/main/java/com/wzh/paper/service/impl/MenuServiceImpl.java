package com.wzh.paper.service.impl;

import com.wzh.paper.dao.MenuDAO;
import com.wzh.paper.entity.Menu;
import com.wzh.paper.entity.Result;
import com.wzh.paper.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuDAO menuDAO;

    @Override
    public Result createMenu(Menu menu) {
        Result result;
        try{
            menuDAO.createMenu(menu);
            result = new Result(Result.SUCCESS_CODE, "菜单添加成功");
        }catch (Exception e){
            result = new Result(Result.FAIL_CODE, "菜单添加失败");
            e.printStackTrace();
        }
        return result;
    }
}
