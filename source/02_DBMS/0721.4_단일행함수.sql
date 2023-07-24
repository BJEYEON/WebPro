-- [IV] �������Լ�

-- �Լ� = �������Լ� + �׷��Լ�(�����Լ�)
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YYYY-MM-DD') FROM EMP;--������ ����(INPUT N�� ->OUT PUT1��)

SELECT SUM(SAL), AVG(SAL) FROM EMP; --�׷��Լ� (INPUT N�� ->OUT PUT1��)
SELECT DEPTNO, SUM(SAL), AVG(SAL) FROM EMP GROUP BY DEPTNO; --DEPTNO�� �׷��Լ� ����(INPUT N��->OUT PUT1��)

-- �������Լ� : ���ڰ����Լ�, ���ڰ����Լ�, ��¥�����Լ�, ����ȯ�Լ�, NVL(), ETC...
    -- DUAL���̺�: ����Ŭ���� ������ 1��1��¥�� ���̺�

--1. ���ڰ����Լ�
SELECT FLOOR(34.5678) FROM DUAL; -- ���������� ����
SELECT FLOOR(34.5678*100)/100 FROM DUAL; --�Ҽ����ι�° �ٸ��� ����
SELECT TRUNC(34.5678, 2) FROM DUAL; --�Ҽ��� �ι�° �ڸ����� ����
SELECT TRUNC(34.5678) FROM DUAL; -- �Ҽ������� ����
SELECT TRUNC(34.5678,-1) FROM DUAL; --���� �ڸ����� ����
    -- EX. EMP���̺��� �̸�, �޿�(���� �ڸ� ����)
SELECT ENAME, TRUNC(SAL,-2), SAL FROM EMP;

SELECT ROUND(34.5678) FROM DUAL; --�Ҽ������� �ݿø�
SELECT ROUND(34.5678,2) FROM DUAL; --�Ҽ��� �ι�° �ڸ����� �ݿø�(34.57)
SELECT ROUND(34.5678, -1) FROM DUAL;--���� �ڸ����� �ݿø�
SELECT CEIL (34.5678) FROM DUAL; --�Ҽ������� �ø�
SELECT CEIL (34.5678*100)/100 FROM DUAL;--�Ҽ��� �ι�°�ڸ����� �ø�

SELECT MOD(9,2) FROM DUAL; --9%2
    -- EX. Ȧ���⵵�� �Ի��� ����� ��� ���� ���
SELECT '10'/2 FROM DUAL;
SELECT * FROM EMP WHERE MOD (TO_CHAR(HIREDATE, 'RR'), 2) = 1;

--2. ���ڰ����Լ�
-- (1) ��ҹ��ڰ���
SELECT INITCAP('WELCOM TO ORACLE') FROM DUAL; --' '������ ������ ù���ڸ� �빮�ڷ�
SELECT UPPER('ABCabc') FROM DUAL; --�빮�ڷ�
SELECT LOWER('ABCabc') FROM DUAL;--�ҹ��ڷ�
    --EX. �̸��� SCOTT�� ������ ��� �ʵ�
    SELECT * FROM EMP WHERE UPPER(ENAME)='SCOTT';
    SELECT * FROM EMP WHERE INITCAP(ENAME)='Scott';
    SELECT * FROM EMP WHERE LOWER(ENAME)='scott';
    
-- (2) ���ڿ���(CONCAT�Լ�, ||������)
SELECT 'AB'||'CD'||'EF'||'GH' FROM DUAL;
SELECT CONCAT('AB','CD'), CONCAT('EF','GH') FROM DUAL;
-- EX. SMITH�� MANAGER��
SELECT ENAME || '��' || JOB || '��' FROM EMP;
SELECT CONCAT(CONCAT(ENAME, '��'), CONCAT(JOB, '��') ) MESSAGE FROM EMP;

