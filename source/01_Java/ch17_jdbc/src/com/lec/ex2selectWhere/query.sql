-- Ex1 . ����ڷκ��� �μ���ȣ�� �޾� �μ����� ���
SELECT * FROM DEPT WHERE DEPTNO=40;

--EX2. �μ�����, (���, �̸�, �޿�, ����̸�) ���
SELECT * FROM DEPT WHERE DEPTNO=40;
SELECT W.EMPNO, W.ENAME, W.SAL, NVL(M.ENAME, ' ') MANAGER
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+) AND W.DEPTNO=10;
    
--EX3. ����ڷκ��� �μ����� �޾� �μ����� ���
SELECT * FROM DEPT WHERE DNAME = UPPER('SALES');