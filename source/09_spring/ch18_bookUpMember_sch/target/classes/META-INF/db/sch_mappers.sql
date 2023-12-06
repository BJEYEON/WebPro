-- mapper에 들어갈 query
-- ★ ★ ★ ★ ★ book.xml ★ ★ ★ ★ ★ 
-- Book.xml id=mainList (신작순서대로 book리스트)
SELECT * FROM BOOK ORDER BY BRDATE DESC;

-- Book.xml id=bookList (책이름 ㄱㄴ 순서대로 book리스트 top-N구문)
  -- schItem이 null이거나 빈스트링일 때
  SELECT * 
    FROM (SELECT ROWNUM RN, A.* 
          FROM (SELECT * FROM BOOK ORDER BY BTITLE) A)
    WHERE RN BETWEEN 2 AND 4;
  -- schItem이 all일 때
  SELECT * 
    FROM (SELECT ROWNUM RN, A.* 
          FROM (SELECT * FROM BOOK 
		        WHERE UPPER(BTITLE) LIKE '%'||UPPER('s')||'%' OR UPPER(BINFO) LIKE '%'||UPPER('s')||'%' ORDER BY BTITLE) A)
		  	WHERE RN BETWEEN 4 AND 6;
  -- schItem이 btitle일 때
  SELECT * 
    FROM (SELECT ROWNUM RN, A.* 
          FROM (SELECT * FROM BOOK 
		        WHERE UPPER(BTITLE) LIKE '%'||UPPER('s')||'%' ORDER BY BTITLE) A)
		  	WHERE RN BETWEEN 4 AND 6;
  -- schItem이 bwriter일 때
  SELECT * 
    FROM (SELECT ROWNUM RN, A.* 
          FROM (SELECT * FROM BOOK 
		        WHERE UPPER(BWRITER) LIKE '%'||UPPER('홍')||'%' ORDER BY BTITLE) A)
		  	WHERE RN BETWEEN 1 AND 6;
-- Book.xml id=totCntBook (등록된 책 갯수)
  -- schItem이 null이거나 빈스트링일 때
  SELECT COUNT(*) FROM BOOK;
  -- schItem이 all일 때
  SELECT COUNT(*) FROM BOOK WHERE UPPER(BTITLE) LIKE '%'||UPPER('s')||'%' OR UPPER(BINFO) LIKE '%'||UPPER('s')||'%';
  -- schItem이 btitle일 때
  SELECT COUNT(*) FROM BOOK WHERE UPPER(BTITLE) LIKE '%'||UPPER('s')||'%';
  -- schItem이 bwriter일 때
  SELECT COUNT(*) FROM BOOK WHERE UPPER(BWRITER) LIKE '%'||UPPER('홍')||'%';
  
-- Book.xml id=getDetailBook(책번호로 dto가져오기)
SELECT * FROM BOOK WHERE BNUM=1;

-- Book.xml id=registerBook (bimg를 둘다 입력할 수도 하나만 입력할 수도 입력안할수도 있음)
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG1, bIMG2, bINFO)
  VALUES (BOOK_SQ.NEXTVAL, 'PYTHON','김파이','23/11/01', 'noImg.png','noImg.png','파이썬 기본서');
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG1, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'JPA','박제이', '23/11/01', 'noImg.png','JPA 개념서S');
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG2, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'MYBATIS','마이바','23/11/13', 'noImg.png','MybatiS 개념서');
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'SQL','지피티', '23/02/01', 'SQL 기본 정리');
 
-- Book.xml id=modifyBook
UPDATE BOOK SET
    BTITLE = '스프링부트',
    BWRITER = '부길동',
    BRDATE = '23/01/01',
    BIMG1 = 'noImg.png',
    BIMG2 = 'noImg.png',
    BINFO = '스프링과 스프링 부트의 차이 개념'
  WHERE BNUM=1;  
SELECT * FROM BOOK;

-- ★ ★ ★ ★ ★ member.xml ★ ★ ★ ★ ★ 
-- Member.xml id=idConfirm (resultType=int)
SELECT COUNT(*) FROM MEMBER WHERE MID='aaa';
-- Member.xml id=joinMember
INSERT INTO MEMBER VALUES ('bbb','1','김길석','kim@naver.com','03780','서울시 마포구 신촌로 141');
-- Member.xml id=getDetailMember
SELECT * FROM MEMBER WHERE MID = 'bbb';
-- Member.xml id=modifyMember
UPDATE MEMBER SET MPW='1',
                MNAME='신길동',
                MMAIL = 'shin@gmail.com',
                MADDR='서울시 영등포구 신길동 1266',
                MPOST = '07355'
    WHERE MID='bbb';
COMMIT;
SELECT * FROM MEMBER;
SELECT * FROM BOOK;