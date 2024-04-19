package com.team2.sbucks.ui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.team2.sbucks.dto.Product;
import com.team2.sbucks.service.CartService;
import com.team2.sbucks.ui.productPanel.ProductAllPanel;
import com.team2.sbucks.ui.productPanel.ProductDetailPanel;

import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class CartPanel extends JPanel {
	private JTextField allnumTF;
	private JTextField allpriceTF;
	private CartService cartService;
	private JPanel panel;
	private JPanel panel_1;
	private JButton productalldeleteBtn;
	private Product product; 
	private JTextField productpriceTF;
	private JTextField syrupnumTF;
	private JTextField espressonumTF;
	private JTextField productnameTF;
	private JTextField productnumTF;
	private MainFrame mainFrame;
	private ProductAllPanel productAllPanel; 
	
	public CartPanel() {
		cartService=new CartService();
		setLayout(null);
		
		
		
		
		
		
		panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 370, 85);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("장바구니");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(12, 10, 135, 65);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(Color.WHITE);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);

		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("총");
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(12, 27, 18, 23);
		panel_1.add(lblNewLabel_4);
		
		allnumTF = new JTextField();
		allnumTF.setOpaque(false);
		allnumTF.setFont(new Font("굴림", Font.PLAIN, 18));
		allnumTF.setBounds(34, 29, 25, 21);
		panel_1.add(allnumTF);
		allnumTF.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("개");
		lblNewLabel_4_1.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_4_1.setBounds(62, 27, 18, 23);
		panel_1.add(lblNewLabel_4_1);
		
		allpriceTF = new JTextField();
		allpriceTF.setBackground(Color.LIGHT_GRAY);
		allpriceTF.setFont(new Font("굴림", Font.PLAIN, 22));
		allpriceTF.setBounds(223, 23, 135, 33);
		panel_1.add(allpriceTF);
		allpriceTF.setColumns(10);
		
		JButton orderBtn = new JButton("");
		orderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		orderBtn.setIcon(new ImageIcon("C:\\Users\\ITWILL\\Desktop\\주문하기.PNG"));
		orderBtn.setForeground(Color.WHITE);
		orderBtn.setBackground(Color.GREEN);
		orderBtn.setBounds(120, 71, 117, 23);
		panel_1.add(orderBtn);
		
		JLabel lblNewLabel_6 = new JLabel("결제금액");
		lblNewLabel_6.setBounds(154, 32, 57, 15);
		panel_1.add(lblNewLabel_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(0, 140, 370, 3);
		add(panel_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.LIGHT_GRAY);
		panel_2_1.setBounds(0, 399, 370, 3);
		add(panel_2_1);
		
		JLabel lblNewLabel = new JLabel("음료/푸드");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel.setBounds(139, 94, 88, 36);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("주문 메뉴");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(22, 156, 67, 26);
		add(lblNewLabel_1);
		
		JButton productchoicedeleteBtn = new JButton("");
		productchoicedeleteBtn.setIcon(new ImageIcon(CartPanel.class.getResource("/images/선택삭제-2.png")));
		productchoicedeleteBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		productchoicedeleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int cart_no=1;
					cartService.deleteCartItem(cart_no);
				}catch(Exception e2){
					
				}
			}
		});
		productchoicedeleteBtn.setContentAreaFilled(false);
		productchoicedeleteBtn.setBorderPainted(false);
		productchoicedeleteBtn.setContentAreaFilled(false);
		productchoicedeleteBtn.setFocusPainted(false);
		productchoicedeleteBtn.setBorder(null);
		productchoicedeleteBtn.setFont(new Font("굴림", Font.PLAIN, 8));
		productchoicedeleteBtn.setBounds(199, 157, 84, 27);
		add(productchoicedeleteBtn);
		
		productalldeleteBtn = new JButton("");
		productalldeleteBtn.setIcon(new ImageIcon(CartPanel.class.getResource("/images/전체삭제-2.png")));
		productalldeleteBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		productalldeleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int member_no=1;
					cartService.deleteCart(member_no);
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
			}
		});
		productalldeleteBtn.setContentAreaFilled(false);
		productalldeleteBtn.setContentAreaFilled(false);
		productalldeleteBtn.setBorderPainted(false);
		productalldeleteBtn.setContentAreaFilled(false);
		productalldeleteBtn.setFocusPainted(false);
		productalldeleteBtn.setBorder(null);
		productalldeleteBtn.setFont(new Font("굴림", Font.PLAIN, 8));
		productalldeleteBtn.setBounds(288, 157, 67, 27);
		add(productalldeleteBtn);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(281, 156, 2, 26);
		add(panel_3);
		try {
			String price = Integer.toString(cartService.cartItemPrice(11));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		JPanel panel_4 = new JPanel();

		add(panel_4);
		panel_4.setLayout(null);
		
		
		
		JPanel producPN_1 = new JPanel();
		producPN_1.setLayout(null);
		producPN_1.setBounds(0, 10, 370, 181);
		panel_4.add(producPN_1);
		
		JCheckBox pricechoiceCB = new JCheckBox("");
		pricechoiceCB.setBounds(8, 6, 21, 23);
		producPN_1.add(pricechoiceCB);
		
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setIcon(new ImageIcon(CartPanel.class.getResource("/images/(HOT)아메리카노.jpg")));
		lblNewLabel_2_1.setBounds(8, 45, 107, 97);
		producPN_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("espresso");
		lblNewLabel_5_2_1.setBounds(125, 63, 58, 15);
		producPN_1.add(lblNewLabel_5_2_1);
		
		JLabel lblNewLabel_5_1_2_1 = new JLabel("syrup");
		lblNewLabel_5_1_2_1.setBounds(127, 94, 58, 15);
		producPN_1.add(lblNewLabel_5_1_2_1);
		
		JLabel lblNewLabel_5_1_1_1_2 = new JLabel("price");
		lblNewLabel_5_1_1_1_2.setBounds(129, 156, 58, 15);
		producPN_1.add(lblNewLabel_5_1_1_1_2);
		
		JComboBox espressonumCB_1 = new JComboBox();
		espressonumCB_1.setBounds(218, 59, 40, 23);
		producPN_1.add(espressonumCB_1);
		
		JComboBox syrupnumCB_1 = new JComboBox();
		syrupnumCB_1.setBounds(219, 90, 40, 23);
		producPN_1.add(syrupnumCB_1);
		
		JComboBox pricenumCB_1 = new JComboBox();
		pricenumCB_1.setBounds(219, 122, 40, 23);
		producPN_1.add(pricenumCB_1);
		
		productpriceTF = new JTextField();
		productpriceTF.setEnabled(false);
		productpriceTF.setEditable(false);
		productpriceTF.setColumns(10);
		productpriceTF.setBounds(270, 150, 88, 21);
		
		producPN_1.add(productpriceTF);
		
		syrupnumTF = new JTextField();
		syrupnumTF.setEnabled(false);
		syrupnumTF.setEditable(false);
		syrupnumTF.setColumns(10);
		syrupnumTF.setBounds(270, 92, 88, 21);
		producPN_1.add(syrupnumTF);
		
		espressonumTF = new JTextField();
		espressonumTF.setEditable(false);
		espressonumTF.setEnabled(false);
		espressonumTF.setColumns(10);
		espressonumTF.setBounds(270, 60, 88, 21);
		producPN_1.add(espressonumTF);
		
		productnameTF = new JTextField();
		productnameTF.setEditable(false);
		productnameTF.setEnabled(false);
		productnameTF.setFont(new Font("굴림", Font.PLAIN, 20));
		productnameTF.setColumns(10);
		productnameTF.setBounds(121, 21, 238, 23);
		producPN_1.add(productnameTF);
		
		productnumTF = new JTextField();
		productnumTF.setEnabled(false);
		productnumTF.setEditable(false);
		productnumTF.setColumns(10);
		productnumTF.setBounds(270, 123, 88, 21);
		producPN_1.add(productnumTF);
		
		JLabel lblNewLabel_5_1_1_1_1_1 = new JLabel("quantity");
		lblNewLabel_5_1_1_1_1_1.setBounds(127, 127, 58, 15);
		producPN_1.add(lblNewLabel_5_1_1_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 650, 370, -499);
		add(scrollPane);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnNewButton.setBounds(10, 95, 36, 23);
		add(btnNewButton);
	}//생성자끝
	
	public void setFrame(MainFrame mainFrame) {
		this.mainFrame=mainFrame;
	}

	
}//클래스 끝

