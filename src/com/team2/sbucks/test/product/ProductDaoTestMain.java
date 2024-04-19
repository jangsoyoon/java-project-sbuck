package com.team2.sbucks.test.product;

import java.util.List;

import com.team2.sbucks.dao.product.ProductDao;
import com.team2.sbucks.dto.Product;




public class ProductDaoTestMain {

	public static void main(String[] args) throws Exception {
		
		ProductDao productDao= new ProductDao();
		
		/*
		 * 상품상세리스트 보기
		 */
		System.out.println(productDao.selectByNo(1));
		System.out.println();
		/*
		 * 상품전체 리스트보기
		 */
		List<Product> productList = productDao.selectAll();
		System.out.println(productList);
		
		/*
		 * 상품추가.
		 */
//		Product insertProduct1 = new Product(1,"(ICE)아메리카노",4500,"고카페인함유","진한 에스프레소에 시원한 정수물과 얼음을 더하여 스타벅스의 깔끔하고 강렬한 에스프레소를 가장 부드럽고 시원하게 즐길 수 있는 커피",0,0,500,300);
//		Product insertProduct2 = new Product(2,"(HOT)아메리카노",4500,"고카페인함유","진한 에스프레소와 뜨거운 물을 섞어 스타벅스의 깔끔하고 강렬한 에스프레소를 가장 부드럽게 잘 느낄 수 있는 커피",0,0,500,300);
//		Product insertProduct3 = new Product(3,"(ICE)카페라떼",5000,"알레르기 유발요인 : 우유","풍부하고 진한 농도의 에스프레소가 시원한 우유와 얼음을 만나 고소함과 시원함을 즐길 수 있는 대표적인 커피 라떼",0,0,500,300);
//		Product insertProduct4 = new Product(4,"(HOT)카페라떼",5000,"알레르기 유발요인 : 우유","풍부하고 진한 에스프레소가 신선한 스팀 밀크를 만나 부드러워진 커피 위에 우유 거품을 살짝 얹은 대표적인 커피 라떼",0,0,500,300);
//		Product insertProduct5 = new Product(5,"(ICE)카페모카",5500,"알레르기 유발요인 : 우유","진한 초콜릿 모카 시럽과 풍부한 에스프레소를 신선한 우유 그리고 얼음과 섞어 휘핑크림으로 마무리한 음료로 진한 에스프레소와 초콜릿 맛이 어우러진 커피",0,0,500,300);
//		Product insertProduct6 = new Product(6,"(HOT)카페모카",5500,"알레르기 유발요인 : 우유","진한 초콜릿 모카 시럽과 풍부한 에스프레소를 스팀 밀크와 섞어 휘핑크림으로 마무리한 음료로 진한 에스프레소와 초콜릿 맛이 어우러진 커피",0,0,500,300);
//		Product insertProduct7 = new Product(7,"(ICE)카라멜마키야또",5900,"알레르기 유발요인 : 대두 / 우유","향긋한 바닐라 시럽과 시원한 우유와 얼음을 넣고 점을 찍듯이 에스프레소를 부은 후 벌집 모양으로 카라멜 드리즐을 올린 달콤한 커피 음료",0,0,500,300);
//		Product insertProduct8 = new Product(8,"(HOT)카라멜마키야또",5900,"알레르기 유발요인 : 대두 / 우유","향긋한 바닐라 시럽과 따뜻한 스팀 밀크 위에 풍성한 우유 거품을 얹고 점을 찍듯이 에스프레소를 부은 후 벌집 모양으로 카라멜 드리즐을 올린 달콤한 커피 음료",0,0,500,300);
//		Product insertProduct9 = new Product(9,"(ICE)카푸치노",5000,"알레르기 유발요인 : 우유","풍부하고 진한 에스프레소에 신선한 우유와 우유 거품이 얼음과 함께 들어간 시원하고 부드러운 커피 음료",0,0,500,300);
//		Product insertProduct10 = new Product(10,"(HOT)카푸치노",5000,"알레르기 유발요인 : 우유","풍부하고 진한 에스프레소에 따뜻한 우유와 벨벳 같은 우유 거품이 1:1 비율로 어우러져 마무리된 커피 음료",0,0,500,300);
//		
//		//productDao.insertProduct(insertProduct1);
//		productDao.insertProduct(insertProduct2);
//		productDao.insertProduct(insertProduct3);
//		productDao.insertProduct(insertProduct4);
//		productDao.insertProduct(insertProduct5);
//		productDao.insertProduct(insertProduct6);
//		productDao.insertProduct(insertProduct7);
//		productDao.insertProduct(insertProduct8);
//		productDao.insertProduct(insertProduct9);
	
		/*
		 * 상품정보 업데이트
		 */
		//Product updateProduct = new Product(11, "(ICE)자몽허니블랙티", 5700, null, "새콤한 자몽과 달달한 꿀이 깊고 그윽한 풍미의 스타벅스 티바나 블랙티의 조화", 0, 0, 0, 0);
		//productDao.updateProduct(updateProduct);
		/*
		 * 상품한개삭제
		 */
//		productDao.deleteProduct(1);
//		productDao.deleteProduct(2);
//		productDao.deleteProduct(3);
//		productDao.deleteProduct(4);
//		productDao.deleteProduct(5);
//		productDao.deleteProduct(6);
//		productDao.deleteProduct(7);
//		productDao.deleteProduct(8);
//		productDao.deleteProduct(9);
		
	}

}
