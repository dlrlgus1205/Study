2023-11-06
3] ��¥ ������ Ÿ��
  - DATE(�⺻Ÿ��), TIMESTAMP ����
  
  1) DATE Ÿ��
    - �⺻ ��¥��
    - ��, ��, ��, ��, ��, �� ���� ����
    - ������ ������ ����� ��
    
    [�������]
    �÷��� DATE; -- ũ�� ���� ���� �ڵ����� ������
    
    (��뿹)
    CREATE TABLE TEMP07(
        COL1 DATE,
        COL2 DATE,
        COL3 DATE);
        
    ** SYSDATE : �ý����� ��¥ ������ ��ȯ�ϴ� ��¥ �Լ�
    INSERT INTO TEMP07 VALUES(SYSDATE, SYSDATE - 7, SYSDATE + 7);
    INSERT INTO TEMP07 VALUES(TO_DATE('20231101'), 
                              TO_DATE('20231101132517','YYYYMMDDHH24MISS'),
                              '2023-11-05');
    SELECT * FROM TEMP07;
    
    SELECT TO_CHAR(COL1,'YYYY-MM-DD HH24:MI:SS') AS "COL1", 
           TO_CHAR(COL2,'YYYY-MM-DD HH24:MI:SS') AS "COL2", 
           TO_CHAR(COL3,'YYYY-MM-DD HH24:MI:SS') AS "COL3"
    FROM TEMP07;
    
  2) TIMESTAMP Ÿ��
    - �ð���(TIME ZONE : �����/���ø�)������ 10����� 1�� ������ ������ �ð����� ����
    - TIMESTAMP : �ð��� ���� ���� �� ���� 9�ڸ����� ǥ��
    - TIMESTAMP WITH LOCAL TIME ZONE : ���� ������ ��ġ�� ������ ���� �ڵ����� ��¥ ������ ��ȯ��(�ð��� ���� ����, TIMESTAMP�� ���� ���)
    - TIMESTAMP WITH TIME ZONE : �ð��� ���� ǥ��
    
    (��뿹)
    CREATE TABLE TEMP08(
        COL1 DATE,
        COL2 TIMESTAMP,
        COL3 TIMESTAMP WITH LOCAL TIME ZONE,
        COL4 TIMESTAMP WITH TIME ZONE);
        
    INSERT INTO TEMP08(COL1, COL2, COL3, COL4)
           VALUES(SYSDATE, SYSTIMESTAMP, SYSTIMESTAMP, SYSTIMESTAMP);
           
    SELECT * FROM TEMP08;

4] ���� ������ Ÿ��
  - RAW, LONG RAW, BLOB, BFILE
  - �ڷ� �����̳� �˻��� ��� �ش� �ڷḦ �ؼ��ϰų� ��ȯ�Ͽ� ������� ����
  
  1) RAW
    . �ִ� 2000BYTE������ 2�� ���� ����
    . �ε��� ó�� ����
    . 16������ 2���� ���·� ����
  
    [�������]
    �÷��� RAW(ũ��);
  
    (��뿹)
      CREATE TABLE TEMP09(
          COL1 RAW(2000));
    
      INSERT INTO TEMP09 VALUES('1100001111110001');
      INSERT INTO TEMP09 VALUES('C3F1');
    
      SELECT * FROM TEMP09;
    
  2) BFILE
    . 4GB���� 2�� �ڷ� ����
    . �����ڷḦ �����ͺ��̽� �ۿ� �����ϰ� �����ͺ��̽����� ��ο� ���ϸ� ����
    . ���� �����Ͱ� ���� ����Ǵ� ��� ȿ������ �ڷ� Ÿ��
    
    [�������]
    �÷��� BFILE; -- �� ���̺� ���� �÷� ��� ����
    
    (��뿹)
    1. �ڷ� �� ���̺� �غ�
    
    CREATE TABLE TEMP10(
        COL1 BFILE);
        
    2. ���丮 ��ü ����
    
    CREATE DIRECTORY ���丮�� AS ��θ�;
    
    CREATE DIRECTORY TEST_DIR AS 'D:\1.Oracle\util';
    
    3. ������ ����
    INSERT INTO TEMP10 VALUES(BFILENAME('TEST_DIR', 'Cat03.jpg'));
    
    SELECT * FROM TEMP10;
    
  3) BLOB(Binary Large OBject)
    . 4GB������ ���� �ڷ� ����
    . ���� �����͸� �����ͺ��̽� ���ο� ����
    . ó�� �ӵ��� ���� ������ ���� �ڷ��� ���忡�� ������
    
    [�������]
    �÷��� BLOB;
    
    (��뿹)
    1. ���̺� ����
    
    CREATE TABLE TEMP11(
        COL1 BLOB);
        
    2. ���丮 ��ü ����
      - ���� ������ TEST_DIR ���
      
    3. �ڷ� ���� => �͸� ����̳� ���ν����� ����
    
    DECLARE
      L_DIR VARCHAR2(20) := 'TEST_DIR';
      L_FILE VARCHAR2(30) := 'Cat03.jpg';
      L_BFILE BFILE;
      L_BLOB BLOB;
    BEGIN
        INSERT INTO TEMP11(COL1) VALUES(EMPTY_BLOB())
            RETURN COL1 INTO L_BLOB;
        
        L_BFILE := BFILENAME(L_DIR, L_FILE);
        DBMS_LOB.FILEOPEN(L_BFILE, DBMS_LOB.FILE_READONLY);
        DBMS_LOB.LOADFROMFILE(L_BLOB, L_BFILE, DBMS_LOB.GETLENGTH(L_BFILE));
        DBMS_LOB.FILECLOSE(L_BFILE);
    END;
    
    COMMIT;
    
    SELECT * FROM TEMP11;