package com.team2.sbucks.dao.member;

	import java.sql.Connection;



	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	import java.util.List;

	import com.team2.sbucks.common.DataSource;
	import com.team2.sbucks.dto.Login;





	/*
	 * 이름              널?       유형           
	--------------- -------- ------------ 
	MEMBER_ID       NOT NULL VARCHAR2(50) 
	MEMBER_PASSWORD          VARCHAR2(50) 
	LOGIN                    NUMBER(10)   

	 */
	public class LoginDao {
		private DataSource dataSource;
		
		public LoginDao() {
			dataSource = new DataSource();
		}
		
		
		public int insertLogin (Login newLogin) throws Exception{
			
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(LoginSQL.LOGIN_INSERT);
			
			pstmt.setString(1, newLogin.getMember_id());
			pstmt.setString(2, newLogin.getMember_password());
			pstmt.setInt(3, newLogin.getLogin());
			
			int insertCount = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
			return insertCount;
		}
		
		public int updateLogin(Login login) throws Exception {

			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(LoginSQL.UPDATE_LOGIN);
			pstmt.setString(1, login.getMember_password());
			pstmt.setInt(2, login.getLogin());
			pstmt.setString(3, login.getMember_id());
			int rowCount = pstmt.executeUpdate();
			con.close();
			pstmt.close();
			return rowCount;
		}
		
		public int updatePassword (String newPassword, String id) throws Exception{
			
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(LoginSQL.UPDATE_PASSWORD);
			
			pstmt.setString(1, newPassword);
			pstmt.setString(2, id);
			
			int updateCount = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
			return updateCount;
		}
		
		public boolean checkPassword(String member_password) throws Exception{
			
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(LoginSQL.CHECK_PASSWORD);
			
			pstmt.setString(1, member_password);
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
			int rowCount = rs.getInt(1);
			
			if(rowCount==1) {
				return true;
			}else {
				return false;
			}
		}
		
		public Login findPassword (String id, String email) throws Exception{
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(LoginSQL.FIND_PASSWORD);
			Login findPassword = null;
			
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				
				findPassword = new Login(rs.getString("member_id"), rs.getString("member_password"),
										rs.getInt("login"));
				
			}
			
			con.close();
			pstmt.close();
			rs.close();
			return findPassword;
		}
		
		
		public Login selectByID (String member_id) throws Exception {
			
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(LoginSQL.FIND_BY_ID);
			
			Login findLogin = null;
			pstmt.setString(1, member_id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				findLogin = new Login(rs.getString("member_id"),
										rs.getString("member_password"),
										rs.getInt("login"));
						
			}
			rs.close();
			pstmt.close();
			con.close();

			return findLogin;
		}
		
		
		
		public List<Login> selectAll() throws Exception {
			List<Login> findLoginList = new ArrayList<Login>();
			Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(LoginSQL.SElECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				findLoginList
						.add(new Login(rs.getString("member_id"), rs.getString("member_password"), rs.getInt("login")));
			}
			con.close();
			pstmt.close();
			rs.close();
			return findLoginList;
		}
		
		
		
	}

