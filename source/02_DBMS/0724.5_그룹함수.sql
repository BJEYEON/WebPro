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