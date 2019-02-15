package com.capgemini.salesmanagement.dao;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.salesmanagement.bean.Sale;

public class SaleDAO implements ISaleDAO {
	private static Map<Integer,Sale> sales=new HashMap<Integer,Sale>();
	@Override
	public HashMap<Integer, Sale> insertSalesDetails(Sale sale) {
		sales.put(sale.getSaleId(),sale);
		return null;
	}
}
