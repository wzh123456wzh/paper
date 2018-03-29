package com.wzh.paper.service;

import com.wzh.paper.dto.ProductionDTO;
import com.wzh.paper.entity.Production;
import com.wzh.paper.entity.Result;

public interface ProductionService {
    Result saveProduction(ProductionDTO productionDTO);

    Result savaProductionMenu(ProductionDTO productionDTO);
}
