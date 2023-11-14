SELECT * FROM MEMBER;
SELECT * FROM BOOK;
-- Book.xml id = mainList (신작순서대로)
SELECT * FROM BOOK ORDER BY BRDATE DESC;

-- Book.xml id= bookList(책 이름ㄱㄴ순서대로book리스트 top-N구문)

SELECT ROWNUM RN, A.*
    FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A;
SELECT *
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A)
    WHERE RN BETWEEN 1 AND 3;
-- Book.xml id=totCntBook
SELECT COUNT(*) CNT FROM BOOK;
-- Book.xml id=getDetailBook BID로DTO가져오기
SELECT * FROM BOOK WHERE BNUM=1;
-- Book.xml id=registerBook(bimg를 둘다 입력할 수도 하나만 입력할 수도 입력 안할수도있음)
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG1,bIMG2, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'JSP','박제이',SYSDATE, 'noImg.png','noImg.png', 'jsp 개념서');
-- Book.xml id=modifyBook
UPDATE BOOK
    SET bTITLE = '바꾼제목',
        bWRITER = '바꾼저자',
        bRDATE = SYSDATE,
        bIMG1 = 'CHIMG1',
        bIMG2 = 'CHIMG2',
        bINFO = 'Dp'
    WHERE bNUM=1;
-- Member.xml id=idConfirm (resultType=int)
SELECT * FROM MEMBER WHERE MID='aaa';
-- Member.xml id=joinMember
INSERT INTO MEMBER (MID, MPW, MNAME, MMAIL, MPOST, MADDR)
    VALUES ('rrr','1','김길동','jis12030@naver.com','00000','서울싱'); 
-- Member.xml id=getDetailMember
SELECT * FROM MEMBER WHERE MID = 'rrr';
-- Member.xml id=modifyMember
UPDATE MEMBER SET MPW='1',
                MNAME='신길동',
                MMAIL = 'shin@gmail.com',
                MADDR='서울시 영등포구 신길동 1266',
                MPOST = '07355'
    WHERE MID='bbb';
COMMIT;