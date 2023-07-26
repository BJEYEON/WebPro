-- [V] 그룹함수 : SUM, AVG, MIN, MAX, COUNT, STDDEV(표준편차), VARIANCE(분산) 
SELECT MAX(SAL) FROM EMP;
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; --그룹별 최대값
--최대급여를 받는 사람의 이름과 급여 -> 서브쿼리6장
SELECT ENAME,SAL
    FROM EMP
    WHERE SAL = (SELECT MAX(SAL) FROM EMP);
--★ 1.그룹함수들 실습
SELECT ROUND(AVG(SAL), 2)
    FROM EMP;
SELECT AVG(SAL), SUM(SAL)/COUNT(SAL)
    FROM EMP;
SELECT SUM(SOMM)
    FROM EMP; --평균:2200/14 = 157.142857
SELECT SUM(SOMM), COUNT(SOMM), AVG(COMM) FROM EMP; --모든 그룹함수는 NULL값을 제외하고 연산
SELECT COUNT(*) FROM EMP; -- EMP테이블의 행수
    --EX. SAL의 편균, 합, 최소값, 최대값, 분산, 표준편차, 갯수(소수점 한자리엣 반올림)
SELECT ROUND(AVG(SAL), 1), SUM(SAL), MIN(SAL), MAX(SAL),
        ROUND(VARIANCE(SAL), 1), ROUND(STDDEV(SAL), 1)
        FROM EMP;
    --그룹함수 MIN, MAX, COUNT는 숫자형, 문자형, 날짜형 모두가능
SELECT MIN(ENAME), MIN(SIREDATE) FROM EMP; --이름최소값과 최초입사일

-- 탄탄ex1. 입사한지 가장 오래된 사원의 입사일과 가장 최근에 입사한 사원의 입사일을 출력. 
SELECT MIN(HIREDATE), MAX(HIREDATE)
    FROM EMP;
-- 탄탄ex2. (결과) 80/12/17:155590일째 83/01/12:14803일째
	--  (hint : TRUNC, MIN, ||)
    SELECT MIN(HIREDATE)||':'|| TRUNC(SYSDATE-MIN(HIREDATE))|| '일째' FIRST,
            MAX(HIREDATE)||':'|| TRUNC(SYSDATE-MAX(HIREDATE))||'일째' LAST
    FROM EMP;
-- 탄탄ex3.  (결과) 80년12월17일 최초입사:15,558일째 83년01월12일 최근입사 :14,803일째
   --  (hint :TRUNC, MIN, ||, TO_CHAR)
SELECT TO_CHAR(MIN(HIREDATE), 'RR"년"MM"월"MM"일 최초입사:"') ||
        TRIM(TO_CHAR(TRUNC(SYSDATE-MIN(HIREDATE)), '99,999')) || '일째' FIRST,
        TO_CHAR(MAX(HIREDATE),  'RR"년"MM"월"MM"일 최근입사:"') ||
        TRIM(TO_CHAR(TRUNC(SYSDATE-MAX(HIREDATE)), '99,999')) || '일째' LAST
        FROM EMP;
-- 탄탄ex4. 10번 부서 소속의 사원 중에서 커미션을 받는 사원의 수를 구해 보시오.
SELECT COUNT(COMM) FROM EMP WHERE DEPTNO=10;

-- ★ 2. GROUP BY절
    -- EX. 부서번호별 최대급여, 평균급여 (부서번호 순 정렬)
SELECT DEPTNO, MAX(SAL), AVG(SAL) FROM EMP GROUP BY DEPTNO ORDER BY DEPTNO ;
    -- GROUP BY절에서는 필드의 별칭을 사용없음(ORDER BY절에서는 필드의 별칭 사용가능)
SELECT DEPTNO 부서, MAX(SAL) MAX, AVG(SAL) AVG
    FROM EMP
    GROUP BY DEPTNO
    ORDER BY MAX;
    
-- EX. 부서명별 최대급여, 평군급여 (부서명순으로 정력)
SELECT DNAME, MAX(SAL), AVG(SAL)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    GROUP BY DNAME;
--EX. SAL이 5000미만인 사원에 대해서만 부서번호별, 사원수, 최대급여, 최소급여, 평균급여(부서번호 순 정렬)
SELECT DEPTNO, COUNT(EMPNO), MAX(SAL), MIN(SAL), AVG(SAL) --(3)
    FROM EMP   --(1)
    WHERE SAL<5000 --(2)
    GROUP BY DEPTNO
    ORDER BY DEPTNO;
-- ★ 3. HAVING절 : 그룹함수 결과로 제한적으로 출력(필드의 조건을 사용하여 결과를 제한할 때는 WHERE절)
    -- EX. 부서번호별 평균급여 (평균급여가 2000이상인 부서만 출력)
SELECT DEPTNO, AVG(SAL)
    FROM EMP
    --WHERE AVG(SAL) >= 2000
    GROUP BY DEPTNO
    HAVING AVG(SAL)>=2000;
    --EX.SAL이 5000만원 미만인 사원에 대해 부서명별 최소급여, 평균급여(소숫점 2자리에서 반올림)), 최대급여
    --단 평균급여가 1800이상인 부서에 대해 평균급여순으로 정렬
