-- 테이블 삭제
DROP TABLE MVCMEMBER;
-- 테이블 생성
CREATE TABLE MVCMEMBER(
    MID VARCHAR2(30) PRIMARY KEY,
    MPW VARCHAR2(30) NOT NULL,
    MNAME VARCHAR(30) NOT NULL,
    MEMAIL VARCHAR2(30),
    MBIRTH DATE,
    MADDRESS VARCHAR2(300),
    MRDATE DATE DEFAULT SYSDATE NOT NULL);
-- Dao에 들어갈 query
-- 1. mid중복체크
SELECT COUNT(*) FROM MVCMEMBER WHERE MID='go';
-- 2. 회원가입(mid, mpw, mname, memail, mbirth, maddress)
INSERT INTO MVCMEMBER (MID, MPW, MNAME, MEMAIL, MBIRTH, MADDRESS)
    VALUES ('go', '1', '고소영', 'go@naver.com', '1999-10-21', '서울');
-- 3. 로그인 체크(mid, mpw)
SELECT * FROM MVCMEMBER WHERE MID='go' AND MPW='1';
-- 4. 로그인 성공시 session에 넣을 dto (mid로 dto가져오기)
SELECT * FROM MVCMEMBER WHERE MID='go';
COMMIT;