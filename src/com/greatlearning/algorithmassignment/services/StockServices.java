package com.greatlearning.algorithmassignment.services;

import com.greatlearning.algorithmassignment.model.Company;

public class StockServices {

	MergeSortImplementation mergeSortImpl = new MergeSortImplementation();
	BinarySearchImplementation binarySearchImpl = new BinarySearchImplementation();

	/*
	 * @author: Rohit Shrivastva
	 * 
	 * @description: This method will return the count the total number of companies
	 * for which price rose/declined today
	 *
	 * @param: company[] array, boolean status
	 * 
	 */

	public int noOfCompaniesByStockStatus(Company[] company, boolean status) {

		int count = 0;

		for (Company stock : company) {
			if (stock.isStockStatusToday() == status)
				count++;
		}

		return count;
	}

	/*
	 * @author: Rohit Shrivastva
	 * 
	 * @description: This method will find specific stock present in the company or
	 * not
	 * 
	 * It will first sort the array with merge sort and then find the element with binary search
	 * 
	 * Time Complexity for this method will be O(n log(n))
	 *
	 * @param: company[] array, double
	 * 
	 */

	public void searchStock(Company[] companies, double stock) {

		mergeSortImpl.sort(companies, 0, companies.length - 1, "asc");

		int index = binarySearchImpl.binarySearch(companies, 0, 0, stock);

		if (index != -1) {
			System.out.println("Stock of value " + stock + " is present ");
		} else {
			System.out.println("Value not found");
		}
	}

	/*
	 * @author: Rohit Shrivastva
	 * 
	 * @description: This method will find specific stock present in the company or
	 * not
	 *
	 * @param: company[] array, boolean status
	 * 
	 */

	public void displayNoOfStocks(Company[] companies, boolean status) {

		int count = this.noOfCompaniesByStockStatus(companies, status);

		if (status) {
			System.out.println("Total no of companies whose stock price rose today : " + count);
		} else {
			System.out.println("Total no of companies whose stock price declined today : " + count);
		}
	}

	/*
	 * @author: Rohit Shrivastva
	 * 
	 * @description: This method will display companies stock prices in desc/asc
	 * order
	 *
	 * @param: company[] array, String order
	 * 
	 */

	public void displayStocks(Company[] companies, String order) {

		mergeSortImpl.sort(companies, 0, companies.length - 1, order);

		if (order.equals("asc"))
			System.out.println("Stock prices in ascending order are :");
		else
			System.out.println("Stock prices in descending order are :");

		for (int i = 0; i < companies.length; i++) {
			System.out.print(companies[i].getStockPrice() + " ");
		}
	}

}
