package com.team2.sbucks.ui.LJH;

import java.util.ArrayList;
import java.util.List;

import com.team2.sbucks.dto.OrderDetail;
import com.team2.sbucks.dto.OrderList;
import com.team2.sbucks.dto.Product;
import com.team2.sbucks.service.OrderService;
import com.team2.sbucks.service.ProductService;

public class ServiceTest {
public static void main(String[] args) throws Exception{
	OrderService orderService =new OrderService();
	ProductService productService=new ProductService();
	int memberNo=1;
	Product product;
	int qty=10;
	product=productService.selectByNo(3);
	product.setProduct_espresso(10);
	product.setProduct_syrup(10);
	orderService.createOneOrder(memberNo, product, qty);

}
	
}
