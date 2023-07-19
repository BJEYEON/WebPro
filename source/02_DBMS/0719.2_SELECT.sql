-- [i] SELECT문 - 조회
-- 1. SELECT 문자 작성법 (실행방법: CTRL+ENTER)
SHOW USER;
SELECT * FROM TAB; --현계정이 가지고 있는 테이블 정보
SELECT * FROM EMP; -- EMP테이블의 모든열, 모든행 출력
SELECT * FROM DEPT; -- DEPT테이블의 모든 열, 모든행
SELECT * FROM SALGRADE; -- SALGRADE테이블의 모든 열, 모든 행

-- 2. 특정 열만 출력
DESC EMP;
            --테이블 구조
SELECT EMPNO, ENAME, SAL, JOB FROM EMP; -- EMP테이블의 EMPNO, ENAME, SAL, JOB필드의 모든행
SELECT EMPNO AS "사 번", ENAME AS "이름", SAL AS "급여", JOB AS "직책" FROM EMP;
SELECT EMPNO NO, ENAME NAME, SAL SALARY, JOB FROM EMP; --필드의 별칭을 두는경우

--3. 특정 행 출력 : WHERE절 (조건절) -- 비교연산자:같다(=), 다르다(!=, ^=, <>)
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL=3000; --SAL3000인사람
SELECT EMPNO NO, ENAME ENAME, SAL FROM EMP WHERE SAL != 3000;
SELECT * FROM EMP WHERE SAL<3000;
    -- 비교연산자는 숫자형(NUMBER), 문자(VARCHAR2), DATE모두가능
    --EX1. 사원이름(ENAME)이 'A', 'B', 'C'로 시작하는 사원의 모든 필드 출력
        -- A<AA<AAA..A<B<BA
SELECT * FROM EMP WHERE ENAME < 'D';
-- EX2. 81년 이전에 입사한 사원의 모든필드
SELECT * FROM EMP WHERE HIREDATE < '81/01/01';
-- EX3. 부서번호(DEPTNO)가 10번 부서인 사원의 모든 필드
SELECT * FROM EMP WHERE DEPTNO = 10;
-- EX4. 이름(ENAME)이 FORD인 직원의 사번(EMPND), 이름(ENAME), 상사의 사번 (MGR)을 출력
SELECT EMPNO, ENAME, MGR FROM EMP WHERE ENAME = 'FORD';

--4. 조건절의 논리연산자: AND, OR, NOT
    -- EX1. 급여(SAL)가 2000이상, 3000이하인 직원의 모든필드
SELECT * FROM EMP WHERE SAL >=2000 AND SAL<=3000;
    --EX2. 82년도에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE>='82/01/01' AND HIREDATE<='82/12/31';
    --날짜 표기법 셋팅(현재: YY/MM/DD 또는 RR/MM/DD) 23/07/19
ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-YYYY';
SELECT ENAME, HIREDATE FROM EMP;
SELECT * FROM EMP WHERE HIREDATE>='01-01-1982' AND HIREDATE<='12-31-1982';
SELECT * FROM EMP
    WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') >= '82/01/01'
        AND TO CHAR(HIREDATE, 'RR/MM/DD') <= '82/12/31';
--날짜 표기법 복귀
 ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';
 -- EX3. 연봉이 2400이상인 직원의 ENAME, SAL, 연봉(SAL*12)을 출력
 SELECT ENAME, SAL, SAL*12 ANNUALSAL --(3)
    FROM EMP --(1)
    WHERE SAL*12>=2400; --(2) WHERE절에는 필드의 별칭사용 불가
-- EX3. 연봉이 2400이상인 직원의 ENAME, SAL, 연봉(SAL*12)을 출력(연봉순으로)
SELECT ENAME, SAL, SAL*12 ANNUALSAL --(3)
    FROM EMP --(1)
    WHERE SAL*12>2400 -- (2)
    ORDER BY ANNUALSAL; --(4)ORDER BY절에서는 필드의 별칭 사용가능
 
 
 
 
 
 
 
 
 
 
 