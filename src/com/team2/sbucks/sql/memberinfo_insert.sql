-- membership insert

insert into membership values (1,'guard1','010-4554-8542',to_date('2006-09-04','yyyy-mm-dd'), 'guard1@naver.com','가드1','경기도 용인시','1','2');
insert into membership values (2,'guard2','010-6324-4522',to_date('2012-03-07','yyyy-mm-dd'), 'guard2@naver.com','가드2','경기도 성남시','1','2');
insert into membership values (3,'guard3','010-2185-8428',to_date('2009-12-05','yyyy-mm-dd'), 'guard3@naver.com','가드3','경기도 시흥시','2','2');
insert into membership values (4,'guard4','010-3554-5284',to_date('2014-10-11','yyyy-mm-dd'), 'guard4@naver.com','가드4','경기도 광주시','2','1');
insert into membership values (5,'guard5','010-3258-4524',to_date('2002-08-17','yyyy-mm-dd'), 'guard5@naver.com','가드5','경기도 고양시','1','1');
insert into membership values (6,'guard6','010-1254-6587',to_date('1998-11-25','yyyy-mm-dd'), 'guard6@naver.com','가드6','경기도 파주시','1','2');
insert into membership values (7,'guard7','010-3015-5751',to_date('1995-03-28','yyyy-mm-dd'), 'guard7@naver.com','가드7','경기도 수원시','2','1');
insert into membership values (8,'guard8','010-5784-5421',to_date('1993-07-08','yyyy-mm-dd'), 'guard8@naver.com','가드8','서울시 강남구','2','1');
insert into membership values (9,'guard9','010-3101-7522',to_date('1989-05-05','yyyy-mm-dd'), 'guard9@naver.com','가드9','서울시 광진구','2','1');
insert into membership values (10,'guard10','010-0288-1879',to_date('1987-01-11','yyyy-mm-dd'), 'guard10@naver.com','가드10','서울시 마포구','2','1');
insert into membership values (11,'guard11','010-3304-4248',to_date('1956-03-14','yyyy-mm-dd'), 'guard11@naver.com','가드11','서울시 성동구','1','1');
insert into membership values (12,'guard12','010-6057-9654',to_date('1968-08-11','yyyy-mm-dd'), 'guard12@naver.com','가드12','서울시 종로구','2','1');
insert into membership values (13,'delete1','010-7292-0789',to_date('1975-03-18','yyyy-mm-dd'), 'delete1@naver.com','삭제1','서울시 서대문구','1','2');
insert into membership values (14,'delete2','010-3752-4735',to_date('2007-11-28','yyyy-mm-dd'), 'delete2@naver.com','삭제2','서울시 관악구','1','1');
insert into membership values (15,'delete3','010-3495-7568',to_date('1874-09-25','yyyy-mm-dd'), 'delete3@naver.com','삭제3','서울시 금천구','2','1');
insert into membership values (16,'update1','010-9854-1457',to_date('1999-10-25','yyyy-mm-dd'), 'update1@naver.com','수정1','서울시 서초구','2','2');
insert into membership values (17,'update2','010-5678-8945',to_date('1994-06-07','yyyy-mm-dd'), 'update2@naver.com','수정2','서울시 영등포구','1','1');
insert into membership values (18,'update3','010-3058-3647',to_date('2000-07-13','yyyy-mm-dd'), 'update3@naver.com','수정3','서울시 강동구','1','1');


--login insert

insert into login values ('guard1','1111',1);
insert into login(member_id, member_password) values ('guard2','2222');
insert into login(member_id, member_password) values ('guard3','3333');
insert into login(member_id, member_password) values ('guard4','4444');
insert into login(member_id, member_password) values ('guard5','5555');
insert into login(member_id, member_password) values ('guard6','6666');
insert into login(member_id, member_password) values ('guard7','7777');
insert into login(member_id, member_password) values ('guard8','8888');
insert into login(member_id, member_password) values ('guard9','9999');
insert into login(member_id, member_password) values ('guard10','1010');
insert into login(member_id, member_password) values ('guard11','1111');
insert into login(member_id, member_password) values ('guard12','1212');
insert into login(member_id, member_password) values ('delete1','1001');
insert into login(member_id, member_password) values ('delete2','1002');
insert into login(member_id, member_password) values ('delete3','1003');
insert into login values ('update1','1004',1);
insert into login values ('update2','1005',0);
insert into login values ('update3','1006',1);

commit;