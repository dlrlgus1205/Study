2023-11-15-02

* ��¥ �Լ�

1. SYSDATE
    - �ý����� �����ϴ� ������ ��¥/�ð� ���� ��ȯ
    - '+', '-' ������ ����� ��
    - ��¥������ - ��¥������ = ����� �ϼ�
    - ��¥������ +(-) ���� => ��¥�� ��ȯ
    
    (��뿹)
    SELECT SYSDATE, SYSDATE - 10, SYSDATE + 10 FROM DUAL;
    
    SELECT TO_CHAR(ROUND(SYSDATE), 'YYYY-MM-DD HH24:MI:SS'),TRUNC(SYSDATE) FROM DUAL;
    
    SELECT TO_CHAR(TO_DATE('00010101'), 'YYYY-MM-DD HH24:MI:SS') FROM DUAL;
    
    SELECT MOD(TO_DATE('19961205') - TO_DATE('00010101') - 1, 7) FROM DUAL;
    
2. ADD_MONTHS
    - �־��� ��¥�� ������ ������ŭ�� ���� ���� ��¥ ��ȯ
    
    [�������]
    ADD_MONTHS(d1, n)
        .��¥ d1�� ���Ե� ���� n�� ���� ��¥�� ��ȯ
        
    (��뿹)
    SELECT ADD_MONTHS(SYSDATE, 3) FROM DUAL;
    
3. NEXT_DAY
    - �ش� ��¥ ���� ���� ���� ���ǵ� ������ ��¥ ��ȯ
    
    [�������]
    NEXT_DAY(d1, c)
        . 'c' : ������ ��Ÿ���� ���ڿ� ex) '��', '������' ~ '�Ͽ���'
        . ��¥ d1 ���Ŀ� ó�� ������ c ������ ��¥ ��ȯ
        
    (��뿹)
    SELECT NEXT_DAY(SYSDATE, '��'), 
           NEXT_DAY(SYSDATE, '�����')
      FROM DUAL;

4. LAST_DAY
    
    [�������]
    LAST_DAY(d)
        . �־��� ��¥ d�� ���Ե� ���� ������ ���� ��ȯ
        
    (��뿹)
    �������̺��� 2020�� 2�� ���Աݾ� �հ踦 ��ȸ�Ͻÿ�
    
    SELECT TO_CHAR(SUM(BUY_QTY * BUY_COST), '9,999,999,999') AS "���Աݾ� �հ�"
      FROM BUYPROD
     WHERE BUY_DATE BETWEEN TO_DATE('20200201') AND 
                            LAST_DAY(TO_DATE('20200201'));
                            
    (��뿹)
    Ű����� ���� �Է� �޾� �ش� ���� �߻��� ���Աݾ��հ踦 ����Ͻÿ�
    
    ACCEPT P_MONTH PROMPT '��ȸ�� ���� 2�ڸ��� �Է��Ͻÿ� : '
    DECLARE
        L_SDATE DATE := TO_DATE('2020' || TRIM('&P_MONTH') || TRIM('01'));
        L_EDATE DATE := LAST_DAY(L_SDATE);
        L_AMT NUMBER := 0;
    BEGIN
        SELECT SUM(BUY_QTY * BUY_COST) INTO L_AMT
          FROM BUYPROD
         WHERE BUY_DATE BETWEEN L_SDATE AND L_EDATE;
         
         DBMS_OUTPUT.PUT_LINE('2020�� &P_MONTH ���� ���� �հ� : ' ||
                         TO_CHAR(L_AMT, '999,999,999') || '��');
         
    END;

5. MONTHS_BETWEEN(d1, d2)
    - �� ��¥ ������ ������ �� ���� ���ڷ� ��ȯ
    
    SELECT TRUNC(MONTHS_BETWEEN(SYSDATE, '20211224')) FROM DUAL;

6. EXTRACT(fmt FROM d1)
    - ��¥ ������ d1���� 'fmt' �ڷḦ ���ڷ� ��ȯ
    - 'fmt' �� YEAR, MONTH, DAY, HOUR, MINUTE, SECOND �� ���
    
    (��뿹)
    ȸ�����̺��� �̹��޿� ������ �ִ� ȸ�������� �����Ͻÿ�
    Alias �� ȸ����ȣ, ȸ����, �������, ����, ���ϸ���
    
    SELECT MEM_ID AS ȸ����ȣ,
           MEM_NAME AS ȸ����,
           MEM_BIR AS �������,
           MEM_JOB AS ����,
           MEM_MILEAGE AS ���ϸ���
      FROM MEMBER
     WHERE EXTRACT(MONTH FROM SYSDATE) = EXTRACT(MONTH FROM MEM_BIR);