package com.capgemini.salesmanagement.view;

import java.time.LocalDate;
import java.util.Scanner;

import com.capgemini.salesmanagement.bean.Sale;
import com.capgemini.salesmanagement.service.SaleService;

public class AppTesting {
	private static Scanner scanner=new Scanner(System.in);
	static SaleService ss=new SaleService();
	public static void main(String[] args) {
		double saleId=Math.random();
		System.out.println("Enter Product Code");
		int prodCode=scanner.nextInt();
		System.out.println("Enter Product Category");
		String prodCat=scanner.next();
		System.out.println("Enter Product Name");
		String prodName =scanner.next();
		System.out.println("Enter Product Quantity");
		int quantity=scanner.nextInt();
		System.out.println("Enter Product Price");
		float price=scanner.nextFloat();
		try {
			Sale sale=ss.insertSalesDetails(saleId, prodCode, prodCat, prodName, quantity,price);
			double lineTotal=sale.getPrice()*sale.getQuantity();
			System.out.println("Product Code : "+sale.getProdCode());
			System.out.println("Product Quantity : "+sale.getQuantity());
			System.out.println("Product Category : "+sale.getCategory());
			System.out.println("Product Name: "+sale.getProductName());
			System.out.println("Product Price : "+sale.getPrice());
			System.out.println("Line Total : "+lineTotal);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
