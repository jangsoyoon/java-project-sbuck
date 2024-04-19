package com.team2.sbucks.dao.member;

/*
 * 이름              널?       유형           
--------------- -------- ------------ 
MEMBER_ID       NOT NULL VARCHAR2(50) 
MEMBER_PASSWORD          VARCHAR2(50) 
LOGIN                    NUMBER(10)   

 */
public class LoginSQL {
	public static final String LOGIN_INSERT 
						= "insert into login values (?,?,?)";
	
	public static final String UPDATE_PASSWORD
						= "update login set member_password =? where member_id =?";
	
	public static final String UPDATE_LOGIN="update login set member_id=member_id,member_password=?,login=? where member_id=?";
	
	public static final String FIND_PASSWORD
						= "select *"
								+ " from login l join membership m on l.member_id = m.member_id "
								+ " where m.member_id = ? and m.member_email = ?";
	
	public static final String MEMBER_INFO
						="select * from membership m join login l on m.member_id = l.member_id "
								+ "where member_password = ?";
	
	public static final String FIND_BY_ID
						="select * from login where member_id =?";
	
	public static final String CHECK_PASSWORD
						="select count(*) from login where member_password =?";
	
	public static final String SElECT_ALL="select * from login";
}
