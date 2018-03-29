package com.wzh.paper.dao;

import com.wzh.paper.dto.ProductionDTO;
import com.wzh.paper.entity.Production;

public interface ProductionDAO {
    void saveProduction(ProductionDTO productionDTO);

    void savaProductionMenu(ProductionDTO productionDTO);
}
