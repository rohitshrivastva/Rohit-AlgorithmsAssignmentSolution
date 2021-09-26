package com.greatlearning.algorithmassignment.services;

import com.greatlearning.algorithmassignment.model.Company;

/*
 * @author: Rohit Shrivastva
 * 
 * @description: This class is implementation of Merge Sort Algorithm. It will sort the Company array in asc/desc order
 * 
 * The time complexity for this algorithm is O(n log(n))
 * 
 * 
 */

public class MergeSortImplementation {

	void sort(Company[] arr, int l, int r, String order) {
		if (l < r) {
			int m = l + (r - l) / 2;

			sort(arr, l, m, order);
			sort(arr, m + 1, r, order);

			merge(arr, l, m, r, order);
		}
	}

	void merge(Company arr[], int l, int m, int r, String order) {

		int n1 = m - l + 1;
		int n2 = r - m;

		Company L[] = new Company[n1];
		Company R[] = new Company[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {

			if (order.equalsIgnoreCase("asc")) {
				if (L[i].getStockPrice() <= R[j].getStockPrice()) {
					arr[k] = L[i];
					i++;
				} else {
					arr[k] = R[j];
					j++;
				}
				k++;
			}

			if (order.equalsIgnoreCase("desc")) {
				if (L[i].getStockPrice() >= R[j].getStockPrice()) {
					arr[k] = L[i];
					i++;
				} else {
					arr[k] = R[j];
					j++;
				}
				k++;
			}

		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

}
