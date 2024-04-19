package com.team2.sbucks.dao.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.team2.sbucks.common.DataSource;
import com.team2.sbucks.dto.Cart;
import com.team2.sbucks.dto.Product;

public class CartDao {

	private DataSource dataSource;

	public CartDao() {
		// TODO Auto-generated constructor stub
		dataSource = new DataSource();
	}

	// 회원의 카트에 상품 추가
	public int addCart(Cart cartitem) throws Exception {
		String addCartSQL = "insert into cart(cart_no,product_no,member_no,cart_qty,product_espresso,product_syrup) values(cart_cart_no_seq.nextval,?,?,?,?,?)";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(addCartSQL);

		pstmt.setInt(1, cartitem.getProduct().getProduct_no());
		pstmt.setInt(2, cartitem.getMember_no());
		pstmt.setInt(3, cartitem.getCart_qty());
		pstmt.setInt(4, cartitem.getProduct_espresso());
		pstmt.setInt(5, cartitem.getProduct_syrup());

		int rowCount = pstmt.executeUpdate();

		con.close();
		pstmt.close();

		return rowCount;

	}

	// 회원의 카트에서 상품 전체 삭제 -- 선택 삭제/주문하려면 체크 칼럼 추가
	public int deleteAllCart(int memberNo) throws Exception {
		String deleteCartSQL = "delete cart where member_no=?";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(deleteCartSQL);

		pstmt.setInt(1, memberNo);
		int rowCount = pstmt.executeUpdate();

		con.close();
		pstmt.close();
		return rowCount;
	}
	
	//카트 아이템 하나 삭제 
	public int deleteCartItem(int cartNo) throws Exception{
		String deleteCart="delete cart where cart_no=?";
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(deleteCart);
		
		pstmt.setInt(1, cartNo);
		int rowCount=pstmt.executeUpdate();
		
		con.close();
		pstmt.close();
		
		return rowCount;
		
	}
	
	// 상품이 회원 장바구니에 이미 존재하는지 확인
	public boolean checkProductCount(int memberNo, int productNo, int product_espresso, int product_syrup)
			throws Exception {
		boolean check = false;
		String checkProductSQL = "select count(*) from cart where member_no=? and product_no=? and product_espresso=? and product_syrup=?";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(checkProductSQL);

		pstmt.setInt(1, memberNo);
		pstmt.setInt(2, productNo);
		pstmt.setInt(3, product_espresso);
		pstmt.setInt(4, product_syrup);

		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int productCheck = rs.getInt(1);
		if (productCheck >= 1) {
			check = true;
		}

		return check;
	}

	// 동일 메소드 - 매개변수만 cart인경우
	public boolean checkProductCount(Cart cart) throws Exception {
		boolean check = false;
		String checkProductSQL = "select count(*) from cart where member_no=? and product_no=? and product_espresso=? and product_syrup=?";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(checkProductSQL);

		pstmt.setInt(1, cart.getMember_no());
		pstmt.setInt(2, cart.getProduct().getProduct_no());
		pstmt.setInt(3, cart.getProduct_espresso());
		pstmt.setInt(4, cart.getProduct_syrup());

		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int productCheck = rs.getInt(1);
		if (productCheck >= 1) {
			check = true;
		}

		return check;
	}

	//// 해당 상품의 주문번호 반환 (장바구니에 없는 경우 0 반환)
	public int returnCartno(Cart cart) throws Exception {
		int cart_no = 0;
		String checkProductSQL = "select cart_no from cart where member_no=? and product_no=? and product_espresso=? and product_syrup=?";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(checkProductSQL);

		pstmt.setInt(1, cart.getMember_no());
		pstmt.setInt(2, cart.getProduct().getProduct_no());
		pstmt.setInt(3, cart.getProduct_espresso());
		pstmt.setInt(4, cart.getProduct_syrup());

		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			cart_no = rs.getInt(1);
		}

