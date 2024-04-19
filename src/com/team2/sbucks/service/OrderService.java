package com.team2.sbucks.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.team2.sbucks.dao.order.CartDao;
import com.team2.sbucks.dao.order.OrderDao;
import com.team2.sbucks.dto.Cart;
import com.team2.sbucks.dto.OrderDetail;
import com.team2.sbucks.dto.OrderList;
import com.team2.sbucks.dto.Product;

public class OrderService {

	private OrderDao orderDao;
	private CartDao cartDao;

	public OrderService() {
		orderDao = new OrderDao();
		cartDao = new CartDao();
	}

	// 주문입력
	public int createOrder(OrderList order) throws Exception {
		return orderDao.create(order);
	}

	// 단품주문
	public int createOneOrder(int member_no, Product product, int qty) throws Exception {
		List<OrderDetail> orderdetailList = new ArrayList<OrderDetail>();
		orderdetailList.add(
				// OrderDetail(int orderdetail_no, int order_no, int order_qty, int order_stmt,
				// Product product, int product_espresso, int product_syrup)
				new OrderDetail(0, 0, qty, 0, product, product.getProduct_espresso(), product.getProduct_syrup()));
		OrderList order = new OrderList(0, null, member_no, orderDao.calOrderdetail(orderdetailList), orderdetailList);
		orderDao.create(order);
		return 0;
	}

	// 장바구니 전체 주문
	public int allCartToOrder(int memberNo) throws Exception {
		List<Cart> cartlist = new ArrayList<Cart>();
		cartlist = cartDao.selectbyMemberNo(memberNo);
		List<OrderDetail> orderdetailList = new ArrayList<OrderDetail>();

		for (Iterator iterator = cartlist.iterator(); iterator.hasNext();) {
			Cart cart = (Cart) iterator.next();
			orderdetailList.add(new OrderDetail(0, 0, cart.getCart_qty(), 0, cart.getProduct(),
					cart.getProduct_espresso(), cart.getProduct_syrup()));

		}
		OrderList order = new OrderList(0, null, memberNo, orderDao.calOrderdetail(orderdetailList), orderdetailList);
		orderDao.create(order);
		cartDao.deleteAllCart(memberNo);
		return 0;
	}
	
	//카트 선택된 단품들 주문
	public int cartitemToOrder(int memberNo,List<Cart> cartList) throws Exception{
		List<OrderDetail> orderdetailList = new ArrayList<OrderDetail>();

		for (Iterator iterator = cartList.iterator(); iterator.hasNext();) {
			Cart cart = (Cart) iterator.next();
			orderdetailList.add(new OrderDetail(0, 0, cart.getCart_qty(), 0, cart.getProduct(),
					cart.getProduct_espresso(), cart.getProduct_syrup()));
			cartDao.deleteCartItem(cart.getCart_no());
		}
		OrderList order = new OrderList(0, null, memberNo, orderDao.calOrderdetail(orderdetailList), orderdetailList);
		orderDao.create(order);
		
		return 0;
	}

	// 주문삭제
	public int deleteOrder(int order_no) throws Exception {
		return orderDao.deleteOrder(order_no);
	}

	// 주문 상태 변경
	public int changeOrderStmt(int orderdetail_no) throws Exception {
		return orderDao.updateOrder(orderdetail_no);
	}

	// 회원의 특정 주문내역1개 - 주문상세까지 출력

	public OrderList printOrder(int memberNo, int orderNo) throws Exception {
		OrderList selectOrder = orderDao.selectOrder(memberNo, orderNo);
		return selectOrder;
	}

	// 회원의 전체 주문내역 출력
	public List<OrderList> printAllOrderList(int memberNo) throws Exception {
		List<OrderList> memberOrderList = new ArrayList<OrderList>();
		memberOrderList = orderDao.selectAll(memberNo);
		return memberOrderList;
	}
}
