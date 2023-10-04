-- EmpDao에 들어갈 query
-- 전체 리스트 
SELECT * FROM EMP;
SELECT TO_CHAR(HIREDATE, 'YYMMDD HH:MI:SS') FROM EMP;
-- EMPDAO 에 들어갈 쿼리
INSERT INTO EMP VALUES (9000, 'HONG', 'CLERK', 7902, SYSDATE, 9000, 1000, 40);
-- 전체 리스트 :public ArrayList<EmpDto> getListEmp()
SELECT * FROM EMP;
-- 이름과 JOB으로 검색한 리스트 : public ArratList<EmpDto> getListEmp(String schName, String schJob)
SELECT * FROM EMP
    WHERE ENAME LIKE '%'||TRIM(UPPER(' S  '))||'%'
        AND JOB LIKE '%' || UPPER(TRIM(' a    '))||'%';

