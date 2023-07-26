--[6��] SUB QERUY : ���� QEURY�ȿ� QUERY�� ����
-- �� 1. ���� ���� ����
    -- ���������� �ʿ��� EX. �޿��� ���� ���� �޴� ����� ��� ����
    SELECT MAX(SAL) FROM EMP; --��������
    SELECT * FROM EMP WHERE SAL =(SELECT MAX(SAL) FROM EMP); --��������
    
    --���������� ����(1)������ ��������(���������� �������� ������) : = > <= !=
        --EX. SCOTT�� ������ �μ����� �ٹ��ϴ� ����� �̸�,�޿�
SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'; -- ������ ��������
SELECT ENAME, SAL
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT')
        AND ENAME != 'SCOTT'; --��������
    -- ���������� ���� (2)������ �������� (���������� �������� 2���̻�): IN,> ALL, ANY(SOME), EXITS 
        --EX. SCOTT�̳� KING�� ������ �μ����� �ٹ��ϴ� ����� �̸�,�޿�
SELECT DEPTNO FROM EMP WHERE ENAME IN ('SCOTT', 'KING'); --������ �������� 10,20
SELECT ENAME, SAL
    FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME IN ('SCOTT', 'KING')); --��������
    
-- �� 2. ������ ��������
    -- EX. SCOTT�� ������ �ٹ������� �ٹ��ϴ� ����� ��� ����
        --������ �߰� (DALLAS 50������, 50�� �μ��� �ٹ��ϴ� ȫ�浿 ���)
        INSERT INTO DEPT VALUES (50, 'IT', 'DALLAS');
        INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (8000,'ȫ�浿', 50);
        SELECT * FROM DEPT;
        SELECT * FROM EMP;
SELECT LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND ENAME='SCOTT'; -- ��������
SELECT E.*, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND LOC=(SELECT LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND ENAME='SCOTT')
    AND ENAME != 'SCOTT'; --��������
ROLLBACK; -- DML
    --EX2. �����Ի������̸��� �����Ի���
SELECT MIN(HIREDATE) FROM EMP; -- ��������(�����Ի���)
SELECT ENAME, HIREDATE FROM EMP WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP); --��������
    --EX3. �ֱ��Ի������̸��� �ֱ��Ի���
SELECT MAX(HIREDATE) FROM EMP; --��������
SELECT ENAME, HIREDATE FROM EMP WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);
    --EX4. �����Ի����� �̸��� ���� �Ի���, �ֱ��Ի������̸��� �ֱ��Ի��� (EX2 + EX3)
SELECT E1.ENAME, E1.HIREDATE, E2.ENAME, E2.HIREDATE
    FROM EMP E1, EMP E2
    WHERE E1.HIREDATE = (SELECT MIN(HIREDATE) FROM EMP) AND
        E2.HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);
SELECT
    (SELECT ENAME FROM EMP WHERE HIREDATE=(SELECT MIN(HIREDATE) FROM EMP) ) �����Ի���,
    (SELECT MIN(HIREDATE) FROM EMP) �����Ի���,
    (SELECT ENAME FROM EMP WHERE HIREDATE = (SELECT MAX (HIREDATE) FROM EMP) ) �ֱ��Ի���,
    (SELECT MAX(HIREDATE) FROM EMP) �ֱ��Ի���
        FROM DUAL;
    -- EX5. SCOTT�� ���� �μ��� �ٹ��ϴ� ������� �޿���
SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT'; --��������
SELECT SUM(SAL) FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME='SCOTT');--��������
    --EX6. SCOTT�� ������ JOB�� ���� ����� ��� �ʵ�(����)
SELECT JOB FROM EMP WHERE ENAME='SCOTT'; -- ��������
SELECT * FROM EMP WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME='SCOTT'); --��������
    --EX7. DALLAS�� �ٹ��ϴ� ����� �̸��� �μ���ȣ (��������, JOIN)
SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS'; -- ������ ��������
SELECT ENAME, DEPTNO FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS'); --��������

SELECT ENAME, E.DEPTNO
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND LOC='DALLAS';
    --EX8. 'KING'�� ���ӻ���� ����� �̸����޿� (��������, SELF-JOIN)
SELECT EMPNO FROM EMP WHERE ENAME='KING'; --ŷ�� ���
SELECT ENAME, SAL FROM EMP WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME='KING');
SELECT W.ENAME, W.SAL
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO AND M.ENAME='KING'; --SELF����
    --EX9. ��ձ޿� ���Ϸ� �޴� ����� �̸��� �޿��� ���
