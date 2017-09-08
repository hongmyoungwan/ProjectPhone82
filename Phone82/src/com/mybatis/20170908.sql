
  CREATE TABLE ADMIN
   (	ADMINID VARCHAR2(20), 
	ADMINPW VARCHAR2(20)
   );
   
--------------------------------------------------------
--  DDL for Table BOARD
--------------------------------------------------------

  CREATE TABLE BOARD (
  NUM NUMBER(38), 
	"TITLE" VARCHAR2(30 ), 
	"USERID" VARCHAR2(30 ), 
	"AUTHOR" VARCHAR2(20 ), 
	"WRITEDAY" DATE, 
	"CONTENT" VARCHAR2(500 ), 
	"READCNT" NUMBER(38)
   ) ;
--------------------------------------------------------
--  DDL for Table CART
--------------------------------------------------------

  CREATE TABLE CART
   (	"NUM" NUMBER(20), 
	"USERID" VARCHAR2(20 ), 
	"PHONE_MODEL_NUM" VARCHAR2(20), 
	"PHONE_NAME" VARCHAR2(20), 
	"PHONE_PRICE" NUMBER(20), 
	"PHONE_IMAGE" VARCHAR2(20), 
	"PHONE_AMOUNT" NUMBER(20), 
	"PHONE_COLOR" VARCHAR2(10 )
   )  ;
--------------------------------------------------------
--  DDL for Table FAQ
--------------------------------------------------------

  CREATE TABLE FAQ
   (	"NUM" NUMBER(20), 
	"TITLE" VARCHAR2(200 ), 
	"CONTENT" VARCHAR2(1000 )
   );
--------------------------------------------------------
--  DDL for Table MEMBER
--------------------------------------------------------

  CREATE TABLE MEMBER
   (	"USERID" VARCHAR2(20 ), 
	"PASSWD" VARCHAR2(20 ), 
	"USERNAME" VARCHAR2(20 ), 
	"PHONE1" VARCHAR2(3 ), 
	"PHONE2" VARCHAR2(4 ), 
	"PHONE3" VARCHAR2(4 ), 
	"POST1" VARCHAR2(20 ), 
	"POST2" VARCHAR2(20 ), 
	"ADDR1" VARCHAR2(20 ), 
	"ADDR2" VARCHAR2(20 ), 
	"EMAIL" VARCHAR2(30)
   ) ;
  CREATE TABLE ORDERHISTORY
   (	"NUM" NUMBER(20), 
	"USERID" VARCHAR2(20), 
	"PHONE_MODEL_NUM" VARCHAR2(20 ), 
	"PHONE_NAME" VARCHAR2(20 ), 
	"PHONE_PRICE" NUMBER(20), 
	"PHONE_IMAGE" VARCHAR2(20), 
	"PHONE_AMOUNT" NUMBER(20), 
	"PHONE_COLOR" VARCHAR2(10), 
	"ORDERNAME" VARCHAR2(20), 
	"POST1" VARCHAR2(20), 
	"POST2" VARCHAR2(20), 
	"ADDR1" VARCHAR2(20), 
	"ADDR2" VARCHAR2(20), 
	"PHONE" VARCHAR2(20), 
	"PAYMETHOD" VARCHAR2(20)
   );
--------------------------------------------------------
--  DDL for Table PHONES
--------------------------------------------------------

  CREATE TABLE PHONES
   (	"TELECOM_NUM" NUMBER(3), 
	"PHONE_MODEL_NUM" VARCHAR2(20), 
	"PHONE_NAME" VARCHAR2(20 ), 
	"PHONE_CONTENT" VARCHAR2(20 ), 
	"PHONE_PRICE" VARCHAR2(20 ), 
	"PHONE_IMAGE" VARCHAR2(20 ), 
	"PHONE_COLOR" VARCHAR2(20 )
   );
--------------------------------------------------------
--  DDL for Table QNA
--------------------------------------------------------

  CREATE TABLE QNA 
   (	"NUM" NUMBER(38), 
	"TITLE" VARCHAR2(30), 
	"USERID" VARCHAR2(30), 
	"AUTHOR" VARCHAR2(20), 
	"WRITEDAY" DATE, 
	"CONTENT" VARCHAR2(500), 
	"READCNT" NUMBER(38)
   );
--------------------------------------------------------
--  DDL for Table SALES_STATUS
--------------------------------------------------------

  CREATE TABLE SALES_STATUS 
   (	"ORDERNAME" VARCHAR2(20), 
	"TELECOM_NUM" NUMBER(3), 
	"PHONE_MODEL_NUM" VARCHAR2(20), 
	"PHONE_PRICE" NUMBER(20), 
	"PHONE_AMOUNT" NUMBER(20), 
	"ORDERDATE" DATE
   );

Insert into ADMIN (ADMINID,ADMINPW) values ('master','master');

