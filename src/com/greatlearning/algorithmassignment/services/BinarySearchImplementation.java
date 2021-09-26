package com.greatlearning.algorithmassignment.services;

import com.greatlearning.algorithmassignment.model.Company;

public class BinarySearchImplementation {

	/*
	 * @author: Rohit Shrivastva
	 * 
	 * This method will search a stock in a companies array and return the index of
	 * Company if not found it will return -1
	 * 
	 * It will search the give stock price in O(log (n)) time
	 * 
	 *
	 * @param:Company[] arr, int l, int r, double x
	 * 
	 */

	int binarySearch(Company[] arr, int l, int r, double x) {
		if (r >= l) {
			int mid = l + (r - l) / 2;

			if (arr[mid].getStockPrice() == x)
				return mid;

			if (arr[mid].getStockPrice() > x)
				return binarySearch(arr, l, mid - 1, x);

			return binarySearch(arr, mid + 1, r, x);
		}
		return -1;
	}
}
