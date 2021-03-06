package com.wzh.paper.controller;

import com.github.pagehelper.PageInfo;
import com.wzh.paper.dto.StockDTO;
import com.wzh.paper.entity.Result;
import com.wzh.paper.entity.StockInfo;
import com.wzh.paper.service.StockService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/stock")
public class StockController {

    @Resource
    private StockService stockService;

    //分页展示股市行情数据
    @ResponseBody
    @RequestMapping(value = "/listStockInfo", method = RequestMethod.POST)
    public Result<PageInfo<List<StockInfo>>> listStockInfo(@RequestBody StockDTO dto){
        return stockService.listStockInfoSelect(dto);
    }

    //用图表展示股票价格
    @ResponseBody
    @RequestMapping(value = "/listStockByChart", method = RequestMethod.POST)
    public Result<List<StockInfo>> listStockByChart(@RequestBody StockDTO dto){
        return stockService.listStockByChartSelect(dto);
    }

    //根据股票代码，名称模糊查询
    @ResponseBody
    @RequestMapping(value = "/listStockName", method = RequestMethod.POST)
    public Result<List<StockInfo>> listStockName(@RequestBody StockDTO dto){
        return stockService.listStockNameSelect(dto);
    }

    //根据股票代码，查询股票详细信息
    @ResponseBody
    @RequestMapping(value = "/getSymbolLastInfo", method = RequestMethod.POST)
    public Result<StockInfo> getSymbolLastInfo(@RequestBody StockDTO dto){
        return stockService.getSymbolLastInfoSelect(dto);
    }

    //购买股票
    @ResponseBody
    @RequestMapping(value = "/buyStock", method = RequestMethod.POST)
    public Result buyStock(@RequestBody StockDTO stockDTO){
        return stockService.saveBuyStock(stockDTO);
    }

    //卖出股票
    @ResponseBody
    @RequestMapping(value = "/sellStock", method = RequestMethod.POST)
    public Result sellStock(@RequestBody StockDTO StockDTO){
        return stockService.saveSellStock(StockDTO);
    }

    //关注股票
    @ResponseBody
    @RequestMapping(value = "/attentionStock", method = RequestMethod.POST)
    public Result attentionStock(@RequestBody StockDTO dto){
        return stockService.updateAttentionStock(dto);
    }

    //判断是否已经关注股票
    @ResponseBody
    @RequestMapping(value = "/isAttention", method = RequestMethod.POST)
    public Result isAttention(@RequestBody StockDTO dto){
        return stockService.isAttentionSelect(dto);
    }

    //取消关注股票
    @ResponseBody
    @RequestMapping(value = "/cancenAttention", method = RequestMethod.POST)
    public Result cancenAttention(@RequestBody StockDTO dto){
        return stockService.updateCancenAttention(dto);
    }

    //已经关注的股票列表
    @ResponseBody
    @RequestMapping(value = "/listAttentionStock", method = RequestMethod.POST)
    public Result<List<StockInfo>> listAttentionStockSelect(@RequestBody StockDTO dto){
        return stockService.listAttentionStockSelect(dto);
    }

    //已经购买的股票列表
    @ResponseBody
    @RequestMapping(value = "/listBuyStock", method = RequestMethod.POST)
    public Result<List<StockInfo>> listBuyStockSelect(@RequestBody StockDTO dto){
        return stockService.listBuyStockSelect(dto);
    }

    //交易记录列表
    @ResponseBody
    @RequestMapping(value = "/listStockDistory", method = RequestMethod.POST)
    public Result<List<StockInfo>> listStockDistorySelect(@RequestBody StockDTO dto){
        return stockService.listStockDistorySelect(dto);
    }
}
