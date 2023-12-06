


/* Drop Tables */

DROP TABLE address CASCADE CONSTRAINTS;
DROP TABLE attraction CASCADE CONSTRAINTS;
DROP TABLE cart2 CASCADE CONSTRAINTS;
DROP TABLE Lqna CASCADE CONSTRAINTS;
DROP TABLE Lmember CASCADE CONSTRAINTS;
DROP TABLE notice CASCADE CONSTRAINTS;
DROP TABLE Lworker CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE attraction_aseq;
DROP SEQUENCE cart2_cseq;
DROP SEQUENCE Lqna_lqseq;
DROP SEQUENCE notice_nseq;



/* Create Sequences */

CREATE SEQUENCE attraction_aseq INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE cart2_cseq INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE Lqna_lqseq INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE notice_nseq INCREMENT BY 1 START WITH 1;

/* Create Tables */

CREATE TABLE address
(
	zip_num varchar2(7) NOT NULL,
	sido varchar2(30) NOT NULL,
	gugun varchar2(30) NOT NULL,
	zip_code varchar2(30),
	bunji varchar2(1000),
	dong varchar2(1000)
);


CREATE TABLE attraction
(
	aseq number(5,0) NOT NULL,
	atname varchar2(100) NOT NULL,
	acontent varchar2(1000),
	limitkey varchar2(1000),
	limitage varchar2(1000),
	bestat char(1) DEFAULT 'N',
	aresult char(1) DEFAULT 'N',
	act1 varchar2(100),
	act2 varchar2(100),
	image varchar2(255),
	pnum number(10,0) NOT NULL,
	PRIMARY KEY (aseq)
);

select*from cart2;

CREATE TABLE cart2
(
	cseq number(10,0) NOT NULL,
	id varchar2(20) NOT NULL,
	p1 number(10,0),
	p2 number(10,0),
	kind number(10,0),
	tatname1 varchar2(100),
	tatname2 varchar2(100),
	tatname3 varchar2(100),
	price1 number(10,0) NOT NULL,
	price2 number(10,0),
	result number(10,0) DEFAULT 0,
	indate date DEFAULT sysdate,
	visitdate date DEFAULT sysdate,
	PRIMARY KEY (cseq)
);


CREATE TABLE Lmember
(
	id varchar2(20) NOT NULL,
	pwd varchar2(20) NOT NULL,
	name varchar2(20) NOT NULL,
	phone varchar2(20) NOT NULL,
	email varchar2(40) NOT NULL,
	zip_num varchar2(7),
	address1 varchar2(1000),
	address2 varchar2(1000),
	indate date DEFAULT sysdate,
	PRIMARY KEY (id)
);

alter table lmember add provider varchar2(30) default 'normal';
alter table lmember add useyn varchar2(30) default 'Y';
ALTER TABLE Lmember ADD address3 varchar2(100);


select*from Lqna

CREATE TABLE Lqna
(
	lqseq number(5,0) NOT NULL,
	id varchar2(20) NOT NULL,
	title varchar2(100),
	indate date DEFAULT sysdate,
	reply varchar2(1000),
	rep char DEFAULT 'N' NOT NULL,
	content varchar2(1000),
	PRIMARY KEY (lqseq)
);
alter table lqna add passcheck varchar2(10) default 'N';
alter table lqna add pass varchar2(10);


CREATE TABLE Lworker
(
	id varchar2(20) NOT NULL,
	pwd varchar2(20) NOT NULL,
	name varchar2(20) NOT NULL,
	phone varchar2(20),
	PRIMARY KEY (id)
);


CREATE TABLE notice
(
	nseq number(10,0) NOT NULL,
	id varchar2(20) NOT NULL,
	title varchar2(100),
	ncontent varchar2(1000),
	indate date DEFAULT sysdate,
	PRIMARY KEY (nseq)
);

create table banner(
	bseq number(5),
	subject varchar2(30),
	ORDER_SEQ number(3) default 1,
	useyn char(1) default 'Y',
	indate date default sysdate,
	image varchar2(30),
	PRIMARY KEY (bseq)
);

create sequence banner_seq start with 1;



-----베스트 놀이기구
create or replace view best_at_view
as
select * from
(select rownum, aseq, atname, image from attraction  where bestat='Y'  ) 
where  rownum <=3;

select * from best_at_view;

--------운영 운휴
create or replace view rest_at_view
as
select aseq, atname, image from attraction where aresult='Y';

select * from rest_at_view;



/* Create Foreign Keys */

ALTER TABLE cart2
	ADD FOREIGN KEY (id)
	REFERENCES Lmember (id)
;


ALTER TABLE Lqna
	ADD FOREIGN KEY (id)
	REFERENCES Lmember (id)
;


ALTER TABLE notice
	ADD FOREIGN KEY (id)
	REFERENCES Lworker (id)
;


