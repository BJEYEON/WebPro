--BOOKDAO에 들어갈 QUERY

--1. 책등록
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, 'HTML5',2000,'114.jpg','noImg.png','좋다 ',10);
--2. 책목록(페이징없이)
SELECT * FROM BOOK ORDER BY BRDATE DESC;
--2. 책목록(PAGING처리: TOP-N)
SELECT ROWNUM RN, A.*
    FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A; --TOP-N구문의 INLINE VIEW에 들어갈 QUERY   
SELECT * 
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A)
    WHERE RN BETWEEN 7 AND 12; -- DAO에 들어갈 쿼리
-- 3. 등록된 책 갯수
SELECT COUNT(*) CNT FROM BOOK;
--4. 책상세보기(BID로 DTO가져오기)
SELECT * FROM BOOK WHERE BID=1;


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
-- 6. 회원리스트 public ArrayList<CustomerDto> listCustomer(StartRow, endRow): cid순으로 TOP-N

-- 7. 가입한 회원수 public int getCustomerTotalCnt()


-- FileBoard에 들어갈 query
--검색
SELECT * FROM FILEBOARD;
-- 1. 글목록  (startRow ~ endRow까지 fileBoard 리스트)
SELECT * FROM FILEBOARD ORDER BY FGROUP DESC;
SELECT ROWNUM RN, A.*
    FROM(;
-- 2. 전체 글 갯수
SELECT COUNT(*) CNT FROM FILEBOARD;
--3. 글쓰기 : cid(글쓴이 id), 글제목, 본문, 첨부파일, 비번, ip (fgroup은 글번호, fstep과 findent는 0)
INSERT INTO BOARD (FID, FTITLE, FCONTENT, FILENAME, FPW, FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, '제목1', '내용1', '파일', '111', BOARD_SEQ.CURRVAL, 1, 0,'192.168.5.4');
-- 4. fid로 조회수 1올리기

-- 5. fid로 dto가져오기

-- 6. 글수정 : 글제목, 본문, 첨부파일, 비번, ip 수정

-- 7. 글삭제(fid, fpw)

-- 8. 답변글 쓰기 전단계(엑셀 a단계)

-- 9. 답변글 쓰기
SELECT * FROM CUSTOMER;
COMMIT;
        