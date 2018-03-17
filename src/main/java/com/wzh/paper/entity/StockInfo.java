package com.wzh.paper.entity;

import java.util.Date;

public class StockInfo {
    private int symbol;   	             //代码,
    private String stockName;              	 //简称,
    private double lastTrade;        	 //最新价,
    private double chg;               	 //涨跌幅,
    private double stockChange;                //涨跌额,
    private double fiveMinCg;      	 //5分钟涨跌幅,
    private double volume;            	 //成交量(手),
    private double turnover;          	 //成交额（万元),
    private double turnoverRate;     	 //换手率,
    private double swing;             	 //振幅,
    private double qrr;               	 //量比,
    private double theCommittee;     	 //委比,
    private double peratio; 			 //市盈率
    private String stockDate;               //数据产生的时间

    public int getSymbol() {
        return symbol;
    }

    public void setSymbol(int symbol) {
        this.symbol = symbol;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public double getLastTrade() {
        return lastTrade;
    }

    public void setLastTrade(double lastTrade) {
        this.lastTrade = lastTrade;
    }

    public double getChg() {
        return chg;
    }

    public void setChg(double chg) {
        this.chg = chg;
    }

    public double getStockChange() {
        return stockChange;
    }

    public void setStockChange(double stockChange) {
        this.stockChange = stockChange;
    }

    public double getFiveMinCg() {
        return fiveMinCg;
    }

    public void setFiveMinCg(double fiveMinCg) {
        this.fiveMinCg = fiveMinCg;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getTurnover() {
        return turnover;
    }

    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }

    public double getTurnoverRate() {
        return turnoverRate;
    }

    public void setTurnoverRate(double turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    public double getSwing() {
        return swing;
    }

    public void setSwing(double swing) {
        this.swing = swing;
    }

    public double getQrr() {
        return qrr;
    }

    public void setQrr(double qrr) {
        this.qrr = qrr;
    }

    public double getTheCommittee() {
        return theCommittee;
    }

    public void setTheCommittee(double theCommittee) {
        this.theCommittee = theCommittee;
    }

    public double getPeratio() {
        return peratio;
    }

    public void setPeratio(double peratio) {
        this.peratio = peratio;
    }

    public String getStockDate() {
        return stockDate;
    }

    public void setStockDate(String stockDate) {
        this.stockDate = stockDate;
    }
}