SELECT DNAME, MIN(SAL), ROUND(AVG(SAL), 2), MAX(SAL)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND SAL<5000
    GROUP BY DNAME
    HAVING AVG(SAL)>=1800
    ORDER BY AVG (SAL);
    
--★ 4. 그룹함수 결과의 짐계값 생성
SELECT NVL(TO_CHAR(DEPTNO), '합'), SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO);
SELECT DEPTNO, JOB, AVG(SAL) FROM EMP GROUP BY DEPTNO, JOB;
SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY ROLLUP (DEPTNO, JOB);

-- 1. 인원수,최대 급여,최소 급여,급여의 합을 출력
SELECT COUNT(*), MAX(SAL), MIN(SAL), SUM(SAL)
    FROM EMP;
-- 2. 업무별 인원수를 구하여 출력
SELECT JOB, COUNT(JOB)
    FROM EMP
    GROUP BY JOB;
--- 3. 최고 급여와 최소 급여의 차이는 얼마인가 출력
SELECT MAX(SAL) - MIN(SAL)
    FROM EMP;
    
-- 4. 각 부서별로 인원수, 급여 평균, 최저 급여, 최고 급여, 급여의 합을 출력(급여의 합이 많은 순으로)
SELECT JOB, COUNT(JOB), AVG(SAL), MIN(SAL), MAX(SAL), SUM(SAL)
    FROM EMP
    GROUP BY JOB
    ORDER BY SUM(SAL)DESC;
    
-- 5. 부서별, 업무별 그룹하여 결과를 부서번호, 업무, 인원수, 급여의 평균, 급여의 합을 출력(부서번호, 업무순으로 오름차순 정렬)
SELECT DEPTNO, JOB, COUNT(*), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY DEPTNO, JOB
    ORDER BY JOB, DEPTNO;
-- 6. 업무별, 부서별 그룹하여 결과를  업무, 부서번호, 인원수, 급여의 평균, 급여의 합을 출력(출력결과는 업무순, 부서번호 순 오름차순 정렬)
SELECT JOB, DEPTNO, COUNT(*), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY JOB, DEPTNO
    ORDER BY JOB, DEPTNO;
--7. 사원수가 5명이상 넘는 부서번호와 사원수를 출력
SELECT DEPTNO, COUNT(*)
    FROM EMP
    GROUP BY DEPTNO
    HAVING COUNT(*)>=5;
-- 8. 사원수가 5명이상 넘는 부서명과 사원수를 출력
SELECT DNAME, COUNT(*)
    FROM EMP E , DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    GROUP BY DNAME
    HAVING COUNT(*)>=5;
--9. 업무별 급여의 평균이 3000이상인 업무에 대해서 업무명, 평균 급여, 급여의 합을 출력
SELECT JOB, AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY JOB
    HAVING AVG(SAL)>=3000;
--10. 급여 합이 5000을 초과하는 각 업무에 대해서 업무와 급여합을 출력(급여 합계순 내림차순 정렬)
SELECT JOB, SUM(SAL)
    FROM EMP
    GROUP BY JOB
    HAVING SUM(SAL)>=5000;
--11. 부서별 급여평균, 부서별 급여합계, 부서별 최소급여를 출력
SELECT DNAME, AVG(SAL), SUM(SAL), MIN(SAL)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    GROUP BY DNAME;
--12. 위의 11번을 수정하여, 부서별 급여평균 최대치, 부서별 급여합의 최대치, 부서별 최소급여의 최대치를 출력
SELECT MAX(AVG(SAL)), MAX(SUM(SAL)), MAX(MIN(SAL))
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    GROUP BY DNAME;
--13. 사원 테이블에서 아래의 결과를 출력
--   H_YEAR	COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
--     80	  1		    800		    800		    800		    800
--	81	 10		    950		    5000	    2282.5	  22825
--	82	  2		    1300	    3000	   2150		   4300
--	83	  1		    1100	    1100	    1100	   1100
SELECT TO_CHAR(HIREDATE, 'RR'), COUNT(*), MIN(SAL), MAX(SAL), AVG(SAL)
    FROM EMP
    GROUP BY ROLLUP (TO_CHAR(HIREDATE, 'RR'))
    ORDER BY (TO_CHAR(HIREDATE, 'RR'));
-- 14.  아래의 결과를 출력(입사년도별 사원수)
--  1980     1	
--  1981     10
--  1982     2
--  1983     1
--  total    14	
SELECT NVL(TO_CHAR(HIREDATE, 'YYYY'),'TOTAL'), COUNT(HIREDATE)
    FROM EMP
    GROUP BY ROLLUP (TO_CHAR(HIREDATE, 'YYYY'));
    --ORDER BY HIREDATE;
--15. 최대급여, 최소급여, 전체급여합, 평균을 출력
SELECT MAX(SAL), MIN(SAL), SUM(SAL), AVG(SAL)
    FROM EMP;
--16. 부서별 인원수 출력
SELECT DNAME, COUNT(DNAME)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    GROUP BY DNAME;
--17. 부서별 인원수가 6명이상인 부서번호 출력
SELECT DNAME, COUNT(DNAME)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    GROUP BY DNAME
    HAVING COUNT(DNAME)>=6;