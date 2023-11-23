2023-11-23-01

* ��������(SUBQUERY)
    - SQL ���� �ȿ� �� �ٸ� SQL ������ ���Ե� ����
    - ���� JOIN ������ ����� �� ����
    - �˷����� ���� ���ǿ� �ٰ��� ���� ��ȸ�� �� ���
    - INSERT, UPDATE, DELETE �� ���� DML ����� SELECT ��, CREATE TABLE ��, VIEW ���� ���
    - ���� ������ ����Ǳ� ���� �����
    - ����Ǵ� ��ġ�� ����
        . �Ϲݼ�������(SELECT ��)
        . INLINE ��������(FROM �� : �ݵ�� ���� ����ž� ��)
        . ��ø ��������(WHERE ��)
    - ���������� ���������� ������ ���� ���ο� ����
        . ������ �ִ� ��������, ������ ���� ��������
    - ��ȯ�ϴ� ��/���� ���� ���� ������/���Ͽ�, ������/���߿�, ������/���Ͽ�, ������/���߿� �� ����
    - ���������� Ư�� ��츦 �����ϰ� '( )'�� ����ؾ� ��
    - �����ڿ� ����� ��� ������ �����ʿ� ����ؾ� ��
    
    (��뿹)
    ������̺��� ��ձ޿����� ���� �޿��� �޴� ������� ��ȸ�Ͻÿ�
    Alias �� �����ȣ, �����, �޿�, ��ձ޿�
    
    1) �������� : �����ȣ, �����, �޿�, ������ȣ, �����, �޿�, ��ձ޿��ձ޿� ���(���� : ��ձ޿� ����)
    
    SELECT EMPLOYEE_ID AS �����ȣ,
           EMP_NAME AS �����,
           SALARY AS �޿�, ��ձ޿�
      FROM HR.EMPLOYEES
     WHERE SALARY <= (�������� : ��ձ޿�)
      
    2) �������� : ��ձ޿� ���  
    SELECT AVG(SALARY)
      FROM HR.EMPLOYEES
      
    3) ����
    
     SELECT EMPLOYEE_ID AS �����ȣ,
           EMP_NAME AS �����,
           SALARY AS �޿�,
           ROUND((SELECT AVG(SALARY)
                   FROM HR.EMPLOYEES)) AS ��ձ޿�
      FROM HR.EMPLOYEES
     WHERE SALARY <= (SELECT AVG(SALARY)
                        FROM HR.EMPLOYEES);
                        
    (INLINE SUBQUERY ���)
    SELECT A.EMPLOYEE_ID AS �����ȣ,
           A.EMP_NAME AS �����,
           A.SALARY AS �޿�,
           ROUND(B.ASAL) AS ��ձ޿�
      FROM HR.EMPLOYEES A, (SELECT AVG(SALARY) AS ASAL
                              FROM HR.EMPLOYEES) B
     WHERE A.SALARY <= B.ASAL;
     
** ��� �������̺�(REMAIN) ����
------------------------------------------------------
�÷���           ������Ÿ��       �������      COMMIT
------------------------------------------------------
REMAIN_YEAR     CHAR(4)        PK          �����ҳ⵵
PROD_ID         VARCHAR2(10)   PK&FK       ��ǰ�ڵ�
REMAIN_J_00     NUMBER(5)      0           �������
REMAIN_I        NUMBER(5)      0           �԰����
REMAIN_O        NUMBER(5)      0           ������
REMAIN_J_99     NUMBER(5)      0           �����
REMAIN_DATE     DATE           SYSDATE     �۾���

CREATE TABLE REMAIN(
       REMAIN_YEAR CHAR(4),
       PROD_ID     VARCHAR2(10),
       REMAIN_J_00 NUMBER(5) DEFAULT 0,
       REMAIN_I    NUMBER(5) DEFAULT 0,
       REMAIN_O    NUMBER(5) DEFAULT 0,
       REMAIN_J_99 NUMBER(5) DEFAULT 0,
       REMAIN_DATE DATE DEFAULT SYSDATE,
       
       CONSTRAINT PK_REMAIN PRIMARY KEY(REMAIN_YEAR, PROD_ID),
       CONSTRAINT FK_REMAIN_PROD FOREIGN KEY(PROD_ID)
       REFERENCES PROD(PROD_ID));