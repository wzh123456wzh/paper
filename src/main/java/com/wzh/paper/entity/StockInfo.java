package com.wzh.paper.entity;

import java.util.*;

public class StockInfo {
    private String symbol;   	             //代码,
    private String stockName;              	 //简称,
    private Double lastTrade;        	 //最新价,
    private Double chg;               	 //涨跌幅,
    private Double stockChange;                //涨跌额,
    private Double fiveMinCg;          	 //5分钟涨跌幅,
    private Double volume;            	 //成交量(手),
    private Double turnover;          	 //成交额（万元),
    private Double turnoverRate;     	 //换手率,
    private Double swing;             	 //振幅,
    private Double qrr;               	 //量比,
    private Double theCommittee;     	 //委比,
    private Double peratio; 			 //市盈率
    private String stockDate;               //数据产生的时间
    private String value;               //扩展参数
    private String count;               //数量
    private String amount;               //总价

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Double getLastTrade() {
        return lastTrade;
    }

    public void setLastTrade(Double lastTrade) {
        this.lastTrade = lastTrade;
    }

    public Double getChg() {
        return chg;
    }

    public void setChg(Double chg) {
        this.chg = chg;
    }

    public Double getStockChange() {
        return stockChange;
    }

    public void setStockChange(Double stockChange) {
        this.stockChange = stockChange;
    }

    public Double getFiveMinCg() {
        return fiveMinCg;
    }

    public void setFiveMinCg(Double fiveMinCg) {
        this.fiveMinCg = fiveMinCg;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getTurnover() {
        return turnover;
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }

    public Double getTurnoverRate() {
        return turnoverRate;
    }

    public void setTurnoverRate(Double turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    public Double getSwing() {
        return swing;
    }

    public void setSwing(Double swing) {
        this.swing = swing;
    }

    public Double getQrr() {
        return qrr;
    }

    public void setQrr(Double qrr) {
        this.qrr = qrr;
    }

    public Double getTheCommittee() {
        return theCommittee;
    }

    public void setTheCommittee(Double theCommittee) {
        this.theCommittee = theCommittee;
    }

    public Double getPeratio() {
        return peratio;
    }

    public void setPeratio(Double peratio) {
        this.peratio = peratio;
    }

    public String getStockDate() {
        return stockDate;
    }

    public void setStockDate(String stockDate) {
        this.stockDate = stockDate;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
