-- [i] SELECT�� - ��ȸ
-- 1. SELECT ���� �ۼ��� (������: CTRL+ENTER)
SHOW USER;
SELECT * FROM TAB; --�������� ������ �ִ� ���̺� ����
SELECT * FROM EMP; -- EMP���̺��� ��翭, ����� ���
SELECT * FROM DEPT; -- DEPT���̺��� ��� ��, �����
SELECT * FROM SALGRADE; -- SALGRADE���̺��� ��� ��, ��� ��

-- 2. Ư�� ���� ���
DESC EMP;
            --���̺� ����
SELECT EMPNO, ENAME, SAL, JOB FROM EMP; -- EMP���̺��� EMPNO, ENAME, SAL, JOB�ʵ��� �����
SELECT EMPNO AS "�� ��", ENAME AS "�̸�", SAL AS "�޿�", JOB AS "��å" FROM EMP;
SELECT EMPNO NO, ENAME NAME, SAL SALARY, JOB FROM EMP; --�ʵ��� ��Ī�� �δ°��

--3. Ư�� �� ��� : WHERE�� (������) -- �񱳿�����:����(=), �ٸ���(!=, ^=, <>)
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL=3000; --SAL3000�λ��
SELECT EMPNO NO, ENAME ENAME, SAL FROM EMP WHERE SAL != 3000;
SELECT * FROM EMP WHERE SAL<3000;
    -- �񱳿����ڴ� ������(NUMBER), ����(VARCHAR2), DATE��ΰ���
    --EX1. ����̸�(ENAME)�� 'A', 'B', 'C'�� �����ϴ� ����� ��� �ʵ� ���
        -- A<AA<AAA..A<B<BA
SELECT * FROM EMP WHERE ENAME < 'D';
-- EX2. 81�� ������ �Ի��� ����� ����ʵ�
SELECT * FROM EMP WHERE HIREDATE < '81/01/01';
-- EX3. �μ���ȣ(DEPTNO)�� 10�� �μ��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO = 10;
-- EX4. �̸�(ENAME)�� FORD�� ������ ���(EMPND), �̸�(ENAME), ����� ��� (MGR)�� ���
SELECT EMPNO, ENAME, MGR FROM EMP WHERE ENAME = 'FORD';

--4. �������� ��������: AND, OR, NOT
    -- EX1. �޿�(SAL)�� 2000�̻�, 3000������ ������ ����ʵ�
SELECT * FROM EMP WHERE SAL >=2000 AND SAL<=3000;
    --EX2. 82�⵵�� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE>='82/01/01' AND HIREDATE<='82/12/31';
    --��¥ ǥ��� ����(����: YY/MM/DD �Ǵ� RR/MM/DD) 23/07/19
ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-YYYY';
SELECT ENAME, HIREDATE FROM EMP;
SELECT * FROM EMP WHERE HIREDATE>='01-01-1982' AND HIREDATE<='12-31-1982';
SELECT * FROM EMP
    WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') >= '82/01/01'
        AND TO CHAR(HIREDATE, 'RR/MM/DD') <= '82/12/31';
--��¥ ǥ��� ����
 ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';
 -- EX3. ������ 2400�̻��� ������ ENAME, SAL, ����(SAL*12)�� ���
 SELECT ENAME, SAL, SAL*12 ANNUALSAL --(3)
    FROM EMP --(1)
    WHERE SAL*12>=2400; --(2) WHERE������ �ʵ��� ��Ī��� �Ұ�
-- EX3. ������ 2400�̻��� ������ ENAME, SAL, ����(SAL*12)�� ���(����������)
SELECT ENAME, SAL, SAL*12 ANNUALSAL --(3)
    FROM EMP --(1)
    WHERE SAL*12>2400 -- (2)
    ORDER BY ANNUALSAL; --(4)ORDER BY�������� �ʵ��� ��Ī ��밡��
 
 
 
 
 
 
 
 
 
 
 