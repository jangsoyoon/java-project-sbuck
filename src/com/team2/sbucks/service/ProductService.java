package com.team2.sbucks.service;

import java.util.List;

import com.team2.sbucks.dao.product.ProductDao;
import com.team2.sbucks.dto.Product;




public class ProductService {
	private ProductDao productDao;
	public ProductService() {
		productDao=new ProductDao();
	}
	
	/*
	 * 상품검색(한개)
	 * 
	 */
	public Product selectByNo(int no) throws Exception{
		return productDao.selectByNo(no);
		
	}
	/*
	 * 상품 여러개 검색
	 */
	public List<Product> selectAll() throws Exception{
		return productDao.selectAll();
	}
}
