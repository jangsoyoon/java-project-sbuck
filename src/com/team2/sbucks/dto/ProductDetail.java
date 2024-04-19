package com.team2.sbucks.dto;

public class ProductDetail {
	private int product_no;
	private int kal;
	private int caffeine;
	private int na;
	
	public ProductDetail() {
		
	}

	public ProductDetail(int product_no, int kal, int caffeine, int na) {
		super();
		this.product_no = product_no;
		this.kal = kal;
		this.caffeine = caffeine;
		this.na = na;
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public int getKal() {
		return kal;
	}

	public void setKal(int kal) {
		this.kal = kal;
	}

	public int getCaffeine() {
		return caffeine;
	}

	public void setCaffeine(int caffeine) {
		this.caffeine = caffeine;
	}

	public int getNa() {
		return na;
	}

	public void setNa(int na) {
		this.na = na;
	}

	@Override
	public String toString() {
		return "ProductDetail [product_no=" + product_no + ", kal=" + kal + ", caffeine=" + caffeine + ", na=" + na
				+ "]";
	}
	
}
