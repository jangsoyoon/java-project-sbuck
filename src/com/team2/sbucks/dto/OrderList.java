package com.team2.sbucks.dto;
/*
 * 이름          널?       유형         
----------- -------- ---------- 
ORDER_NO    NOT NULL NUMBER(10) 
ORDER_DATE           DATE       
MEMBER_NO            NUMBER(10) 
ORDER_PRICE          NUMBER(10) 
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderList {

	private int order_no;
	private Date order_date;
	private int member_no;
	private int order_price;
	private List<OrderDetail> orderDetail=new ArrayList<OrderDetail>();

	public OrderList() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

	public OrderList(int order_no, Date order_date, int member_no, int order_price) {
		super();
		this.order_no = order_no;
		this.order_date = order_date;
		this.member_no = member_no;
		this.order_price = order_price;
	}







	public OrderList(int order_no, Date order_date, int member_no, int order_price, List<OrderDetail> orderDetail) {
		super();
		this.order_no = order_no;
		this.order_date = order_date;
		this.member_no = member_no;
		this.order_price = order_price;
		this.orderDetail = orderDetail;
	}



	



	public Date getOrder_date() {
		return order_date;
	}







	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}







	public int getOrder_price() {
		return order_price;
	}







	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}







	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}







	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}







	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}







	@Override
	public String toString() {
		return "Order2 [order_no=" + order_no + ", order_date=" + order_date + ", member_no=" + member_no
				+ ", order_price=" + order_price + ", orderDetail=" + orderDetail + "]";
	}
	
	
	

	

}
