-- DROP & CREATE SEQUENCE, TABLE
DROP TABLE FILEBOARD;
DROP TABLE CUSTOMER CASCADE CONSTRAINTS;
DROP TABLE BOOK;
DROP SEQUENCE FILEBOARD_SEQ;
DROP SEQUENCE BOOK_SEQ;
--BOOK테이블 생성
CREATE TABLE BOOK(
    BID NUMBER(7) PRIMARY KEY,
    BTITLE VARCHAR2(100) NOT NULL, --책이름
    BPRICE NUMBER(6) NOT NULL, --책가격
    BIMAGE1 VARCHAR2(100) NOT NULL, -- 책 대표이미지
    BIMAGE2 VARCHAR2(100) NOT NULL, --책 부가이미지
    BCONTENT VARCHAR2(4000), --책설명(4000초과시CLOB)
    BDISCOUNT NUMBER(3) NOT NULL, -- 할인율
    BRDATE DATE DEFAULT SYSDATE NOT NULL
);
--BOOK시퀀스 생성
CREATE SEQUENCE BOOK_SEQ MAXVALUE 9999999 NOCACHE NOCYCLE;
-- BOOK검색
SELECT * FROM BOOK;
--CUSTOMER테이블 생성
CREATE TABLE CUSTOMER(
    CID VARCHAR2(50) PRIMARY KEY,
    CPW VARCHAR2(50) NOT NULL,
    CNAME VARCHAR2(50) NOT NULL,
    CTEL VARCHAR2(50),
    CEMAIL VARCHAR2(50),
    CADDRESS VARCHAR2(50),
    CBIRTH DATE,
    CGENDER VARCHAR2(1),
    CRDATE DATE DEFAULT SYSDATE);
--CUSTOMER검색
SELECT * FROM CUSTOMER;
--FILEBOARD테이블 생성
CREATE TABLE FILEBOARD (
    FID NUMBER(6) PRIMARY KEY, --글번호
    CID VARCHAR2(50) REFERENCES CUSTOMER(CID) NOT NULL, --글쓴이ID
    FTITLE VARCHAR2(100) NOT NULL, --글제목
    FCONTENT VARCHAR2(1000), --글본문
    FILENAME VARCHAR2(100), --첨부파일명
    FHIT NUMBER(5) DEFAULT 0 NOT NULL, --조회수
    FPW VARCHAR2(50) NOT NULL, --삭제용 비번
    FGROUP NUMBER(6) NOT NULL,
    FSTEP NUMBER(2) NOT NULL,
    FINDENT NUMBER(2) NOT NULL,
    FIP VARCHAR2(50) NOT NULL,
    FRDATE DATE DEFAULT SYSDATE NOT NULL);
--FILEBOARD시퀀스 생성
CREATE SEQUENCE FILEBOARD_SEQ MAXVALUE 999999 NOCACHE NOCYCLE;
--FILEBOARD검색
SELECT * FROM FILEBOARD;
    