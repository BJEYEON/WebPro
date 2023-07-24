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