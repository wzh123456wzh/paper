package com.wzh.paper.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzh.paper.dao.StockDAO;
import com.wzh.paper.dto.StockDTO;
import com.wzh.paper.entity.MyPage;
import com.wzh.paper.entity.Result;
import com.wzh.paper.entity.StockInfo;
import com.wzh.paper.service.StockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Resource
    private StockDAO stockDAO;


    @Override
    public Result<PageInfo<List<StockInfo>>> listStockInfo(StockDTO dto) {
        Result<PageInfo<List<StockInfo>>> result;
        dto.setCurrentPage(dto.getCurrentPage() == null ? 1 : dto.getCurrentPage());
        dto.setPageItems(dto.getPageItems() == null ? 10 : dto.getPageItems());
//        MyPage<StockInfo> stockInfoPage = new MyPage<>(dto.getCurrentPage(), dto.getPageItems());

        try {
            PageHelper.startPage(dto.getCurrentPage(),
                    dto.getPageItems(), true);
            List<StockInfo> stockInfoList = stockDAO.listStockInfo(dto);
            PageInfo<List<StockInfo>> pageInfo = new PageInfo(stockInfoList);
            result = new Result<>(Result.getSuccessCode(), "数据查询成功", pageInfo);
        } catch (Exception e) {
            result = new Result<>(Result.getFailCode(), "数据查询失败");
            e.printStackTrace();
        }
        return result;
    }
}
