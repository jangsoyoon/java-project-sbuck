package com.team2.sbucks.ui.memberPanel;

import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;

import com.team2.sbucks.dto.Login;
import com.team2.sbucks.dto.Member;
import com.team2.sbucks.service.LoginService;
import com.team2.sbucks.service.MemberService;
import com.team2.sbucks.ui.MainFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class JoinPanel extends JPanel {
	private JTextField joinID_TF;
	private JTextField joinPhone_TF;
	private JTextField joinBirth_TF;
	private JTextField joinEmail_TF;
	private JTextField joinLoc_TF;
	private JTextField joinNickname_TF;
	private JPasswordField joinPassword_TF;
	private JPasswordField joinCpassword_TF;
	
	/**********멤버서비스 객체선언*************/
	private MemberService memberService;
	private LoginService loginService;
	
	/**********로그인한 회원******************/
	private Member loginMember = null;
	
	/*********회원가입한 회원*****************/
	private Member newMember = null;
	
	/*********메인프레임*************/
	private MainFrame mainFrame;

	/**
	 * Create the panel.
	 */
	public JoinPanel() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JButton sbucksLogo = new JButton("");
		sbucksLogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//홈으로가기
			}
		});
		//이미지투명화
		sbucksLogo.setBorderPainted(false);
		sbucksLogo.setContentAreaFilled(false);
		sbucksLogo.setFocusPainted(false);
		sbucksLogo.setBorder(null);
		sbucksLogo.setIcon(new ImageIcon(JoinPanel.class.getResource("/images/스타벅스로고.png")));
		sbucksLogo.setBounds(56, 2, 242, 94);
		add(sbucksLogo);
		
		JLabel joinID_LB = new JLabel("아이디");
		joinID_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		joinID_LB.setBounds(31, 156, 57, 15);
		add(joinID_LB);
		
		JLabel joinPassword_LB = new JLabel("비밀번호");
		joinPassword_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		joinPassword_LB.setBounds(31, 194, 57, 15);
		add(joinPassword_LB);
		
		JLabel joinPhone_LB = new JLabel("핸드폰");
		joinPhone_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		joinPhone_LB.setBounds(31, 261, 57, 15);
		add(joinPhone_LB);
		
		JLabel joinBirth_LB = new JLabel("생일");
		joinBirth_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		joinBirth_LB.setBounds(31, 298, 57, 15);
		add(joinBirth_LB);
		
		JLabel joinEmail_LB = new JLabel("이메일");
		joinEmail_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		joinEmail_LB.setBounds(31, 331, 57, 15);
		add(joinEmail_LB);
		
		JLabel joinLoc_LB = new JLabel("지역");
		joinLoc_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		joinLoc_LB.setBounds(31, 396, 57, 15);
		add(joinLoc_LB);
		
		JCheckBox joinPagree_CB = new JCheckBox("핸드폰 정보제공 동의");
		joinPagree_CB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		joinPagree_CB.setBounds(35, 424, 148, 23);
		add(joinPagree_CB);
		
		JCheckBox joinEagree_CB = new JCheckBox("지역 정보제공 동의");
		joinEagree_CB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		joinEagree_CB.setBounds(205, 423, 146, 23);
		add(joinEagree_CB);
		
		joinID_TF = new JTextField();
		joinID_TF.setBackground(new Color(245, 245, 245));
		joinID_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		joinID_TF.setBounds(103, 153, 143, 21);
		add(joinID_TF);
		joinID_TF.setColumns(10);
		
		joinPhone_TF = new JTextField();
		joinPhone_TF.setBackground(new Color(245, 245, 245));
		joinPhone_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		joinPhone_TF.setColumns(10);
		joinPhone_TF.setBounds(172, 258, 74, 21);
		add(joinPhone_TF);
		
		joinBirth_TF = new JTextField();
		joinBirth_TF.setBackground(new Color(245, 245, 245));
		joinBirth_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		joinBirth_TF.setColumns(10);
		joinBirth_TF.setBounds(103, 295, 143, 21);
		add(joinBirth_TF);
		
		joinEmail_TF = new JTextField();
		joinEmail_TF.setBackground(new Color(245, 245, 245));
		joinEmail_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		joinEmail_TF.setColumns(10);
		joinEmail_TF.setBounds(103, 328, 143, 21);
		add(joinEmail_TF);
		
		joinLoc_TF = new JTextField();
		joinLoc_TF.setBackground(new Color(245, 245, 245));
		joinLoc_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		joinLoc_TF.setColumns(10);
		joinLoc_TF.setBounds(104, 393, 142, 21);
		add(joinLoc_TF);
		
		joinNickname_TF = new JTextField();
		joinNickname_TF.setBackground(new Color(245, 245, 245));
		joinNickname_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		joinNickname_TF.setColumns(10);
		joinNickname_TF.setBounds(104, 358, 142, 21);
		add(joinNickname_TF);
		
		JLabel joinNickname_LB = new JLabel("닉네임");
		joinNickname_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		joinNickname_LB.setBounds(31, 363, 57, 15);
		add(joinNickname_LB);
		
		JButton IDduplicate_Btn = new JButton("아이디 중복확인");
		IDduplicate_Btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*******아이디 중복확인*********/
				try {
					String id = joinID_TF.getText();
					boolean isSuccess=memberService.IDCheck(id);
				if(isSuccess==true) {
					JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.");
					joinPassword_TF.requestFocus();
			} else if(isSuccess==false) {
				JOptionPane.showMessageDialog(null, "존재하는 아이디입니다.");
			}
				
				} catch(Exception e1) {
					
				}
			}
		});
		IDduplicate_Btn.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 10));
		IDduplicate_Btn.setBounds(251, 153, 107, 23);
		add(IDduplicate_Btn);
		
		JLabel joinCpassword_LB = new JLabel("비밀번호확인");
		joinCpassword_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		joinCpassword_LB.setBounds(31, 225, 97, 15);
		add(joinCpassword_LB);
		
		joinPassword_TF = new JPasswordField();
		joinPassword_TF.setBackground(new Color(245, 245, 245));
		joinPassword_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		joinPassword_TF.setBounds(103, 191, 143, 21);
		add(joinPassword_TF);
		
		joinCpassword_TF = new JPasswordField();
		joinCpassword_TF.setBackground(new Color(245, 245, 245));
		joinCpassword_TF.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		joinCpassword_TF.setBounds(103, 222, 143, 21);
		add(joinCpassword_TF);
		
		JLabel joinTitle_LB = new JLabel("회원가입");
		joinTitle_LB.setHorizontalAlignment(SwingConstants.CENTER);
		joinTitle_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.BOLD, 20));
		joinTitle_LB.setBounds(105, 95, 140, 46);
		add(joinTitle_LB);
		
		JButton joinCancelBtn = new JButton("");
		joinCancelBtn.setBorderPainted(false);
		joinCancelBtn.setContentAreaFilled(false);
		joinCancelBtn.setFocusPainted(false);
		joinCancelBtn.setBorder(null);
		joinCancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//mainFrame.MemberTabbedPane.setSelectedIndex(0);
			}
		});
		joinCancelBtn.setIcon(new ImageIcon(JoinPanel.class.getResource("/images/취소.png")));
		joinCancelBtn.setBounds(59, 462, 117, 29);
		add(joinCancelBtn);
		
		
		
		JButton Passwordduplicate_Btn = new JButton("비밀번호 일치 확인");
		Passwordduplicate_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**********비밀번호 일치 확인***********/
				try {
					String password = joinPassword_TF.getText();
					String Cpassword = joinCpassword_TF.getText();
					boolean check = memberService.checkPassword(password, Cpassword);
					if(check ==true) {
						JOptionPane.showMessageDialog(null, "비밀번호가 일치합니다.");
						joinPhone_TF.requestFocus();
					}else {
						JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
						joinCpassword_TF.requestFocus();
						
					}
					
				}catch(Exception e1){
					
				}
			}
		});
		Passwordduplicate_Btn.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 10));
		Passwordduplicate_Btn.setBounds(251, 221, 107, 23);
		add(Passwordduplicate_Btn);
		
		JComboBox phoneCB = new JComboBox();
		phoneCB.setModel(new DefaultComboBoxModel(new String[] {"010", "011", "017"}));
		phoneCB.setBounds(104, 255, 61, 27);
		add(phoneCB);
		
		JButton Phonedublicate_Btn = new JButton("본인인증");
		Phonedublicate_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/********핸드폰 중복확인************/
				String ber = joinPhone_TF.getText();
				String phoneNum = (String)phoneCB.getSelectedItem();
				String phoneNumber = phoneNum+"-"+ber;
				String exphoneNum = phoneNumber;
				
				try {
					boolean check = memberService.duplicatePhone(exphoneNum);
				if(check==true) {
					JOptionPane.showMessageDialog(null, "본인인증이 완료되었습니다.");
					joinBirth_TF.requestFocus();
				}else {
					JOptionPane.showMessageDialog(null, "이미 가입되어 있는 번호입니다.");
					joinPhone_TF.requestFocus();
				}
				}catch(Exception e1){
					
				}
				
			}
			
			
			
		});
		
		JButton joinBtn = new JButton("");
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***********회원가입************/
				try {
				String id = joinID_TF.getText();
				String password = joinPassword_TF.getText();
				
				/******핸드폰 어떻게 처리해야할지 모르겠음********/
				String ber = joinPhone_TF.getText();
				String phoneNum = (String)phoneCB.getSelectedItem();
				String phoneNumber = phoneNum+ber;
				String exphoneNum=phoneNum+"-"+ber;
				phoneNumber = joinPhone_TF.getText();
				/****************************************/
				
				String birth = joinBirth_TF.getText();
				String nickName = joinNickname_TF.getText();
				String email = joinEmail_TF.getText();
				String loc = joinLoc_TF.getText();
				int pAgreeStr=-999;
				if(joinPagree_CB.isSelected()) {
					pAgreeStr=1;
					
				}else {
					pAgreeStr = 0;
				}
				
				int eAgreeStr=-999;
				if(joinEagree_CB.isSelected()) {
					eAgreeStr=1;
				}else {
					eAgreeStr=0;
				}
				if(id.equals("")|| password.equals("")||phoneNumber.equals("")|| birth.equals("")||nickName.equals("")||email.equals("")||loc.equals("")) {
					JOptionPane.showMessageDialog(null, "내용을 입력하세요.");
					return;
				}
				/*****번호처리문제******/
				//Member newMember = new Member(, id, phoneNumber, birth, email, nickName, loc, pAgreeStr, eAgreeStr);
				//memberService.insertMember(newMember);
				Member newMember = new Member(0,id, exphoneNum, birth, email, nickName, loc, pAgreeStr, eAgreeStr);
				Login newLogin = new Login(id, password, 1);
				boolean insertSuccess = memberService.addMember(newMember);
				if(insertSuccess==true) {
					JOptionPane.showMessageDialog(null, "회원가입에 성공하셨습니다.");
					loginService.insertLogin(newLogin);
					mainFrame.MemberTabbedPane.setSelectedIndex(4);
					
					
				}else {
					JOptionPane.showMessageDialog(null,"회원가입에 실패하셨습니다.");
				}
				
				/*
				 int insertSuccess = memberService.insertMember(newMember);
				 if(insertSuccess!=1){
				JOptionPane.showMessageDialog(null, "회원가입에 실패셨습니다.");
				 }else{
				 JOptionPane.showMessageDialog(null, "회원가입에 성공하셨습니다.");
				 }
				 */
				}catch(Exception e1) {
					
				}
				
			}
		});
		joinBtn.setBorderPainted(false);
		joinBtn.setContentAreaFilled(false);
		joinBtn.setFocusPainted(false);
		joinBtn.setBorder(null);
		joinBtn.setIcon(new ImageIcon(JoinPanel.class.getResource("/images/가입.png")));
		joinBtn.setBounds(202, 462, 90, 29);
		add(joinBtn);
		
		
		
		Phonedublicate_Btn.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 10));
		Phonedublicate_Btn.setBounds(251, 257, 77, 23);
		add(Phonedublicate_Btn);
		
		JButton Emailduplicate_Btn = new JButton("이메일인증");
		Emailduplicate_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String email = joinEmail_TF.getText();
				boolean check = memberService.duplicateEmail(email);
				if(check==true) {
					JOptionPane.showMessageDialog(null, "사용 가능한 이메일입니다.");
					joinNickname_TF.requestFocus();
				}else {
					JOptionPane.showMessageDialog(null, "이미 가입되어 있는 이메일입니다.");
					joinEmail_TF.requestFocus();
					
				}
				}catch(Exception e1) {
					
				}
				
			}
		});
		Emailduplicate_Btn.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 10));
		Emailduplicate_Btn.setBounds(251, 327, 77, 23);
		add(Emailduplicate_Btn);
		
		
		
		
		
		
		
		
		
		/***************************
		 * 객체생성
		 ***************************/
		memberService = new MemberService();
		loginService = new LoginService();

	}
	public void setFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		
		
	}
}//생성자끝
