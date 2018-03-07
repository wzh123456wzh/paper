package com.wzh.paper.controller;

import com.wzh.paper.entity.Menu;
import com.wzh.paper.entity.Result;
import com.wzh.paper.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    //添加菜单
    @ResponseBody
    @RequestMapping("/createMenu")
    public Result createMenu(@RequestBody Menu menu){
        Result result;
        if(menu.getMenuName().length() > 50){
            result = new Result(Result.FAIL_CODE, "菜单名称不能大于50个字符");
        }
        result = menuService.createMenu(menu);
        return result;
    }

//    public Result<List<Menu>> listMenus(){
//
//    }
}
