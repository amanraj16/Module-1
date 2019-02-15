package com.capgemini.salesmanagement.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.salesmanagement.exceptions.InvalidProductCategoryException;
import com.capgemini.salesmanagement.exceptions.InvalidProductCodeException;
import com.capgemini.salesmanagement.exceptions.InvalidProductNameException;
import com.capgemini.salesmanagement.exceptions.InvalidProductPriceException;
import com.capgemini.salesmanagement.exceptions.InvalidQuantityException;
import com.capgemini.salesmanagement.service.SaleService;

public class TestApp {
SaleService saleService=new SaleService();
	@Test(expected=com.capgemini.salesmanagement.exceptions.InvalidProductCodeException.class)
	public void whenProductCodeIsInvalid()throws InvalidProductCodeException, InvalidProductPriceException, InvalidProductNameException, InvalidProductCategoryException, InvalidQuantityException {
		saleService.insertSalesDetails(Math.random(),1008, "Electronics", "TV",2,10000);
		
	}
	@Test(expected=com.capgemini.salesmanagement.exceptions.InvalidProductCategoryException.class)
	public void whenInvalidProductCategoryIsEntered()throws InvalidProductCategoryException, InvalidProductPriceException, InvalidProductNameException, InvalidQuantityException, InvalidProductCodeException
	{
		saleService.insertSalesDetails(Math.random(), 1001,"Car", "TV", 1,10000);
	}
	@Test(expected=com.capgemini.salesmanagement.exceptions.InvalidProductPriceException.class)
	public void whenProductPriceIsInvalid() throws InvalidProductPriceException, InvalidProductNameException, InvalidProductCategoryException, InvalidQuantityException, InvalidProductCodeException
	{
		saleService.insertSalesDetails(Math.random(),1001,"Toys","Telescope",1,100);
	}
	@Test(expected=com.capgemini.salesmanagement.exceptions.InvalidQuantityException.class)
	public void whenProductQuantityIsInvalid() throws InvalidProductPriceException, InvalidProductNameException, InvalidProductCategoryException, InvalidQuantityException, InvalidProductCodeException
	{
		saleService.insertSalesDetails(Math.random(),1001,"Electronics","TV",10,500);
	}
	@Test(expected=com.capgemini.salesmanagement.exceptions.InvalidProductNameException.class)
	public void whenInvalidProductNameIsEntered() throws InvalidProductPriceException, InvalidProductNameException, InvalidProductCategoryException, InvalidQuantityException, InvalidProductCodeException
	{
		saleService.insertSalesDetails(Math.random(),1001,"Electronics","Mouse",1,10000);
	}
}
