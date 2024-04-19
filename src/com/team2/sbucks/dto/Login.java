package com.team2.sbucks.dto;


public class Login {
	private String member_id;
	private String member_password;
	private int login;
	private Member member;
	
	
	public Member getMember() {
		return member;
	}



	public void setMember(Member member) {
		this.member = member;
	}



	public Login() {
		
	}
	


	public Login(String member_id, String member_password, int login) {
		super();
		this.member_id = member_id;
		this.member_password = member_password;
		this.login = login;
	}

	public Login(int login) {
		super();
		this.login = login;
	}


	public String getMember_id() {
		return member_id;
	}


	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}


	public String getMember_password() {
		return member_password;
	}


	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}


	public int getLogin() {
		return login;
	}


	public void setLogin(int login) {
		this.login = login;
	}
	
	@Override
	public String toString() {
		return "Login [member_id=" + member_id + ", member_password=" + member_password + ", login=" + login + "]";
	}
	
}
