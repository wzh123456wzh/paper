package com.wzh.paper.service.impl;

import com.wzh.paper.dao.MenuDAO;
import com.wzh.paper.dto.UserMenu;
import com.wzh.paper.entity.Menu;
import com.wzh.paper.entity.Result;
import com.wzh.paper.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuDAO menuDAO;

    @Override
    public Result createMenu(Menu menu) {
        Result result;
        try{
            Menu parentMenu = menuDAO.findMenu(menu.getParentId());
            long nextPrimaryKey = menuDAO.findNextPrimaryKey();
            menu.setFullPath(parentMenu.getFullPath() + "-" + nextPrimaryKey);
            menu.setMenuId(nextPrimaryKey);
            menuDAO.createMenu(menu);
            result = new Result(Result.SUCCESS_CODE, "菜单添加成功");
        }catch (Exception e){
            result = new Result(Result.FAIL_CODE, "菜单添加失败");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result<List<Menu>> listMenusByParent(UserMenu userMenu) {
        Result<List<Menu>> result;
        try{
            List<Menu> menus = menuDAO.listMenus(userMenu);
            result = new Result(Result.SUCCESS_CODE, "菜单查询成功", menus);
        }catch (Exception e){
            result = new Result(Result.FAIL_CODE, "菜单查询失败");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result<List<Menu>> listMenus(UserMenu userMenu) {
        Result<List<Menu>> result;
        try{
            List<Menu> tmpList = menuDAO.listMenus(userMenu);
            List<Menu> resultList = new ArrayList<>(10);
            //查询full_path长度为5的第一个元素(第二级菜单)
            int secondMenuIndex = 0;
            for(int i = 0; i < tmpList.size(); i++){
                if(tmpList.get(i).getFullPath().length() == 5){
                    secondMenuIndex = i;
                    break;
                }
            }
            //把菜单一级级挂在前面的菜单上
            for(int i = tmpList.size() - 1; i >= secondMenuIndex; i--){
                Menu currentMenu = tmpList.get(i);
                for (int j = i - 1; j >= 0; j--) {
                    Menu frontMenu = tmpList.get(j);
                    //若当前菜单的parent_id找到一个menu_id与他相同则挂到这个元素下
                    if(currentMenu.getParentId() == frontMenu.getMenuId()){
                        if(frontMenu.getChildMenus() == null){
                            frontMenu.setChildMenus(new ArrayList<Menu>());
                        }
                        frontMenu.getChildMenus().add(currentMenu);
                        break;
                    }
                }
            }
            //把第一级菜单存放在resultList上
            for(int i = secondMenuIndex - 1; i >= 0 ; i--){
                resultList.add(tmpList.get(i));
            }
            result = new Result(Result.SUCCESS_CODE, "菜单查询成功", resultList);
        }catch (Exception e){
            result = new Result(Result.FAIL_CODE, "菜单查询失败");
            e.printStackTrace();
        }
        return result;
    }
}