--(3) SUBSTR(STR, ������ġ, ���ڰ���): STR�� ������ġ���� ���ڰ�����ŭ ����
        --������ġ�� 1���� ����, ��ġ�� �����̸� ������ �ڸ����� ���ϴ�
    --SUBSTRB(STR, ���۹���Ʈ��ġ, �����ҹ���Ʈ��) : STR�� ���۹���Ʈ��ġ���� ����Ʈ ���� ����
SELECT SUBSTR('ORACLE', 3, 2) FROM DUAL;--3��° ���ں��� 2���� ����
SELECT SUBSTRB('ORACLE', 3, 2) FROM DUAL; --3��° ����Ʈ���� 2����Ʈ ����
SELECT SUBSTR('�����ͺ��̽�', 4, 3) FROM DUAL;-- 4��° ���ں��� 3���� ����
SELECT SUBSTRB('�����ͺ��̽�', 4, 3) FROM DUAL;-- 4��° ����Ʈ���� 3����Ʈ ����
-- O R A C L E
-- 1 2 3 4 5 6 (��ġ)
-- -6 -5 -4 -3 -2 -1(��ġ)
SELECT SUBSTR ('010-9999-9999', -4,4) FROM DUAL; -- -4 ��° ���ں��� 4��¥ ����
SELECT SUBSTR('ORACLE', -1, 1) FROM DUAL;

SELECT SUBSTR(123,-1,1) FROM DUAL; -- ���� ������ ����
--EX. 9�Ͽ� �Ի��� ����� ��� ����
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, -2, 2)= '09';
SELECT * FROM EMP WHERE SUBSTR(TO_CHAR(HIREDATE, 'RR/MM/DD'), -2, 2)= '09';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'DD') = '09';

-- (4) LENGTH (STR) : STR�� ���ڼ�
        --LENGTHB(STR) : STR�� ����Ʈ ��
SELECT LENGTH('ABC') FROM DUAL;
SELECT LENGTHB('ABC') FROM DUAL;
SELECT LENGTH('����Ŭ') FROM DUAL;
SELECT LENGTHB('����Ŭ') FROM DUAL;

-- (5) LPAD (STR, �ڸ���, ä�﹮��) : STR�� �ڸ��� ��Ŭ Ȯ���ϰ� ���� ���ڸ��� ä�﹮�ڷ� ���
    --LPAD (STR, �ڸ���) : STR�� �ڸ�����ŭ Ȯ�� ���� ���ڸ��� ' '���
    --RPAD(STR, �ڸ���, ä�﹮��) : STR�� �ڸ�����ŭ Ȯ���ϰ� ������ ���ڸ��� ä�� ���ڷ� ���
    --RPAD(STR, �ڸ���) : STR�� �ڸ�����ŭ Ȯ���ϰ� ������ ���ڸ��� ' '�� ���
SELECT LPAD('ORACLE', 10, '#') FROM DUAL;
SELECT RPAD('ORACLE', 10, '*') FROM DUAL;
SELECT ENAME, LENGTH(ENAME), SAL FROM EMP; -- ENAME 10���ڱ���,SAL�� 5�ڸ����� ����
DESC EMP;
SELECT RPAD(ENAME, 11, '-')ENAME, LPAD(SAL, 6, '*') SAL FROM EMP;
SELECT LPAD(ENAME, 11, '-')ENAME, RPAD(SAL, 6, '*') SAL FROM EMP;
SELECT LPAD(ENAME, 11)ENAME, RPAD(SAL, 6) SAL FROM EMP;
    -- EX.��� �̸� (7369 S****, 7521 W***, ..) : SUBSTR, LENGTH, RPAD
