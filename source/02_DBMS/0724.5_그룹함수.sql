-- [V] �׷��Լ� : SUM, AVG, MIN, MAX, COUNT, STDDEV(ǥ������), VARIANCE(�л�) 
SELECT MAX(SAL) FROM EMP;
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; --�׷캰 �ִ밪
--�ִ�޿��� �޴� ����� �̸��� �޿� -> ��������6��
SELECT ENAME,SAL
    FROM EMP
    WHERE SAL = (SELECT MAX(SAL) FROM EMP);
--�� 1.�׷��Լ��� �ǽ�
SELECT ROUND(AVG(SAL), 2)
    FROM EMP;
SELECT AVG(SAL), SUM(SAL)/COUNT(SAL)
    FROM EMP;
SELECT SUM(SOMM)
    FROM EMP; --���:2200/14 = 157.142857
SELECT SUM(SOMM), COUNT(SOMM), AVG(COMM) FROM EMP; --��� �׷��Լ��� NULL���� �����ϰ� ����
SELECT COUNT(*) FROM EMP; -- EMP���̺��� ���
    --EX. SAL�� ���, ��, �ּҰ�, �ִ밪, �л�, ǥ������, ����(�Ҽ��� ���ڸ��� �ݿø�)
SELECT ROUND(AVG(SAL), 1), SUM(SAL), MIN(SAL), MAX(SAL),
        ROUND(VARIANCE(SAL), 1), ROUND(STDDEV(SAL), 1)
        FROM EMP;
    --�׷��Լ� MIN, MAX, COUNT�� ������, ������, ��¥�� ��ΰ���
SELECT MIN(ENAME), MIN(SIREDATE) FROM EMP; --�̸��ּҰ��� �����Ի���

-- źźex1. �Ի����� ���� ������ ����� �Ի��ϰ� ���� �ֱٿ� �Ի��� ����� �Ի����� ���. 
SELECT MIN(HIREDATE), MAX(HIREDATE)
    FROM EMP;
-- źźex2. (���) 80/12/17:155590��° 83/01/12:14803��°
	--  (hint : TRUNC, MIN, ||)
    SELECT MIN(HIREDATE)||':'|| TRUNC(SYSDATE-MIN(HIREDATE))|| '��°' FIRST,
            MAX(HIREDATE)||':'|| TRUNC(SYSDATE-MAX(HIREDATE))||'��°' LAST
    FROM EMP;
-- źźex3.  (���) 80��12��17�� �����Ի�:15,558��° 83��01��12�� �ֱ��Ի� :14,803��°
   --  (hint :TRUNC, MIN, ||, TO_CHAR)
SELECT TO_CHAR(MIN(HIREDATE), 'RR"��"MM"��"MM"�� �����Ի�:"') ||
        TRIM(TO_CHAR(TRUNC(SYSDATE-MIN(HIREDATE)), '99,999')) || '��°' FIRST,
        TO_CHAR(MAX(HIREDATE),  'RR"��"MM"��"MM"�� �ֱ��Ի�:"') ||
        TRIM(TO_CHAR(TRUNC(SYSDATE-MAX(HIREDATE)), '99,999')) || '��°' LAST
        FROM EMP;
-- źźex4. 10�� �μ� �Ҽ��� ��� �߿��� Ŀ�̼��� �޴� ����� ���� ���� ���ÿ�.
SELECT COUNT(COMM) FROM EMP WHERE DEPTNO=10;

-- �� 2. GROUP BY��
    -- EX. �μ���ȣ�� �ִ�޿�, ��ձ޿� (�μ���ȣ �� ����)
SELECT DEPTNO, MAX(SAL), AVG(SAL) FROM EMP GROUP BY DEPTNO ORDER BY DEPTNO ;
    -- GROUP BY�������� �ʵ��� ��Ī�� ������(ORDER BY�������� �ʵ��� ��Ī ��밡��)
SELECT DEPTNO �μ�, MAX(SAL) MAX, AVG(SAL) AVG
    FROM EMP
    GROUP BY DEPTNO
    ORDER BY MAX;
    
-- EX. �μ��� �ִ�޿�, �򱺱޿� (�μ�������� ����)
SELECT DNAME, MAX(SAL), AVG(SAL)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    GROUP BY DNAME;
--EX. SAL�� 5000�̸��� ����� ���ؼ��� �μ���ȣ��, �����, �ִ�޿�, �ּұ޿�, ��ձ޿�(�μ���ȣ �� ����)
SELECT DEPTNO, COUNT(EMPNO), MAX(SAL), MIN(SAL), AVG(SAL) --(3)
    FROM EMP   --(1)
    WHERE SAL<5000 --(2)
    GROUP BY DEPTNO
    ORDER BY DEPTNO;
