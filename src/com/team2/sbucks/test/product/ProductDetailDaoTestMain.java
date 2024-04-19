package com.team2.sbucks.test.product;

import java.util.List;

import com.team2.sbucks.dao.product.ProductDetailDao;
import com.team2.sbucks.dto.ProductDetail;




public class ProductDetailDaoTestMain {

	public static void main(String[] args) throws Exception {
		ProductDetailDao productDetailDao = new ProductDetailDao();
		
		/*
		 * 영양정보상세리스트 보기
		 */
		System.out.println(productDetailDao.selectByNo(1));
		/*
		 * 전체메뉴 영양정보보기
		 */
		List<ProductDetail> productDetailList = productDetailDao.selectAll();
		System.out.println(productDetailList);
		/*
		 * 영양정보추가
		 */
		ProductDetail insertProductDetail = new ProductDetail(11, 0, 0, 0);
		productDetailDao.insertProuductdetail(insertProductDetail);
		/*
		 * 영양정보업데이트
		 */
		ProductDetail updateProductDetail = new ProductDetail(11, 125, 30, 5);
		productDetailDao.updateProuductDetail(updateProductDetail);
		/*
		 * 영양정보삭제
		 */
		productDetailDao.deleteProuductDetail(11);
	}
}
