package com.team2.sbucks.ui.productPanel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.SwingConstants;


import com.team2.sbucks.dto.Product;
import com.team2.sbucks.dto.ProductDetail;
import com.team2.sbucks.service.ProductDetailService;
import com.team2.sbucks.service.ProductService;
import com.team2.sbucks.ui.MainFrame;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class ProductAllPanel extends JPanel {
	private JPanel productListBasicpanel;
	private JPanel productitemPanel_1;
    private ProductService productService;
    private ProductDetailService productDetailService;
    private Product product;
    private ProductDetail productDetail;
	private JTextField productNameTF;
	private JTextField productPriceTF;
	private JTextField productAllergyTF;
	private JTextField productContentTF;
	private JTextField productKalTF;
	private JTextField productCaffineTF;
	private JTextField productNaTF;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	
	private MainFrame mainFrame;

	/**
	 * Create the panel.
	 */
	public ProductAllPanel() {
		setBorder(null);
		setBackground(new Color(255, 255, 255));
		setForeground(SystemColor.info);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(0, 22, 450, 278);
		add(scrollPane);
		
		productListBasicpanel = new JPanel();
		productListBasicpanel.setBorder(null);
		productListBasicpanel.setOpaque(false);
		productListBasicpanel.setBackground(new Color(255, 255, 255));
		
		productListBasicpanel.setForeground(new Color(46, 139, 87));
		productListBasicpanel.setPreferredSize(new Dimension(320, 1500));
		scrollPane.setViewportView(productListBasicpanel);
		productListBasicpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		productitemPanel_1 = new JPanel();

		productListBasicpanel.add(productitemPanel_1);
		productitemPanel_1.setLayout(null);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		lblNewLabel_6.setBounds(5, 5, 100, 100);
		
		
		lblNewLabel_6.setIcon(new ImageIcon(ProductAllPanel.class.getResource("/images/(HOT)아메리카노.jpg")));
		productitemPanel_1.add(lblNewLabel_6);
		
		lblNewLabel_5 = new JLabel("(HOT)아메리카노");
		lblNewLabel_5.setBounds(110, 46, 93, 17);
		lblNewLabel_5.setFont(new Font("KoPubWorldDotum_Pro", Font.BOLD, 12));
		productitemPanel_1.add(lblNewLabel_5);
		
		lblNewLabel_4 = new JLabel("<html>안녕<br>안녕</html>");
		lblNewLabel_4.setBounds(208, 40, 22, 30);
		lblNewLabel_4.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 11));
		
		productitemPanel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("전체상품");
		lblNewLabel_3.setBounds(6, 1, 71, 22);
		lblNewLabel_3.setFont(new Font("KoPubWorldDotum_Pro", Font.BOLD, 14));
		/*********************************************************/
		add(lblNewLabel_3);
		productService=new ProductService();
		try {
			productListDispaly();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//생성자끝
	/**
	 * @throws Exception *********************************************************/
	public void productListDispaly() throws Exception{
		java.util.List<Product>  productList=productService.selectAll();

		ProductService productService= new ProductService();
		ProductDetailService productDetailService=new ProductDetailService();
		
		productListBasicpanel.removeAll();
		for(int i=0;i<productList.size();i++) {
			
			Product product = productList.get(i);
			productitemPanel_1 = new JPanel();
			
			productitemPanel_1.setPreferredSize(new Dimension(400, 130));
			productListBasicpanel.add(productitemPanel_1);
			productitemPanel_1.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblNewLabel.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					
					
					try {
						
						/********************************************************/
						ProductDetail selectedProductDetail=productDetailService.selectByNo(product.getProduct_no());
						Product selectedProduct=productService.selectByNo(product.getProduct_no());
						
						mainFrame.selectedProduct=selectedProduct;
						mainFrame.selectedProductDetail=selectedProductDetail;
						/*******************************************************/
						
						mainFrame.productTabbedPane.setSelectedIndex(1);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			lblNewLabel.setIcon(new ImageIcon(ProductAllPanel.class.getResource("/images/"+product.getProduct_name()+".jpg")));


			lblNewLabel.setBounds(12, 10, 107, 98);
			
			productitemPanel_1.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel(product.getProduct_name());
			lblNewLabel_1.setBounds(120, 20, 113, 15);
			lblNewLabel_1.setFont(new Font("KoPubWorldDotum_Pro", Font.BOLD, 12));
			productitemPanel_1.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("<html>"+product.getProduct_content()+"</html>");
			lblNewLabel_2.setBounds(120, 35, 231, 73);
			lblNewLabel_2.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 11));
			productitemPanel_1.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("전체상품");
			lblNewLabel_3.setFont(new Font("KoPubWorldDotum_Pro", Font.BOLD, 16));
			
			
		}
		
	}//생성자끝
	public void setFrame(MainFrame mainFrame) {
		this.mainFrame=mainFrame;
		
	}

}//클래스끝
