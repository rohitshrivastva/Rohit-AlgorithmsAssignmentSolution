package com.greatlearning.algorithmassignment.main;

import java.util.Scanner;

import com.greatlearning.algorithmassignment.model.Company;
import com.greatlearning.algorithmassignment.services.StockServices;

/*
 * @author: Rohit Shrivastva
 * 
 * @description: The Driver class is the entry point for the algorithm assignment problem
 * 
 */

public class Driver {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter no of companies ");
		int companiesCount = sc.nextInt();

		Company[] companies = new Company[companiesCount];

		StockServices services = new StockServices();
		Company company;

		if (companiesCount > 0) {

			for (int i = 0; i < companiesCount; i++) {
				company = new Company();
				System.out.println("Enter current stock price of the stocker " + (i + 1));
				double stock = sc.nextDouble();
				company.setStockPrice(stock);
				System.out.println("Whether stocker's stock price rose today compare to yesterday? (true/false))");
				String status = sc.next();
				if (status.equalsIgnoreCase("true") || status.equalsIgnoreCase("t")) {
					company.setStockStatusToday(true);
				} else if (status.equalsIgnoreCase("false") || status.equalsIgnoreCase("f")) {
					company.setStockStatusToday(false);
				} else {
					System.out.println("Try with correct input");
				}
				companies[i] = company;

			}
		}

		int choice = 0;
		do {
			System.out.println("\n----------------------------------------------------");
			System.out.println("Enter the operation that you want to perform");
			System.out.println("1. Display the companies stock prices in ascending order");
			System.out.println("2. Display the companies stock prices in descending order");
			System.out.println("3. Display the total no of companies for which stock prices rose today");
			System.out.println("4. Display the total no of companies for which stock prices declined today");
			System.out.println("5. Search a specific stock price");
			System.out.println("0. press 0 to exit");
			System.out.println("----------------------------------------------------\n");

			choice = sc.nextInt();
			company = new Company();

			switch (choice) {
			case 1:
				services.displayStocks(companies, "asc");
				break;

			case 2:
				services.displayStocks(companies, "desc");
				break;

			case 3:
				services.displayNoOfStocks(companies, true);
				break;

			case 4:
				services.displayNoOfStocks(companies, false);
				break;

			case 5:
				System.out.println("enter the key value");
				double stockValue = sc.nextDouble();
				services.searchStock(companies, stockValue);

				break;

			case 0:
				System.out.println("Exited successfully !!!");
				System.exit(0);

			default:
				System.out.println("Wrong choice");
			}

		} while (choice != 0);

		sc.close();
	}

}
