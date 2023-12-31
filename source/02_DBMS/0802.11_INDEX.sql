-- [XI] 인덱스 : 조회를 빠르게 하는 인덱스
SELECT * FROM USER_INDEXES WHERE TABLE_NAME='EMP';
SELECT * FROM EMP01;
DROP TABLE EMP01;
CREATE TABLE EMP01 AS SELECT * FROM EMP; -- EMP테이블과 내용만 같은 EMP01(제약조건은 없음)
DESC EMP01;
SELECT * FROM EMP01; --14행
INSERT INTO EMP01 SELECT * FROM EMP01;--1번(28행) 2번(56행)
SELECT TO_CHAR(COUNT(*), '999,999,999') CNT FROM EMP01;
INSERT INTO EMP01 SELECT * FROM EMP01; --11번 -- 114.688개
INSERT INTO EMP01 (EMPNO, ENAME, DEPTNO) VALUES (1111, 'HONG', 40);
INSERT INTO EMP01 SELECT * FROM EMP01; -- 1번(22만) 2번(44만)
SELECT TO_CHAR(COUNT(*), '999,999,999') CNT FROM EMP01;

SELECT  * FROM EMP01 WHERE ENAME='HONG'; -- 인덱스 생성전 조회
--인덱스 생성
CREATE INDEX IDX_EMP01_ENAME ON EMP01(ENAME); --0.55
SELECT  * FROM EMP01 WHERE ENAME='HONG';--인덱스 생성후 0.001초
COMMIT;
INSERT INTO EMP01 SELECT * FROM EMP01; -- 인덱스 생성후 91만 ->182만만
SELECT TO_CHAR(COUNT(*), '999,999,999') CNT FROM EMP01;-- 183
ROLLBACK; --15초
DROP INDEX IDX_EMP01_ENAME;
DROP TABLE EMP01; --테이블을 제거하면 테이블에 딸린 인덱스도 자동제거


