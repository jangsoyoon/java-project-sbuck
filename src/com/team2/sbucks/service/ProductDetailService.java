package com.team2.sbucks.service;

import java.util.List;

import com.team2.sbucks.dao.product.ProductDetailDao;
import com.team2.sbucks.dto.ProductDetail;





public class ProductDetailService {
	private ProductDetailDao productDetailDao;
	public ProductDetailService() {
		productDetailDao=new ProductDetailDao();
	}
	
	/*
	 * 영양정보검색(메뉴한개)
	 * 
	 */
	public ProductDetail selectByNo(int no) throws Exception{
		return productDetailDao.selectByNo(no);
		
	}
	/*
	 * 영양정보전체 검색
	 */
	public List<ProductDetail> selectAll() throws Exception{
		return productDetailDao.selectAll();
	}
}
