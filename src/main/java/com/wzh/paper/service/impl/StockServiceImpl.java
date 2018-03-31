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
            List<StockInfo> stockInfoList = stockDAO.listStockName(dto);
            result = new Result<>(Result.getSuccessCode(), "数据查询成功", stockInfoList);
        } catch (Exception e) {
            result = new Result<>(Result.getFailCode(), "数据查询失败");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result<StockInfo> getSymbolLastInfo(StockDTO dto) {
        Result<StockInfo> result;
        try {
            StockInfo stockInfoList = stockDAO.getSymbolLastInfo(dto);
            result = new Result<>(Result.getSuccessCode(), "数据查询成功", stockInfoList);
        } catch (Exception e) {
            result = new Result<>(Result.getFailCode(), "数据查询失败");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result buyStock(StockDTO stockDTO) {
        Result result;
        try {

            stockDAO.buyStock(stockDTO);
            result = new Result<>(Result.getSuccessCode(), "购买股票成功");
        } catch (Exception e) {
            result = new Result<>(Result.getFailCode(), "购买股票失败");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result attentionStock(StockDTO dto) {
        Result result;
        try {
            stockDAO.attentionStock(dto);
            result = new Result<>(Result.getSuccessCode(), "关注股票成功");
        } catch (Exception e) {
            result = new Result<>(Result.getFailCode(), "关注股票失败");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result isAttention(StockDTO dto) {
        Result result;
        try {
            int status = stockDAO.isAttention(dto);
            if(status == 1){
                result = new Result<>(Result.getSuccessCode(), "股票已经关注");
            } else {
                result = new Result<>(Result.getEmptyCode(), "股票还未关注");
            }
        } catch (Exception e) {
            result = new Result<>(Result.getFailCode(), "获取信息失败");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result cancenAttention(StockDTO dto) {
        Result result;
        try {
            stockDAO.cancenAttention(dto);
            result = new Result<>(Result.getSuccessCode(), "取消关注股票成功");
        } catch (Exception e) {
            result = new Result<>(Result.getFailCode(), "取消关注股票失败");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result<List<StockInfo>> listAttentionStockSelect(StockDTO dto) {
        List<StockInfo> listResult = stockDAO.listAttentionStockSelect(dto);
        return new Result<>(listResult);
    }
}
