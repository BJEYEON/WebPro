--CustomerDao에 들어갈쿼리
SELECT * FROM CUSTOMER;
--1. 회원가입시 ID, PW중복체크
SELECT COUNT(*) FROM CUSTOMER WHERE CID='aaa';
--SELECT * FROM CUSTOMER WHERE CID='aaa' AND CPW='111';
--2. 회원가입 INSERT
INSERT INTO CUSTOMER(CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CBIRTH, CGENDER)
    VALUES('aaa', '111','홍길동','010-9999-9999' ,'asd@asd,com','서울',TO_date('1999-12-12'),'m');
--3. 로그인
SELECT * FROM CUSTOMER WHERE CID='aaa' AND CPW='111';

--4. CID로DTO가져오기
SELECT * FROM CUSTOMER WHERE CID='aaa';
--5. 회원정보 수정
UPDATE CUSTOMER
    SET CPW='1',
        CNAME='신길동',
        CTEL='010-8888-8888',
        CMAIL='qwe@qwe.com',
        CADDRESS='경기',
        CBIRTH='1999-01-01',
        CGENDER='m'
    WHERE CID='aaa';
    
SELECT * FROM CUSTOMER;
COMMIT;
        