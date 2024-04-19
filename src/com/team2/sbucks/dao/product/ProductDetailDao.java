package com.team2.sbucks.dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.team2.sbucks.common.DataSource;
import com.team2.sbucks.dto.ProductDetail;




public class ProductDetailDao {
	private DataSource dataSource;
	public ProductDetailDao() {
		dataSource = new DataSource();
	}
	
	public int insertProuductdetail(ProductDetail productDetail) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductDetailSQL.PRODUCTDETAIL_INSERT);
		pstmt.setInt(1, productDetail.getProduct_no());
		pstmt.setInt(2, productDetail.getKal());
		pstmt.setInt(3, productDetail.getCaffeine());
		pstmt.setInt(4, productDetail.getNa());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	public int updateProuductDetail(ProductDetail productDetail) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductDetailSQL.PRODUCTDETAIL_UPDATE);
		pstmt.setInt(1, productDetail.getKal());
		pstmt.setInt(2, productDetail.getCaffeine());
		pstmt.setInt(3, productDetail.getNa());
		pstmt.setInt(4, productDetail.getProduct_no());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	public int deleteProuductDetail(int product_no) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductDetailSQL.PRODUCTDETAIL_DELETE);
		pstmt.setInt(1, product_no);
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	public ProductDetail selectByNo(int product_no) throws Exception{
		ProductDetail findProductDetail = null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductDetailSQL.PRODUCTDETAIL_SELECT_BY_NO);
		pstmt.setInt(1, product_no);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			findProductDetail = new ProductDetail(rs.getInt("product_no"),
												  rs.getInt("kal"),
												  rs.getInt("caffeine"),
												  rs.getInt("na"));
		}
		rs.close();
		pstmt.close();
		con.close();
		return findProductDetail;
		
	}
	
	public List<ProductDetail> selectAll() throws Exception{
		List<ProductDetail> productDetailList = new ArrayList<ProductDetail>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductDetailSQL.PRODUCTDETAIL_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			productDetailList.add(new ProductDetail(rs.getInt("product_no"),
													rs.getInt("kal"),
													rs.getInt("caffeine"),
													rs.getInt("na")));
		}
		rs.close();
		pstmt.close();
		con.close();
		return productDetailList;
	}
}
