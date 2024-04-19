package com.team2.sbucks.dto;
/*
이름               널?       유형         
---------------- -------- ---------- 
CART_NO          NOT NULL NUMBER(10) 
PRODUCT_NO                NUMBER(10) 
MEMBER_NO                 NUMBER(10) 
CART_QTY                  NUMBER(10) 
PRODUCT_ESPRESSO          NUMBER(10) 
PRODUCT_SYRUP             NUMBER(10)
*/

public class Cart {
	private int cart_no;
	private Product product;
	private int member_no;
	private int cart_qty;
	private int product_espresso;
	private int product_syrup;
	
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	
	


	public Cart(int cart_no, Product product, int member_no, int cart_qty, int product_espresso, int product_syrup) {
		super();
		this.cart_no = cart_no;
		this.product = product;
		this.member_no = member_no;
		this.cart_qty = cart_qty;
		this.product_espresso = product_espresso;
		this.product_syrup = product_syrup;
	}




	public int getCart_no() {
		return cart_no;
	}


	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public int getMember_no() {
		return member_no;
	}


	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}


	public int getCart_qty() {
		return cart_qty;
	}


	public void setCart_qty(int cart_qty) {
		this.cart_qty = cart_qty;
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




	@Override
	public String toString() {
		return "Cart [cart_no=" + cart_no + ", product=" + product + ", member_no=" + member_no + ", cart_qty="
				+ cart_qty + ", product_espresso=" + product_espresso + ", product_syrup=" + product_syrup + "]\n";
	}
	
	
	
	



	}
