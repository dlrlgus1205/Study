    2023-11-23-02

    1. INSERT ���� SUBQUERY
        - INSERT ���� ���������� �̿��Ͽ� �����͸� ����
        - VALUES ���� '( )'�� ������� ����
        
        [�������]
        INSERT INTO ���̺��[(�÷���, ...)]
        SELECT �÷���, ...
          FROM ���̺��;
        - 'INSERT INTO' ���� �÷��� ����� ��� ���������� SELECT ���� SELECT �� �÷��� ����, Ÿ���� ��ġ�ؾ���
        
        (��뿹)
        ��ǰ���̺�(PROD)�� ��� �ڷḦ ���� ������ �����ϵ��� �����Ͽ� ���������̺� �����Ͻÿ�
        ������ �ڷ�
        1) ������ �⵵ : '2020'
        2) ��ǰ�ڵ� : PROD���̺��� ��ǰ�ڵ�
        3) ������� : ��ǰ���̺��� PROD_PROPERSTOCK
        4) �԰�/��� ���� : ����
        5) ����� : ��ǰ���̺��� PROD_PROPERSTOCK
        6) ������ : '20200101'
        
        INSERT INTO REMAIN
        SELECT '2020', PROD_ID, PROD_PROPERSTOCK, 0, 0, PROD_PROPERSTOCK, TO_DATE('20200101')
          FROM PROD;
        
        COMMIT;
        
        SELECT * FROM REMAIN;