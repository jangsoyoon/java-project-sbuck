package com.team2.sbucks.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.team2.sbucks.ui.productPanel.ProductAllPanel;
import com.team2.sbucks.ui.productPanel.ProductDetailPanel;

public class MainFrameHeeCheol extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrameHeeCheol frame = new MainFrameHeeCheol();
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
	public MainFrameHeeCheol() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ProductAllPanel productAllPanel = new ProductAllPanel();
		contentPane.add(productAllPanel, BorderLayout.CENTER);
		
		ProductDetailPanel productDetailPanel = new ProductDetailPanel();
		contentPane.add(productDetailPanel, BorderLayout.NORTH);

	}

}