SELECT ENAME, SAL FROM EMP WHERE SAL <= (SELECT AVG(SAL) FROM EMP);
    --EX10. ��ձ޿� ���Ϸ� �޴� ����� �̸�, �޿�, ��ձ޿�(�Ҽ���1�ڸ� �ݿø�)���
SELECT ENAME, SAL, ROUND((SELECT AVG(SAL) FROM EMP), 1) AVG
    FROM EMP
    WHERE SAL <= (SELECT AVG(SAL) FROM EMP);
    -- EX11. ��ձ޿� ���Ϸ� �޴� ����� �̸�, �޿�, ��ձ޿����� ����(�Ҽ���1�ڸ� �ݿø�)�� ���
SELECT ENAME, SAL, ROUND((SELECT AVG(SAL) FROM EMP)-SAL,1) DIFF
    FROM EMP
    WHERE SAL <= (SELECT AVG(SAL) FROM EMP);
    --������ ���߿� ��������
    --SCOTT�� JOB�� �μ���ȣ�� ���� ������ ��� �ʵ� ���
    SELECT JOB, DEPTNO FROM EMP WHERE ENAME='SCOTT'; -- ���߿� ��������
    SELECT * FROM EMP
        WHERE (JOB, DEPTNO) = (SELECT JOB, DEPTNO FROM EMP WHERE ENAME='SCOTT')AND ENAME != 'SCOTT';
        
-- �� 3. ������ �������� : IN, ALL, ANT(SOME), EXISTS
-- (1) IN : ���������� ��� �� �ϳ��� ��ġ�ϸ� ��
    --EX. �μ��� �Ի����� ���� ���� ����� �̸�, �Ի���, �μ���ȣ
SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO; -- ������ ���߿� ��������
SELECT ENAME, HIREDATE, DEPTNO
    FROM EMP
    WHERE (DEPTNO, HIREDATE) IN (SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO);
    --EX. �޿��� 3000�̻� �޴� ����� �Ҽӵ� �μ� ������� ����ʵ�
SELECT DEPTNO FROM EMP WHERE SAL>=3000;--������ �������� (20,10,20)
SELECT * FROM EMP WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE SAL>=3000);--��������
-- (2) ALL : �������� ��� ��� �����ϸ� ��
    --EX. 30�� �μ����� ��� �޿����� ū ������ ����ʵ�
SELECT SAL FROM EMP WHERE DEPTNO=30; --950,1250,1500,1600,2850
SELECT * FROM EMP
    WHERE SAL > ALL (SELECT SAL FROM EMP WHERE DEPTNO=30);--������ ��������
    -- =30�� �μ������� �ִ� �޿����� ���� �޴� ������ ����ʵ�
SELECT * FROM EMP
    WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE DEPTNO=30);--������ ��������
-- (3) ANY(=SOME) : �������� ����� �ϳ��̻� �����ϸ� ��
    -- 30�� �μ����� �Ѹ��̶� �޿��� ū ������ ����ʵ�
SELECT SAL FROM EMP WHERE DEPTNO=30; -- �������� ��� : 950,1250,1500,1600,2850
SELECT * FROM EMP
    WHERE SAL > ANY (SELECT SAL FROM EMP WHERE DEPTNO=30); -- ��������: ������ ���������̿�
-- = 30�� �μ������� �ּ� �޿����� ���� �޴� ������ ����ʵ�
SELECT * FROM EMP
    WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO=30); -- �������� :������ ���������̿�
-- (4) EXISTS : �������� ����� �����ϸ� ��
    --EX. ���Ӻ��ϰ� �ִ� �������� ���, �̸�, �޿�
SELECT DISTINCT EMPNO, ENAME, SAL
    FROM EMP MANAGER
    WHERE EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO=MGR); --�������� �̿�
SELECT M.EMPNO, M.ENAME, M.SAL
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO; -- SELF�����̿�
-- EX. ���Ӻ��ϰ� ���� �������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
    FROM EMP M
    WHERE NOT EXISTS (SELECT * FROM EMP WHERE M.EMPNO=MGR); --���������̿�
SELECT M.EMPNO, M.ENAME, M.SAL
    FROM EMP W, EMP M
    WHERE W.MGR(+)=M.EMPNO AND W.ENAME IS NULL; --SELF ���� �̿�
-- źź1. �μ����� ���� �޿��� ���� �޴� ����� ��� ������ ���(IN ������ �̿�)
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- ��������
SELECT E.*, GRADE, DNAME, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO AND
    SAL BETWEEN LOSAL AND HISAL AND
    (E.DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO)
    ORDER BY E.DEPTNO;