Insert into phone.FAQ (NUM,TITLE,CONTENT) values (1,'<회원관리> 회원탈퇴는 어떻게 하나요?','회원 탈퇴를 하시면 주문한 상품에 대한 배송상태를 사이트내에서는 조회하실 수 없습니다.  
(아직 배송건이 남아 있는 경우라면 탈퇴처리 되지 않으며 모든 배송건이 완료 상태가 되면  
 고객님이 원하실 때 언제든 탈퇴하실 수 있습니다.) 
 
회원탈퇴를 하시면 해당 아이디는 즉시 탈퇴 처리되며,  
이후 영구적으로 사용이 중지되므로 새로운 아이디로만 재가입이 가능합니다. 
 
G마켓 서비스 이용약관에 근거한 이용계약 종료시 당사는 회원의 개인정보를 즉시 파기하며 
제3자에게 기제공된 정보에 대해서도 지체없이 파기하도록 조치합니다. 
 
다만, 다음의 경우 각각 명시한 기간동안 개인정보를 보유합니다.  
- 계약 또는 청약철회 등에 관한 기록 : 5년  
- 대금결제 및 재화 등의 공급에 관한 기록 : 5년  
- 소비자의 불만 또는 분쟁처리에 관한 기록 : 3년 ');
Insert into phone.FAQ (NUM,TITLE,CONTENT) values (2,'<회원관리> 회원탈퇴후, 재가입이 가능한가요?','회원탈퇴를 하시면 해당 아이디는 즉시 탈퇴 처리되며, 이후 영구적으로 사용이 중지되므로  
새로운 아이디로만 재가입이 가능합니다. 
 
회원 탈퇴 후 재가입은 7일 후부터 가능합니다. 
또한, 법령 위반 등의 이유로 계약을 해지 당하신 경우라면 G마켓 자체 심사 후,  
회원 재가입 여부를 결정하게 되어 있습니다. 
 
G마켓은 다음과 같은 사유가 발생하거나 확인된 경우 이용계약을 해지할 수 있습니다. 
 
① 다른 이용자의 권리나 명예, 신용 기타 정당한 이익을 침해하거나 대한민국 법령 또는 공서양속에  
   위배되는 행위를 한 경우 
② 회사가 제공하는 G마켓 서비스의 원활한 진행을 방해하는 행위를 하거나 시도한 경우 
③ 제10조에 기한 회원의 누적 구매건수/신용점수가 -20점에 이른 경우 
④ 기타 회사가 합리적인 판단에 기하여 서비스의 제공을 거부할 필요가 있다고 인정할 경우');
Insert into phone.FAQ (NUM,TITLE,CONTENT) values (3,'<회원관리> 아이디를 여러개 사용할 수 있나요?','G마켓에서는 회원가입 시 가입확인 절차를 거친 본인의 명의로 하나의 아이디만을 사용하실 수 있습니다.  
 
외국인 회원의 경우 회원가입시 본인확인을 위한 e-mail 주소 확인 작업이 있으며, 반드시 본인이 사용하시는 e-mail을 입력하셔야 회원가입이 가능합니다. 
 
다만, 사업자 판매회원의 경우, 판매 편의성 개선을 위해 하나의 사업자 등록번호로 최대 3개까지  
ID를 신청하실 수 있습니다. ');
Insert into phone.FAQ (NUM,TITLE,CONTENT) values (4,'<주문/결제> 현금 결제 시 주문자명과 다른 이름으로 입금해도 되나요?','주문자 명과 다른 이름으로 입금하셨다 하더라도 고객님의 전용입금계좌로 정확한 결제금액을 입금하셨다면
입금 확인이 가능합니다.
');

Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',3,'asf3',22,1,to_date('17/01/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',1,'asf3',22,1,to_date('17/02/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',2,'asf3',22,1,to_date('17/02/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',1,'asf3',22,1,to_date('17/03/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',3,'asf3',22,1,to_date('17/03/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',1,'asf3',22,1,to_date('17/04/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',3,'asf3',22,1,to_date('17/04/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',1,'asf3',22,1,to_date('17/06/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',3,'asf3',22,1,to_date('17/06/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',2,'asf3',22,1,to_date('17/07/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',3,'asf3',22,1,to_date('17/07/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',1,'asf3',22,1,to_date('17/08/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',3,'asf3',22,1,to_date('17/08/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',1,'asf3',22,1,to_date('17/09/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',2,'asf3',22,1,to_date('17/09/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',2,'asf3',22,1,to_date('17/10/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',3,'asf3',22,1,to_date('17/10/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',2,'asf3',22,1,to_date('17/11/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',3,'asf3',22,1,to_date('17/11/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',1,'asf3',22,1,to_date('17/12/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',2,'asf3',22,1,to_date('17/12/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',3,'asf3',22,1,to_date('17/09/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',2,'asf3',22,1,to_date('17/01/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',3,'asf3',22,1,to_date('17/02/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',2,'asf3',22,1,to_date('17/03/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',2,'asf3',22,1,to_date('17/04/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',1,'asf3',22,1,to_date('17/05/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',2,'asf3',22,1,to_date('17/06/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',1,'asf3',22,1,to_date('17/07/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',2,'asf3',22,1,to_date('17/01/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',1,'asf3',22,1,to_date('17/05/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',2,'asf3',22,1,to_date('17/08/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',3,'asf3',22,1,to_date('17/09/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',1,'asf3',22,1,to_date('17/10/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',2,'asf3',22,1,to_date('17/10/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',1,'asf3',22,1,to_date('17/11/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',3,'asf3',22,1,to_date('17/12/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',1,'asf3',22,1,to_date('17/01/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',2,'asf3',22,1,to_date('17/05/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',3,'asf3',22,1,to_date('17/05/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',2,'asf3',22,1,to_date('17/01/06','RR/MM/DD'));
Insert into phone.SALES_STATUS (ORDERNAME,TELECOM_NUM,PHONE_MODEL_NUM,PHONE_PRICE,PHONE_AMOUNT,ORDERDATE) values ('tester',2,'asf3',22,1,to_date('17/10/06','RR/MM/DD'));


--  Constraints for Table QNA