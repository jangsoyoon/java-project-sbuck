package com.team2.sbucks.test.member;

import com.team2.sbucks.dao.member.LoginDao;

public class LoginDaoTest {
	
	public static void main(String[] args) throws Exception {
		LoginDao loginDao = new LoginDao();
		
		/*
		System.out.println("---비밀번호 찾기----");
		System.out.println("아이디 입력");
		String member_id = scan.nextLine();
		System.out.println("이메일 입력");
		String member_email = scan.nextLine();
		System.out.println(loginDao.findPassword(member_id, member_email).getMember_password());
		*/
		
		//System.out.println("아이디로 조회");
		//Login searchLogin =loginDao.selectByID("guard1");
		//System.out.println(searchLogin);
		
		//System.out.println("비밀번호 변경");
		//loginDao.updatePassword("8888", "7777");
		
		//System.out.println("아이디 비밀번호 로그인 상태 입력");
		//Login insertLoginLow = new Login("guard11","1011",1);
		//int insertCount=loginDao.insertLogin(insertLoginLow);
		//System.out.println(insertCount);
		
		//boolean isCheck = loginDao.CheckPassword("1011");
		//System.out.println(isCheck);
		
	}
}
