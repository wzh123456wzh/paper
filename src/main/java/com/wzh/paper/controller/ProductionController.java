package com.wzh.paper.controller;

import com.wzh.paper.dto.ProductionDTO;
import com.wzh.paper.entity.Production;
import com.wzh.paper.entity.Result;
import com.wzh.paper.service.ProductionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/production")
public class ProductionController {

    @Resource
    private ProductionService productionService;

    //添加产品
    @ResponseBody
    @RequestMapping(value = "/saveProduction", method = RequestMethod.POST)
    public Result saveProduction(@RequestBody ProductionDTO productionDTO){
        return productionService.saveProduction(productionDTO);
}

    //产品菜单映射
    @ResponseBody
    @RequestMapping(value = "/savaProductionMenu", method = RequestMethod.POST)
    public Result savaProductionMenu(@RequestBody ProductionDTO productionDTO){
        return productionService.savaProductionMenu(productionDTO);
    }

}
