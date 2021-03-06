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

    StockInfo getSymbolLastInfo(StockDTO dto);

    void buyStock(StockDTO stockDTO);

    void attentionStock(StockDTO dto);

    StockInfo isAttention(StockDTO dto);

    void cancenAttention(StockDTO dto);

    int getUserMoney(StockDTO stockDTO);

    void updateUserAccount(StockDTO stockDTO);

    void insertUpdateHoldUser(StockDTO stockDTO);

    int getStockNumSelect(StockDTO stockDTO);

    void sellStock(StockDTO stockDTO);

    List<StockInfo> listAttentionStockSelect(StockDTO dto);

    List<StockInfo> listBuyStockSelect(StockDTO dto);

    List<StockInfo> listStockDistorySelect(StockDTO dto);
}