		return cart_no;
	}

	/*
	//장바구니 상품의 수량 업데이트 
	public int addProductCount(int memberNo,int productNo,int espresso,int syrup,int productQTY) throws Exception{
		String updateCartSQL="update cart set cart_no=cart_no,product_no=product_no,member_no=member_no,cart_qty=cart_qty+? where member_no=? and product_no=? ";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(updateCartSQL);
		pstmt.setInt(1, productQTY);
		pstmt.setInt(2, memberNo);
		pstmt.setInt(3, productNo);
		int rowCount=pstmt.executeUpdate();
		return rowCount;
	}*/

	// 장바구니 수량 업데이트
	public int addProductCount(int qty, int cart_no) throws Exception {
		String updateCartSQL = "update cart set cart_no=cart_no,product_no=product_no,member_no=member_no,product_espresso=product_espresso,product_syrup=product_syrup,cart_qty=cart_qty+? where cart_no=?";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(updateCartSQL);
		pstmt.setInt(1, qty);
		pstmt.setInt(2, cart_no);
		int rowCount = pstmt.executeUpdate();
		return rowCount;
	}
	
	

	/*
	이름                    널?       유형            
			--------------------- -------- ------------- 
			PRODUCT_NO            NOT NULL NUMBER(10)    
			PRODUCT_NAME                   VARCHAR2(50)  
			PRODUCT_PRICE                  NUMBER(20)    
			PRODUCT_ALLERGY                VARCHAR2(500) 
			PRODUCT_CONTENT                VARCHAR2(500) 
			PRODUCT_ESPRESSO               NUMBER(10)    
			PRODUCT_SYRUP                  NUMBER(10)    
			PRODUCT_SYRUPPRICE             NUMBER(10)    
			PRODUCT_ESPRESSOPRICE          NUMBER(10)    
			*/

	// 카트 번호로 카트 select
	public Cart selectbyCartNo(int cartNo) throws Exception {
		String selectByCartNo = "select * from cart c join product p on p.product_no=c.product_no where cart_no=?";
		Cart findCart = null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(selectByCartNo);

		pstmt.setInt(1, cartNo);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			findCart = new Cart(rs.getInt("cart_no"),
					new Product(rs.getInt("product_no"), rs.getString("product_name"), rs.getInt("product_price"),
							rs.getString("product_allergy"), rs.getString("product_content"),
							rs.getInt("product_espresso"), rs.getInt("product_syrup"), rs.getInt("product_syrupprice"),
							rs.getInt("product_espressoprice")),
					rs.getInt("member_no"), rs.getInt("cart_qty"), rs.getInt("product_espresso"),
					rs.getInt("product_syrup"));
		}

		rs.close();
		pstmt.close();
		con.close();

		return findCart;

	}

	// 카트 번호로 해당 카트 item 가격 출력
	public int CartItemPrice(int cartNo) throws Exception {
		String selectCartPrice = "select  c.cart_qty * ( p.product_price +((p.product_espressoprice * c.product_espresso) + (p.product_syrupprice * c.product_syrup)))  from cart c join product p on c.product_no=p.product_no where cart_no=?";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(selectCartPrice);
		pstmt.setInt(1, cartNo);
		ResultSet rs = pstmt.executeQuery();

		int cartPrice = 0;
		if (rs.next()) {
			cartPrice = rs.getInt(1);
		}
		return cartPrice;
	}

	// 회원의 장바구니 전체 출력
	public List<Cart> selectbyMemberNo(int memberNo) throws Exception {
		String selectMemberCartAll = "select * from cart c join product p on c.product_no=p.product_no where member_no=? ";
		List<Cart> findCartList = new ArrayList<Cart>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(selectMemberCartAll);

		pstmt.setInt(1, memberNo);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			// int cart_no, Product product, int member_no, int cart_qty, int
			// product_espresso, int product_syrup
			findCartList.add(new Cart(rs.getInt("cart_no"),
					new Product(rs.getInt("product_no"), rs.getString("product_name"), rs.getInt("product_price"),
							rs.getString("product_allergy"), rs.getString("product_content"),
							rs.getInt("product_espresso"), rs.getInt("product_syrup"), rs.getInt("product_syrupprice"),
							rs.getInt("product_espressoprice")),
					rs.getInt("member_no"), rs.getInt("cart_qty"), rs.getInt("product_espresso"),
					rs.getInt("product_syrup")));

		}
		rs.close();
		pstmt.close();
		con.close();

		return findCartList;
	}

}
