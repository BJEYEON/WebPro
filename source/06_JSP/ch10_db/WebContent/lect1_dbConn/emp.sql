--ex1 
SELECT * FROM EMP; --실행할 sql을 블럭잡고 alt+x
--ex2
SELECT * FROM DEPT;
--입력받은 파라미터 값의 직원을 출력(10->10번부서 직원/0->모든부서직원
SELECT * FROM EMP WHERE DEPTNO LIKE '%' || '0';

DELETE FROM DEPT WHERE DEPTNO >40;
SELECT E.*, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO LIKE '%'||'10';
--ex3
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, E.DEPTNO, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND ENAME LIKE '%'||TRIM(UPPER('  S  '))||'%' ;
