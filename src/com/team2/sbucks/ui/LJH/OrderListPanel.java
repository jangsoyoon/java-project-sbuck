package com.team2.sbucks.ui.LJH;

import javax.swing.JPanel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.team2.sbucks.dto.OrderList;
import com.team2.sbucks.service.OrderService;
import com.team2.sbucks.ui.MainFrame;
import com.team2.sbucks.ui.productPanel.ProductAllPanel;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import javax.swing.JSplitPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Color;

public class OrderListPanel extends JPanel {
	private JPanel orderListPanel;
	private OrderService orderService;
	private JPanel orderListBasicPanel;
	//private int memberNo;
	private int orderNo;
	private JLabel p_NameLB_1;
	private JLabel o_DateLB_1;
	private JLabel o_PriceLB_1;
	private JLabel p_imgLB_1;
	private JLabel o_NoLB_1;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	
	/******************/
	private MainFrame mainFrame;
	
	/***************/

	/**
	 * Create the panel.
	 */
	public OrderListPanel() {
		setBackground(new Color(255, 255, 255));
		orderService = new OrderService();
		setLayout(new BorderLayout(0, 0));

		lblNewLabel = new JLabel("주문 내역");
		lblNewLabel.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 31));
		add(lblNewLabel, BorderLayout.NORTH);

		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		orderListBasicPanel = new JPanel();
		orderListBasicPanel.setBackground(new Color(255, 255, 255));
		
		orderListBasicPanel.setPreferredSize(new Dimension(10, 800));
		scrollPane.setViewportView(orderListBasicPanel);

		orderListPanel = new JPanel();
		orderListPanel.setBackground(new Color(255, 255, 255));
		orderListPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
		orderListPanel.setPreferredSize(new Dimension(400, 100));
		orderListBasicPanel.add(orderListPanel);
		orderListPanel.setLayout(null);

		p_NameLB_1 = new JLabel("상품 이름");
		p_NameLB_1.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		p_NameLB_1.setBounds(144, 26, 139, 15);
		orderListPanel.add(p_NameLB_1);

		o_DateLB_1 = new JLabel("주문 날짜");
		o_DateLB_1.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		o_DateLB_1.setBounds(144, 64, 92, 15);
		orderListPanel.add(o_DateLB_1);

		o_PriceLB_1 = new JLabel("주문금액");
		o_PriceLB_1.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		o_PriceLB_1.setBounds(298, 64, 57, 15);
		orderListPanel.add(o_PriceLB_1);

		p_imgLB_1 = new JLabel("이미지");
		p_imgLB_1.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		p_imgLB_1.setBounds(41, 10, 77, 80);
		orderListPanel.add(p_imgLB_1);

		o_NoLB_1 = new JLabel("주문번호");
		o_NoLB_1.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 13));
		o_NoLB_1.setBounds(267, 10, 107, 15);
		orderListPanel.add(o_NoLB_1);

		

	} // 생성자 끝

	public void orderListDisplay(int memberNo) throws Exception {
		List<OrderList> orderList = new ArrayList<OrderList>();
		orderList = orderService.printAllOrderList(memberNo);

		orderListBasicPanel.removeAll();
		for (int i = 0; i < orderList.size(); i++) {
			OrderList order = orderList.get(i);

			orderListPanel = new JPanel();
			orderListPanel.setPreferredSize(new Dimension(310, 100));
			orderListBasicPanel.add(orderListPanel);
			orderListPanel.setLayout(null);

			orderListPanel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						System.out.println("주문완료");
						System.out.println(orderService.printOrder(order.getMember_no(), order.getOrder_no()));
						
						/******************
						 * 
						 * 
						 */
						
						mainFrame.orderNo=order.getOrder_no();
						mainFrame.OrderTabbedPane.setSelectedIndex(1);
						mainFrame.orderDetailPanel.orderDetailDisplay(order.getMember_no(), order.getOrder_no());
						
						
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
			});
			orderListPanel.setPreferredSize(new Dimension(310, 100));
			orderListBasicPanel.add(orderListPanel);
			orderListPanel.setLayout(null);

			JLabel p_NameLB = new JLabel(orderService.printOrder(memberNo, order.getOrder_no()).getOrderDetail().get(0)
					.getProduct().getProduct_name());
			p_NameLB.setBounds(144, 26, 139, 15);
			orderListPanel.add(p_NameLB);

			JLabel o_DateLB = new JLabel(order.getOrder_date() + "");
			o_DateLB.setBounds(144, 64, 92, 15);
			orderListPanel.add(o_DateLB);

			JLabel o_PriceLB = new JLabel(order.getOrder_price() + "원");
			o_PriceLB.setBounds(227, 64, 57, 15);
			orderListPanel.add(o_PriceLB);

			JLabel p_imgLB = new JLabel("이미지");
			p_imgLB.setIcon(new ImageIcon(
					OrderListPanel.class.getResource("/images/" + orderService.printOrder(memberNo, order.getOrder_no())
							.getOrderDetail().get(0).getProduct().getProduct_name() + ".jpg")));

			p_imgLB.setBounds(12, 10, 77, 80);
			orderListPanel.add(p_imgLB);

			JLabel o_NoLB = new JLabel("NO." + order.getOrder_no());
			o_NoLB.setBounds(267, 10, 107, 15);
			orderListPanel.add(o_NoLB);

		}
		
		
	}
		/**********************************/
		public void setFrame(MainFrame mainFrame) {
			this.mainFrame=mainFrame;
			
			try {
				if(mainFrame.memberNo>0) {
					orderListDisplay(mainFrame.memberNo);
					System.out.println(mainFrame.memberNo);
				}
				
			} catch (Exception e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}
		
	}

}
