package com.wzh.paper.dao;

import com.wzh.paper.dto.StockDTO;
import com.wzh.paper.dto.UserMenu;
import com.wzh.paper.entity.Menu;
import com.wzh.paper.entity.StockInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StockDAO {

    List<StockInfo> listStockInfo(StockDTO dto);

    List<StockInfo> listStockByChart(StockDTO dto);

    List<StockInfo> listStockName(StockDTO dto);

    StockInfo getDetailBySymbol(StockDTO dto);
}
