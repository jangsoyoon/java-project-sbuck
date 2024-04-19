package com.team2.sbucks.test.member;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import com.team2.sbucks.dao.member.MemberDao;
import com.team2.sbucks.dto.Member;
import com.team2.sbucks.service.MemberService;

public class MembershipDaoTest {
	public static void main(String[] args) throws Exception{
		 MemberDao memberDao = new MemberDao();
		 MemberService memberService = new MemberService();
		 
		 //Member findMember = memberDao.findById("guard1");
		 //System.out.println(findMember);
		 
		//Member insertMemberTest = new Member(0, "greengrape", "010-1234-1234", "2022-07-01", "greengrape@naver.com", "청포도사탕", "경기도 용인시", 1, 1);
		//int insertOk = memberDao.insertMember(insertMemberTest);
		//System.out.println("삽입된 행의 수:"+insertOk);
		 
		 //Member updateMember = new Member(0,"candy1", "010-3587-7898", new Date(),"candy2@naver.com", "청포도사탕", "경기도 시흥시",0,0);
		 //int updateCount = memberDao.updateMember(updateMember);
		 //System.out.println("수정된 행의 수:"+updateCount);
		 
		 //Member updateByNo = new Member(1,"dfd", "010-2323-2323", new Date(), "candy1@naver.com","썬키스트사탕", "경기도 용인시", 1,1);
		 //int updateByNoCount = memberDao.updateByNo(updateByNo);
		 //System.out.println("번호인자받아 수정된 행의 수:"+updateByNoCount);
		 
		 //int deleteCount = memberDao.deleteMember(1);
		 //System.out.println("삭제된 행의 수 :"+deleteCount);
		  
		 /*
		List<Member> memberList = memberDao.findAll();
		 for (Member member : memberList) {
			 	System.out.println(member);
		}
		 */
		 
		Member printInfo = memberDao.findInfo("guard1", "1111");
		System.out.println(printInfo);
		
}
}