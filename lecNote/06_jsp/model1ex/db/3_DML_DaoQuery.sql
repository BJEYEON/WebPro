-- CustomerDao에 들어갈 query
-- 1. 회원가입시 id 중복체크 : public int confirmId(String cid)
SELECT COUNT(*) FROM CUSTOMER WHERE CID='aaa';
-- SELECT * FROM CUSTOMER WHERE CID='aaa';
-- 2. 회원가입 : public int joinCustmer(CustomerDto dto)
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CBIRTH, CGENDER)
  VALUES ('aaa', '111', '홍길동', '010-9999-9999', 'h@h.com', '서울', '1995-12-12', 'm');
-- 3. 로그인 : public int loginCheck(String cid, String cpw)
SELECT * FROM CUSTOMER WHERE CID='aaa' AND CPW='111';

-- 4. cid로 DTO 가져오기 : public CustomerDto getCustomer(String cid)
SELECT * FROM CUSTOMER WHERE CID='aaa';

-- 5. 정보수정 : public int modifyCustomer(CustomerDto dto)
UPDATE CUSTOMER SET CPW = '111',
                CNAME='마길순',
                CTEL = '02-111-1111',
                CEMAIL='m@h.com',
                CADDRESS='제주도',
                CBIRTH = '1999-12-12',
                CGENDER = 'f'
          WHERE CID='aaa';
-- 6. 회원리스트
SELECT * 
  FROM (SELECT ROWNUM RN, CID, CPW, CNAME, CEMAIL, CADDRESS  
      FROM (SELECT * FROM CUSTOMER ORDER BY CID)) 
  WHERE RN BETWEEN 2 AND 3;
-- 7. 가입회원 명수
SELECT COUNT(*) TOTCNT FROM CUSTOMER;

COMMIT;

-- FileboardDao에 들어갈 query
-- 1. 글목록(startRow부터 endRow까지 리스트)
SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C 
  WHERE F.CID = C.CID
  ORDER BY fGROUP DESC, fSTEP; -- 출력 기준
SELECT ROWNUM RN, A.* 
  FROM (SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C 
    WHERE F.CID = C.CID
    ORDER BY fGROUP DESC, fSTEP) A; -- TOP-N구문 전단계
SELECT *
  FROM (SELECT ROWNUM RN, A.* 
        FROM (SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C 
          WHERE F.CID = C.CID
          ORDER BY fGROUP DESC, fSTEP) A)
  WHERE RN BETWEEN 2 AND 3; -- TOP-N구문 (DAO에 들어갈 QUERY)
-- 2. 전체 글 갯수
SELECT COUNT(*) CNT FROM FILEBOARD;
-- 3. 원글쓰기 - 글제목, 본문, 첨부파일, 비번, IP (FGROUP은 글번호, FSTEP은 0, FINDENT는 0)
INSERT INTO FILEBOARD (FID, cID, fTITLE, fCONTENT, FILENAME, fPW, 
                fGROUP, fSTEP, fINDENT, fIP)
        VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa', '글3','냉무',null,'111',
                FILEBOARD_SEQ.CURRVAL, 0,0, '192.168.20.44');
-- 4. 답변글 쓰기 전 단계( 엑셀 ⓐ단계)
UPDATE FILEBOARD SET FSTEP = FSTEP+1 WHERE FGROUP=1 AND FSTEP>0;
-- 5. 답변글 쓰기
INSERT INTO FILEBOARD (fID, cID, fTITLE, fCONTENT, FILENAME, fPW, 
                fGROUP, fSTEP, fINDENT, fIP)
        VALUES (FILEBOARD_SEQ.NEXTVAL, 'ccc', '글1-1','냉무',null,'111',
                1, 1, 1, '192.168.20.44');
-- 6. FID로 조회수 1 올리기 (글상세보기시 필요)
UPDATE FILEBOARD SET FHIT = FHIT + 1 WHERE FID=1;
-- 7. bID로 DTO가져오기
SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C 
  WHERE F.CID = C.CID AND FID=1
  ORDER BY fGROUP DESC, fSTEP;
-- 8. 글수정 (글제목, 본문, 이메일, 첨부파일, 비번, IP 수정)
UPDATE FILEBOARD
  SET 
      FTITLE = '바꾼제목',
      FCONTENT = '바꾼본문',
      FILENAME = NULL,
      FPW    = '111',
      FIP    = '127.0.0.1'
  WHERE FID=1;
-- 9. 글삭제(비번을 맞게 입력한 경우만 삭제)
COMMIT;
DELETE FROM FILEBOARD WHERE FID=1 AND FPW='111';
ROLLBACK;

-- BookDao 들어갈 QUERY
-- 1. 책등록
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, 'HTML5',2000,'114.jpg','noImg.png','좋다 ',10);
-- 2. 책목록(PAGING 없이)
SELECT * FROM BOOK ORDER BY BRDATE DESC;
-- 2. 책목록(PAGING처리 : TOP-N)
SELECT ROWNUM RN, A.*
  FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A; -- TOP-N구문의 INLINE VIEW에 들어갈 QUERY
SELECT *
  FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A)
  WHERE RN BETWEEN 7 AND 12; -- DAO에 들어갈 QUERY
-- 3. 등록된 책 갯수
SELECT COUNT(*) CNT FROM BOOK;
-- 4. 책상세보기(BID로 DTO가져오기)
SELECT * FROM BOOK WHERE BID=1;
COMMIT;