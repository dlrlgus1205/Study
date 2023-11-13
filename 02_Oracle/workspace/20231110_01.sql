2023-11-10-01
    3) ALL ������
        . �־��� ���� ���� �ڷ� ��θ� �����ؾ� ����� ���� �Ǵ� ������
        
        [�������]
        expr ���迬���� ALL(��1[, ��2, ... ��n])
            . '���迬����'�� '=' �����ڴ� ����� �� ����
        
        (��뿹)
        HR ������  ������̺��� 50�� �μ��� ���� ��� �� ���� �޿��� ���� ������� �� ���� �޿��� �޴� ������� ��ȸ�Ͻÿ�
        Alias �����ȣ, �����, �μ���ȣ, �޿�
        
        (50�� �μ��� ���� ������� �޿�)
        SELECT SALARY
          FROM HR.EMPLOYEES
         WHERE DEPARTMENT_ID = 50
         
        (���)
        SELECT EMPLOYEE_ID AS �����ȣ, 
               EMP_NAME AS �����, 
               DEPARTMENT_ID AS �μ���ȣ, 
               SALARY AS �޿�
          FROM HR.EMPLOYEES
         WHERE SALARY > ALL( SELECT SALARY
                               FROM HR.EMPLOYEES
                              WHERE DEPARTMENT_ID = 50)
         ORDER BY 4;
    
    4) LIKE ������
        . ���ڿ� �� ������
        . �������� ���ڿ�(���ϵ�ī�� : '%', '_')�� ����Ͽ� ���� ��
        . '%' = ���� ������ '%'�� ���� ��ġ���� ������ ��� ���ڿ��� ����
        ex) '��%' : '��'�� �����ϴ� ��� ���ڿ��� ����
            '%��%' : �ܾ� �� '��'�� �����ϴ� ��� ���ڿ��� ����
            '%��' : ��� ������ ��� ���ڿ��� ����
        . '_' = ���� �������� '_'�� ���� ��ġ���� �� ���ڿ� ����
        ex) '��_' : 2�����̸�, '��'�� �����ϴ� ���ڿ��� ����
            '_��_'  3���ڷ� �����Ǹ�, �ܾ� �� '��'�� �����ϴ� ���ڿ��� ����
            '_��' : '��'�� ������ 2���� ���ڿ��� ����
        .��¥�� �����ڷῡ�� ������� �� ��
        
        (��뿹)
        ��ǰ���̺�(PROD)���� �з��ڵ尡 P100���뿡 ���� ��ǰ���� ��ȸ�Ͻÿ� (�з��ڵ� ������ ����� ��)
        Alias�� ��ǰ �ڵ�, ��ǰ��, �з��ڵ�, ���Ⱑ��
        
        SELECT PROD_ID AS "��ǰ �ڵ�", 
               PROD_NAME AS ��ǰ��, 
               PROD_LGU AS �з��ڵ�, 
               PROD_PRICE AS ���Ⱑ��
          FROM PROD
         WHERE PROD_LGU LIKE 'P1%'
        
        (��뿹)
        ȸ�����̺��� ������ �����ϴ� ȸ������ ��ȸ�Ͻÿ�
        Alias�� ȸ����ȣ, ȸ����, �ּ�
        
        SELECT MEM_ID AS ȸ����ȣ,
               MEM_NAME AS ȸ����,
               MEM_ADD1 || ' ' || MEM_ADD2 AS �ּ�
          FROM MEMBER
         WHERE MEM_ADD1 LIKE '����%';
         
        (��뿹)
        ��ٱ������̺�(CART)���� 2020�� 6���� �Ǹŵ� ������ ��ȸ�Ͻÿ�
        Alias�� ����ȸ�� ��ȣ, ��������, ��ǰ�ڵ�, ���� ����
        
        SELECT CART_MEMBER AS "����ȸ�� ��ȣ",
               TO_DATE(SUBSTR(CART_NO, 1, 8)) AS ��������,
               CART_PROD AS ��ǰ�ڵ�,
               CART_QTY AS "���� ����"
          FROM CART
         WHERE CART_NO LIKE '202006%';
        (��뿹)
        �������̺�(BUYPROD)���� 2020�� 2�� ���������� ��ȸ�Ͻÿ�
        Alias�� ������, ���Ի�ǰ �ڵ�, ���Լ���, �ܰ�, �ݾ�
        
        SELECT BUY_DATE AS ������, 
               BUY_PROD AS ���Ի�ǰ�ڵ�, 
               BUY_QTY AS ���Լ���, 
               BUY_COST AS �ܰ�, 
               BUY_QTY * BUY_COST AS �ݾ�
          FROM BUYPROD
         -- WHERE BUY_DATE BETWEEN '20200201' AND LAST_DAY('20200201');
         WHERE BUY_DATE >= '20200201' AND BUY_DATE <= LAST_DAY('20200201');
         
    5) BETWEEN ������
        . ������ ������ �� ���
        . ��� Ÿ���� �ڷῡ ��� ����
        . AND �����ڸ� ����� �� ����
        
        [�������]
        expr BETWEEN ��1 AND ��2;
            . '��1'�� '��2'�� ���� Ÿ��
            . '��1'���� '��2'������ ������ �����Ͽ� ��
            . IN �����ڴ� �ҿ��� �ڷḦ ���ϰ�, AND�� BETWEEN�����ڴ� ������ �ڷḦ ��
        
        (��뿹)
        ��ǰ���̺��� 'P100' ~ 'P200'�� ���� ��ǰ �� �ǸŰ����� 50���� �̻��� ��ǰ�� ��ȸ�Ͻÿ�
        Alias �� ��ǰ��ȣ, ��ǰ��, �з��ڵ�, �ǸŰ���
        
        -- AND ������ ���
        SELECT PROD_ID AS ��ǰ��ȣ, 
               PROD_NAME AS ��ǰ��,
               PROD_LGU AS �з��ڵ�,
               PROD_PRICE AS �ǸŰ���
          FROM PROD
         WHERE PROD_LGU >= 'P100' AND PROD_LGU <= 'P299'
               AND PROD_PRICE > = 500000;
        -- BETWEEN ������ ���
        --  WHERE PROD_LGU BETWEEN 'P100' AND 'P299'
        --      AND PROD_PRICE > = 500000;         
        (��뿹)
        ȸ�����̺��� ���� ���ϸ����� 2000 ~ 3000�� ȸ������ ��ȸ�Ͻÿ�
        Alias �� ȸ����ȣ, ȸ����, ����, ���ϸ���
        
        SELECT MEM_ID AS ȸ����ȣ, 
               MEM_NAME AS ȸ����, 
               MEM_ AS ����, 
               MEM_MILEAGE AS ���ϸ���
          FROM MEMBER    
         WHERE MEM_MILEAGE BETWEEN 2000 AND 3000;
        (��뿹)
        HR ������ ������̺��� 10 ~ 40�� �μ��� ���� ������� ��ȸ�Ͻÿ�
        Alias �� �����ȣ, �����, �Ի���, �����ڵ�
        
        SELECT EMPLOYEE_ID AS �����ȣ,
               EMP_NAME AS �����,
               HIRE_DATE AS �Ի���,
               JOB_ID AS �����ڵ�
          FROM HR.EMPLOYEES
         WHERE  
        
        (��뿹)
        �������̺��� 2020�� 1�б� �ڷ� �� ���Աݾ��� 500���� �̻��� ���������� ��ȸ�Ͻÿ�
        Alias �� ���Կ�, ���Ի�ǰ, ���Աݾ�
        
        SELECT EXTRACT(MONTH FROM BUY_DATE) AS ���Կ�, 
               BUY_PROD AS ���Ի�ǰ, 
               BUY_QTY * BUY_COST AS ���Աݾ�
          FROM BUYPROD
         WHERE EXTRACT(MONTH FROM BUY_DATE) BETWEEN 1 AND 3
               AND BUY_QTY * BUY_COST >= 5000000
         ORDER BY 3 DESC;