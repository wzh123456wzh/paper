package com.wzh.paper.controller;

import com.wzh.paper.dto.UserMenu;
import com.wzh.paper.entity.Menu;
import com.wzh.paper.entity.Result;
import com.wzh.paper.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @RequestMapping(value = "/createMenu", method = RequestMethod.POST)
    public Result saveMenu(@RequestBody Menu menu){
        Result result;
        if(menu.getMenuName().length() > 50){
            result = new Result(Result.ResultCode.FAIL_CODE, "菜单名称不能大于50个字符");
        }
        return menuService.saveMenu(menu);
    }

    //按照父菜单获得下一集菜单
    @ResponseBody
    @RequestMapping(value = "/listMenusByParent", method = RequestMethod.POST)
    public Result<List<Menu>> listMenusByParentSelect(@RequestBody UserMenu userMenu){
        Result<List<Menu>> result;
        return menuService.listMenusByParentSelect(userMenu);
    }

    //查找用户的所有菜单
    @ResponseBody
    @RequestMapping(value = "/listMenus", method = RequestMethod.POST)
    public Result<List<Menu>> listMenusSelect(@RequestBody UserMenu userMenu){
        Result<List<Menu>> result;
        return menuService.listMenusSelect(userMenu);
    }
}
