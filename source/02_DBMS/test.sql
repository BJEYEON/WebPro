--6. 5��(SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���)�� �μ��� �߰��ϰ� �޿��� ū �� ����
SELECT ENAME, SAL,HIREDATE, GRADE, DNAME
    FROM EMP E, DEPT D , SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT');
--7. BLAKE ���� �޿��� ���� ������� ���, �̸�, �޿�
--8. MILLER���� �ʰ� �Ի��� ����� ���, �̸�, �Ի���
--9. �����ü ��� �޿����� �޿��� ���� ������� ���, �̸�, �޿�
--10. CLARK�� ���� �μ���ȣ�̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿�
--11.  �����ȭ. CLARK�� ���� �μ����̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND DNAME
     = (SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME='CLARK') 
     AND SAL > (SELECT SAL FROM EMP WHERE EMPNO='7698');
