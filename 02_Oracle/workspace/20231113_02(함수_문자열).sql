2023-11-13-02
    7) REPLACE
        - ���ڿ��� ���ڳ� ���ڿ��� ġȯ
        
        [�������]
        REPLACE(c1, c2, [, c3])
            . ���ڿ� c1���� c2���ڿ��� c3 ���ڿ��� ġȯ
            . c3�� �����Ǹ� c2�� ã�� ������(���� ����)
            
        (��뿹)
        �ŷ������̺�(BUYER)�� �ŷ�ó���� '�ﺸ'�� ã�� 'APPLE'�� �ٲٽÿ�
        
        SELECT BUYER_NAME AS ���ŷ�ó��,
               REPLACE(BUYER_NAME, '�ﺸ', 'APPLE') AS �Űŷ�ó��
          FROM BUYER;
          
        (��뿹)
        ��ǰ���̺��� ��ǰ�� �÷��� ���ο� �����ϴ� ������ �����Ͻÿ�
        
        SELECT PROD_NAME AS "���� �� ��ǰ��",
               REPLACE(PROD_NAME, ' ') AS "���� �� ��ǰ��"
          FROM PROD;
          
    8)LENGTH
        - ���ڿ� ������ ������ ���� ��ȯ
        
        [�������]
        LENGTH(c1)
            . c1 ���ڿ��� ���Ե� ������ ���� ��ȯ
            
        (��뿹)
            SELECT LENGTH('Oracle SQL�� ������ �𵨸�') FROM DUAL;