package com.team2.sbucks.service;

import java.util.List;


import com.team2.sbucks.dto.Member;
import com.team2.sbucks.dao.member.LoginDao;
import com.team2.sbucks.dao.member.MemberDao;



public class MemberService {

	private MemberDao memberDao;
	private LoginDao loginDao;

	public MemberService() {
		memberDao = new MemberDao(); // 객체초기화?
		loginDao = new LoginDao();
	}
	/*
	 * 회원가입
	 */

	/*
	 * 아이디가 이미 존재하면 중복되었다는 메세지를 띄운다.
	 */
	/*
	 * 아이디존재여부체크 - 존재하면 메세지 - 존재안하면 가입
	 */
	public boolean addMember(Member newMember) throws Exception {
		boolean isSuccess = false;

		Member findMember = memberDao.findById(newMember.getMember_id());
		if (findMember == null) {
			memberDao.insertMember(newMember);
			isSuccess = true;
		} else {
			isSuccess = false;
		}
		return isSuccess;
	}
	
	public boolean IDCheck(String id) throws Exception{
		boolean isSuccess = false;
		if(memberDao.findById(id)==null) {
			isSuccess = true;
		} else {
			isSuccess = false;
		}
		
		return isSuccess;
	}

	/*
	 * 이메일중복체크
	 */
	public boolean duplicateEmail(String member_email) throws Exception {
		boolean isSuccess = false;

		if (memberDao.checkEmail(member_email) == true) {
			isSuccess = false;
		} else {
			isSuccess = true;
		}
		return isSuccess;
	}

	/*
	 * 핸드폰중복체크
	 */
	public boolean duplicatePhone(String member_phone) throws Exception {
		boolean isSuccess = false;

		if (memberDao.checkPhone(member_phone) == true) {
			isSuccess = false;
		} else {
			isSuccess = true;
		}

		return isSuccess;
	}

	/*
	 * 비밀번호 확인
	 */
	/*
	public boolean checkPassword(String id, String password) throws Exception {
		boolean check = false;
		if (loginDao.selectByID(id).getMember_password().equals(password)) {
			check = true;
			System.out.println("비밀번호가 일치합니다");

		} else {
			System.out.println("비밀번호가 일치하지 않습니다.");
			check = false;
		}

		return check;
	}
	*/
	
	public boolean checkPassword(String password, String checkPassword) throws Exception{
		boolean check = false;
		if(password.equals(checkPassword)) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}
	

	/*
	 * 아이디확인
	 */

	public boolean sameID(String id, String password) throws Exception {
		boolean check = false;
		if (loginDao.selectByID(id).getMember_id().equals(id)) {
			check = true;
			System.out.println("아이디가 일치합니다");

		} else {
			System.out.println("아이디가 일치하지 않습니다.");
			check = false;
		}

		return check;
	}

	/*
	 * 회원가입
	 */
	public int insertMember(Member newMember) throws Exception {

		return memberDao.insertMember(newMember);
	}

	public Member findById(String member_id) throws Exception {

		return memberDao.findById(member_id);
	}

	/*
	 * 회원정보수정
	 */

	public int updateMember(Member updateMember) throws Exception {

		return memberDao.updateMember(updateMember);

	}
	
	/*
	public boolean addMember(Member newMember) throws Exception {
		boolean isSuccess = false;

		Member findMember = memberDao.findById(newMember.getMember_id());
		if (findMember == null) {
			memberDao.insertMember(newMember);
			isSuccess = true;
		} else {
			isSuccess = false;
		}
		return isSuccess;
	}
	*/
	
	public boolean updateMemberByID(Member updateMember) throws Exception {
		
		boolean check = false;
		Member findMember = memberDao.findById(updateMember.getMember_id());
		if(findMember!=null) {
			memberDao.updateMember(updateMember);
			check=true;
		}else {
			check = false;
		}
		
		return check;
	}

	/*
	 * 회원전체검색
	 */
	public List<Member> findAll() throws Exception {

		return memberDao.findAll();
	}

	/*
	 * 회원번호로수정
	 */

	public int updateByID(Member updateByNoMember) throws Exception {

		return memberDao.updateByID(updateByNoMember);
	}

	/*
	 * 회원아이디로삭제
	 */
	public boolean deleteMember(String member_id) throws Exception {
		boolean isSuccess = false;
		Member findMember = memberDao.findById(member_id);
		if(findMember !=null) {
			memberDao.deleteMember(member_id);
			isSuccess = true;
		}else {
			isSuccess = false;
		}
		return isSuccess;

	}
	
	/*
	 * 비밀번호 확인 후 회원 삭제
	 */
	
	public boolean deleteByPassword(String member_id, String member_password) throws Exception{
		boolean isSuccess = false;
		if(loginDao.checkPassword(member_password)==true) {
			memberDao.deleteMemberByID(member_id);
			isSuccess = true;
			System.out.println("회원탈퇴가 정상적으로 되었습니다.");
		}else {
			System.out.println("비밀번호를 다시 입력해주세요.");
			isSuccess = false;
		}
		
		
		
		return isSuccess;
	}

	/*
	 * 회원정보 출력 (회원번호)
	 */

	public void printMember(int member_no) throws Exception {
		System.out.println(memberDao.findByNo(member_no));

	}

	/*
	 * 아이디 비밀번호로 회원정보 찾기
	 */
	public Member findInfo(String member_id, String member_password) throws Exception {
		return memberDao.findInfo(member_id, member_password);
	}

	/*
	 * 이메일, 핸드폰번호로 아이디 찾기
	 */
	public Member findId(String member_email, String member_phone) throws Exception {
		return memberDao.findId(member_email, member_phone);
	}

	/*
	 * 로그인성공
	 */
	public int loginSuccess(String member_id, String member_password) throws Exception {
		int loginResult = -999;
		if (memberDao.checkID(member_id) == true) {
			if (loginDao.selectByID(member_id).getMember_password().equals(member_password)) {
				//System.out.println("로그인성공!");
				loginResult = 1;
			} else {
				//System.out.println("비밀번호가 틀렸습니다");
				loginResult = 2;
			}
		} else {
			//System.out.println("아이디가 틀렸습니다.");
			loginResult = 0;
		}

		return loginResult;
	}
	

}