-- �� 3. HAVING�� : �׷��Լ� ����� ���������� ���(�ʵ��� ������ ����Ͽ� ����� ������ ���� WHERE��)
    -- EX. �μ���ȣ�� ��ձ޿� (��ձ޿��� 2000�̻��� �μ��� ���)
SELECT DEPTNO, AVG(SAL)
    FROM EMP
    --WHERE AVG(SAL) >= 2000
    GROUP BY DEPTNO
    HAVING AVG(SAL)>=2000;
    --EX.SAL�� 5000���� �̸��� ����� ���� �μ��� �ּұ޿�, ��ձ޿�(�Ҽ��� 2�ڸ����� �ݿø�)), �ִ�޿�
    --�� ��ձ޿��� 1800�̻��� �μ��� ���� ��ձ޿������� ����
SELECT DNAME, MIN(SAL), ROUND(AVG(SAL), 2), MAX(SAL)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND SAL<5000
    GROUP BY DNAME
    HAVING AVG(SAL)>=1800
    ORDER BY AVG (SAL);
    
--�� 4. �׷��Լ� ����� ���谪 ����
SELECT NVL(TO_CHAR(DEPTNO), '��'), SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO);
SELECT DEPTNO, JOB, AVG(SAL) FROM EMP GROUP BY DEPTNO, JOB;
SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY ROLLUP (DEPTNO, JOB);

-- 1. �ο���,�ִ� �޿�,�ּ� �޿�,�޿��� ���� ���
SELECT COUNT(*), MAX(SAL), MIN(SAL), SUM(SAL)
    FROM EMP;
-- 2. ������ �ο����� ���Ͽ� ���
SELECT JOB, COUNT(JOB)
    FROM EMP
    GROUP BY JOB;
--- 3. �ְ� �޿��� �ּ� �޿��� ���̴� ���ΰ� ���
SELECT MAX(SAL) - MIN(SAL)
    FROM EMP;
    
-- 4. �� �μ����� �ο���, �޿� ���, ���� �޿�, �ְ� �޿�, �޿��� ���� ���(�޿��� ���� ���� ������)
SELECT JOB, COUNT(JOB), AVG(SAL), MIN(SAL), MAX(SAL), SUM(SAL)
    FROM EMP
    GROUP BY JOB
    ORDER BY SUM(SAL)DESC;
    
-- 5. �μ���, ������ �׷��Ͽ� ����� �μ���ȣ, ����, �ο���, �޿��� ���, �޿��� ���� ���(�μ���ȣ, ���������� �������� ����)
SELECT DEPTNO, JOB, COUNT(*), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY DEPTNO, JOB
    ORDER BY JOB, DEPTNO;
-- 6. ������, �μ��� �׷��Ͽ� �����  ����, �μ���ȣ, �ο���, �޿��� ���, �޿��� ���� ���(��°���� ������, �μ���ȣ �� �������� ����)
SELECT JOB, DEPTNO, COUNT(*), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY JOB, DEPTNO
    ORDER BY JOB, DEPTNO;
--7. ������� 5���̻� �Ѵ� �μ���ȣ�� ������� ���
SELECT DEPTNO, COUNT(*)
    FROM EMP
    GROUP BY DEPTNO
    HAVING COUNT(*)>=5;
-- 8. ������� 5���̻� �Ѵ� �μ���� ������� ���
SELECT DNAME, COUNT(ENPNO)
    FROM EMP E , DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND COUNT(EMPNO)>=5
    GROUP BY DNAME;
    
    
--9. ������ �޿��� ����� 3000�̻��� ������ ���ؼ� ������, ��� �޿�, �޿��� ���� ���

--10. �޿� ���� 5000�� �ʰ��ϴ� �� ������ ���ؼ� ������ �޿����� ���(�޿� �հ�� �������� ����)

--11. �μ��� �޿����, �μ��� �޿��հ�, �μ��� �ּұ޿��� ���

--12. ���� 11���� �����Ͽ�, �μ��� �޿���� �ִ�ġ, �μ��� �޿����� �ִ�ġ, �μ��� �ּұ޿��� �ִ�ġ�� ���

--13. ��� ���̺��� �Ʒ��� ����� ���
--   H_YEAR	COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
--     80	  1		    800		    800		    800		    800
--	81	 10		    950		    5000	    2282.5	  22825
--	82	  2		    1300	    3000	   2150		   4300
--	83	  1		    1100	    1100	    1100	   1100

-- 14.  �Ʒ��� ����� ���(�Ի�⵵�� �����)
--  1980     1	
--  1981     10
--  1982     2
--  1983     1
--  total    14	

--15. �ִ�޿�, �ּұ޿�, ��ü�޿���, ����� ���

--16. �μ��� �ο��� ���

--17. �μ��� �ο����� 6���̻��� �μ���ȣ ���