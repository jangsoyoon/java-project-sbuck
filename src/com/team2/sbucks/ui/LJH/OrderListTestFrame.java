package com.team2.sbucks.ui.LJH;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.team2.sbucks.dto.OrderDetail;
import com.team2.sbucks.dto.OrderList;
import com.team2.sbucks.dto.Product;

import javax.swing.JTabbedPane;

public class OrderListTestFrame extends JFrame {

	public JPanel contentPane;
	public OrderListPanel orderListPanel;
	
	public Product product;
	public OrderList orderList;
	public OrderDetail orderDetail;
	public int memberNo=3;
	public int orderNo;
	public JTabbedPane tabbedPane;
	public OrderDetailPanel orderDetailPanel;
	public OrderPanel orderPanel;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderListTestFrame frame = new OrderListTestFrame();
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
	public OrderListTestFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		orderListPanel = new OrderListPanel();
		tabbedPane.addTab("New tab", null, orderListPanel, null);
		orderDetailPanel = new OrderDetailPanel();
		tabbedPane.addTab("New tab", null, orderDetailPanel, null);
		orderPanel = new OrderPanel();
		tabbedPane.addTab("New tab", null, orderPanel, null);
		/************************************프레임 객체의주소를 패널에 set**********/
		/*
		orderListPanel.setFrame(this);
		
		orderDetailPanel.setFrame(this);
		
		orderPanel.setFrame(this);
		*/
		
	}

}
