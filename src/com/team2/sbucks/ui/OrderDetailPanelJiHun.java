package com.team2.sbucks.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class OrderDetailPanelJiHun extends JPanel {
	private JTextField order_noTF;
	private JTextField od_coffeeNameTF;
	private JTextField od_coffeePriceTF;
	private JTextField od_espressoTF;
	private JTextField od_espressoPriceTF;
	private JTextField od_sypupTF;
	private JTextField od_sypupPriceTF;
	private JTextField od_totPriceTF;
	private JTextField od_totCountTF;
	private JLabel order_noLB;

	/**
	 * Create the panel.
	 */
	public OrderDetailPanelJiHun() {
		setLayout(null);
		
		order_noTF = new JTextField();
		order_noTF.setText("주문번호");
		order_noTF.setBounds(170, 24, 73, 35);
		add(order_noTF);
		order_noTF.setColumns(10);
		
		od_coffeeNameTF = new JTextField();
		od_coffeeNameTF.setText("커피 이름");
		od_coffeeNameTF.setBounds(41, 259, 131, 35);
		add(od_coffeeNameTF);
		od_coffeeNameTF.setColumns(10);
		
		od_coffeePriceTF = new JTextField();
		od_coffeePriceTF.setText("커피 가격");
		od_coffeePriceTF.setColumns(10);
		od_coffeePriceTF.setBounds(253, 259, 87, 35);
		add(od_coffeePriceTF);
		
		od_espressoTF = new JTextField();
		od_espressoTF.setHorizontalAlignment(SwingConstants.LEFT);
		od_espressoTF.setText("에스프레소 옵션");
		od_espressoTF.setBounds(41, 304, 127, 21);
		add(od_espressoTF);
		od_espressoTF.setColumns(10);
		
		od_espressoPriceTF = new JTextField();
		od_espressoPriceTF.setText("옵션 가격");
		od_espressoPriceTF.setColumns(10);
		od_espressoPriceTF.setBounds(253, 304, 87, 21);
		add(od_espressoPriceTF);
		
		od_sypupTF = new JTextField();
		od_sypupTF.setText("샷 옵션");
		od_sypupTF.setBounds(41, 340, 127, 21);
		add(od_sypupTF);
		od_sypupTF.setColumns(10);
		
		od_sypupPriceTF = new JTextField();
		od_sypupPriceTF.setText("샷 옵션 가격");
		od_sypupPriceTF.setColumns(10);
		od_sypupPriceTF.setBounds(253, 340, 87, 21);
		add(od_sypupPriceTF);
		
		od_totPriceTF = new JTextField();
		od_totPriceTF.setText("총 가격");
		od_totPriceTF.setBounds(220, 386, 120, 35);
		add(od_totPriceTF);
		od_totPriceTF.setColumns(10);
		
		od_totCountTF = new JTextField();
		od_totCountTF.setText("총 개수");
		od_totCountTF.setBounds(41, 390, 46, 28);
		add(od_totCountTF);
		od_totCountTF.setColumns(10);
		
		JButton od_cartJoinBtn = new JButton("메뉴 담기");
		od_cartJoinBtn.setBounds(128, 450, 113, 35);
		add(od_cartJoinBtn);
		
		order_noLB = new JLabel("주문번호");
		order_noLB.setBounds(105, 27, 53, 28);
		add(order_noLB);

	}
}
