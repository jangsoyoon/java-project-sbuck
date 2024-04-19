package com.team2.sbucks.ui.memberPanel;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.team2.sbucks.dto.Login;
import com.team2.sbucks.dto.Member;
import com.team2.sbucks.service.LoginService;
import com.team2.sbucks.service.MemberService;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class SearchPanel extends JPanel {
	private JTextField searchEmail_TF;
	private JTextField searchID_TF;
	private JTextField searchPhone_TF;
	private JTextField searchEmail2_TF;
	
	private MemberService memberService;
	private LoginService loginService;
	

	/**
	 * Create the panel.
	 */
	public SearchPanel() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JButton sbucksLogo = new JButton("");
		sbucksLogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sbucksLogo.setIcon(new ImageIcon(SearchPanel.class.getResource("/images/스타벅스로고큰ver.png")));
		sbucksLogo.setBounds(73, -23, 215, 167);
		sbucksLogo.setBorderPainted(false);
		sbucksLogo.setContentAreaFilled(false);
		sbucksLogo.setFocusPainted(false);
		sbucksLogo.setBorder(null);
		add(sbucksLogo);
		
		JLabel SearchTitle_LB = new JLabel("아이디/비밀번호 찾기");
		SearchTitle_LB.setHorizontalAlignment(SwingConstants.CENTER);
		SearchTitle_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.BOLD, 20));
		SearchTitle_LB.setBounds(46, 124, 257, 46);
		add(SearchTitle_LB);
		
		JLabel searchID_LB = new JLabel("아이디찾기");
		searchID_LB.setHorizontalAlignment(SwingConstants.LEFT);
		searchID_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 15));
		searchID_LB.setBounds(36, 191, 88, 16);
		add(searchID_LB);
		
		searchEmail_TF = new JTextField();
		searchEmail_TF.setBackground(new Color(245, 245, 245));
		searchEmail_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		searchEmail_TF.setColumns(10);
		searchEmail_TF.setBounds(34, 231, 197, 36);
		add(searchEmail_TF);
		
		searchID_TF = new JTextField();
		searchID_TF.setBackground(new Color(245, 245, 245));
		searchID_TF.setColumns(10);
		searchID_TF.setBounds(34, 378, 197, 36);
		add(searchID_TF);
		
		JLabel searchPassword_LB = new JLabel("패스워드 찾기");
		searchPassword_LB.setHorizontalAlignment(SwingConstants.LEFT);
		searchPassword_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 15));
		searchPassword_LB.setBounds(36, 342, 112, 16);
		add(searchPassword_LB);
		
		searchPhone_TF = new JTextField();
		searchPhone_TF.setBackground(new Color(245, 245, 245));
		searchPhone_TF.setColumns(10);
		searchPhone_TF.setBounds(128, 283, 100, 36);
		add(searchPhone_TF);
		
		searchEmail2_TF = new JTextField();
		searchEmail2_TF.setBackground(new Color(245, 245, 245));
		searchEmail2_TF.setColumns(10);
		searchEmail2_TF.setBounds(33, 436, 198, 36);
		add(searchEmail2_TF);
		
		JComboBox searchPhone_CB = new JComboBox();
		searchPhone_CB.setModel(new DefaultComboBoxModel(new String[] {"010", "017", "011"}));
		searchPhone_CB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		searchPhone_CB.setBounds(36, 289, 82, 27);
		add(searchPhone_CB);
		
		JLabel inputEmail_LB = new JLabel("*이메일을 입력하세요.");
		inputEmail_LB.setForeground(new Color(0, 128, 0));
		inputEmail_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 9));
		inputEmail_LB.setBounds(35, 213, 100, 16);
		add(inputEmail_LB);
		
		JLabel inputPhone_TF = new JLabel("*핸드폰번호를 입력하세요. * 'xxxx-xxxx'");
		inputPhone_TF.setForeground(new Color(0, 128, 0));
		inputPhone_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 9));
		inputPhone_TF.setBounds(35, 270, 173, 16);
		add(inputPhone_TF);
		
		JLabel inputID_LB = new JLabel("*아이디를 입력하세요.");
		inputID_LB.setForeground(new Color(0, 128, 0));
		inputID_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 9));
		inputID_LB.setBounds(35, 362, 112, 16);
		add(inputID_LB);
		
		JLabel inputEmail2_LB = new JLabel("*이메일을 입력하세요.");
		inputEmail2_LB.setForeground(new Color(0, 128, 0));
		inputEmail2_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 9));
		inputEmail2_LB.setBounds(35, 419, 115, 16);
		add(inputEmail2_LB);
		
		JButton confirmID_Btn = new JButton("");
		confirmID_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String email = searchEmail_TF.getText();
					String phone = (String)searchPhone_CB.getSelectedItem();
					String number = searchPhone_TF.getText();
					String exphoneNum = phone+"-"+number;
					Member findPassword = memberService.findId(email, exphoneNum);
					if(findPassword!=null) {
						JOptionPane.showMessageDialog(null, "회원님의 아이디는 "+ "\"" +findPassword.getMember_id()+"\"" +" 입니다.");
					}else {
						JOptionPane.showMessageDialog(null, "존재하는 아이디가 없습니다.");
					}
				}catch(Exception e1) {
					
				}
			}
		});
		confirmID_Btn.setBorderPainted(false);
		confirmID_Btn.setContentAreaFilled(false);
		confirmID_Btn.setFocusPainted(false);
		confirmID_Btn.setBorder(null);
		confirmID_Btn.setIcon(new ImageIcon(SearchPanel.class.getResource("/images/확인-2.png")));
		confirmID_Btn.setBounds(235, 230, 117, 86);
		add(confirmID_Btn);
		
		JButton confirmPassword_Btn = new JButton("");
		confirmPassword_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**********비밀번호찾기*************/
				try {
					String id = searchID_TF.getText();
					String email = searchEmail2_TF.getText();
					
					Login searchP = loginService.searchPassword(id, email);
					if(searchP!=null) {
						JOptionPane.showMessageDialog(null, "회원님의 비밀번호는 "+ "\"" +searchP.getMember_password()+"\"" +" 입니다.");
						
					}else {
						JOptionPane.showMessageDialog(null, "잘못 입력하셨습니다.");
						searchID_TF.setText("");
						searchEmail2_TF.setText("");
					}
					
				}catch(Exception e1){
					
					
				}
				
			}
		});
		confirmPassword_Btn.setBorderPainted(false);
		confirmPassword_Btn.setContentAreaFilled(false);
		confirmPassword_Btn.setFocusPainted(false);
		confirmPassword_Btn.setBorder(null);
		confirmPassword_Btn.setIcon(new ImageIcon(SearchPanel.class.getResource("/images/확인-2.png")));
		confirmPassword_Btn.setBounds(235, 382, 117, 86);
		add(confirmPassword_Btn);
		

		
		
		
		
		
		//객체생성
		memberService = new MemberService();
		loginService = new LoginService();
	}
	
	
}
