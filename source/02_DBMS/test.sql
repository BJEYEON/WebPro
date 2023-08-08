--6. 5번(SCOTT보다 먼저 입사한 사람의 이름, 급여, 입사일, 급여 등급)에 부서명 추가하고 급여가 큰 순 정렬
SELECT ENAME, SAL,HIREDATE, GRADE, DNAME
    FROM EMP E, DEPT D , SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT');
--7. BLAKE 보다 급여가 많은 사원들의 사번, 이름, 급여
--8. MILLER보다 늦게 입사한 사원의 사번, 이름, 입사일
--9. 사원전체 평균 급여보다 급여가 많은 사원들의 사번, 이름, 급여
--10. CLARK와 같은 부서번호이며, 사번이 7698인 직원의 급여보다 많은 급여를 받는 사원의 사번, 이름, 급여
--11.  응용심화. CLARK와 같은 부서명이며, 사번이 7698인 직원의 급여보다 많은 급여를 받는 사원의 사번, 이름, 급여
SELECT EMPNO, ENAME, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND DNAME
     = (SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='CLARK') 
     AND SAL > (SELECT SAL FROM EMP WHERE EMPNO='7698');
