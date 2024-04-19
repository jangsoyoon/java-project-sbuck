DROP TABLE login CASCADE CONSTRAINTS;
DROP TABLE orderDetail CASCADE CONSTRAINTS;
DROP TABLE orderList CASCADE CONSTRAINTS;
DROP TABLE cart CASCADE CONSTRAINTS;
DROP TABLE productDetail CASCADE CONSTRAINTS;
DROP TABLE product CASCADE CONSTRAINTS;
DROP TABLE membership CASCADE CONSTRAINTS;

CREATE TABLE membership(
		member_no                     		NUMBER(10)		 NULL ,
		member_id                     		VARCHAR2(50)		 NOT NULL,
		member_phone                  		VARCHAR2(50)		 NULL ,
		member_birthday               		DATE		 DEFAULT sysdate		 NULL ,
		member_email                  		VARCHAR2(50)		 NULL ,
		member_nickname               		VARCHAR2(50)		 NULL ,
		member_loc                    		VARCHAR2(50)		 NULL ,
		member_PAgree                 		NUMBER(10)		 DEFAULT 0		 NULL ,
		member_EAgree                 		NUMBER(10)		 DEFAULT 0		 NULL 
);

DROP SEQUENCE membership_member_no_SEQ;

CREATE SEQUENCE membership_member_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE product(
		product_no                    		NUMBER(10)		 NULL ,
		product_name                  		VARCHAR2(50)		 NULL ,
		product_price                 		NUMBER(20)		 NULL ,
		product_allergy               		VARCHAR2(500)		 NULL ,
		product_content               		VARCHAR2(500)		 NULL ,
		product_espresso              		NUMBER(10)		 NULL ,
		product_syrup                 		NUMBER(10)		 NULL ,
		product_syrupPrice            		NUMBER(10)		 NULL ,
		product_espressoPrice         		NUMBER(10)		 NULL 
);

DROP SEQUENCE product_product_no_SEQ;

CREATE SEQUENCE product_product_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE productDetail(
		product_no                    		NUMBER(10)		 NULL ,
		kal                           		NUMBER(10)		 NULL ,
		caffeine                      		NUMBER(10)		 NULL ,
		na                            		NUMBER(10)		 NULL 
);


CREATE TABLE cart(
		cart_no                       		NUMBER(10)		 NULL ,
		product_no                    		NUMBER(10)		 NULL ,
		member_no                     		NUMBER(10)		 NULL ,
		cart_qty                      		NUMBER(10)		 NULL,
        product_espresso number(10) null,
        product_syrup number(10) null
);

DROP SEQUENCE cart_cart_no_SEQ;

CREATE SEQUENCE cart_cart_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE orderList(
		order_no                      		NUMBER(10)		 NULL ,
		order_date                    		DATE		 DEFAULT sysdate		 NULL ,
		member_no                     		NUMBER(10)		 NULL ,
		order_price                   		NUMBER(10)		 NULL 
);

DROP SEQUENCE orderList_order_no_SEQ;

CREATE SEQUENCE orderList_order_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE orderDetail(
		orderDetail_no                		NUMBER(10)		 NULL ,
		order_no                      		NUMBER(10)		 NULL ,
		order_qty                     		NUMBER(10)		 NULL ,
		order_stmt                    		NUMBER(10)		 NULL ,
		product_no                    		NUMBER(10)		 NULL ,
        product_espresso number(10) null,
        product_syrup number(10) null
);

DROP SEQUENCE orderDetail_orderDetail_no_SEQ;

CREATE SEQUENCE orderDetail_orderDetail_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE login(
		member_id                     		VARCHAR2(50)		 NOT NULL,
		member_password               		VARCHAR2(50)		 NULL ,
		login                         		NUMBER(10)		 DEFAULT 0		 NULL 
);



ALTER TABLE membership ADD CONSTRAINT IDX_membership_PK PRIMARY KEY (member_no);
ALTER TABLE membership ADD CONSTRAINT IDX_membership_1 UNIQUE (member_id);
ALTER TABLE membership ADD CONSTRAINT IDX_membership_2 UNIQUE (member_email);
ALTER TABLE membership ADD CONSTRAINT IDX_membership_3 UNIQUE (member_phone);

ALTER TABLE product ADD CONSTRAINT IDX_product_PK PRIMARY KEY (product_no);

ALTER TABLE productDetail ADD CONSTRAINT IDX_productDetail_FK0 FOREIGN KEY (product_no) REFERENCES product (product_no);

ALTER TABLE cart ADD CONSTRAINT IDX_cart_PK PRIMARY KEY (cart_no);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK0 FOREIGN KEY (product_no) REFERENCES product (product_no);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK1 FOREIGN KEY (member_no) REFERENCES membership (member_no);

ALTER TABLE orderList ADD CONSTRAINT IDX_orderList_PK PRIMARY KEY (order_no);
ALTER TABLE orderList ADD CONSTRAINT IDX_orderList_FK0 FOREIGN KEY (member_no) REFERENCES membership (member_no);

ALTER TABLE orderDetail ADD CONSTRAINT IDX_orderDetail_PK PRIMARY KEY (orderDetail_no);
ALTER TABLE orderDetail ADD CONSTRAINT IDX_orderDetail_FK0 FOREIGN KEY (order_no) REFERENCES orderList (order_no);
ALTER TABLE orderDetail ADD CONSTRAINT IDX_orderDetail_FK1 FOREIGN KEY (product_no) REFERENCES product (product_no);

ALTER TABLE login ADD CONSTRAINT IDX_login_PK PRIMARY KEY (member_id);
ALTER TABLE LOGIN ADD CONSTRAINT IDX_LOGIN_FK FOREIGN KEY (member_id) REFERENCES MEMBERSHIP(member_id) on delete CASCADE;


