package com.team2.sbucks.service;

import java.util.ArrayList;
import java.util.List;

import com.team2.sbucks.dao.order.CartDao;
import com.team2.sbucks.dao.product.ProductDao;
import com.team2.sbucks.dto.Cart;
import com.team2.sbucks.dto.Product;

public class CartService {
	public CartDao cartDao;
	public ProductDao productDao;

	public CartService() {
		cartDao = new CartDao();
		productDao = new ProductDao();
	}

	// 카트 담기(수량체크후 담기) - 인자 3가지 경우
	public int insertCart(Cart cart) throws Exception {
		int cart_no = cartDao.returnCartno(cart);

		if (cartDao.returnCartno(cart) == 0) {
			System.out.println("존재하지 않는 상품이므로 새롭게 추가");
			cartDao.addCart(cart);
		} else {
			cartDao.addProductCount(cart.getCart_qty(), cart_no);
			System.out.println("이미 존재하는 상품이므로 수량 추가");
		}
		return 0;
	}

	public int insertCart(int productno, int member_no, int cart_qty, int espresso, int syrup) throws Exception {
		Cart newCart = new Cart(0, productDao.selectByNo(productno), member_no, cart_qty, espresso, syrup);

		int cart_no = cartDao.returnCartno(newCart);

		if (cartDao.returnCartno(newCart) == 0) {
			System.out.println("존재하지 않는 상품이므로 새롭게 추가");
			cartDao.addCart(newCart);
		} else {
			cartDao.addProductCount(newCart.getCart_qty(), cart_no);
			System.out.println("이미 존재하는 상품이므로 수량 추가");
		}
		return 0;
	}

	public int insertCart(Product product, int memberNo, int cart_qty) throws Exception {
		Cart newCart = new Cart(0, product, memberNo, cart_qty, product.getProduct_espresso(),
				product.getProduct_syrup());

		int cart_no = cartDao.returnCartno(newCart);

		if (cartDao.returnCartno(newCart) == 0) {
			System.out.println("존재하지 않는 상품이므로 새롭게 추가");
			cartDao.addCart(newCart);
		} else {
			cartDao.addProductCount(newCart.getCart_qty(), cart_no);
			System.out.println("이미 존재하는 상품이므로 수량 추가");
		}
		return 0;
	}

	// 카트에서 곧바로 수량 변경

	public int addProductCount(int qty, int cart_no) throws Exception {
		return cartDao.addProductCount(qty, cart_no);
	}

	// 카트 전체 삭제
	public int deleteCart(int memberNo) throws Exception {
		return cartDao.deleteAllCart(memberNo);
		
	}

	// 카트 아이템 하나 삭제
	public int deleteCartItem(int cart_no) throws Exception{
			return cartDao.deleteCartItem(cart_no);
		}

	// 회원의 카트 전체 출력
	public List<Cart> printCart(int memberNo) throws Exception {
		List<Cart> memberCartList = new ArrayList<Cart>();
		memberCartList = cartDao.selectbyMemberNo(memberNo);
		return memberCartList;

	}
	
	//카트 번호로 해당 카트 찾아서 출력
	public Cart selectCart(int cartNo) throws Exception{
		return cartDao.selectbyCartNo(cartNo);
	}

	// 카트 번호로 해당 카트 아이템 가격 출력
	public int cartItemPrice(int cartNo) throws Exception {
		return cartDao.CartItemPrice(cartNo);
	}

}
