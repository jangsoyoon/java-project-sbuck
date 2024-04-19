package com.team2.sbucks.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.Scrollbar;
import java.awt.Panel;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class OrderListPanelJiHun extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public OrderListPanelJiHun() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel orderListLB = new JLabel("주문내역");
		add(orderListLB, BorderLayout.NORTH);
		
		Panel panel = new Panel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 800));
		panel_1.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"\uC8FC\uBB38\uBC88\uD638", "\uC8FC\uBB38\uB0A0\uC9DC", "\uD68C\uC6D0\uBC88\uD638"
			}
		));
		table.setBounds(12, 10, 327, 128);
		panel_1.add(table);

	}
}
