package com.capgemini.salesmanagement.service;

import java.time.LocalDate;
import java.util.HashMap;

import com.capgemini.salesmanagement.bean.Sale;
import com.capgemini.salesmanagement.exceptions.InvalidProductCategoryException;
import com.capgemini.salesmanagement.exceptions.InvalidProductCodeException;
import com.capgemini.salesmanagement.exceptions.InvalidProductNameException;
import com.capgemini.salesmanagement.exceptions.InvalidProductPriceException;
import com.capgemini.salesmanagement.exceptions.InvalidQuantityException;

public interface ISaleService {
	public Sale insertSalesDetails(double saleId,int prodCode,String category,String productName,int quantity,float price) throws InvalidProductPriceException, InvalidProductNameException, InvalidProductCategoryException, InvalidQuantityException, InvalidProductCodeException;
	public boolean validateProductCode(int productId);
	public boolean validateQuantity(int qty);
	public boolean validateProductCat(String prodCat);
	public boolean validateProductName(String prodName);
	public boolean validateProductPrice(float price);
}
