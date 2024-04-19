package com.team2.sbucks.dao.member;

/*
 * 이름              널?       유형           
--------------- -------- ------------ 
MEMBER_NO       NOT NULL NUMBER(10)   
MEMBER_ID       NOT NULL VARCHAR2(50) 
MEMBER_PHONE             VARCHAR2(50) 
MEMBER_BIRTHDAY          DATE         
MEMBER_EMAIL             VARCHAR2(50) 
MEMBER_NICKNAME          VARCHAR2(50) 
MEMBER_LOC               VARCHAR2(50) 
MEMBER_PAGREE            NUMBER(10)   
MEMBER_EAGREE            NUMBER(10)   
 */
public class MemberSQL {
	public static final String MEMBER_INSERT
				= "insert into membership values(membership_member_no_seq.nextval,?,?,?,?,?,?,?,?)";
	
	public static final String MEMBER_UPDATE
				= "update membership set member_nickname=?, "
						+ "member_loc = ?, member_pagree=?, member_eagree=? where member_id =?";
	
	public static final String MEMBER_CHECK_ID
				="select count(*) from membership where member_id=?";
	
	public static final String MEMBER_ID_UPDATE
					= "update membership set member_phone=?,member_email = ?, member_nickname=?, "
							+ "member_loc = ?, member_pagree=?, member_eagree=? where member_id=? ";
	
	public static final String MEMBER_DELETE
				="delete from membership where member_id =?";
	
	public static final String MEMBERDELETE_BY_ID
				="delete from membership where member_id =?";
	
	public static final String MEMBER_FINDBYID
				="select * from membership where member_id =?";
	
	public static final String MEMBER_FINDBYNO
				="select * from membership where member_no = ?";
	
	public static final String MEMBER_CHECKEMAIL
				="select count(*) from membership where member_email = ?";
	
	public static final String MEMBER_CHECKPHONE
				="select count(*) from membership where member_phone =?";
	
	public static final String MEMBER_FINDALL
				="select * from membership";
	
	public static final String MEMBER_PRINT_BY_ID_PASSWORD
				="select * from membership m join login l on m.member_id = l.member_id where m.member_id = ? and member_password = ?";
	
	public static final String FIND_ID
				="select * from membership where member_email =? and member_phone =?";
}
