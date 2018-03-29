package com.wzh.paper.service.impl;

import com.wzh.paper.dao.ProductionDAO;
import com.wzh.paper.dto.ProductionDTO;
import com.wzh.paper.entity.Production;
import com.wzh.paper.entity.Result;
import com.wzh.paper.service.ProductionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductionServiceImpl implements ProductionService {

    @Resource
    private ProductionDAO productionDAO;


//    public Result saveProduction(ProductionDTO productionDTO){
//        Result result;
//        try {
//            productionDAO.saveProduction(productionDTO);
//            result = new Result(Result.SUCCESS_CODE, "添加成功");
//        } catch (Exception e) {
//            result = new Result(Result.FAIL_CODE, "添加失败");
//            e.printStackTrace();
//        }
//        return result;
//    }

    @Override
    public Result saveProduction(ProductionDTO productionDTO){
        productionDAO.saveProduction(productionDTO);
        return new Result();
    }

    @Override
    public Result savaProductionMenu(ProductionDTO productionDTO) {
        productionDAO.savaProductionMenu(productionDTO);
        return new Result();
    }
}
