package com.team2.sbucks.test.order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.team2.sbucks.dao.order.CartDao;
import com.team2.sbucks.dao.order.OrderDao;
import com.team2.sbucks.dao.product.ProductDao;
import com.team2.sbucks.dto.Cart;
import com.team2.sbucks.dto.OrderDetail;
import com.team2.sbucks.dto.OrderList;
import com.team2.sbucks.dto.Product;

public class OrderDaoTest {
	public static void main(String[] args) throws Exception {
		OrderDao orderdao = new OrderDao();
		ProductDao productDao = new ProductDao();
		CartDao cartDao=new CartDao();
		
		
		
		
		
		// 1번 회원이 3번 상품 4개 (에스프레소 1, 시럽0) 2번 상품 5개 (에스프레소 3, 시럽 3) 주문

		Product product3 = productDao.selectByNo(3);
		product3.setProduct_espresso(1);
		product3.setProduct_syrup(0);

		Product product2 = productDao.selectByNo(2);
		product2.setProduct_espresso(3);
		product2.setProduct_syrup(3);
		
		List<OrderDetail> orderdetailList = new ArrayList<OrderDetail>();
		orderdetailList.add(
				new OrderDetail(0, 0, 5, 0, product2, product2.getProduct_espresso(), product2.getProduct_syrup()));
		orderdetailList.add(
				new OrderDetail(0, 0, 4, 0, product3, product3.getProduct_espresso(), product3.getProduct_syrup()));
		
		
		
		OrderList newOrder=new OrderList(0, null, 1, orderdao.calOrderdetail(orderdetailList), orderdetailList);
		
		orderdao.create(newOrder);
		
		orderdetailList.clear();
		
		List<Cart> cartlist=cartDao.selectbyMemberNo(3);
		for (Iterator iterator = cartlist.iterator(); iterator.hasNext();) {
			Cart cart2 = (Cart) iterator.next();
			orderdetailList.add(new OrderDetail(0, 0, cart2.getCart_qty(), 0, cart2.getProduct(), cart2.getProduct_espresso(), cart2.getProduct_syrup()));
			
		}
		
		
		OrderList cartOrder=new OrderList(0, null, 3, orderdao.calOrderdetail(orderdetailList), orderdetailList);
		
		orderdao.create(cartOrder);
		
		System.out.println(orderdao.selectOrder(3, 34));
		
		System.out.println(orderdao.selectAll(3));
		
		orderdao.updateOrder(61);
		
		orderdao.deleteOrder(2);
	}

}
