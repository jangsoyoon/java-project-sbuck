package com.team2.sbucks.dto;

import java.text.SimpleDateFormat;


import java.util.Date;

public class Member {
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
			
			private int member_no;
			private String member_id;
			private String member_phone;
			private Date member_birthday;
			private String member_email;
			private String memeber_nickname;
			private String member_loc;
			private int member_pagree;
			private int member_eagree;
			private Login login;
			
			
			public Member() {
				// TODO Auto-generated constructor stub
			}


			public Member(int member_no, String member_id, String member_phone, String sBirthday, String member_email,
					String memeber_nickname, String member_loc, int member_pagree, int member_eagree) throws Exception{
				super();
				this.member_no = member_no;
				this.member_id = member_id;
				this.member_phone = member_phone;
				SimpleDateFormat sdf = new SimpleDateFormat();
				sdf.applyPattern("yyyy-MM-dd");
				Date birthday = sdf.parse(sBirthday);
				this.member_birthday = birthday;
				this.member_email = member_email;
				this.memeber_nickname = memeber_nickname;
				this.member_loc = member_loc;
				this.member_pagree = member_pagree;
				this.member_eagree = member_eagree;
			}
			
			
			public Member(Login login) {
				this.login = login;
			}
			
			public Login getLogin() {
				return login;
			}


			public void setLogin(Login login) {
				this.login = login;
			}


			public int getMember_no() {
				return member_no;
			}


			public void setMember_no(int member_no) {
				this.member_no = member_no;
			}


			public String getMember_id() {
				return member_id;
			}


			public void setMember_id(String member_id) {
				this.member_id = member_id;
			}


			public String getMember_phone() {
				return member_phone;
			}


			public void setMember_phone(String member_phone) {
				this.member_phone = member_phone;
			}


			public Date getMember_birthday() {
				return member_birthday;
			}


			public void setMember_birthday(Date member_birthday) {
				this.member_birthday = member_birthday;
			}


			public String getMember_email() {
				return member_email;
			}


			public void setMember_email(String member_email) {
				this.member_email = member_email;
			}


			public String getMemeber_nickname() {
				return memeber_nickname;
			}


			public void setMemeber_nickname(String memeber_nickname) {
				this.memeber_nickname = memeber_nickname;
			}


			public String getMember_loc() {
				return member_loc;
			}


			public void setMember_loc(String member_loc) {
				this.member_loc = member_loc;
			}


			public int getMember_pagree() {
				return member_pagree;
			}


			public void setMember_pagree(int member_pagree) {
				this.member_pagree = member_pagree;
			}


			public int getMember_eagree() {
				return member_eagree;
			}


			public void setMember_eagree(int member_eagree) {
				this.member_eagree = member_eagree;
			}


			@Override
			public String toString() {
				return "Member [member_no=" + member_no + ", member_id=" + member_id + ", member_phone=" + member_phone
						+ ", member_birthday=" + member_birthday + ", member_email=" + member_email + ", memeber_nickname="
						+ memeber_nickname + ", member_loc=" + member_loc + ", member_pagree=" + member_pagree
						+ ", member_eagree=" + member_eagree + "]";
			}
			
			
		}

