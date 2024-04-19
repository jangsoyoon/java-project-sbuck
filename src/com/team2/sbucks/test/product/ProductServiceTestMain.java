package com.team2.sbucks.test.product;

import com.team2.sbucks.service.ProductService;

public class ProductServiceTestMain {

	public static void main(String[] args) throws Exception {
		ProductService productService = new ProductService();
		/*
		 * 상품한개검색
		 * 
		 */
		System.out.println(productService.selectByNo(7));
		/*
		 * 상품전체검색
		 */
		System.out.println(productService.selectAll());
		
	}

}
