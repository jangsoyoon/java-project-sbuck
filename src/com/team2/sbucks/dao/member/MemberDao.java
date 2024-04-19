package com.team2.sbucks.dao.member;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.team2.sbucks.common.DataSource;
import com.team2.sbucks.dto.Member;


public class MemberDao {

	
	private DataSource dataSource;

	public MemberDao() {
		dataSource = new DataSource();
	}

	public int insertMember(Member newMember) throws Exception {

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_INSERT);
		
		pstmt.setString(1, newMember.getMember_id());
		pstmt.setString(2, newMember.getMember_phone());
		java.sql.Date member_date = new java.sql.Date(newMember.getMember_birthday().getTime());
		pstmt.setDate(3, member_date);
		pstmt.setString(4, newMember.getMember_email());
		pstmt.setString(5, newMember.getMemeber_nickname());
		pstmt.setString(6, newMember.getMember_loc());
		pstmt.setInt(7, newMember.getMember_pagree());
		pstmt.setInt(8, newMember.getMember_eagree());

		int insertCount = pstmt.executeUpdate();

		pstmt.close();
		con.close();
		return insertCount;

	}
	
	
	public int updateMember(Member updateMember) throws Exception {

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_UPDATE);

		pstmt.setString(1, updateMember.getMemeber_nickname());
		pstmt.setString(2, updateMember.getMember_loc());
		pstmt.setInt(3, updateMember.getMember_pagree());
		pstmt.setInt(4, updateMember.getMember_eagree());
		pstmt.setString(5, updateMember.getMember_id());

		int updateCount = pstmt.executeUpdate();

		pstmt.close();
		con.close();

		return updateCount;
	}
	
	
	public int updateByID(Member updateByNoMember) throws Exception {

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_ID_UPDATE);

		pstmt.setString(1, updateByNoMember.getMember_phone());
		pstmt.setString(2, updateByNoMember.getMember_email());
		pstmt.setString(3, updateByNoMember.getMemeber_nickname());
		pstmt.setString(4, updateByNoMember.getMember_loc());
		pstmt.setInt(5, updateByNoMember.getMember_pagree());
		pstmt.setInt(6, updateByNoMember.getMember_eagree());
		pstmt.setString(7, updateByNoMember.getMember_id());

		int updateByNoCount = pstmt.executeUpdate();

		pstmt.close();
		con.close();

		return updateByNoCount;
	}
	
	
	public int deleteMember(String member_id) throws Exception {

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_DELETE);

		pstmt.setString(1, member_id);

		int deleteCount = pstmt.executeUpdate();

		pstmt.close();
		con.close();

		return deleteCount;
	}
	
	
	public int deleteMemberByID(String member_id) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBERDELETE_BY_ID);
		
		pstmt.setString(1, member_id);

		int deleteCount = pstmt.executeUpdate();

		pstmt.close();
		con.close();

		return deleteCount;
	}
	
	
	
	
	public Member findById(String member_id) throws Exception {

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_FINDBYID);

		Member findMember = null;

		pstmt.setString(1, member_id);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			findMember = new Member(rs.getInt("member_no"), rs.getString("member_id"), rs.getString("member_phone"),
					rs.getString("member_birthday"), rs.getString("member_email"), rs.getString("member_nickname"),
					rs.getString("member_loc"), rs.getInt("member_pagree"), rs.getInt("member_eagree"));
		}
		rs.close();
		pstmt.close();
		con.close();
		return findMember;
	}
	
	public Member findByNo(int member_no) throws Exception {

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_FINDBYNO);

		Member findMember = null;

		pstmt.setInt(1, member_no);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			findMember = new Member(rs.getInt("member_no"), rs.getString("member_id"), rs.getString("member_phone"),
					rs.getString("member_birthday"), rs.getString("member_email"), rs.getString("member_nickname"),
					rs.getString("member_loc"), rs.getInt("member_pagree"), rs.getInt("member_eagree"));
		}
		rs.close();
		pstmt.close();
		con.close();
		return findMember;
	}
	
	public boolean checkEmail(String member_email) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_CHECKEMAIL);
		pstmt.setString(1, member_email);
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		int emailCount = rs.getInt(1);
		
		if(emailCount ==1) {
			return true;
		}else {
			return false;
		}
	}
	public boolean checkPhone(String member_phone) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_CHECKPHONE);
		
		pstmt.setString(1, member_phone);
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		int rowCount = rs.getInt(1);
		
		if(rowCount==1) {
			return true;
		}else {
			return false;
		}
		
	}
		
		
	public boolean checkID(String member_id) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_CHECK_ID);
		
		pstmt.setString(1, member_id);
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		int rowCount = rs.getInt(1);
		
		if(rowCount==1) {
			return true;
		}else {
			return false;
			}
	}
	
	/*
	 * 이메일, 핸드폰 넣으면 아이디찾기
	 */
	public Member findId(String member_email, String member_phone) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.FIND_ID);
		Member searchId = null;
		
		pstmt.setString(1, member_email);
		pstmt.setString(2, member_phone);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			
			searchId = new Member(rs.getInt("member_no"), rs.getString("member_id"), rs.getString("member_phone"),
					rs.getString("member_birthday"), rs.getString("member_email"), rs.getString("member_nickname"),
					rs.getString("member_loc"), rs.getInt("member_pagree"), rs.getInt("member_eagree"));
		}

		rs.close();
		pstmt.close();
		con.close();
		return searchId;
	}
	
	/*
	 * 아이디랑 비밀번호로 회원정보찾기
	 */
	
	public Member findInfo(String member_id, String member_password) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_PRINT_BY_ID_PASSWORD);
		Member printInfo = null;
		
		pstmt.setString(1, member_id);
		pstmt.setString(2, member_password);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			
			printInfo = new Member(rs.getInt("member_no"), rs.getString("member_id"), rs.getString("member_phone"),
					rs.getString("member_birthday"), rs.getString("member_email"), rs.getString("member_nickname"),
					rs.getString("member_loc"), rs.getInt("member_pagree"), rs.getInt("member_eagree"));
			
		}
		
		return printInfo;
	}
	
	
	public List<Member> findAll() throws Exception {

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_FINDALL);

		ArrayList<Member> memberList = new ArrayList<Member>(); // 여기 그냥 null로 해도 되는지?

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			memberList.add(new Member(rs.getInt("member_no"), rs.getString("member_id"), rs.getString("member_phone"),
					rs.getString("member_birthday"), rs.getString("member_email"), rs.getString("member_nickname"),
					rs.getString("member_loc"), rs.getInt("member_pagree"), rs.getInt("member_eagree")));
		}

		return memberList;
	}
	
	
	
	
	
}
