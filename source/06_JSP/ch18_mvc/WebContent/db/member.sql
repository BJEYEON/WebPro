-- 테이블 제거
DROP TABLE MEMBER CASCADE CONSTRAINTS;
-- 테이블 생성
CREATE TABLE MEMBER(
    ID VARCHAR2(30) PRIMARY KEY,
    PW VARCHAR2(30) NOT NULL,
    NAME VARCHAR2(30) NOT NULL,
    BIRTH DATE,
    RDATE DATE DEFAULT SYSDATE NOT NULL);
-- dummy 데이터
INSERT INTO MEMBER (ID, PW, NAME, BIRTH)
    VALUES ('aaa','1','홍길동', TO_DATE('1998-12-12','yyyy-MM-dd'));

-- Dao에 들어갈 query
-- 1. 회원리스트
SELECT * FROM MEMBER;
-- 2. 회원가입
INSERT INTO MEMBER (ID, PW, NAME, BIRTH)
    VALUES ('bbb','1','비길동', '1998-07-01');
commit;
    