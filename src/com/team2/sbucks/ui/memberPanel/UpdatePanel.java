package com.team2.sbucks.ui.memberPanel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.team2.sbucks.dto.Login;
import com.team2.sbucks.dto.Member;
import com.team2.sbucks.service.LoginService;
import com.team2.sbucks.service.MemberService;
import com.team2.sbucks.ui.MainFrame;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class UpdatePanel extends JPanel {
	private JTextField updateID_TF;
	private JPasswordField originalPassword_TF;
	private JPasswordField updatePassword_TF;
	private JTextField updatePhone_TF;
	private JTextField updateBirth_TF;
	private JTextField updateEmail_TF;
	private JTextField updateNickname_TF;
	private JTextField updateLoc_TF;
	private MainFrame mainFrame;
	
	/**********멤버서비스 객체선언*************/
	private MemberService memberService;
	private LoginService loginService;
	
	/**********로그인한 회원******************/
	private Member loginMember = null;
	private Member newMember = null;
	
	
	private JCheckBox updatePagree_CB;
	private JCheckBox updateEagree_CB;
	private JComboBox updatePhone_CB;
	

	/**
	 * Create the panel.
	 */
	public UpdatePanel() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel updateTitle_LB = new JLabel("회원정보");
		updateTitle_LB.setBounds(81, 100, 188, 40);
		updateTitle_LB.setHorizontalAlignment(SwingConstants.CENTER);
		updateTitle_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 20));
		add(updateTitle_LB);
		
		JButton sbucksLogo = new JButton("");
		sbucksLogo.setIcon(new ImageIcon(UpdatePanel.class.getResource("/images/스타벅스로고.png")));
		sbucksLogo.setFocusPainted(false);
		sbucksLogo.setContentAreaFilled(false);
		sbucksLogo.setBorderPainted(false);
		sbucksLogo.setBorder(null);
		sbucksLogo.setBounds(57, 5, 242, 94);
		add(sbucksLogo);
		
		JLabel updateID_LB = new JLabel("아이디");
		updateID_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateID_LB.setBounds(28, 159, 57, 15);
		add(updateID_LB);
		
		updateID_TF = new JTextField();
		updateID_TF.setBackground(new Color(245, 245, 245));
		updateID_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateID_TF.setColumns(10);
		updateID_TF.setBounds(109, 156, 143, 21);
		add(updateID_TF);
		
		JLabel originalPassword_LB = new JLabel("기존 비밀번호");
		originalPassword_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		originalPassword_LB.setBounds(28, 200, 83, 15);
		add(originalPassword_LB);
		
		originalPassword_TF = new JPasswordField();
		originalPassword_TF.setBackground(new Color(245, 245, 245));
		originalPassword_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		originalPassword_TF.setBounds(109, 197, 143, 21);
		add(originalPassword_TF);
		
		JLabel updatePassword_LB = new JLabel("비밀번호변경");
		updatePassword_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updatePassword_LB.setBounds(28, 239, 97, 15);
		add(updatePassword_LB);
		
		updatePassword_TF = new JPasswordField();
		updatePassword_TF.setBackground(new Color(245, 245, 245));
		updatePassword_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updatePassword_TF.setEnabled(false);
		updatePassword_TF.setBounds(109, 236, 143, 21);
		add(updatePassword_TF);
		
		JLabel updatePhone_LB = new JLabel("핸드폰");
		updatePhone_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updatePhone_LB.setBounds(28, 284, 57, 15);
		add(updatePhone_LB);
		
		
		
		
		updatePhone_TF = new JTextField();
		updatePhone_TF.setBackground(new Color(245, 245, 245));
		updatePhone_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updatePhone_TF.setEditable(false);
		updatePhone_TF.setColumns(10);
		updatePhone_TF.setBounds(178, 281, 74, 21);
		add(updatePhone_TF);
		
		JLabel updateBirth_LB = new JLabel("생일");
		updateBirth_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateBirth_LB.setBounds(28, 321, 57, 15);
		add(updateBirth_LB);
		
		updateBirth_TF = new JTextField();
		updateBirth_TF.setBackground(new Color(245, 245, 245));
		updateBirth_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateBirth_TF.setEditable(false);
		updateBirth_TF.setColumns(10);
		updateBirth_TF.setBounds(109, 318, 143, 21);
		add(updateBirth_TF);
		
		JLabel updateEmail_LB = new JLabel("이메일");
		updateEmail_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateEmail_LB.setBounds(28, 354, 57, 15);
		add(updateEmail_LB);
		
		updateEmail_TF = new JTextField();
		updateEmail_TF.setBackground(new Color(245, 245, 245));
		updateEmail_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateEmail_TF.setEditable(false);
		updateEmail_TF.setColumns(10);
		updateEmail_TF.setBounds(109, 351, 143, 21);
		add(updateEmail_TF);
		
		JLabel updateNickname_LB = new JLabel("닉네임");
		updateNickname_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateNickname_LB.setBounds(28, 386, 57, 15);
		add(updateNickname_LB);
		
		updateNickname_TF = new JTextField();
		updateNickname_TF.setBackground(new Color(245, 245, 245));
		updateNickname_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateNickname_TF.setEnabled(false);
		updateNickname_TF.setColumns(10);
		updateNickname_TF.setBounds(110, 381, 142, 21);
		add(updateNickname_TF);
		
		JLabel updateLoc_LB = new JLabel("지역");
		updateLoc_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateLoc_LB.setBounds(28, 419, 57, 15);
		add(updateLoc_LB);
		
		updateLoc_TF = new JTextField();
		updateLoc_TF.setBackground(new Color(245, 245, 245));
		updateLoc_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateLoc_TF.setEnabled(false);
		updateLoc_TF.setColumns(10);
		updateLoc_TF.setBounds(110, 416, 142, 21);
		add(updateLoc_TF);
		
		updatePagree_CB = new JCheckBox("핸드폰 정보제공 동의");
		updatePagree_CB.setEnabled(false);
		updatePagree_CB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updatePagree_CB.setBounds(25, 446, 148, 23);
		add(updatePagree_CB);
		
		updateEagree_CB = new JCheckBox("지역 정보제공 동의");
		updateEagree_CB.setEnabled(false);
		updateEagree_CB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		updateEagree_CB.setBounds(206, 446, 146, 23);
		add(updateEagree_CB);
		
		
		
		JButton update_Btn = new JButton("");
		update_Btn.setIcon(new ImageIcon(UpdatePanel.class.getResource("/images/업데이트1.png")));
		update_Btn.setBorderPainted(false);
		update_Btn.setContentAreaFilled(false);
		update_Btn.setFocusPainted(false);
		update_Btn.setBorder(null);
		update_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = updateID_TF.getText();
					//String password = updatePassword_TF.getText();
					
					String ber = updatePhone_TF.getText();
					String phoneNum = (String)updatePhone_CB.getSelectedItem();
					String phoneNumber = phoneNum+ber;
					
					phoneNumber = updatePhone_TF.getText();
					
					String birth = updateBirth_TF.getText();
					String nickName = updateNickname_TF.getText();
					String email = updateEmail_TF.getText();
					String loc = updateLoc_TF.getText();
					int pAgreeStr = -999;
					if(updatePagree_CB.isSelected()) {
						pAgreeStr = 1;
					}else {
						pAgreeStr = 0;
					}
					
					int eAgreeStr = -999;
					if(updateEagree_CB.isSelected()) {
						eAgreeStr = 1;
					}else {
						eAgreeStr = 0;
					}
					if(id.equals("")||phoneNumber.equals("")|| birth.equals("")||nickName.equals("")||email.equals("")||loc.equals("")) {
						JOptionPane.showMessageDialog(null, "내용을 입력하세요.");
						return;
					}
					Member loginMember = new Member(0,id, phoneNumber, birth, email, nickName, loc, pAgreeStr, eAgreeStr);
					boolean check = memberService.updateMemberByID(loginMember);
					if(check==true) {
					JOptionPane.showMessageDialog(null, "회원정보 변경이 완료되었습니다.");
					} else {
					JOptionPane.showMessageDialog(null, "회원정보 변경이 실패했습니다.");
					}
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		update_Btn.setBounds(209, 482, 97, 23);
		add(update_Btn);
		
		JButton out_Btn = new JButton("");
		out_Btn.setEnabled(false);
		out_Btn.setIcon(new ImageIcon(UpdatePanel.class.getResource("/images/탈퇴11.png")));
		out_Btn.setBorderPainted(false);
		out_Btn.setContentAreaFilled(false);
		out_Btn.setFocusPainted(false);
		out_Btn.setBorder(null);
		out_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = updateID_TF.getText();
					
					int var =JOptionPane.showConfirmDialog(null, "탈퇴하면 되돌릴 수 없는데 계속 진행할까요?","탈퇴",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
					
					if(var==0) {
						memberService.deleteMember(id);
						JOptionPane.showConfirmDialog(null, "탈퇴가 성공적으로 이루어졌습니다!","",JOptionPane.YES_NO_OPTION);
						updateID_TF.setText("");
						originalPassword_TF.setText("");
						updatePhone_TF.setText("");
						updateBirth_TF.setText("");
						updateEmail_TF.setText("");
						updateNickname_TF.setText("");
						updateLoc_TF.setText("");
						updatePagree_CB.setEnabled(false);
						updateEagree_CB.setEnabled(false);
						updatePassword_TF.setText("");
						mainFrame.MemberTabbedPane.setSelectedIndex(0);
						
						
						//이렇게 하는 것보다 탈퇴되자마자 홈으로 돌아가게 만드는 것이 좋을 듯하다.
							
						}else {
							JOptionPane.getRootFrame().dispose();
						}
					} catch(Exception e1) {
					
				}
				
			}
		});
		out_Btn.setBounds(66, 481, 89, 24);
		add(out_Btn);
		
		JButton updatePassword_Btn = new JButton("변경");
		updatePassword_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = updateID_TF.getText();
					String newPassword = updatePassword_TF.getText();
					boolean isSuccess = loginService.CheckUpdatePassword(newPassword, id);
					if(isSuccess) {
						JOptionPane.showMessageDialog(null, "비밀번호가 변경되었습니다.");
					}else {
						JOptionPane.showMessageDialog(null, "다시 입력해주세요.");
					}
					/*
				    if() {
				    	loginService.updatePassword(newPassword, oldPassword);
				         System.out.println("화깅ㄴ");
				    	updatePassword_TF.setEnabled(false);
				    	updateNickname_TF.requestFocus();
				    }else {
				    }
					*/
					
					
				}catch(Exception e1) {
					
				}
			}
		});
		updatePassword_Btn.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 10));
		updatePassword_Btn.setBounds(266, 236, 71, 23);
		add(updatePassword_Btn);
		
		updatePhone_CB = new JComboBox();
		updatePhone_CB.setModel(new DefaultComboBoxModel(new String[] {"010", "017", "011"}));
		updatePhone_CB.setEnabled(false);
		updatePhone_CB.setBounds(110, 278, 61, 27);
		add(updatePhone_CB);
		
		JButton sameID_Btn = new JButton("일치 확인");
		sameID_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/*******회원정보 수정**********/
				String id = updateID_TF.getText();
				String password = originalPassword_TF.getText();
				Member loginMember = memberService.findInfo(id, password);
				String birth = updateBirth_TF.getText();
				
				if(loginMember!=null) {
					
					updateID_TF.setEnabled(false);
					originalPassword_TF.setEnabled(false);
					updatePassword_TF.setEnabled(true);
					updatePassword_TF.setEnabled(true);
					out_Btn.setEnabled(true);
					updatePhone_TF.setText(loginMember.getMember_phone());
					
					SimpleDateFormat sdf = new SimpleDateFormat();
					sdf.applyPattern("yyyy-MM-dd");
					//Date birthday = sdf.parse(birth);
					updateBirth_TF.setText(sdf.format(loginMember.getMember_birthday()));
					
					
					updateEmail_TF.setText(loginMember.getMember_email());
					updateLoc_TF.setText(loginMember.getMember_loc());
					updateNickname_TF.setText(loginMember.getMemeber_nickname());
					updateNickname_TF.setEnabled(true);
					updateLoc_TF.setEnabled(true);
					updatePagree_CB.setEnabled(true);
					updateEagree_CB.setEnabled(true);
					updatePhone_CB.setSelectedItem(loginMember.getMember_phone().substring(0, 3));
					if(loginMember.getMember_pagree()==0) {
						updatePagree_CB.setSelected(false);
					} else {
						updatePagree_CB.setSelected(true);
					}
			} else {
				JOptionPane.showMessageDialog(null, "다시 입력해주세요");
			}
				}catch(Exception e1) {
					
				}
			}
		});
		sameID_Btn.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 10));
		sameID_Btn.setBounds(265, 175, 71, 23);
		add(sameID_Btn);
	
		memberService=new MemberService();
		loginService = new LoginService();
	}

/*******************로그인성공시호출할메쏘드******************/
public void loginProcess(String id)throws Exception {
	/*
	 * 1.로그인멤버객체 저장
	 * 2.MemberMainFrame타이틀변경
	 * 3.로그인,회원가입 tab 불활성화
	 * 4.로그아웃메뉴아이템 활성화
	 * 5.회원리스트탭 활성화
	 */
	Member loginSuccessMember=memberService.findById(id);
	loginMember = loginSuccessMember;
	//setTitle(loginMember.getMember_id());   --탭 생성시
	
	
}
public void setFrame(MainFrame mainFrame) {
	this.mainFrame = mainFrame;
	
	
}
}//클래스끝