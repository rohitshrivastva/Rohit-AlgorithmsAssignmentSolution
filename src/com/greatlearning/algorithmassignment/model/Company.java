package com.greatlearning.algorithmassignment.model;

/*
 * @author: Rohit Shrivastva
 * 
 * @description: This class defines the structure of Company. It contains todaysStockPrice and todayStockStatus
 * 
 * 
 */

public class Company {

	private double stockPriceToday;
	private boolean stockStatusToday;

	public double getStockPrice() {
		return stockPriceToday;
	}

	public void setStockPrice(double stockPriceToday) {
		this.stockPriceToday = stockPriceToday;
	}

	public boolean isStockStatusToday() {
		return stockStatusToday;
	}

	public void setStockStatusToday(boolean stockStatusToday) {
		this.stockStatusToday = stockStatusToday;
	}

}
