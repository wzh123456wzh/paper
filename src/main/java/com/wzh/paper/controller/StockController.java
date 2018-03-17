package com.wzh.paper.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.wzh.paper.dto.StockDTO;
import com.wzh.paper.entity.MyPage;
import com.wzh.paper.entity.Result;
import com.wzh.paper.entity.StockInfo;
import com.wzh.paper.service.StockService;
import org.springframework.stereotype.Controller;
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
    public Result<PageInfo<List<StockInfo>>> listStockInfo(StockDTO dto){
        return stockService.listStockInfo(dto);
    }
}
