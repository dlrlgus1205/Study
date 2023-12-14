2023-11-17-02

* NULL ó�� �Լ�
    - ����Ŭ�� ��� �÷��� ���� ���� ���� ���ϸ� ������ Ÿ�Կ� ��� ���� NULL ������ �ʱ�ȭ ��(DEFAULT �ɼ� ����� ����)
    - �� NULL ���� ���� �÷��� ���꿡 ���Ǹ� ����� ��� NULL �� �� �������� �ְ��� �߻��� ���輺�� ����
    - NULL �ڷ� ó���� ���� NVL, NVL2, NULLIF ���� �Լ��� ������
    ** - �÷��� ���� NULL �������� �Ǵ��ϴ� ���ǹ������� '=' �����ڴ� NULL ���θ� �Ǵ����� ����
    
    1. IS NULL, IS NOT NULL
        - NULL ���� �Ǵ��� ���� ���ǹ��� ���Ǵ� ������
        
        (��뿹)
        HR ������ ������̺��� ���������ڵ尡 NULL�� �ƴ� ������� ��ȸ�Ͻÿ�
        
        SELECT COUNT(*) AS �����
          FROM HR.EMPLOYEES
         WHERE COMMISSION_PCT IS NULL;
        
    2. NVL(expr, VAL1)
        - NULL ó���Լ� �� ���� �θ� ���Ǵ� �Լ�
        - 'expr'�� ���� NULL �̸� 'VAL1' ���� ��ȯ�ϰ� NULL �� �ƴϸ� 'expr' ���� ��ȯ
        - 'expr' �� 'VAL1' �� ���� ������ Ÿ���̾�� ��
        
        (��뿹)
        2020�� 6�� ��� ��ǰ�� �Ǹż����հ踦 ��ȸ�Ͻÿ�
        Alias �� ��ǰ��ȣ, ��ǰ��, �Ǹż����հ�, �Ǹűݾ��հ�
        
        SELECT B.PROD_ID AS ��ǰ��ȣ,
               B.PROD_NAME AS ��ǰ��,
               NVL(SUM(A.CART_QTY), 0) AS �Ǹż����հ�,
               NVL(SUM(A.CART_QTY * B.PROD_PRICE), 0) AS �Ǹűݾ��հ�
          FROM CART A
         RIGHT OUTER JOIN PROD B ON(A.CART_PROD = PROD_ID AND
               A.CART_NO LIKE '202006%')
         GROUP BY B.PROD_ID, B.PROD_NAME
         ORDER BY 1;
        
        (��뿹)
        HR ���� ������̺��� ���������� ���� ���ʽ��� ����Ͽ� ���޾��� ��ȸ�Ͻÿ�
        Alias �� �����ȣ, �����, �⺻��, ���������ڵ�, ���ʽ�, ���޾�
        ���ʽ� = �⺻�� * ���������ڵ� * 0.6
        ���޾� = �⺻�� + ���ʽ�
        ���������ڵ尡 NULL �̸� '�������� ����' ���
        
        SELECT EMPLOYEE_ID AS �����ȣ,
               EMP_NAME AS �����, 
               SALARY AS �⺻��,
               DEPARTMENT_ID AS �μ��ڵ�, 
               NVL(TO_CHAR(COMMISSION_PCT, '990.99'), '�������� ����') AS ���������ڵ�,
               NVL(ROUND(SALARY * COMMISSION_PCT * 0.6), 0) AS ���ʽ�, 
               SALARY + NVL(ROUND(SALARY * COMMISSION_PCT * 0.6), 0) AS ���޾�
          FROM HR.EMPLOYEES
         ORDER BY �μ��ڵ�;
         
    3. NVL2(expr, VAL1, VAL2)
        - 'expr' �� NULL �� �ƴϸ� VAL1 �� NULL �̸� VAL2 �� ��ȯ
        - VAL1 �� VAL2 �� �ݵ�� ���� Ÿ���� �ڷῩ�� ��
        
        (��뿹)
        ��ǰ���̺��� ��ǰ�� ��������(PROD_COLOR)�� NULL �̸� '�������� ����' NULL �� �ƴϸ� �ش� ���������� ����Ͻÿ� (��, NVL2 �� ����Ͻÿ�)
        Alias �� ��ǰ�ڵ�, ��ǰ��, ����
        
        SELECT PROD_LGU AS ��ǰ�ڵ�, 
               PROD_NAME AS ��ǰ��, 
               NVL2(PROD_COLOR, PROD_COLOR, '�������� ����') AS ����
          FROM PROD;
          
        **��ǰ���̺��� �з���ȣ 'P102' �� ���� ��ǰ���� �ǸŰ��� ���԰��� �����Ͻÿ�
        
        UPDATE PROD
           SET PROD_PRICE = PROD_COST
         WHERE PROD_LGU = 'P102';
         
         COMMIT;
         
    4. NULLIF(col1, col2)
        - 'col1' �� 'col2' �� ���Ͽ� ���� ���̸� NULL �� ��ȯ�ϰ� �ٸ� ���̸� 'col1'�� ��ȯ
        
        (��뿹)
        ��ǰ���̺��� ���԰��� �ǸŰ��� ���� ��ǰ�� ã�� ��� ���� '����������ǰ' �̶�� ���ڿ��� ����ϰ�, ���� ������ �ǸŰ��� ����Ͻÿ�
        Alias �� ��ǰ��ȣ, ��ǰ��, ���
        
        SELECT PROD_ID AS ��ǰ��ȣ,
               PROD_NAME AS ��ǰ��, 
               NVL(TO_CHAR(NULLIF(PROD_PRICE, PROD_COST), '9,999,999'), '����������ǰ') AS "���(�ǸŰ�)"
          FROM PROD;