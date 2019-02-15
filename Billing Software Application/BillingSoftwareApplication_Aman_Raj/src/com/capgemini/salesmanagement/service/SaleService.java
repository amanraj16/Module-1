package com.capgemini.salesmanagement.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.capgemini.salesmanagement.bean.Sale;
import com.capgemini.salesmanagement.dao.ISaleDAO;
import com.capgemini.salesmanagement.dao.SaleDAO;
import com.capgemini.salesmanagement.exceptions.InvalidProductCategoryException;
import com.capgemini.salesmanagement.exceptions.InvalidProductCodeException;
import com.capgemini.salesmanagement.exceptions.InvalidProductNameException;
import com.capgemini.salesmanagement.exceptions.InvalidProductPriceException;
import com.capgemini.salesmanagement.exceptions.InvalidQuantityException;


public class SaleService implements ISaleService {
	private static Scanner scanner=new Scanner(System.in);
	ISaleDAO iSaleDAO=new SaleDAO();
	public SaleService() {
		super();
		
	}

	public SaleService(ISaleDAO iSaleDAO) {
		super();
		this.iSaleDAO = iSaleDAO;
	}

	@Override
	public Sale insertSalesDetails(double saleId,int prodCode,String category,String productName,int quantity,float price) throws InvalidProductPriceException, InvalidProductNameException, InvalidProductCategoryException, InvalidQuantityException, InvalidProductCodeException {
		SaleService ss=new SaleService();
		Sale sale=new Sale();
		if(ss.validateProductCode(prodCode))
		{
			sale.setProdCode(prodCode);
				if(ss.validateProductCat(category))
				{
					sale.setCategory(category);
					if(ss.validateProductName(productName))
					{
						sale.setProductName(productName);
						if(ss.validateQuantity(quantity))
						{
							sale.setQuantity(quantity);
						if(ss.validateProductPrice(price))
						{
							sale.setPrice(price);
							return sale;
						}
						else
							throw new InvalidProductPriceException("Product Price Is Invalid");
					}
					else
						throw new InvalidQuantityException("Invalid Product Quantity");
				}
				else
					throw new InvalidProductCategoryException("Invalid Product Name");
			}
			else 
				throw new InvalidProductCategoryException("Invalid Product Category");
		}
		else 
			throw new InvalidProductCodeException("Invalid Product Code");
	}

	@Override
	public boolean validateProductCode(int productId) {
			if(productId==1001||productId==1002||productId==1003||productId==1004)
				return true;
			else
				return false;
	}

	@Override
	public boolean validateQuantity(int qty) {
		if(qty>0&&qty<5)
			return true;
		else
			return false;
	}

	@Override
	public boolean validateProductCat(String prodCat) {
		
		if(prodCat.equals("Electronics")||Pattern.matches("Toys",prodCat))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean validateProductName(String prodName) {
		
		if(prodName.equals("TV")||Pattern.matches("Smart phone",prodName)||Pattern.matches("Video Game",prodName)||Pattern.matches("Soft Toy",prodName)||Pattern.matches("Telescope",prodName)||Pattern.matches("Barbee Doll",prodName))
				return true;
		return false;
	}
	@Override
	public boolean validateProductPrice(float price) {
		
		if(price>200)
			return true;
			return false;
	}

}
