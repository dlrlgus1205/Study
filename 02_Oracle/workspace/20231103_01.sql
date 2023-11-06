2023-11-03-01
1. ����Ŭ ������ Ÿ��

1] ���ڿ� Ÿ��
  . ' '�� ���� �ڷ� : ���ڿ�
  . ��������(CHAR)
  . ��������(VARCHAR, VARCHAR2, NVARCHAR, LONG, CLOB)
  
  1) CHAR
    - �������� ���ڿ� �ڷ� ����
    - �ִ� 2000 BYTE ���� ����(�ѱ��� �� ���ڰ� 3BYTE)
    - �⺻Ű�� ���̰� ������ �ڷ�(�����ȣ, �ֹι�ȣ ��) ���忡 �ַ� ���
    
    [�������]
    �÷��� CHAR(ũ�� [BYTE|CHAR]);
      SELECT * FROM TEMP01;

    (��뿹)
    CREATE TABLE TEMP01(
        COL1 CHAR(10),
        COL2 CHAR(10 BYTE),
        COL3 CHAR(10 CHAR));
        
    INSERT INTO TEMP01(COL1, COL2, COL3) 
                VALUES('SEOUL', 
                       '������', 
                       '������ �߱� ����');
        
    SELECT * FROM TEMP01;
    
  2) VARCHAR, VARCHAR2, NVARCHAR
    - ����Ŭ������ VARCHAR2 ����� �ǰ���
    - VARCHAR�� VARCHAR2�� ��� ����� ���� ������ ������
    - NVARCHAR�� �����͸� ����ǥ���ڵ�(UTF-8, UTF-16)������� ����
    - �ִ� 4000BYTE���� ����
    - �������� ���ڿ� ����(���ڿ��� ���̸�ŭ ������ Ȯ��)
    
    [�������]
    �÷��� VARCHAR2(ũ�� [BYTE|CHAR]);
      . ũ�� : Ȯ���Ǵ� �������� ũ��(1 ~ 4000)
      . BYTE|CHAR : �����Ǹ� (default) BYTE�� ����
                    'CHAR'�� ����ϸ� 'ũ��'�� ���ڼ��� �ǹ�(�ѱ��� ��� 1333������ ��)
                    
    (��뿹)
    CREATE TABLE TEMP02(
        COL1 CHAR(100),
        COL2 VARCHAR2(4000),
        COL3 VARCHAR2(4000 BYTE),
        COL4 VARCHAR2(4000 CHAR));
        
    INSERT INTO TEMP02 VALUES('IL POSTINO', 
                              'BOYHOOD', 
                              'BOYHOOD', 
                              '������ �߱� ���� 846');
    
    SELECT * FROM TEMP02;
    
    SELECT LENGTHB(COL1), 
           LENGTHB(COL2),
           LENGTHB(COL3),
           LENGTHB(COL4),
           LENGTH(COL4)
           FROM TEMP02;
           
  3) LONG
    - ��뷮 �ڷḦ �����ϱ� ���� �ڷ�Ÿ��(2GB)
    - ����Ŭ ��â����� ����
    - ��� ������ ����� => CLOB(Character Large OBject) ����
    - �� ���̺� �ϳ��� LONG Ÿ�Ը� ���
    
    [�������]
    �÷��� LONG;
    
    (��뿹)
    CREATE TABLE TEMP03(
        COL1 VARCHAR2(2000),
        COL2 LONG,
        COL3 VARCHAR2(3000));
        
      INSERT INTO TEMP03(COL1, COL2) VALUES('IL POSTINO', 'BOYHOOD');
      
      SELECT * FROM TEMP03;
      
  4) CLOB(Character Large OBject)
    - �������� ������ ����
    - �ִ� 4GB ���� ����
    - �� ���̺� �������� CLOB �÷� ��� ����(LONG Ÿ���� ����� ����)
    - �Ϻ� ������ DBMS_LOB API(Application Programming Interface) ����� ����ؾ� ��
    
    [�������]
    �÷��� CLOB;
    
    (��뿹)
    CREATE TABLE TEMP04(
        COL1 CLOB,
        COL2 CLOB,
        COL3 CLOB);
        
      INSERT INTO TEMP04(COL1, COL2) 
                  VALUES('����ȭ ���� �Ǿ����ϴ�.', 
                         '������ �߱� ���� 846');
      
      SELECT * FROM TEMP04;
      
      SELECT --LENGTHB(COL1), 
             LENGTH(COL2)
             FROM TEMP04;
             
      SELECT DBMS_LOB.GETLENGTH(COL1) FROM TEMP04;
      
      SELECT SUBSTR(COL1, 3, 4) AS �÷�1,
             DBMS_LOB.SUBSTR(COL1, 3, 4) AS �÷�2
             FROM TEMP04;