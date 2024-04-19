package com.team2.sbucks.ui.LJH;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import com.team2.sbucks.dto.Cart;
import com.team2.sbucks.dto.Product;
import com.team2.sbucks.service.CartService;
import com.team2.sbucks.service.OrderService;
import com.team2.sbucks.service.ProductService;
import com.team2.sbucks.ui.MainFrame;
import com.team2.sbucks.ui.productPanel.ProductDetailPanel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseMotionAdapter;
import java.text.DecimalFormat;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class OrderPanel extends JPanel {
	private OrderService orderService;
	private CartService cartService;
	private ProductService productService;
	private Product product;
	int memberNo=1;
	int product_no=3;
	private MainFrame mainFrame;
	private JButton orderBtn;
	private JButton cartJoinBtn;
	private JLabel coffeeLB;
	private JComboBox coffeeCB;
	private JLabel sypUpLB;
	private JComboBox sypUpCB;
	private JLabel countLB;
	private JComboBox countCB;
	private JLabel item_imgLB;
	private JButton o_CancelBtn;
	private JLabel item_nameLB;
	private JLabel totalPriceLB;
	private JLabel item_PriceLB;
	private JLabel priceLB;

	
	
	
	/**
	 * Create the panel.
	 */
	public OrderPanel()  {
		setBackground(new Color(255, 255, 255));
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				item_imgLB.setIcon(new ImageIcon(OrderPanel.class.getResource("/images/"+mainFrame.selectedProduct.getProduct_name()+".jpg")));
				item_nameLB.setText(mainFrame.selectedProduct.getProduct_name());
				/*총가격*/
				priceLB.setText(mainFrame.selectedProduct.getProduct_price()+"");	
				
			}
			
			
			
		});
		
		
		productService=new ProductService();
		orderService=new OrderService();
		cartService=new CartService();
		
		
		try {
			product=productService.selectByNo(product_no);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		coffeeLB = new JLabel("에스프레소");
		coffeeLB.setBounds(89, 170, 68, 32);
		coffeeLB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		
		sypUpLB = new JLabel("시럽");
		sypUpLB.setBounds(89, 234, 68, 32);
		sypUpLB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 12));
		
		countLB = new JLabel("수량");
		countLB.setBounds(89, 296, 68, 32);
		countLB.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		coffeeCB = new JComboBox();
		coffeeCB.setBounds(222, 172, 32, 32);
		coffeeCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					displayPrice();
				}
			}
		});
		coffeeCB.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		
		sypUpCB = new JComboBox();
		sypUpCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					displayPrice();
				}
			}
		});
		sypUpCB.setBounds(222, 238, 32, 28);
		sypUpCB.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		
		countCB = new JComboBox();
		countCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					displayPrice();
				}
			}
		});
		countCB.setBounds(222, 298, 32, 28);
		countCB.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		
		
		
		cartJoinBtn = new JButton("");
		cartJoinBtn.setIcon(new ImageIcon(OrderPanel.class.getResource("/images/담기-2png.png")));
		cartJoinBtn.setBorderPainted(false);
		cartJoinBtn.setContentAreaFilled(false);
		cartJoinBtn.setFocusPainted(false);
		cartJoinBtn.setBorder(null);
		cartJoinBtn.setBounds(186, 421, 112, 41);
		cartJoinBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					System.out.println("장바구니");
					
					product=productService.selectByNo(product_no);
					String qty=(String) countCB.getSelectedItem();
					int iqty=Integer.parseInt(qty);
					System.out.println("중간");
					
					String syrup=(String)sypUpCB.getSelectedItem();
					int isyrup=Integer.parseInt(syrup);
					
					String espresso=(String)coffeeCB.getSelectedItem();
					int iespresso=Integer.parseInt(espresso);
					
					
					product.setProduct_espresso(iespresso);
					product.setProduct_syrup(isyrup);
					
					
					
					cartService.insertCart(product,memberNo,iqty);
					System.out.println("담겼음");
				
					
				} catch (Exception e2) {

				}
		
		mainFrame.OrderTabbedPane.setSelectedIndex(3);	
			}
		});
		
		
		orderBtn = new JButton("");
		orderBtn.setIcon(new ImageIcon(OrderPanel.class.getResource("/images/주문하기-1.png")));
		orderBtn.setBorderPainted(false);
		orderBtn.setContentAreaFilled(false);
		orderBtn.setFocusPainted(false);
		orderBtn.setBorder(null);
		orderBtn.setBounds(33, 422, 158, 38);
		orderBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					System.out.println("주문");
					
					product=productService.selectByNo(product_no);
					String qty=(String) countCB.getSelectedItem();
					int iqty=Integer.parseInt(qty);
					System.out.println("중간");
					
					String syrup=(String)sypUpCB.getSelectedItem();
					int isyrup=Integer.parseInt(syrup);
					
					String espresso=(String)coffeeCB.getSelectedItem();
					int iespresso=Integer.parseInt(espresso);
					
					
					product.setProduct_espresso(iespresso);
					product.setProduct_syrup(isyrup);
					
					orderService.createOneOrder(memberNo, product, iqty);
					
					System.out.println("주문완료");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		
		item_imgLB = new JLabel("상품이미지");
		item_imgLB.setBounds(116, 24, 99, 81);
		item_imgLB.setIcon(new ImageIcon(
				OrderListPanel.class.getResource("/images/" +product.getProduct_name() + ".jpg")));

		
		
		item_nameLB = new JLabel(product.getProduct_name());
		item_nameLB.setHorizontalAlignment(SwingConstants.CENTER);
		item_nameLB.setBounds(89, 125, 152, 28);
		item_nameLB.setFont(new Font("KoPubWorldDotum_Pro", Font.BOLD, 18));
		
		totalPriceLB = new JLabel("총가격");
		totalPriceLB.setBounds(87, 371, 42, 20);
		totalPriceLB.setFont(new Font("KoPubWorldDotum_Pro", Font.BOLD, 15));
		/*int qty=(int)countCB.getSelectedItem();
		int syrup=(int)sypUpCB.getSelectedItem();
		int espresso=(int)coffeeCB.getSelectedItem();
		*/
		item_PriceLB = new JLabel("원");
		item_PriceLB.setBounds(239, 370, 75, 20);
		item_PriceLB.setFont(new Font("KoPubWorldDotum_Pro", Font.BOLD, 15));
		/*
		item_PriceLB.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				item_PriceLB.setText(qty*(product.getProduct_price()+(product.getProduct_espressoprice()*syrup)+(product.getProduct_syrupprice()*espresso))+"원");
			}
		});
		*/
		o_CancelBtn = new JButton("");
		o_CancelBtn.setIcon(new ImageIcon(OrderPanel.class.getResource("/images/취소.png")));
		o_CancelBtn.setBorderPainted(false);
		o_CancelBtn.setContentAreaFilled(false);
		o_CancelBtn.setFocusPainted(false);
		o_CancelBtn.setBorder(null);
		o_CancelBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		o_CancelBtn.setBounds(238, 22, 83, 33);
		o_CancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.tabbedPane.setSelectedIndex(0);
				
			}
		});
		setLayout(null);
		
		priceLB = new JLabel("");
		priceLB.setBounds(171, 373, 57, 15);
		add(priceLB);
		add(orderBtn);
		add(cartJoinBtn);
		add(coffeeLB);
		add(coffeeCB);
		add(sypUpLB);
		add(sypUpCB);
		add(countLB);
		add(countCB);
		add(item_imgLB);
		add(o_CancelBtn);
		add(item_nameLB);
		add(totalPriceLB);
		add(item_PriceLB);

	}
	public void displayPrice() {
		int coffeCount=Integer.parseInt((String)coffeeCB.getSelectedItem());
		int syrupCount=Integer.parseInt((String)sypUpCB.getSelectedItem());
		int shopCount=Integer.parseInt((String)countCB.getSelectedItem());
		/*
		System.out.println(coffeCount);
		System.out.println(syrupCount);
		System.out.println(shotCount);
		*/					
		int totPrice=(product.getProduct_price()*shopCount)+(product.getProduct_syrupprice()*syrupCount)+(product.getProduct_espressoprice()*coffeCount);
		DecimalFormat df=new DecimalFormat("#,###,###");;
		String  strPrice=df.format(totPrice);
		priceLB.setText(strPrice);
		
	}
//생성자끝
	public void setFrame(MainFrame mainFrame) {
		this.mainFrame=mainFrame;
		
	}
}