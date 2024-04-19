package com.team2.sbucks.ui.LJH;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.team2.sbucks.dto.Cart;
import com.team2.sbucks.dto.Product;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;

public class CartTestFrame extends JFrame {
	public Product product;
	public Cart cart;
	public int memberNo=2;
	public int cartNo;
	private JTabbedPane tabbedPane;
	private JPanel contentPane;
	public CartItemPanel cartItemPanel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CartTestFrame frame = new CartTestFrame();
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
	public CartTestFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		cartItemPanel = new CartItemPanel();
		tabbedPane.addTab("New tab", null, cartItemPanel, null);
		
		cartItemPanel.setFrame(this);
	}

}
