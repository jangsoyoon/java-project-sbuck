package com.team2.sbucks.test.member;

import com.team2.sbucks.dto.Member;
import com.team2.sbucks.service.MemberService;

public class MemberServiceTest {

	public static void main(String[] args) throws Exception{
		MemberService memberService = new MemberService();
		
		String id = "guard1";
		String password = "1111";
		
		Member newMember =memberService.findInfo(id, password);
		System.out.println(newMember);
		
		

	}

}
