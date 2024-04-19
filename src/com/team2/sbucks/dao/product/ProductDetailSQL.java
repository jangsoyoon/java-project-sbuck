package com.team2.sbucks.dao.product;

public class ProductDetailSQL {
	public static final String PRODUCTDETAIL_INSERT
	="insert into productdetail values(?,?,?,?)";
	public static final String PRODUCTDETAIL_UPDATE
	="update productdetail set kal = ?, caffeine = ?, na = ? where product_no = ?";
	public static final String PRODUCTDETAIL_DELETE
	="delete from productdetail where product_no =?"; 
	public static final String PRODUCTDETAIL_SELECT_BY_NO
	="select * from productdetail where product_no = ?";
	public static final String PRODUCTDETAIL_SELECT_ALL
	="select * from productdetail";
}
