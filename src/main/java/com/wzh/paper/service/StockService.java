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
}
