package com.team2.sbucks.ui;

import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class OrderListPanel1JH extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public OrderListPanel1JH() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(67, 48, 235, 185);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
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
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"\uC8FC\uBB38\uBC88\uD638", "\uC8FC\uBB38\uB0A0\uC9DC", "\uC0C1\uD488\uBC88\uD638"
			}
		));
		scrollPane.setViewportView(table);

	}

}
