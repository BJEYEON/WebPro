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
-- EX5. 10�� DEPTNO�μ��̰ų� JOB�� MANAGER�� ������ ����ʵ�
SELECT * FROM EMP WHERE DEPTNO=10 OR JOB = 'MANAGER';
--ex6. �μ���ȣ�� 10�� �μ��� �ƴ� ������ ��� �ʵ�
SELECT * FROM EMP WHERE NOT DEPTNO = 10;
--5. ��������� (SELECT��, ������, ORDER BY��)
SELECT EMPNO, ENAME, SAL �������, SAL*1.1 �ø����� FROM EMP;
--EX. ��� ����� �̸� (ENAME), ����(SAL), ����(SAL*12+DOMM)�� ���
SELECT ENAME, SAL, COMM, SAL*12 + COMM ANNUALSAL FROM EMP;
--��������� ����� NULL�� �����ϸ� ����� NULL
-- NVL (NULL�ϼ��� �ִ� �ʵ��, ��ü��)�� ���: �ʵ��� ��ü���� Ÿ��(����, ����, ��¥)�� ��ġ
SELECT ENAME, SAL, COMM, SAL*12+NVL(COMM,0) ANNUALSAL FROM EMP;
-- ��� ����� ENAME, MGR(����� ���)�� ��� (����� ����� ������ -1)
SELECT ENAME, MGR FROM EMP;
-- ��� ����� ENAME, MGR(����� ���)�� ��� (��簡 ������ 'CEO'���)
SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO') MGR FROM EMP;
-- ���Ῥ����(||) : �ʵ峪 ���ڸ� ����
SELECT ENAME || '��(��)' || JOB || '��' MESSAGE FROM EMP;
--EX. ��� ����� ���� SMITH : ANNUAL SALARY = XXX �������� ��� (����= SAL*12+SOMM)
SELECT ENAME || ' : ANNUAL SALARY = ' || (SAL*12+NVL(COMM, 0)) MESSAGE FROM EMP;
--7. �ߺ�����
SELECT DISTINCT JOB FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP;

--�������� ��Ǯ��

--1. emp ���̺��� ���� ���
DESC EMP;
--2. emp ���̺��� ��� ������ ��� 
SELECT * FROM EMP;
--3. �� scott �������� ��밡���� ���̺� ���
SELECT * FROM TAB;
--4. emp ���̺��� ���, �̸�, �޿�, ����, �Ի��� ���
SELECT EMPNO, ENAME, SAL, JOB, HIREDATE FROM EMP;
--5. emp ���̺��� �޿��� 2000�̸��� ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL<2000;
--6. �Ի����� 81/02���Ŀ� �Ի��� ����� ���, �̸�, ����, �Ի��� ���
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE >= '81/02/01';
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') >= '81/02/01';
--��¥ ������ RR/MM/DD�� �ƴ� �� ������ ���
--7. ������ SALESMAN�� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE JOB='SALESMAN';
--8. ������ CLERK�� �ƴ� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE JOB!='CLERR';
--9. �޿��� 1500�̻��̰� 3000������ ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL<=3000 AND SAL>=1500;
--10. �μ��ڵ尡 10���̰ų� 30�� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO='10' OR DEPTNO='30';
--11. ������ SALESMAN�̰ų� �޿��� 3000�̻��� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME JOB, DEPTNO FROM EMP WHERE JOB='SALEMAN' OR SAL>=3000;
--12. �޿��� 2500�̻��̰� ������ MANAGER�� ����� ���, �̸�, ����, �޿� ���
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL>=2500 AND JOB='MANAGER';
--13.��ename�� XXX �����̰� ������ XX�١� ��Ÿ�Ϸ� ��� ���(������ SAL*12+COMM)
 SELECT ENAME || '��' || JOB ||'�����̰� ������' || (SAL*12+nvl(comm, 0)) || '��' MESSAGE FROM EMP;

 --8. SQL������ (BETWEEN, IN, LIKE, IS LULL)
  -- () BETWEEN A AND B
    --EX. �޿��� 1500�̻��̰� 3000������ ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL>=1500 AND SAL<=3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000; --A���� �۾ƾ߉�
    -- EX. �޿��� 1500�̸�, 3000�ʰ��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE SAL NOT BETWEEN 1500 AND 3000;
    -- EX. �̸��� 'A', 'B', 'C'�� �����ϴ� ������ ����ʵ�
SELECT * FROM EMP WHERE ENAME BETWEEN 'A' AND 'D' AND ENAME != 'D';
    -- EX. 82�⵵�� �Ի��� ������ ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31';

-- (2) IN
    -- EX. �μ���ȣ(DEPTNO)�� 10,20,40�� �μ��� ������ ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO=10 OR DEPTNO=20 OR DEPTNO=40;
SELECT * FROM EMP WHERE DEPTNO IN (10,20,40);
    -- EX. �μ���ȣ�� 10,20,40,�� �μ��� ������ ������ ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO!=10 AND DEPTNO!=20 AND DEPTNO!=40;
SELECT * FROM EMP WHERE DEPTNO NOT IN (10,20,40);
    -- EX. ����� 7902,7788,7566�� ����� �������
