package com.team2.sbucks.ui.LJH;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.team2.sbucks.dto.OrderDetail;
import com.team2.sbucks.dto.OrderList;
import com.team2.sbucks.dto.Product;
import com.team2.sbucks.service.OrderService;
import com.team2.sbucks.ui.MainFrame;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Color;

public class OrderDetailPanel extends JPanel {
	private OrderService orderService;
	private JPanel orderDetailBasicPanel;
	private JPanel orderDetailPanel;
	/*private int memberNo;
	private int orderNo;
	
	
	
	*/
	private JLabel lblNewLabel;
	private JButton returnOrderListBtn;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JLabel od_p_imgLB_1;
	private JLabel od_p_nameLB_1;
	private JLabel od_addELB_1;
	private JLabel od_addSLB_1;
	private JLabel od_PriceLB_1;
	private JLabel od_espressoLB_1;
	private JLabel od_syrupLB_1;
	private JLabel od_STMTLB_1;
	private JLabel od_qtyLB_1;
	private MainFrame mainFrame;

	/**
	 * Create the panel.
	 */
	public OrderDetailPanel() {
		orderService=new OrderService();
		setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		lblNewLabel = new JLabel("주문상세");
		lblNewLabel.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 31));
		panel.add(lblNewLabel, BorderLayout.WEST);

		returnOrderListBtn = new JButton("");
		returnOrderListBtn.setBorderPainted(false);
		returnOrderListBtn.setContentAreaFilled(false);
		returnOrderListBtn.setFocusPainted(false);
		returnOrderListBtn.setBorder(null);
		returnOrderListBtn.setIcon(new ImageIcon(OrderDetailPanel.class.getResource("/images/주문내역으로 돌아가기1.png")));
		returnOrderListBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mainFrame.OrderTabbedPane.setSelectedIndex(0);

				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
		panel.add(returnOrderListBtn, BorderLayout.EAST);

		scrollPane = new JScrollPane();
		
		add(scrollPane, BorderLayout.CENTER);

		orderDetailBasicPanel = new JPanel();
		orderDetailBasicPanel.setBackground(new Color(255, 255, 255));
		
		
		
		
		
		
		
		orderDetailBasicPanel.setPreferredSize(new Dimension(10, 800));
		scrollPane.setViewportView(orderDetailBasicPanel);
		
		orderDetailPanel = new JPanel();
		orderDetailPanel.setBorder(null);
		orderDetailPanel.setBackground(new Color(255, 255, 255));
		orderDetailPanel.setPreferredSize(new Dimension(400, 150));
		orderDetailBasicPanel.add(orderDetailPanel);
		orderDetailPanel.setLayout(null);
		
		od_p_imgLB_1 = new JLabel("이미지");
		od_p_imgLB_1.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		od_p_imgLB_1.setBounds(27, 18, 98, 101);
		orderDetailPanel.add(od_p_imgLB_1);

		od_p_nameLB_1 = new JLabel("상품 이름입니다~~~~~");
		od_p_nameLB_1.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		od_p_nameLB_1.setBounds(158, 10, 152, 15);
		orderDetailPanel.add(od_p_nameLB_1);

		od_addELB_1 = new JLabel("추가 샷 :");
		od_addELB_1.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		od_addELB_1.setBounds(158, 53, 57, 15);
		orderDetailPanel.add(od_addELB_1);

		od_addSLB_1 = new JLabel("추가 시럽 :");
		od_addSLB_1.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		od_addSLB_1.setBounds(268, 53, 75, 15);
		orderDetailPanel.add(od_addSLB_1);

		od_PriceLB_1 = new JLabel("금액");
		od_PriceLB_1.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		od_PriceLB_1.setBounds(158, 104, 98, 15);
		orderDetailPanel.add(od_PriceLB_1);

		od_espressoLB_1 = new JLabel("0");
		od_espressoLB_1.setBounds(226, 53, 23, 15);
		orderDetailPanel.add(od_espressoLB_1);

		od_syrupLB_1 = new JLabel("0");
		od_syrupLB_1.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		od_syrupLB_1.setBounds(355, 53, 57, 15);
		orderDetailPanel.add(od_syrupLB_1);

		od_STMTLB_1 = new JLabel("주문상태");
		od_STMTLB_1.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		od_STMTLB_1.setBounds(268, 104, 99, 15);
		orderDetailPanel.add(od_STMTLB_1);

		od_qtyLB_1 = new JLabel("수량");
		od_qtyLB_1.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		od_qtyLB_1.setBounds(322, 10, 57, 15);
		orderDetailPanel.add(od_qtyLB_1);
		
		


	} // 생성자 끝

	public void orderDetailDisplay(int memberNo,int orderNo) throws Exception {
		System.out.println("실행!!!!!!!!!!!!");
		OrderList orderList = orderService.printOrder(memberNo,orderNo);
		List<OrderDetail> orderDetail = orderList.getOrderDetail();

		orderDetailBasicPanel.removeAll();

		for (int i = 0; i < orderDetail.size(); i++) {
			OrderDetail order = orderDetail.get(i);
			Product product = order.getProduct();
			
			orderDetailPanel = new JPanel();
			orderDetailPanel.setPreferredSize(new Dimension(400, 150));
			orderDetailBasicPanel.add(orderDetailPanel);
			orderDetailPanel.setLayout(null);
			
			JLabel od_p_imgLB = new JLabel("이미지");
			od_p_imgLB.setIcon(
					new ImageIcon(OrderDetailPanel.class.getResource("/images/" + product.getProduct_name() + ".jpg")));
			od_p_imgLB.setBounds(27, 18, 98, 101);
			orderDetailPanel.add(od_p_imgLB);

			JLabel od_p_nameLB = new JLabel(product.getProduct_name());
			od_p_nameLB.setBounds(158, 10, 152, 15);
			orderDetailPanel.add(od_p_nameLB);

			JLabel od_addELB = new JLabel("추가 샷 :");
			od_addELB.setBounds(158, 53, 57, 15);
			orderDetailPanel.add(od_addELB);

			JLabel od_addSLB = new JLabel("추가 시럽 :");
			od_addSLB.setBounds(268, 53, 75, 15);
			orderDetailPanel.add(od_addSLB);

			JLabel od_PriceLB = new JLabel(order.getOrder_qty()
					* (product.getProduct_price() + (product.getProduct_espressoprice() * order.getProduct_espresso())
							+ (product.getProduct_syrupprice() * order.getProduct_syrup()))
					+ "원");
			od_PriceLB.setBounds(158, 104, 57, 15);
			orderDetailPanel.add(od_PriceLB);

			JLabel od_qtyLB = new JLabel("총" + order.getOrder_qty() + "개");
			od_qtyLB.setBounds(322, 10, 57, 15);
			orderDetailPanel.add(od_qtyLB);

		
			JLabel od_espressoLB = new JLabel(order.getProduct_espresso() + "");
			od_espressoLB.setBounds(226, 53, 23, 15);
			orderDetailPanel.add(od_espressoLB);

			JLabel od_syrupLB = new JLabel(order.getProduct_syrup() + "");
			od_syrupLB.setBounds(355, 53, 57, 15);
			orderDetailPanel.add(od_syrupLB);

			String stmt = "주문완료";
			switch (order.getOrder_stmt()) {
			case 2:
				stmt = "준비중";
				break;
			case 3:
				stmt = "준비완료";
				break;
			case 4:
				stmt = "픽업완료";
			default:
				break;
			}
			
			JLabel od_STMTLB = new JLabel(stmt);
			od_STMTLB.setBounds(268, 104, 99, 15);
			orderDetailPanel.add(od_STMTLB);

		}

	}

	/**********************************/
	public void setFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		
		
	}
}
