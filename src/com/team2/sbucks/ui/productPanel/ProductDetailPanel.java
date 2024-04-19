package com.team2.sbucks.ui.productPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.team2.sbucks.dto.Product;
import com.team2.sbucks.dto.ProductDetail;
import com.team2.sbucks.ui.MainFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ProductDetailPanel extends JPanel {
	private JTextField productNameTF;
	private JTextField productPriceTF;
	private JTextField productAllergyTF;
	private JTextField productKalTF;
	private JTextField productCaffineTF;
	private JTextField productNaTF;
	private Product product;
	private ProductDetail productDetial;
	
	private MainFrame mainFrame;
	private JLabel lblNewLabel_4;
	
	/**
	 * Create the panel.
	 */
	public ProductDetailPanel() {
		setBackground(new Color(255, 255, 255));
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				if(mainFrame.selectedProduct!=null  && mainFrame.selectedProductDetail!=null) {
					productNameTF.setText(mainFrame.selectedProduct.getProduct_name());
					productPriceTF.setText(mainFrame.selectedProduct.getProduct_price()+"");
					productAllergyTF.setText(mainFrame.selectedProduct.getProduct_allergy());
					productKalTF.setText(mainFrame.selectedProductDetail.getKal()+"");
					productCaffineTF.setText(mainFrame.selectedProductDetail.getCaffeine()+"");
					productNaTF.setText(mainFrame.selectedProductDetail.getNa()+"");
					lblNewLabel_4.setIcon(new ImageIcon(ProductDetailPanel.class.getResource("/images/"+mainFrame.selectedProduct.getProduct_name()+".jpg")));
					
					
				}
				
					
				
			}
			
			
			
		});
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("상품이름");
		lblNewLabel.setBounds(62, 200, 57, 15);
		lblNewLabel.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("상품상세");
		lblNewLabel_1.setBounds(44, 154, 70, 30);
		lblNewLabel_1.setForeground(new Color(0, 100, 0));
		lblNewLabel_1.setFont(new Font("KoPubWorldDotum_Pro", Font.BOLD, 18));
		add(lblNewLabel_1);
		
		productNameTF = new JTextField();
		productNameTF.setBackground(new Color(245, 245, 245));
		productNameTF.setBounds(139, 197, 154, 21);
		add(productNameTF);
		productNameTF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("상품가격");
		lblNewLabel_2.setBounds(62, 230, 57, 15);
		lblNewLabel_2.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		add(lblNewLabel_2);
		
		productPriceTF = new JTextField();
		productPriceTF.setBackground(new Color(245, 245, 245));
		productPriceTF.setBounds(139, 228, 154, 21);
		add(productPriceTF);
		productPriceTF.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("알러지정보");
		lblNewLabel_3.setBounds(52, 262, 84, 15);
		lblNewLabel_3.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		add(lblNewLabel_3);
		
		productAllergyTF = new JTextField();
		productAllergyTF.setBackground(new Color(245, 245, 245));
		productAllergyTF.setBounds(139, 259, 154, 21);
		add(productAllergyTF);
		productAllergyTF.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("영양정보");
		lblNewLabel_6.setBounds(41, 308, 85, 30);
		lblNewLabel_6.setForeground(new Color(0, 100, 0));
		lblNewLabel_6.setFont(new Font("KoPubWorldDotum_Pro", Font.BOLD, 18));
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("칼로리");
		lblNewLabel_7.setBounds(72, 352, 57, 15);
		lblNewLabel_7.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("카페인");
		lblNewLabel_8.setBounds(72, 385, 57, 15);
		lblNewLabel_8.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("나트륨");
		lblNewLabel_9.setBounds(72, 421, 57, 15);
		lblNewLabel_9.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		add(lblNewLabel_9);
		
		productKalTF = new JTextField();
		productKalTF.setBackground(new Color(245, 245, 245));
		productKalTF.setBounds(139, 349, 154, 21);
		add(productKalTF);
		productKalTF.setColumns(10);
		
		productCaffineTF = new JTextField();
		productCaffineTF.setBackground(new Color(245, 245, 245));
		productCaffineTF.setBounds(139, 382, 154, 21);
		add(productCaffineTF);
		productCaffineTF.setColumns(10);
		
		productNaTF = new JTextField();
		productNaTF.setBackground(new Color(245, 245, 245));
		productNaTF.setBounds(139, 418, 154, 21);
		add(productNaTF);
		productNaTF.setColumns(10);
		
		
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(80, 10, 213, 151);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon(ProductDetailPanel.class.getResource("/images/(ICE)아메리카노.jpg")));
		add(lblNewLabel_4);
		
		JButton orderBtn = new JButton("");
		orderBtn.setBorderPainted(false);
		orderBtn.setContentAreaFilled(false);
		orderBtn.setFocusPainted(false);
		orderBtn.setBorder(null);
		orderBtn.setIcon(new ImageIcon(ProductDetailPanel.class.getResource("/images/주문하기-1.png")));
		orderBtn.setBounds(78, 461, 197, 41);
		orderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		orderBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				/*******************************************/
				mainFrame.tabbedPane.setSelectedIndex(2);
				mainFrame.OrderTabbedPane.setSelectedIndex(2);
			}
		});
		add(orderBtn);
		
		
		
		
		
		

	}//생성자끝

	public void setFrame(MainFrame mainFrame) {
		this.mainFrame=mainFrame;
	}
}//클래스 끝