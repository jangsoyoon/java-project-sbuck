--insert 
/*
이름               널?       유형           
---------------- -------- ------------ 
PRODUCT_NO       NOT NULL NUMBER(10)   
PRODUCT_NAME              VARCHAR2(50) 
PRODUCT_PRICE             NUMBER(20)   
PRODUCT_ALLERGY           VARCHAR2(500) 
PRODUCT_CONTENT           VARCHAR2(500) 
PRODUCT_ESPRESSO          NUMBER(10)  --> 샷추가 하려면 주문하기에서 샷이랑 시럽을 update쿼리 써야될듯
PRODUCT_SYRUP             NUMBER(10)  --> 샷이랑 시럽테이블로 숫자에 따라 금액 테이블 필요
*/
desc product;
/*******product insert*******/
insert into product values (1,'(ICE)아메리카노',4500,'고카페인함유','진한 에스프레소에 시원한 정수물과 얼음을 더하여 스타벅스의 깔끔하고 강렬한 에스프레소를 가장 부드럽고 시원하게 즐길 수 있는 커피',0,0,500,300);
insert into product values (2,'(HOT)아메리카노',4500,'고카페인함유','진한 에스프레소와 뜨거운 물을 섞어 스타벅스의 깔끔하고 강렬한 에스프레소를 가장 부드럽게 잘 느낄 수 있는 커피',0,0,500,300);
insert into product values (3,'(ICE)카페라떼',5000,'알레르기 유발요인 : 우유','풍부하고 진한 농도의 에스프레소가 시원한 우유와 얼음을 만나 고소함과 시원함을 즐길 수 있는 대표적인 커피 라떼',0,0,500,300);
insert into product values (4,'(HOT)카페라떼',5000,'알레르기 유발요인 : 우유','풍부하고 진한 에스프레소가 신선한 스팀 밀크를 만나 부드러워진 커피 위에 우유 거품을 살짝 얹은 대표적인 커피 라떼',0,0,500,300);
insert into product values (5,'(ICE)카페모카',5500,'알레르기 유발요인 : 우유','진한 초콜릿 모카 시럽과 풍부한 에스프레소를 신선한 우유 그리고 얼음과 섞어 휘핑크림으로 마무리한 음료로 진한 에스프레소와 초콜릿 맛이 어우러진 커피',0,0,500,300);
insert into product values (6,'(HOT)카페모카',5500,'알레르기 유발요인 : 우유','진한 초콜릿 모카 시럽과 풍부한 에스프레소를 스팀 밀크와 섞어 휘핑크림으로 마무리한 음료로 진한 에스프레소와 초콜릿 맛이 어우러진 커피',0,0,500,300);
insert into product values (7,'(ICE)카라멜마키야또',5900,'알레르기 유발요인 : 대두 / 우유','향긋한 바닐라 시럽과 시원한 우유와 얼음을 넣고 점을 찍듯이 에스프레소를 부은 후 벌집 모양으로 카라멜 드리즐을 올린 달콤한 커피 음료',0,0,500,300);
insert into product values (8,'(HOT)카라멜마키야또',5900,'알레르기 유발요인 : 대두 / 우유','향긋한 바닐라 시럽과 따뜻한 스팀 밀크 위에 풍성한 우유 거품을 얹고 점을 찍듯이 에스프레소를 부은 후 벌집 모양으로 카라멜 드리즐을 올린 달콤한 커피 음료',0,0,500,300);
insert into product values (9,'(ICE)카푸치노',5000,'알레르기 유발요인 : 우유','풍부하고 진한 에스프레소에 신선한 우유와 우유 거품이 얼음과 함께 들어간 시원하고 부드러운 커피 음료',0,0,500,300);
insert into product values (10,'(HOT)카푸치노',5000,'알레르기 유발요인 : 우유','풍부하고 진한 에스프레소에 따뜻한 우유와 벨벳 같은 우유 거품이 1:1 비율로 어우러져 마무리된 커피 음료',0,0,500,300);

desc productdetail;
/*
이름         널? 유형         
---------- -- ---------- 
PRODUCT_NO    NUMBER(10) 
KAL           NUMBER(10) 
CAFFEINE      NUMBER(10) 
NA            NUMBER(10) 
*/
/*********productdetail insert**********/
insert into productdetail values (1,10,150,5);
insert into productdetail values (2,5,75,0);
insert into productdetail values (3,110,75,75);
insert into productdetail values (4,110,75,70);
insert into productdetail values (5,250,95,70);
insert into productdetail values (6,200,90,65);
insert into productdetail values (7,190,75,110);
insert into productdetail values (8,140,75,70);
insert into productdetail values (9,115,75,90);
insert into productdetail values (10,90,75,60);