SELECT * FROM EMP WHERE EMPNO IN (7902,7788,7566);
 -- (3) LIKE ����: %(0���� �̻�), _(�ѱ����̻�)�� ������ ����
    --EX. �̸���M���� �����ϴ� ����� ��� �ʵ� ; M,MA,MXXX
SELECT * FROM EMP WHERE ENAME LIKE 'M%';
    --EX. �̸��� M�� ���� ����� ����ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%M%'; -- M, ~M, M~
    --EX. �̸��� N�� ���ų� JOB�� N�� ���� ����� ����ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%N%' OR JOB LIKE '%N%';
    --EX. �̸��� 'S'��  ������ ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%S';
    --EX. SAL�� 5�� ������ ����� ��� �ʵ�
SELECT * FROM EMP WHERE SAL LIKE '%5';
    --EX. 82�⵵�� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE LIKE '82/%';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '82/__/__';
    --EX. 1���� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '%/01/%';

-- (04) IS NULL (NULL������ �˻��� ��)
    --EX. �󿩱�(COMM)�� ���� ����� ��� �ʵ�
SELECT * FROM EMP WHERE COMM IS NULL OR COMM = 0;
    --EX. �󿩱��� �ִ� ����� ����ʵ�
SELECT * FROM EMP WHERE COMM IS NOT NULL AND COMM!=0;

--9. ���� (��������,��������)
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY SAL; -- �޿� �������� ����
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY SAL DESC; -- �޿� �������� ����
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY SAL DESC, HIREDATE DESC; -- �޿� �������� ����, �޿��� ���� ����ֽ� �Ի��� ��
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY ENAME; -- �̸� ������������
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY HIREDATE DESC; -- �Ի��� �������� ����(�ֽż�) 
 
--<�� ��������>
--1.	EMP ���̺��� sal�� 3000�̻��� ����� empno, ename, job, sal�� ���
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL>=3000;
--2.	EMP ���̺��� empno�� 7788�� ����� ename�� deptno�� ���
SELECT EMPNO, DEPTNO, SAL FROM EMP WHERE EMPNO=7788;
--3.	������ 24000�̻��� ���, �̸�, �޿� ��� (�޿�������)
SELECT ENAME, DEPTNO,SAL FROM EMP ORDER BY (SAL*12+NVL(COMM, 0));
--4.	DLQ������ 1981�� 2�� 20�� 1981�� 5�� 1�� ���̿� �Ի��� ����� �����, ��å, �Ի����� ��� (�� hiredate ������ ���)
SELECT ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE BETWEEN '1981/02/20'AND'1981/05/01';
--5.	deptno�� 10,20�� ����� ��� ������ ��� (�� ename������ ����)
SELECT * FROM EMP WHERE DEPTNO IN(10,20);
--6.	sal�� 1500�̻��̰� deptno�� 10,30�� ����� ename�� sal�� ���
-- (�� HEADING�� employee�� Monthly Salary�� ���)
SELECT ENAME, SAL FROM EMP WHERE DEPTNO IN(10,30) AND SAL>=1500;
--7.	hiredate�� 1982���� ����� ��� ������ ���
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '82/__/__';
--8.	�̸��� ù�ڰ� C����  P�� �����ϴ� ����� �̸�, �޿� �̸��� ����
SELECT ENAME, SAL FROM EMP WHERE ENAME LIKE 'C%' OR ENAME LIKE'P%' ORDER BY SAL;
--9.	comm�� sal���� 10%�� ���� ��� ����� ���Ͽ� �̸�, �޿�, �󿩱��� 
--����ϴ� SELECT ���� �ۼ�
SELECT ENAME, SAL, COMM FROM EMP WHERE  COMM>=(SAL*1.1);
--10.	job�� CLERK�̰ų� ANALYST�̰� sal�� 1000,3000,5000�� �ƴ� ��� ����� ������ ���
SELECT * FROM EMP WHERE JOB IN('CLEAR', 'ANALYST') AND SAL NOT IN (1000,3000,5000);
--11.	ename�� L�� �� �ڰ� �ְ� deptno�� 30�̰ų� �Ǵ� mgr�� 7782�� ����� 
--��� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.
SELECT  * FROM EMP WHERE ENAME LIKE '%L%L%' OR DEPTNO=30 OR MGR=7782;
--12.	�Ի����� 81�⵵�� ������ ���,�����, �Ի���, ����, �޿��� ���
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '81/__/__';
--13.	�Ի�����81���̰� ������ 'SALESMAN'�� �ƴ� ������ ���, �����, �Ի���, 
-- ����, �޿��� �˻��Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '81/__/__' AND JOB!='SALESMAN';
--14.	���, �����, �Ի���, ����, �޿��� �޿��� ���� ������ �����ϰ�, 
-- �޿��� ������ �Ի����� ���� ������� �����Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP ORDER BY SAL DESC, HIREDATE DESC;
--15.	������� �� ��° ���ĺ��� 'N'�� ����� ���, ������� �˻��Ͻÿ�
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '__N%';
--16.	����� 'A'�� �� ����� ���, ������� ���
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '%A%';
--17.	����(SAL*12)�� 35000 �̻��� ���, �����, ������ �˻� �Ͻÿ�.
SELECT EMPNO, ENAME, SAL*12 FROM EMP WHERE 35000>=(SAL*12); 
 
 
 
 
 