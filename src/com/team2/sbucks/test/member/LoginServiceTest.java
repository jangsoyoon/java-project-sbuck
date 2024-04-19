package com.team2.sbucks.test.member;

import com.team2.sbucks.dto.Login;
import com.team2.sbucks.service.LoginService;

public class LoginServiceTest {
	public static void main(String[] args) throws Exception{
		LoginService loginService = new LoginService();
		
		Login newLogin = new Login("guard2", "2222", 1);
		loginService.updateLogin(newLogin);
		
	}
	
	
}
