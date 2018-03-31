package com.wzh.paper.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.wzh.paper.dto.StockDTO;
import com.wzh.paper.entity.MyPage;
import com.wzh.paper.entity.Result;
import com.wzh.paper.entity.StockInfo;

import java.util.List;

public interface StockService {
    Result<PageInfo<List<StockInfo>>> listStockInfo(StockDTO dto);

    Result<List<StockInfo>> listStockByChart(StockDTO dto);

    Result<List<StockInfo>> listStockName(StockDTO dto);

    Result<StockInfo> getSymbolLastInfo(StockDTO dto);

    Result buyStock(StockDTO stockDTO);

    Result attentionStock(StockDTO dto);

    Result isAttention(StockDTO dto);

    Result cancenAttention(StockDTO dto);

    Result<List<StockInfo>> listAttentionStockSelect(StockDTO dto);

    Result<List<StockInfo>> listBuyStockSelect(StockDTO dto);
}