-- źź2. ����(JOB)�� MANAGER�� ����� ���� �μ��� �μ� ��ȣ�� �μ���� ������ ���(IN)
SELECT ENAME FROM EMP WHERE JOB='MANAGER'; --����
SELECT DEPTNO, DNAME, LOC
    FROM DEPT
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB='MANAGER');
    
-- źź3. �޿��� 3000�̻��� ����� �� ���� ����� ����� �ش� ��޺� �ְ� �޿��� �޴� ������� ���, �̸�, ����, �Ի���, �޿�, �޿������ ���
SELECT GRADE, MAX(SAL)
    FROM SALGRADE, EMP
    WHERE SAL BETWEEN LOSAL AND HISAL AND SAL>=3000
    GROUP BY GRADE;--��������
SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL AND
        (GRADE, SAL) IN(SELECT GRADE, MAX(SAL)
                        FROM SALGRADE, EMP
                        WHERE SAL BETWEEN LOSAL AND HISAL AND SAL>=3000
                        GROUP BY GRADE)
    ORDER BY GRADE;
-- źź4. �����ȭ : �Ի��� �б⺰�� ���� ���� �޿��� �޴� ������� �б�, ���, �̸�, JOB, �����, �Ի���, �޿�, �󿩸� ����ϼ���
SELECT HIREDATE, CELL(EXTRACT(MONTH FROM HIREDATE)/3) �б� FROM EMP;
SELECT HIREDATE, TO_CHAR(HIREDATE, 'Q') QUARTER FROM EMP;--�б�
SELECT TO_CHAR(HIREDATE, 'Q'), MAX(SAL)
    FROM EMP
    GROUP BY TO_CHAR(HIREDATE, 'Q');--�������� (�б⺰ �ְ� �޿�)
SELECT TO_CHAR(HIREDATE, 'Q') QUATER, EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM
    FROM EMP
    WHERE (TO_CHAR(HIREDATE, 'Q'), SAL) IN (
                                            SELECT TO_CHAR(HIREDATE, 'Q'), MAX(SAL)
                                            FROM EMP
                                            GROUP BY TO_CHAR(HIREDATE, 'Q'));
-- źź5. �޿��� 3000�̸��� ��� �߿� ���� �ֱٿ� �Ի��� ����� �����ȣ�� �̸�, �޿�, �Ի����� ���
SELECT EMPNO, ENAME, SAL, HIREDATE
    FROM EMP
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP WHERE SAL<3000);
-- źź6. SALESMAN ��� ����� ���� �޿��� ���� �޴� ������� �̸��� �޿��� ����(��� ����)�� ����ϵ� ���� ����� ������� �ʴ´�.(ALL�̿�)
SELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL > ALL (SELECT SAL FROM EMP WHERE JOB ='SALESMAN');
SELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE JOB='SALESMAN');
-- źź7. SALESMAN �Ϻ� � �� ������� �޿��� ���� �޴� ������� �̸��� �޿��� ����(��� ����)�� ����ϵ� ���� ����� ���(ANY)
SELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE JOB='SALESMAN');
    
    
    
--1. ������̺��� ���� ���� �Ի��� ����� �̸�, �޿�, �Ի���
SELECT ENAME, SAL, HIREDATE FROM EMP WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP); 
-- 2. ȸ�翡�� ���� �޿��� ���� ����� �̸�, �޿�
SELECT ENAME, SAL FROM EMP WHERE SAL = (SELECT MIN(SAL) FROM EMP);
-- 3. ȸ�� ��պ��� �޿��� ���� �޴� ����� �̸�, �޿�, �μ��ڵ�
SELECT ENAME, SAL, DEPTNO FROM EMP WHERE SAL >= (SELECT AVG(SAL) FROM EMP);
--4. ȸ�� ��� ������ �޿��� �޴� ����� �̸�, �޿�, �μ���
SELECT ENAME, SAL, D.DNAME 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO AND SAL <= (SELECT AVG(SAL) FROM EMP);
--5. SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���
SELECT ENAME, SAL, HIREDATE, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL AND HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT');
--6. 5��(SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���)�� �μ��� �߰��ϰ� �޿��� ū �� ����
SELECT E.ENAME, E.SAL, HIREDATE, GRADE, D.DNAME
    FROM EMP E, SALGRADE, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT')ORDER BY SAL DESC;
--7. BLAKE ���� �޿��� ���� ������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME='BLAKE');
--8. MILLER���� �ʰ� �Ի��� ����� ���, �̸�, �Ի���
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME='MILLER');
--9. �����ü ��� �޿����� �޿��� ���� ������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL > (SELECT AVG(SAL) FROM EMP);
--10. CLARK�� ���� �μ���ȣ�̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ������� ���, �̸�,�޿�
SELECT EMPNO, ENAME, SAL, DEPTNO
    FROM EMP
    WHERE DEPTNO  = (SELECT DEPTNO FROM EMP WHERE ENAME='CLARK') AND
      SAL > (SELECT SAL FROM EMP WHERE EMPNO=7698);
    
