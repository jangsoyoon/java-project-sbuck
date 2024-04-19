package com.team2.sbucks.test.order;

import com.team2.sbucks.dao.order.CartDao;
import com.team2.sbucks.dao.product.ProductDao;
import com.team2.sbucks.dto.Cart;
import com.team2.sbucks.dto.Product;

public class CartDaoTest {
	public static void main(String[] args) throws Exception {
		CartDao cartDao = new CartDao();
		ProductDao productDao = new ProductDao();

		Product product3 = productDao.selectByNo(3);
		product3.setProduct_espresso(2);
		product3.setProduct_syrup(3);

		System.out.println(product3);

		// 1번 회원에게 3번 상품 4개 - (샷 2번 / 시럽 3번 추가)

		Cart newCartItem = new Cart(0, product3, 1, 4, product3.getProduct_espresso(), product3.getProduct_syrup());

		// System.out.println("카트에 입력:"+cartDao.addCart(newCartItem));

		System.out.println(cartDao.selectbyMemberNo(1));

		System.out.println(cartDao.CartItemPrice(10));

		int memberNo = 3;

		System.out.println(memberNo + "번 회원 카트 삭제:" + cartDao.deleteAllCart(memberNo));

		Cart checkCartItem = new Cart(0, productDao.selectByNo(3), 1, 4, 0, 0);
		// boolean check=cartDao.checkProductCount(newCartItem);
		int check = cartDao.returnCartno(checkCartItem);

		System.out.println(check);

		if (cartDao.returnCartno(checkCartItem) == 0) {
			System.out.println("존재하지 않는 상품이므로 새롭게 추가");

			cartDao.addCart(checkCartItem);
		} else {
			cartDao.addProductCount(30, check);
			System.out.println("이미 존재하는 상품이므로 수량 추가");

		}

		if (cartDao.checkProductCount(newCartItem) == false) {
			cartDao.addCart(newCartItem);
			System.out.println("존재하지 않는 상품이므로 새롭게 추가");
		} else {
			check = cartDao.returnCartno(newCartItem);
			cartDao.addProductCount(100, check);
			System.out.println("이미 존재하는 상품이므로 수량 추가");
		}
		
		cartDao.addProductCount(100, 1);
		

	}

}
