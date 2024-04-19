package com.team2.sbucks.dto;

public class Product {
	private int 	product_no;
	private String 	product_name;
	private int		product_price;
	private String	product_allergy;
	private String	product_content;
	private int		product_espresso;
	private int		product_syrup;
	private int product_syrupprice;
	private int product_espressoprice;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(int product_no, String product_name, int product_price, String product_allergy,
			String product_content, int product_espresso, int product_syrup, int product_syrupprice,
			int product_espressoprice) {
		super();
		this.product_no = product_no;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_allergy = product_allergy;
		this.product_content = product_content;
		this.product_espresso = product_espresso;
		this.product_syrup = product_syrup;
		this.product_syrupprice = product_syrupprice;
		this.product_espressoprice = product_espressoprice;
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public String getProduct_allergy() {
		return product_allergy;
	}

	public void setProduct_allergy(String product_allergy) {
		this.product_allergy = product_allergy;
	}

	public String getProduct_content() {
		return product_content;
	}

	public void setProduct_content(String product_content) {
		this.product_content = product_content;
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

	public int getProduct_syrupprice() {
		return product_syrupprice;
	}

	public void setProduct_syrupprice(int product_syrupprice) {
		this.product_syrupprice = product_syrupprice;
	}

	public int getProduct_espressoprice() {
		return product_espressoprice;
	}

	public void setProduct_espressoprice(int product_espressoprice) {
		this.product_espressoprice = product_espressoprice;
	}

	@Override
	public String toString() {
		return "Product [product_no=" + product_no + ", product_name=" + product_name + ", product_price="
				+ product_price + ", product_allergy=" + product_allergy + ", product_content=" + product_content
				+ ", product_espresso=" + product_espresso + ", product_syrup=" + product_syrup
				+ ", product_syrupprice=" + product_syrupprice + ", product_espressoprice=" + product_espressoprice
				+ "]";
	}

	
	
	
	
}