--11. CLARK�� ���� �μ����̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ������� ���, �̸�, �޿�
--12. BLAKE�� ���� �μ��� �ִ� ��� ����� �̸��� �Ի�����
--13. ��� �޿� �̻��� �޴� ��� �������� ���ؼ� �����ȣ�� �̸� �� �޿��� ���� ������ ���)


-- 14.  �̸��� ��T���� �ִ� ����� �ٹ��ϴ� �μ����� �ٹ��ϴ� ��� ������ ��� ��ȣ,�̸�,�޿�(�� ��� �� ���)
SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%' GROUP BY DEPTNO;
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%' GROUP BY DEPTNO);

-- 15. �μ� ��ġ�� Dallas�� ��� �������� ���� �̸�,����,�޿�
SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS';
SELECT ENAME, JOB, SAL
    FROM EMP E
    WHERE E.DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS');
-- 16. EMP ���̺��� King���� �����ϴ� ��� ����� �̸��� �޿�
SELECT EMPNO FROM EMP WHERE ENAME='KING';
SELECT ENAME, SAL
    FROM EMP
    WHERE MGR = (SELECT EMPNO FROM EMP WHERE INITCAP(ENAME)='King');
-- 17. SALES�μ� ����� �̸�, ����
SELECT DEPTNO FROM DEPT WHERE DNAME='SALES';
SELECT ENAME, JOB
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');
-- 18. ������ �μ� 30�� ���� ���޺��� ���� ����� ��� �ʵ�
SELECT MIN(SAL) FROM EMP WHERE DEPTNO='30';
SELECT *
    FROM EMP
    WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO='30');
-- 19.  FORD�� ������ ���޵� ���� ����� ��� �ʵ�
SELECT JOB, SAL FROM EMP WHERE ENAME='FORD';
SELECT *
    FROM EMP
    WHERE (JOB, SAL) IN (SELECT JOB, SAL FROM EMP WHERE ENAME='FORD') AND ENAME != 'FORD';
-- 20. �̸��� JONES�� ������ JOB�� ���ų� FORD�� SAL �̻��� �޴� ����� ������ �̸�, ����, �μ���ȣ, �޿�
    -- ��, ������ ���ĺ� ��, ������ ���� ������ ���
SELECT JOB FROM EMP WHERE ENAME='JONES';
SELECT SAL FROM EMP WHERE ENAME ='FORD';
SELECT ENAME, JOB, DEPTNO, SAL
    FROM EMP
    WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME='JONES') 
    OR SAL > (SELECT SAL FROM EMP WHERE ENAME ='FORD') ORDER BY JOB, SAL DESC;
-- 21. SCOTT �Ǵ� WARD�� ������ ���� ����� ������ �̸�,����,�޿�
SELECT SAL FROM EMP WHERE ENAME='SCOTT' OR ENAME='WARD';

SELECT ENAME, JOB, SAL
    FROM EMP
    WHERE SAL IN (SELECT SAL FROM EMP WHERE ENAME='SCOTT' OR ENAME='WARD') AND ENAME NOT IN ('SCOTT', 'WARD');
-- 22. CHICAGO���� �ٹ��ϴ� ����� ���� ������ �ϴ� ������� �̸�,����
SELECT E.JOB FROM DEPT D WHERE D.LOC='CHICAGO';
SELECT ENAME, JOB
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND  (SELECT JOB FROM JOB E, DEPT D WHERE D.LOC='CHICAGO') ;
-- 23. �μ� ��� ���޺��� ������ ���� ����� ���, �̸�, �޿�, �μ���ȣ
SELECT EMPNO,ENAME, SAL, DEPTNO
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO);
    -- ���, �̸�, �޿�, �μ���ȣ, �ش�μ��� ��ձ޿�
    SELECT EMPNO, ENAME, SAL, DEPTNO, ROUND((SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO))
        FROM EMP E
        WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO);
-- 24. �������� ��� ���޺��� ���� ������ �޴� ����� �μ���ȣ, �̸�, �޿�
SELEC
-- 25. ��� �� �� �̻����κ��� ���� ���� �� �ִ� ����� ����, �̸�, ���, �μ���ȣ�� ���(��, �μ���ȣ ������ �������� ����)

-- 26.  ���� ����� ���, �̸�, ����, �μ���ȣ


    