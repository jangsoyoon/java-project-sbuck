package com.team2.sbucks.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import com.team2.sbucks.ui.productPanel.ProductDetailPanel;
import com.team2.sbucks.dto.Product;
import com.team2.sbucks.dto.ProductDetail;
import com.team2.sbucks.ui.productPanel.ProductAllPanel;

public class MainFrameJiwon extends JFrame {

	public JPanel contentPane;
	public ProductAllPanel productAllPanel;
	public ProductDetailPanel productDetailPanel;
	public JTabbedPane tabbedPane;
	public Product selectedProduct;
	public ProductDetail selectedProductDetail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrameJiwon frame = new MainFrameJiwon();
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
	public MainFrameJiwon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		productDetailPanel = new ProductDetailPanel();
		tabbedPane.addTab("New tab", null, productDetailPanel, null);
		
		productAllPanel = new ProductAllPanel();
		tabbedPane.addTab("New tab", null, productAllPanel, null);
		/*************프레임의객체의주소를 패널에set ************/
		productAllPanel.setFrame(this);
		productDetailPanel.setFrame(this);
		/****************************************************/
	}
		

}