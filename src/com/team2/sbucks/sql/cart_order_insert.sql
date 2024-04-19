desc cart;
/*
이름               널?       유형         
---------------- -------- ---------- 
CART_NO          NOT NULL NUMBER(10) 
PRODUCT_NO                NUMBER(10) 
MEMBER_NO                 NUMBER(10) 
CART_QTY                  NUMBER(10) 
PRODUCT_ESPRESSO          NUMBER(10) 
PRODUCT_SYRUP             NUMBER(10) 
*/

--insert cart
insert into cart (cart_no,product_no,member_no,cart_qty,product_espresso,product_syrup) values (cart_cart_no_SEQ.nextval,1,1,1,1,1); 
insert into cart (cart_no,product_no,member_no,cart_qty,product_espresso,product_syrup) values (cart_cart_no_SEQ.nextval,1,1,2,3,3); 
insert into cart (cart_no,product_no,member_no,cart_qty,product_espresso,product_syrup) values (cart_cart_no_SEQ.nextval,1,1,3,1,0); 
insert into cart (cart_no,product_no,member_no,cart_qty,product_espresso,product_syrup) values (cart_cart_no_SEQ.nextval,1,2,1,1,1); 
insert into cart (cart_no,product_no,member_no,cart_qty,product_espresso,product_syrup) values (cart_cart_no_SEQ.nextval,1,3,1,1,1); 


desc orderlist;
/*
이름          널?       유형         
----------- -------- ---------- 
ORDER_NO    NOT NULL NUMBER(10) 
ORDER_DATE           DATE       
MEMBER_NO            NUMBER(10) 
ORDER_PRICE          NUMBER(10) 
*/

desc orderdetail;
/*
이름               널?       유형         
---------------- -------- ---------- 
ORDERDETAIL_NO   NOT NULL NUMBER(10) 
ORDER_NO                  NUMBER(10) 
ORDER_QTY                 NUMBER(10) 
ORDER_STMT                NUMBER(10) 
PRODUCT_NO                NUMBER(10) 
PRODUCT_ESPRESSO          NUMBER(10) 
PRODUCT_SYRUP             NUMBER(10) 
*/

--단품 주문 1번 회원 1번 상품 (샷 3,시럽1) 2개 주문 
insert into orderlist (order_no,order_date,member_no,order_price) select
orderList_order_no_SEQ.nextval,
sysdate,
1,
(p.product_price+(p.product_espressoprice*3)+(p.product_syrupprice*1))*2
from product p
where p.product_no=1;

insert into orderdetail (orderdetail_no,order_no,order_qty,order_stmt,product_no,product_espresso,product_syrup) 
values (orderDetail_orderDetail_no_SEQ.nextval,orderList_order_no_SEQ.currval,2,1,1,3,1);


--3번 회원의 장바구니에 있던 상품목록 및 수량 전체를 orderdetail에 넣기 
insert into orderlist(order_no,order_date,member_no) 
values (orderList_order_no_SEQ.nextval,sysdate,3);
insert into orderdetail (orderdetail_no, order_no, order_stmt, product_no,order_qty)
select 
ORDERDETAIL_ORDERDETAIL_NO_SEQ.nextval,
orderList_order_no_SEQ.currval,
1,
c.product_no,c.cart_qty
from cart c
where member_no=3;