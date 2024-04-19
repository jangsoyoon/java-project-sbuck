package com.team2.sbucks.dto;

import java.util.Date;

/*
 * 이름               널?       유형         
---------------- -------- ---------- 
ORDERDETAIL_NO   NOT NULL NUMBER(10) 
ORDER_NO                  NUMBER(10) 
ORDER_QTY                 NUMBER(10) 
ORDER_STMT                NUMBER(10) 
PRODUCT_NO                NUMBER(10) 
PRODUCT_ESPRESSO          NUMBER(10) 
PRODUCT_SYRUP             NUMBER(10) 
 */

public class OrderDetail {
	private int orderdetail_no;
	private int order_no;
	private int order_qty;
	private int order_stmt;
	private Product product;

	private int product_espresso;
	private int product_syrup;
	
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}
	
	

	public OrderDetail(int orderdetail_no, int order_no, int order_qty, int order_stmt, Product product,
			int product_espresso, int product_syrup) {
		super();
		this.orderdetail_no = orderdetail_no;
		this.order_no = order_no;
		this.order_qty = order_qty;
		this.order_stmt = order_stmt;
		this.product = product;
		this.product_espresso = product_espresso;
		this.product_syrup = product_syrup;
	}



	@Override
	public String toString() {
		return "OrderDetail [orderdetail_no=" + orderdetail_no + ", order_no=" + order_no + ", order_qty=" + order_qty
				+ ", order_stmt=" + order_stmt + ", product=" + product + ", product_espresso=" + product_espresso
				+ ", product_syrup=" + product_syrup + "]";
	}



	public int getOrderdetail_no() {
		return orderdetail_no;
	}



	public void setOrderdetail_no(int orderdetail_no) {
		this.orderdetail_no = orderdetail_no;
	}



	public int getOrder_no() {
		return order_no;
	}



	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}



	public int getOrder_qty() {
		return order_qty;
	}



	public void setOrder_qty(int order_qty) {
		this.order_qty = order_qty;
	}



	public int getOrder_stmt() {
		return order_stmt;
	}



	public void setOrder_stmt(int order_stmt) {
		this.order_stmt = order_stmt;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public int getProduct_espresso() {
		return product_espresso;
	}



	public void setProduct_espresso(int product_espresso) {
		this.product_espresso = product_espresso;
	}



	public int getProduct_syrup() {
		return product_syrup;
	}



	public void setProduct_syrup(int product_syrup) {
		this.product_syrup = product_syrup;
	}
	

	
	
	
	
	
}
