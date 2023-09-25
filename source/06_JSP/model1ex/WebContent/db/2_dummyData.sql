--DAUMMY DATA


-- CUSTOMER 테이블 DUMMY DATA
--검색
SELECT * FROM CUSTOMER;
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CBIRTH, CGENDER)
    VALUES ('AAA', '111', '홍길동', '010-9999-9999', 'ASD@ASD.COM', '서울', '2022-02-02', 'm');
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CBIRTH, CGENDER)
    VALUES ('BBB', '111', '감길동', '010-8999-9999', 'QWE@ASD.COM', '경기', '2022-02-02', 'f');
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CBIRTH, CGENDER)
    VALUES ('CCC', '111', '넘길동', '010-9799-9999', 'DFG@ASD.COM', '부산', '2022-02-02', 'm');
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CBIRTH, CGENDER)
    VALUES ('DDD', '111', '박길동', '010-9995-9999', 'CVB@ASD.COM', '서울', '2022-02-02', 'f');
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CBIRTH, CGENDER)
    VALUES ('EEE', '111', '길길동', '010-9199-9999', 'GHJ@ASD.COM', '서울', '2022-02-02', 'm');
-- FILEBOARD 테이블 DUMMY DATA(글1, 글2, 글2-1)
--검색
SELECT * FROM FILEBOARD;
INSERT INTO FILEBOARD (FID, CID, FTITLE, FCONTENT, FILENAME, FPW, FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'AAA', '제목1','내용1', NULL , '111', FILEBOARD_SEQ.CURRVAL, 0, 0,'192.168.5.4');
INSERT INTO FILEBOARD (FID, CID, FTITLE, FCONTENT, FILENAME, FPW, FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'BBB', '제목2','내용2', NULL , '111', FILEBOARD_SEQ.CURRVAL, 0, 0,'192.168.5.4');
INSERT INTO FILEBOARD (FID, CID, FTITLE, FCONTENT, FILENAME, FPW, FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'CCC', '제목3','내용3', NULL , '111', FILEBOARD_SEQ.CURRVAL, 0, 0,'192.168.5.4');
    --답변글 INSERT
INSERT INTO FILEBOARD (FID, CID, FTITLE, FCONTENT, FILENAME, FPW, FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'CCC', '제목3','내용3', NULL , '111', FILEBOARD_SEQ.CURRVAL, 0, 0,'192.168.5.4');
    VALUES (BOARD_SEQ.NEXTVAL, '윤', '글1-1', '냉무', NULL, '111', 1, 1, 1, '127.0.0.1');
-- DUMMY DATA
-- BOOK 테이블 DUMMY DATA
--검색
SELECT * FROM BOOK;
INSERT INTO BOOK (BID, BTITLE, BPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '이것이 자바다', 25000, 'noImg.png', 'nothing.png', '베스트셀러', 10);
INSERT INTO BOOK (BID, BTITLE, BPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, 'JSP웹프로그래밍', 30000, 'noImg.png', 'nothing.png', '베스트셀러', 10);
INSERT INTO BOOK (BID, BTITLE, BPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, 'SPRING', 40000, 'noImg.png', 'nothing.png', '베스트셀러', 10);
-- 도서(BOOK)테이블 dummy data  - 15개
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '쳇GPT 혁명',16000,'100.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '주린이가 가장 알고 싶은 최대질문Top77',20000,'101.jpg','noImg.png','증권가',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '공정하다는 착각',14000,'102.jpg','noImg.png','좋아',5);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '부의 대이동',16000,'103.jpg','noImg.png','좋아',5);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '컨버전스 2030',11500,'104.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '내면소통',13000,'105.jpg','noImg.png','좋아',30);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '꽤 괜찮은 해피엔딩',13500,'106.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '결국 무엇이든 해내는 사람',33000,'107.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, 'JSP',20000,'108.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '마지막 몰입',18000,'109.jpg','noImg.png','좋아',5);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, 'SQL',17000,'110.jpg','noImg.png','좋아',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '세이노의 가르침',1600,'111.jpg','noImg.png','좋아',30);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '기후로 다시 읽는 세계사',2000,'112.jpg','noImg.png','2020 트렌드 키워드 ',15);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, 'ADSP 데이터분석 준전문가',1800,'113.jpg','noImg.png','김영하의 여행 경험',10);
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, 'HTML5',2000,'114.jpg','noImg.png','좋다 ',10);
--확인
SELECT * FROM BOOK ORDER BY BRDATE DESC;