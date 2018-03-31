package com.wzh.paper.controller;

import com.github.pagehelper.Page;
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
        return stockService.listStockInfo(dto);
    }

    //用图表展示股票价格
    @ResponseBody
    @RequestMapping(value = "/listStockByChart", method = RequestMethod.POST)
    public Result<List<StockInfo>> listStockByChart(@RequestBody StockDTO dto){
        return stockService.listStockByChart(dto);
    }

    //根据股票代码，名称模糊查询
    @ResponseBody
    @RequestMapping(value = "/listStockName", method = RequestMethod.POST)
    public Result<List<StockInfo>> listStockName(@RequestBody StockDTO dto){
        return stockService.listStockName(dto);
    }

    //根据股票代码，查询股票详细信息
    @ResponseBody
    @RequestMapping(value = "/getSymbolLastInfo", method = RequestMethod.POST)
    public Result<StockInfo> getSymbolLastInfo(@RequestBody StockDTO dto){
        return stockService.getSymbolLastInfo(dto);
    }

    //购买股票
    @ResponseBody
    @RequestMapping(value = "/buyStock", method = RequestMethod.POST)
    public Result buyStock(@RequestBody StockDTO StockDTO){
        return stockService.buyStock(StockDTO);

    }

    //加入自选
    @ResponseBody
    @RequestMapping(value = "/attentionStock", method = RequestMethod.POST)
    public Result attentionStock(@RequestBody StockDTO dto){
        return stockService.attentionStock(dto);
    }

    //判断是否已经关注股票
    @ResponseBody
    @RequestMapping(value = "/isAttention", method = RequestMethod.POST)
    public Result isAttention(@RequestBody StockDTO dto){
        return stockService.isAttention(dto);
    }

    //判断是否已经关注股票
    @ResponseBody
    @RequestMapping(value = "/cancenAttention", method = RequestMethod.POST)
    public Result cancenAttention(@RequestBody StockDTO dto){
        return stockService.cancenAttention(dto);
    }

    @ResponseBody
    @RequestMapping(value = "/listAttentionStock", method = RequestMethod.POST)
    public Result<List<StockInfo>> listAttentionStockSelect(@RequestBody StockDTO dto){
        return stockService.listAttentionStockSelect(dto);
    }

}
