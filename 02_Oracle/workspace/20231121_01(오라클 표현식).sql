2023-11-21-01

        (��뿹)
        ��ǰ���̺��� �з��ڵ带 ��ȸ�� 
        'P1' �� �����ϴ� ��ǰ�� '��ǻ�� �� ������ǰ'
        'P2' �� �����ϸ� '�Ƿ�'
        'P3' ���� �����ϸ� '��ȭ'
        �� �ܸ̿� '��Ÿ' �� ���� ���� ����Ͻÿ�
        Alias �� ��ǰ�ڵ�, ��ǰ��, ����
        DECODE �� �̿��Ͽ� �ڵ�
        
        SELECT PROD_ID AS ��ǰ�ڵ�,
               PROD_NAME AS ��ǰ��, 
               DECODE(SUBSTR(PROD_ID, 1, 2), 
               'P1', '��ǻ�� �� ������ǰ', 
               'P2', '�Ƿ�', 
               'P3', '��ȭ', 
               '��Ÿ') AS ����
          FROM PROD;
        
        CASE WHEN ~  THEN �� �̿��Ͽ� �ڵ�
        
        SELECT PROD_ID AS ��ǰ�ڵ�,
               PROD_NAME AS ��ǰ��, 
               CASE SUBSTR(PROD_ID, 1, 2)
                   WHEN 'P1' THEN '��ǻ�� �� ������ǰ'
                   WHEN 'P2' THEN '�Ƿ�'
                   WHEN 'P3' THEN '��ȭ'
                   ELSE '��Ÿ' END AS ����
          FROM PROD;
          
        SELECT PROD_ID AS ��ǰ�ڵ�,
               PROD_NAME AS ��ǰ��, 
               CASE WHEN SUBSTR(PROD_ID, 1, 2) = 'P1' THEN '��ǻ�� �� ������ǰ'
                    WHEN SUBSTR(PROD_ID, 1, 2) = 'P2' THEN '�Ƿ�'
                    WHEN SUBSTR(PROD_ID, 1, 2) = 'P3' THEN '��ȭ'
                    ELSE '��Ÿ' END AS ����
          FROM PROD;  