package com.team2.sbucks.ui.memberPanel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

public class MySuperFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySuperFrame frame = new MySuperFrame();
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
	public MySuperFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel memberPanel = new JPanel();
		tabbedPane.addTab("New tab", null, memberPanel, null);
		memberPanel.setLayout(null);
		
		JTabbedPane memberTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		memberTabbedPane.setBounds(0, 0, 369, 512);
		memberPanel.add(memberTabbedPane);
		
		LoginPanel loginPanel = new LoginPanel();
		memberTabbedPane.addTab("New tab", null, loginPanel, null);
		
		JoinPanel joinPanel = new JoinPanel();
		memberTabbedPane.addTab("New tab", null, joinPanel, null);
		
		UpdatePanel updatePanel = new UpdatePanel();
		memberTabbedPane.addTab("New tab", null, updatePanel, null);
	}
}
