--// �μ����� �Է¹޾� �ش� �μ� ����� ��� (���, �̸�, ����̸�, �޿�, �޿����, ��簡 ���� ����� ���� -ceo�� ���, �޿��� ����)
SELECT W.EMPNO, W.ENAME, NVL(M.ENAME,'-CEO-') MANAGER, W.SAL, GRADE
    FROM EMP W, EMP M, SALGRADE, DEPT D
    WHERE W.MGR=M.EMPNO(+) AND W.SAL BETWEEN LOSAL AND HISAL
    AND W.DEPTNO=D.DEPTNO
    AND DNAME = UPPER('accounting') ORDER BY SAL;