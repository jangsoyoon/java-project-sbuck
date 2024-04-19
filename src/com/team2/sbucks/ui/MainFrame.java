package com.team2.sbucks.ui;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import com.team2.sbucks.ui.LJH.OrderListPanel;
import com.team2.sbucks.dto.Product;
import com.team2.sbucks.dto.ProductDetail;
import com.team2.sbucks.ui.LJH.OrderDetailPanel;
import com.team2.sbucks.ui.productPanel.ProductAllPanel;
import com.team2.sbucks.ui.productPanel.ProductDetailPanel;
import java.awt.Toolkit;
import com.team2.sbucks.ui.LJH.OrderPanel;
import com.team2.sbucks.ui.order.CartPanel;
import com.team2.sbucks.ui.memberPanel.LoginPanel;
import com.team2.sbucks.ui.memberPanel.JoinPanel;
import com.team2.sbucks.ui.memberPanel.UpdatePanel;
import com.team2.sbucks.ui.LJH.CartItemPanel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import com.team2.sbucks.ui.memberPanel.SearchPanel;

public class MainFrame extends JFrame {

	public JPanel contentPane;
	public JTabbedPane tabbedPane;
	public JPanel MemberPanel;
	public JPanel Product;
	public JPanel OrderPanel;
	public JTabbedPane OrderTabbedPane;
	public JTabbedPane productTabbedPane;
	public ProductAllPanel ProductAllPanel;
	public ProductDetailPanel ProductDetailPanel;
	public Product selectedProduct;
	public ProductDetail selectedProductDetail;
	public OrderListPanel orderListPanel;
	public OrderDetailPanel orderDetailPanel;
	public OrderPanel orderPanel;
	public int memberNo=2;
	public int orderNo;
	public JTabbedPane MemberTabbedPane;
	public LoginPanel loginPanel;
	public UpdatePanel updatePanel;
	public CartItemPanel cartItemPanel;
	private JoinPanel joinPanel;
	private UpdatePanel updatePanel_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/images/스타벅스로고.png")));
		setTitle("sbucks");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		MemberPanel = new JPanel();
		tabbedPane.addTab("회원", null, MemberPanel, null);
		MemberPanel.setLayout(new BorderLayout(0, 0));
		
		MemberTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		MemberPanel.add(MemberTabbedPane);
		
		LoginPanel loginPanel_1 = new LoginPanel();
		MemberTabbedPane.addTab("로그인", null, loginPanel_1, null);
		
		Product = new JPanel();
		tabbedPane.addTab("상품", null, Product, null);
		Product.setLayout(new BorderLayout(0, 0));
		
		productTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		Product.add(productTabbedPane);
		
		ProductAllPanel = new ProductAllPanel();
		productTabbedPane.addTab("전체상품", null, ProductAllPanel, null);
		
		ProductDetailPanel = new ProductDetailPanel();
		productTabbedPane.addTab("상품상세", null, ProductDetailPanel, null);
		
		OrderPanel = new JPanel();
		tabbedPane.addTab("주문", null, OrderPanel, null);
		OrderPanel.setLayout(new BorderLayout(0, 0));
		
		OrderTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		OrderPanel.add(OrderTabbedPane);
		
		orderListPanel = new OrderListPanel();
		OrderTabbedPane.addTab("주문내역", null, orderListPanel, null);
		
		orderDetailPanel = new OrderDetailPanel();
		OrderTabbedPane.addTab("주문상세", null, orderDetailPanel, null);
		
		orderPanel = new OrderPanel();
		OrderTabbedPane.addTab("주문", null, orderPanel, null);
		
	    cartItemPanel = new CartItemPanel();
	    
		OrderTabbedPane.addTab("장바구니", null, cartItemPanel, null);
		
		/*************프레임의객체의주소를 패널에set ************/
		ProductAllPanel.setFrame(this);
		ProductDetailPanel.setFrame(this);
		orderDetailPanel.setFrame(this);
		orderListPanel.setFrame(this);
		orderPanel.setFrame(this);
		
		SearchPanel searchPanel = new SearchPanel();
		MemberTabbedPane.addTab("아이디/비밀번호 찾기", null, searchPanel, null);
		
		joinPanel = new JoinPanel();
		MemberTabbedPane.addTab("회원가입", null, joinPanel, null);
		
		updatePanel_1 = new UpdatePanel();
		MemberTabbedPane.addTab("회원정보", null, updatePanel_1, null);
		cartItemPanel.setFrame(this);
		
		
		
		/****************************************************/
	}
	
	public void test() {
		try {
			cartItemPanel.cartListDisplay(memberNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