SELECT EMPNO,
    RPAD(SUBSTR(ENAME,1,1) , LENGTH(ENAME), '*')ENAME 
    FROM EMP;
    -- EX. ���, �̸�, ��å(9�ڸ� Ȯ��), �Ի��� (7396 Smith_____****K 80/12/**) : LPAD, SUBSTR,||
SELECT EMPNO,
        INITCAP(ENAME),
        LPAD (LPAD(SUBSTR(JOB,-1, 1),  LENGTH (JOB), '*'),9) JOB,
        TO_CHAR (HIREDATE, 'RR/MM/') || '**' HIREDATE
    FROM EMP;
    
-- (6) INSTR(STR, ã������) : STR���� ù��° ���ں��� ã�� ���ڰ� ������ ��ġ(������ 0)
    -- INSTR(STR, ã������, ������ġ) : STR���� ������ġ���� ã�� ���ڰ� ������ ��ġ
SELECT INSTR('ABCABC', 'B') FROM DUAL; --ù��° ���ں��� ã�� ������B��ġ
SELECT INSTR('ABCABC', 'B', 3) FROM DUAL; --3��° ���ں��� ã�� ó��������B��ġ: 5
SELECT INSTR('ABCABC', 'B', -3) FROM DUAL; -- ��3��° ���ں��� �ڷ� ã�� ó��������B�� ��ġ
    -- EX. 9���� �Ի��� ����� ��� ���� ��� (INSTR)
SELECT * FROM EMP WHERE INSTR(HIREDATE,'09', 4) =4;    
SELECT * FROM EMP WHERE INSTR(TO_CHAR(HIREDATE,'RR/MM/DD'),'09', 4) =4;  
    -- EX. 9�Ͽ� �Ի��� ����� ���� ���� ���(INSTR)
SELECT * FROM EMP WHERE INSTR (HIREDATE, '09', 7)= 7;
    -- EX. (7)�������� : TRIM(STR), LTROM(STR), RTRIM(STR)
SELECT '        ORACLE        ' MSG FROM DUAL;
SELECT TRIM('        TRIM         ')MSG FROM DUAL;
SELECT LTRIM('        TRIM         ')MSG FROM DUAL;
SELECT RTRIM('        TRIM         ')MSG FROM DUAL;

    --(8) REPLACE(STR, �ٲ���ҹ���, �ٲ���); STR���� �ٲ���� ���ڸ� �ٲ��ڷ� ��ü
SELECT ENAME, REPLACE(ENAME, 'A', 'XXX') REPLACENAME FROM EMP;
SELECT REPLACE(SAL, '0', 'X') FROM EMP;
SELECT REPLACE(HIREDATE, '0', '*') FROM EMP;

-- (6)��¥�����Լ� �� �����
--  (1) SYSDATE : ����
SELECT SYSDATE FROM DUAL;
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD HH24:MI:SS';
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';
SELECT * FROM EMP;
-- (2)��¥ ��� : ����Ŭ Ÿ�� (��¥, ����, ����) �� ��¥�� ���ڴ� ���갡��
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD HH24:MI:SS';
SELECT SYSDATE-1 �����̽ð�, SYSDATE, SYSDATE+1 �����̽ð� FROM DUAL;
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';
--EX. �ݳ�������
SELECT SYSDATE+14 FROM DUAL;
-- EX. ������ ~������� ���� ������?
SELECT TRUNC(SYSDATE-TO_DATE('23/06/26 09:30', 'RR/MM/DD HH24:MI')) FROM DUAL;
-- EX. ����~�������(23.12.11 ����)
SELECT TRUNC(TO_DATE('2023/12/11 13:20', 'RR/MM/DD HH24:MI')- SYSDATE) FROM DUAL;
-- EX. EMP���� �̸�, �Ի���,  �ٹ��ϼ�
SELECT ENAME, HIREDATE, TRUNC(SYSDATE-HIREDATE) DAY FROM EMP;   
-- EX. EMP���� �̸�, �Ի���, �ٹ���, �ٹ��ּ� �ٹ����
SELECT ENAME, HIREDATE,
    TRUNC(SYSDATE-HIREDATE) DAY,
    TRUNC((SYSDATE-HIREDATE)/7) WEEK,
    TRUNC((SYSDATE-HIREDATE)/365) YEAR
    FROM EMP;
-- (3) MONTHS_BETWEEN (����1, ����2) : �� �������� ����  ��(����1�� ���߽���
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) MONTH FROM EMP;
--EX. �̸�,�Ի��� ���� ȸ�翡�� ���� ���� �� �󿩱�(������ �Ѵ޿� �ѹ�, �󿩱� 1��2��)
SELECT ENAME,
    SAL *TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) + 
    NVL(COMM, 0) *2 * TRUNC((SYSDATE-HIREDATE)/365) COST
    FROM EMP;
-- (4) ADD_MONTHS(Ư������, ������) : Ư���������� �����
    -- �̸�, �Ի���, �����������(�����Ⱓ3����)
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 3) FROM EMP;
    --EX. �Ի����� 22.11.30�̸� �����Ⱓ�� 23.2.28
    SELECT * FROM EMP;
INSERT INTO EMP VALUES (8000, 'ȫ�浿', NULL, NULL, '22/11/30', NULL, NULL, 40);
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 3) FROM EMP;
ROLLBACK; --INSERT���
--(5) NEXT_DAY(Ư������, '��'): Ư���������� ó�� �����ϴ� �����
SELECT NEXT_DAY(SYSDATE, '��') FROM DUAL;

-- (6)LAST_DAY(Ư������,) : Ư�������� ����(28,29,30,31)
SELECT LAST_DAY(SYSDATE) FROM DUAL;
-- �̸�, �Ի���, ù ���޳�(���޳��� ���� -> ������ ����)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) ���޳� FROM EMP; --�̹��� ����
SELECT ENAME, HIREDATE, ADD_MONTHS(LAST_DAY(HIREDATE),1) ���޳� FROM EMP; --������ ����
    
-- (7) ROUND(��¥, XX);��¥�� �ݿø�
-- TRUNC��¥ ����
SELECT ROUND (34.5678, 1) FROM DUAL;
SELECT TRUNC (34.5678, 1) FROM DUAL;
SELECT ROUND (SYSDATE, 'YEAR') FROM DUAL; -- �����1��1��
SELECT ROUND (SYSDATE, 'MONTH') FROM DUAL;-- �����1��
SELECT ROUND (SYSDATE) FROM DUAL; -- ���: �����0��
SELECT ROUND (SYSDATE, 'DAY') FROM DUAL; -- ����� �Ͽ���
SELECT TRUNC (SYSDATE, 'DAT') FROM DUAL; -- ���� �Ͽ���
SELECT TRUNC (SYSDATE, 'MONTH') FROM DUAL; --�̹��� 1��
SELECT TRUNC (SYSDATE, 'YEAR') FROM DUAL; --����1��1��
-- �̸�, �Ի���, ù������(16��) ; 1~15�� �Ի�� �̹��� 16���� ����, 16�����Ŀ� �Ի�� ������16�� ����
SELECT ENAME, HIREDATE, ROUND(HIREDATE, 'MONTH')+15 ù���޳� FROM EMP;
-- �̸�, �Ի���, ù���޳�(10��): 1~9�� �Ի�� �̹��� 10���� ����, 10�� ���ĸ� ������ 10�� ����
SELECT ENAME, HIREDATE, ROUND(HIREDATE+6, 'MONTH')+9 ù���޳� FROM EMP;
-- �̸�, �Ի���, ù���޳�(20��) : 1~19�� �Ի�� �̹��� 20���� ����, 20�����Ŀ� �Ի�� ������ 20�� ����
SELECT ENAME, HIREDATE, ROUND(HIREDATE-16, 'MONTH')+19 ù���޳� FROM EMP;

-- 4. ����ȯ �Լ� (TO_CHAR; ���ڷ� ����ȯ/ TO_DATE; ��¥�� ����ȯ/ TO_NUMER;���ڷ� ����ȯ)
-- (1) TO_CHAR(��¥��, '�������')
    --������� : YYYY �⵵4�ڸ� / RR �⵵ 2�ڸ� / MM��/ DD��/ DY����/
 --             HH24/ HH12/ AM�̳�PM/ MI ��/ SS��
 -- ������Ŀ� ���ڸ� ������ ��� ""�ȿ�
SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD DY"����/" HH24:MI:SS') FROM EMP;
SELECT ENAME, TO_CHAR(HIREDATE, 'RR"��"MM"��"DD"��" DY"����" AM HH12"��"MI"��"SS"��"')FROM EMP;    
-- (2) TO_CHAR(������, '�������')
    -- ������� 0: �ڸ���. ��������� �ڸ����� ������������ ���� ������ 0���� ä��
    --        9: �ڸ���. ��������� �ڸ����� �����������ͺ��� ���Ƶ� ������ �����͸� ���
    --        ,:
    --        L: ������ȭ������ �߰�
    --        $: ��ȭ���� $ �߰�
    SELECT TO_CHAR(12345, '000,000') FROM DUAL;
    SELECT TO_CHAR(12345, '999,999') FROM DUAL;
    SELECT TO_CHAR(1004.76, '99,999.9') FROM DUAL;
    SELECT TO_CHAR(1200, 'L9,999') FROM DUAL;
    -- EX. �̸�, �޿�, $���ڸ����� �޸��� �߰��� SAL
    DESC EMP;
        --SAL�� 7�ڸ����� �� �Ҽ��� 2�ڸ�.
    SELECT ENAME, SAL, TO_CHAR(SAL, '$99,999') FROM EMP;
    
-- (3) TO_DATE(����, '����')
    -- EX. 81/5/1~83/5/1 ���̿� �Ի��� ������ ����ʵ�
SELECT * FROM EMP
    WHERE HIREDATE BETWEEN TO_DATE('81/05/01', 'RR/MM/DD')
                         AND TO_DATE('83/05/01', 'RR/MM/DD'); -- TO_DATE�̿�
                         
SELECT * FROM EMP
    WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') BETWEEN '81/05/01' AND '83/05/01'; --TO_CHAR
    
-- (4) TO_NUMBER(����, '����')
SELECT TO_NUMBER('3,456', '9,999') + 1 FROM DUAL;
SELECT '3456' + 1 FROM DUAL;
     
-- 5. NVL(���ϼ��� �ִ� ������, ���̸� ����� ��) - �Ű����� �ΰ��� Ÿ���� ��ġ
    --EX. ����̸�, ���ӻ���̸�(���ӻ�簡 ������ CEO�� ���
SELECT W.ENAME, NVL(M.ENAME, 'CEO') MANAGER
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+);
    --EX. ����̸�, ����ǻ��( ����� ����� ������ CEO���)
SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO') FROM EMP;

--6. ETC..
-- (1) EXTRACT ; ��¥�� �����Ϳ��� �⵵, ��, �ϸ� �����ϰ��� �� ��
SELECT HIREDATE, EXTRACT(YEAR FROM HIREDATE) YEAR FROM EMP; -- �⵵�� ���ڷ� ������
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YYYY') YEAR FROM EMP; --�⵵4�ڸ��� ���ڷ� ������
SELECT HIREDATE, EXTRACT(MONTH FROM HIREDATE) MONTH FROM EMP; -- ���� ���ڷ� ������
SELECT HIREDATE, TO_CHAR(HIREDATE, 'MM') MONTH FROM EMP;  --��2�ָ� ���ڷ� ������
SELECT HIREDATE, EXTRACT(DAY FROM HIREDATR) DAY FROM EMP; --�ϸ� ���ڷ� �߷���
SELECT HIREDATE, TO_CHAR(HIREDATE, 'DD') MONTH FROM EMP; --�� ���ڸ��� ���ڷ� ���

-- (2) �������� ���
SELECT ENAME, SAL FROM EMP;
SELECT LEVEL, LPAD('��', LEVEL*2) || ENAME NAME , SAL FROM EMP
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO=MGR;
 --��������   
--1. ���� ��¥�� TITLE�� Current Date�� ��Ī���� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT SYSDATE "CURRENT DATE" FROM DUAL;
--2. EMP ���̺��� ���� �޿��� 15%�� ������ �޿��� �����ȣ,�̸�,����,�޿�,������ �޿�(New Salary),������(Increase)
--�� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT EMPNO, ENAME, JOB, SAL, (SAL+(SAL*0.15)) "������ �޿�", (SAL*0.15) ������
    FROM EMP;
--3. EMP ���̺��� �̸�,�Ի���,�Ի��Ϸκ��� 6���� �� ���ƿ��� ������ ���Ͽ� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, HIREDATE, NEXT_DAY(ADD_MONTHS(HIREDATE, 6), '��') "6���� �� ������"
    FROM EMP;
--4. EMP ���̺��� �̸�,�Ի���, �Ի��Ϸκ��� ��������� ����,�޿�, �Ի��Ϻ��� ��������� �޿��� �Ѱ踦 ����ϴ�
--SELECT ������ ����Ͻÿ�.
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "�Ի���� ���� ����", SAL, SAL*(TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))) "÷���� ���ݱ��� �޿�"
    FROM EMP;
--5. EMP ���̺��� ��� ����� �̸��� �޿�(15�ڸ��� ��� ������ �� ���� ��*���� ��ġ)�� ����ϴ� SELECT ������ ���
--�Ͻÿ�.
SELECT ENAME, LPAD(SAL, 15,'*')
    FROM EMP;
--6. EMP ���̺��� ��� ����� ������ �̸�,����,�Ի���,�Ի��� ������ ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DY"����"')
    FROM EMP;
--7. EMP ���̺��� �̸��� ���̰� 6�� �̻��� ����� ������ �̸�,�̸��� ���ڼ�,������ ����ϴ� SELECT ������ �����
--�ÿ�.
SELECT ENAME, LENGTH(ENAME), JOB
    FROM EMP
    WHERE LENGTH(ENAME) >=6;
--8. EMP ���̺��� ��� ����� ������ �̸�, ����, �޿�, ���ʽ�, �޿�+���ʽ��� ����ϴ� SELECT ������ ����Ͻÿ�
SELECT ENAME, JOB, SAL, COMM, SAL+NVL(COMM,0)
    FROM EMP;
--9. ��� ���̺��� ������� 2��° ���ں��� 3���� ���ڸ� �����Ͻÿ�. 
SELECT SUBSTR(ENAME, 2,3)
    FROM EMP;
--10. ��� ���̺��� �Ի����� 12���� ����� ���, �����, �Ի����� �˻��Ͻÿ� (EXTRACT�Լ�, TO_CHAR�Լ�)
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE EXTRACT(MONTH FROM HIREDATE) = 12;
--11. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
--EMPNO ENAME �޿�
--7369 SMITH *******800
--7499 ALLEN ******1600
--7521 WARD ******1250
--����.
SELECT EMPNO, ENAME, LPAD(SAL, 10, '*') �޿�
    FROM EMP;
    
--12. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
--EMPNO ENAME �Ի���
--7369 SMITH 1980-12-17
--��.
SELECT EMPNO, ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD') �Ի���
    FROM EMP;
--13. ��� ���̺��� �μ���ȣ�� 20�� ����� ���, �̸�, ����, �޿��� ����Ͻÿ�(�޿��� �տ� $�� �����ϰ� 3�ڸ����� ,
--�� ����Ѵ�)
SELECT EMPNO, ENAME, JOB, TO_CHAR(SAL, '$9,999')
    FROM EMP
    WHERE DEPTNO = 20;
   -- INSERT INTO EMP VALUE (8000,'ȫ�浿',NULL, NULL, SYSDATE, 100000, NULL, 40 );



