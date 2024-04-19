package com.team2.sbucks.ui.memberPanel;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.team2.sbucks.dto.Login;
import com.team2.sbucks.dto.Member;
import com.team2.sbucks.service.LoginService;
import com.team2.sbucks.service.MemberService;
import com.team2.sbucks.ui.MainFrame;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPanel extends JPanel {
	/**********멤버서비스 객체선언*************/
	private MemberService memberService;
	private LoginService loginService;
	/*******************************************/
	private JTextField password_TF;
	private JTextField id_TF;
	private JLabel idFalse_LB;
	private JLabel passwordFalse_LB;
	private MainFrame mainFrame;
	
	/*****************로그인한 회원**************/
	private Member loginMember = null;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setBackground(new Color(0, 111, 63));
		setLayout(null);

		JButton sbucksLogo = new JButton("");
		// 아이콘투명화
		sbucksLogo.setBorderPainted(false);
		sbucksLogo.setContentAreaFilled(false);
		sbucksLogo.setFocusPainted(false);
		sbucksLogo.setBorder(null);
		sbucksLogo.setIcon(new ImageIcon(LoginPanel.class.getResource("/images/스타벅스로고큰ver.png")));
		sbucksLogo.setBounds(59, 23, 251, 105);
		add(sbucksLogo);

		JLabel loginTitle_LB = new JLabel("로그인");
		loginTitle_LB.setForeground(new Color(255, 255, 255));
		loginTitle_LB.setHorizontalAlignment(SwingConstants.CENTER);
		loginTitle_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.BOLD, 20));
		loginTitle_LB.setBounds(108, 123, 140, 46);
		add(loginTitle_LB);

		JLabel idLB = new JLabel("아이디");
		idLB.setForeground(new Color(255, 255, 255));
		idLB.setHorizontalAlignment(SwingConstants.LEFT);
		idLB.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 17));
		idLB.setBounds(48, 248, 61, 16);
		add(idLB);

		JLabel passwordLB = new JLabel("패스워드");
		passwordLB.setForeground(new Color(255, 255, 255));
		passwordLB.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 17));
		passwordLB.setHorizontalAlignment(SwingConstants.LEFT);
		passwordLB.setBounds(48, 341, 98, 16);
		add(passwordLB);

		id_TF = new JTextField();
		id_TF.setBackground(new Color(245, 245, 245));
		id_TF.setBounds(135, 239, 150, 36);
		add(id_TF);
		id_TF.setColumns(10);

		password_TF = new JTextField();
		password_TF.setBackground(new Color(245, 245, 245));
		password_TF.setColumns(10);
		password_TF.setBounds(134, 334, 150, 36);
		add(password_TF);

		JButton loginBtn = new JButton("");
		loginBtn.setBorderPainted(false);
		loginBtn.setContentAreaFilled(false);
		loginBtn.setFocusPainted(false);
		loginBtn.setBorder(null);
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*************로그인**************/
				try {
					String id = id_TF.getText();
					String password = password_TF.getText();
					int loginResult = memberService.loginSuccess(id, password);
					if (loginResult == 1) {
						JOptionPane.showMessageDialog(null, "로그인에 성공하셨습니다.");
						Login update = new Login(id, password, 1);
						loginService.updateLogin(update);
						id_TF.setText("");
						password_TF.setText("");
						idFalse_LB.setVisible(false);
						passwordFalse_LB.setVisible(false);
						
					} else if (loginResult == 0) {
						idFalse_LB.setText("아이디가 틀렸습니다.");
						id_TF.requestFocus();
						id_TF.setText("");
						mainFrame.MemberTabbedPane.setEnabledAt(2, true);
					} else if (loginResult == 2) {
						passwordFalse_LB.setText("비밀번호가 틀렸습니다.");
						password_TF.requestFocus();
						password_TF.setText("");
						idFalse_LB.setVisible(false);
						mainFrame.MemberTabbedPane.setEnabledAt(2, false);
					} 
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		loginBtn.setIcon(new ImageIcon(LoginPanel.class.getResource("/images/loginwhite.png")));
		loginBtn.setBounds(59, 438, 226, 29);
		add(loginBtn);

		JLabel loginExplain_LB = new JLabel("회원 서비스 이용을 위해 로그인 해주세요.");
		loginExplain_LB.setForeground(new Color(220, 220, 220));
		loginExplain_LB.setHorizontalAlignment(SwingConstants.CENTER);
		loginExplain_LB.setFont(new Font("KoPubWorld돋움체 Light", Font.PLAIN, 13));
		loginExplain_LB.setBounds(48, 175, 261, 16);
		add(loginExplain_LB);

		idFalse_LB = new JLabel("");
		idFalse_LB.setForeground(new Color(255, 255, 255));
		idFalse_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 10));
		idFalse_LB.setBounds(49, 288, 117, 16);
		add(idFalse_LB);

		passwordFalse_LB = new JLabel("");
		passwordFalse_LB.setForeground(new Color(255, 255, 255));
		passwordFalse_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 10));
		passwordFalse_LB.setBounds(47, 378, 117, 16);
		add(passwordFalse_LB);
		
		JLabel searchIDPassword_LB = new JLabel("아이디   |   비밀번호 찾기");
		searchIDPassword_LB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//왜 안될까?
				//mainFrame.MemberTabbedPane.setSelectedIndex(1);
			}
		});
		searchIDPassword_LB.setForeground(new Color(192, 192, 192));
		searchIDPassword_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 10));
		searchIDPassword_LB.setBounds(175, 392, 123, 16);
		add(searchIDPassword_LB);

		/***************************
		 * 객체생성
		 ***************************/
		memberService = new MemberService();
		loginService = new LoginService();

	}
	public void setFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}	
	
	public void loginProccess(String id) throws Exception{
		Member loginSuccessMember = memberService.findById(id);
		loginMember = loginSuccessMember;
		
		
	}
	
}// 생성자 끝
