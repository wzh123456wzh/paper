package com.wzh.paper.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzh.paper.dao.StockDAO;
import com.wzh.paper.dto.StockDTO;
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
        dto.setPageNum(dto.getPageNum() == null ? 1 : dto.getPageNum());
        dto.setPageSize(dto.getPageSize() == null ? 10 : dto.getPageSize());
        try {
            PageHelper.startPage(dto.getPageNum(),
                    dto.getPageSize(), true);
            List<StockInfo> stockInfoList = stockDAO.listStockInfo(dto);
            PageInfo<List<StockInfo>> pageInfo = new PageInfo(stockInfoList);
            result = new Result<>(Result.getSuccessCode(), "数据查询成功", pageInfo);
        } catch (Exception e) {
            result = new Result<>(Result.getFailCode(), "数据查询失败");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result<List<StockInfo>> listStockByChart(StockDTO dto) {
        Result<List<StockInfo>> result;
        try {
            List<StockInfo> stockInfoList = stockDAO.listStockByChart(dto);
            result = new Result<>(Result.getSuccessCode(), "数据查询成功", stockInfoList);
        } catch (Exception e) {
            result = new Result<>(Result.getFailCode(), "数据查询失败");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result<List<StockInfo>> listStockName(StockDTO dto) {
        Result<List<StockInfo>> result;
        try {
            dto.setSymbol("#"+dto.getSymbol()+"#");
            dto.setStockName("#"+dto.getStockName()+"#");
            List<StockInfo> stockInfoList = stockDAO.listStockName(dto);
            result = new Result<>(Result.getSuccessCode(), "数据查询成功", stockInfoList);
        } catch (Exception e) {
            result = new Result<>(Result.getFailCode(), "数据查询失败");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result<StockInfo> selectDetailBySymbol(StockDTO dto) {
        Result<StockInfo> result;
        try {
            StockInfo stockInfoList = stockDAO.getDetailBySymbol(dto);
            result = new Result<>(Result.getSuccessCode(), "数据查询成功", stockInfoList);
        } catch (Exception e) {
            result = new Result<>(Result.getFailCode(), "数据查询失败");
            e.printStackTrace();
        }
        return result;
    }
}
