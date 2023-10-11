-- 테이블 제거
DROP TABLE MVC_MEMBER;
-- 테이블 생성
CREATE TABLE MVC_MEMBER(
    MID VARCHAR2(30) PRIMARY KEY,
    MPW VARCHAR2(30) NOT NULL,
    MNAME VARCHAR(30) NOT NULL,
    MEMAIL VARCHAR2(30),
    MPHOTO VARCHAR2(30)NOT NULL, --회원가입시 사진업로드를 안 할경우 기본이미지로
    MBIRTH DATE,
    MADDRESS VARCHAR2(300),
    MRDATE DATE DEFAULT SYSDATE NOT NULL);
-- 더미데이터
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('gayun','1','김가연','gayun@naver.com','gayun.jpg','1972/09/09','광주광역시');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('gico','1','지코','gico@naver.com','gico.jpg','1992/09/14','서울시');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('go','1','고소영','go@naver.com','go.jpg','1972/10/06','서울시');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('son','1','손흥민','son@naver.com','son.jpg','1992/07/08','강원도');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('han','1','한지민','han@naver.com','han.jpg','1982/11/05','서울시');
SELECT * FROM MVC_MEMBER ORDER BY mRDATE DESC;
-- DAO에 들어갈 쿼리
-- (1) 회원id 중복체크
SELECT COUNT(*) FROM MVC_MEMBER WHERE MID='go';
-- (2) 회원가입
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('han','1','한지민','han@naver.com','han.jpg','1982/11/05','서울시');
-- (3) 로그인
SELECT * FROM MVC_MEMBER WHERE MID='han' AND MPW='1';
-- (4) mid로 dto가져오기(로그인 성공시 session에 넣기 위함)
SELECT * FROM MVC_MEMBER WHERE MID='han';
-- (5) 회원정보 수정
UPDATE MVC_MEMBER SET
        MPW='1',
        MNAME='PARK',
        MEMAIL='PARK@NAVER.COM',
        MPHOTO='NOIAMGE.JPG',
        MBIRTH='19981021',
        MADDRESS='서울'
    WHERE MID='han';
-- (6) 회원리스트(top-N구문)
SELECT * FROM MVC_MEMBER;
SELECT ROWNUM RN, A.*
    FROM(SELECT * FROM MVC_MEMBER) A;
SELECT * FROM (SELECT ROWNUM RN, A.*
    FROM(SELECT * FROM MVC_MEMBER) A)
    WHERE RN BETWEEN 0 AND 6;
-- (7) 회원수
SELECT COUNT(*) FROM MVC_MEMBER;
-- (8) 회원탈퇴
COMMIT;
DELETE FROM MVC_MEMBER WHERE MID='han';
ROLLBACK;
