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
import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Resource
    private StockDAO stockDAO;


    @Override
    public Result<PageInfo<List<StockInfo>>> listStockInfoSelect(StockDTO dto) {
        dto.setPageNum(dto.getPageNum() == null ? 1 : dto.getPageNum());
        dto.setPageSize(dto.getPageSize() == null ? 10 : dto.getPageSize());
        PageHelper.startPage(dto.getPageNum(),
                dto.getPageSize(), true);
        List<StockInfo> stockInfoList = stockDAO.listStockInfo(dto);
        PageInfo<List<StockInfo>> pageInfo = new PageInfo(stockInfoList);
        return new Result(pageInfo);
    }

    @Override
    public Result<List<StockInfo>> listStockByChartSelect(StockDTO dto) {
//        Result<List<StockInfo>> result;
//        try {
        List<StockInfo> stockInfoList = stockDAO.listStockByChart(dto);
//            result = new Result<>(Result.getSuccessCode(), "数据查询成功", stockInfoList);
//        } catch (Exception e) {
//            result = new Result<>(Result.getFailCode(), "数据查询失败");
//            e.printStackTrace();
//        }
        return new Result(stockInfoList);
    }

    @Override
    public Result<List<StockInfo>> listStockNameSelect(StockDTO dto) {
//        Result<List<StockInfo>> result;
//        try {
        List<StockInfo> stockInfoList = stockDAO.listStockName(dto);
//            result = new Result<>(Result.getSuccessCode(), "数据查询成功", stockInfoList);
//        } catch (Exception e) {
//            result = new Result<>(Result.getFailCode(), "数据查询失败");
//            e.printStackTrace();
//        }
        return new Result(stockInfoList);
    }

    @Override
    public Result<StockInfo> getSymbolLastInfoSelect(StockDTO dto) {
//        Result<StockInfo> result;
//        try {
        StockInfo stockInfoList = stockDAO.getSymbolLastInfo(dto);
//            result = new Result<>(Result.getSuccessCode(), "数据查询成功", stockInfoList);
//        } catch (Exception e) {
//            result = new Result<>(Result.getFailCode(), "数据查询失败");
//            e.printStackTrace();
//        }
        return new Result(stockInfoList);
    }

    @Override
    public Result saveBuyStock(StockDTO stockDTO) {
        Result result;
        int money = stockDAO.getUserMoney(stockDTO);
        int count = (int) (money / stockDTO.getLastTrade());
        if(count > stockDTO.getStockNum()){
            //插入买入历史表
            stockDAO.buyStock(stockDTO);
            //更新用户账户金额
            stockDAO.updateUserAccount(stockDTO);
            //插入或更新用户股票持有表
            stockDAO.insertUpdateHoldUser(stockDTO);
            result = new Result();
        } else {
            result = new Result(Result.ResultCode.FAIL_CODE, "账户余额不足");
        }
        return result;
    }

    @Override
    public Result saveSellStock(StockDTO stockDTO) {
        Result result;
        //查询用户持有多少股
        int stockNum = stockDAO.getStockNumSelect(stockDTO);
        if(stockNum > stockDTO.getStockNum()){
            //插入卖出历史表
            stockDAO.sellStock(stockDTO);
            //更新用户账户金额
            stockDTO.setLastTrade(-stockDTO.getLastTrade());
            stockDAO.updateUserAccount(stockDTO);
            //插入或更新用户股票持有表
            stockDTO.setStockNum(-stockDTO.getStockNum());
            stockDAO.insertUpdateHoldUser(stockDTO);
            result = new Result();
        } else{
            result = new Result(Result.ResultCode.FAIL_CODE, "超出用所所剩余的股票数量");
        }

        return result;
    }

    @Override
    public Result<List<StockInfo>> listAttentionStockSelect(StockDTO dto) {
        List<StockInfo> stockInfos = stockDAO.listAttentionStockSelect(dto);
        return new Result<  >(stockInfos);
    }

    @Override
    public Result<List<StockInfo>> listBuyStockSelect(StockDTO dto) {
        List<StockInfo> stockInfos = stockDAO.listBuyStockSelect(dto);
        return new Result<>(stockInfos);
    }

    @Override
    public Result<List<StockInfo>> listStockDistorySelect(StockDTO dto) {
        List<StockInfo> stockInfos = stockDAO.listStockDistorySelect(dto);
        return new Result<>(stockInfos);
    }

    @Override
    public Result updateAttentionStock(StockDTO dto) {
//        Result result;
//        try {
        stockDAO.attentionStock(dto);
//            result = new Result<>(Result.getSuccessCode(), "关注股票成功");
//        } catch (Exception e) {
//            result = new Result<>(Result.getFailCode(), "关注股票失败");
//            e.printStackTrace();
//        }
        return new Result();
    }

    @Override
    public Result isAttentionSelect(StockDTO dto) {
//        Result result;
//        try {
        StockInfo stockInfo = stockDAO.isAttention(dto);
//            if(status == 1){
//                result = new Result<>(Result.getSuccessCode(), "股票已经关注", status);
//            } else {
//                result = new Result<>(Result.getEmptyCode(), "股票还未关注");
//            }
//        } catch (Exception e) {
//            result = new Result<>(Result.getFailCode(), "获取信息失败");
//            e.printStackTrace();
//        }
        return new Result(stockInfo);
    }

    @Override
    public Result updateCancenAttention(StockDTO dto) {
//        Result result;
//        try {
        stockDAO.cancenAttention(dto);
//            result = new Result<>(Result.getSuccessCode(), "取消关注股票成功");
//        } catch (Exception e) {
//            result = new Result<>(Result.getFailCode(), "取消关注股票失败");
//            e.printStackTrace();
//        }
        return new Result();
    }

}