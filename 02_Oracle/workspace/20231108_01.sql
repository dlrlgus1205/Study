2023-11-08-01

������ �˻� ���(SELECT ��)
    - ������ �˻� ���
    
    [�������]
    SELECT * | [DISTINCT] �÷��� [AS ��Ī][,]
            �÷��� [AS ��Ī][,]
                :
            �÷��� [AS ��Ī]
      FROM ���̺�� [��Ī][, ���̺�� [��Ī], ...]
    
    [WHERE ����]
    [GROUP BY �÷���|�÷��ε���[, �÷���|�÷��ε���, ...]]
    
    [HAVING ����]
    [ORDER BY �÷���|�÷��ε���[DESC|[ASC]]
              [, �÷���|�÷��ε���[DESC|[ASC], ...]];
              
    SELECT SALARY AS "����",
           SALARY + (SALARY * COMMISSION_PCT) AS "���޾�(���ʽ� ����)",
           (SALARY + (SALARY * COMMISSION_PCT)) * 0.1 AS ����,
           SALARY + (SALARY * COMMISSION_PCT - ((SALARY + (SALARY * COMMISSION_PCT)) * 0.1)) �Ǽ��ɾ�
      FROM HR.EMPLOYEES;
      
      1) ������
          - ���������(+, -, *, )
          - ��(����)������(>, <, >=, <=, !=(<>), =)
          - ��������(NOT, AND, OR)
          - ��Ÿ������(LIKE, BETWEEN, IN, ANY(SOME), ALL)
          - ���ǽ� ������ �ַ� ���
          
          (1) ���������
              - +, -, *, / ��� ����
              
              (��뿹)
              HR ������ ������̺�(EMPLOYEES)���� ���ʽ��� ���޾��� ����Ͻÿ�
              ��, ���ʽ��� �޿�(SALARY) * ���������ڵ�(COMMISSION_PCT)�� 50% ���޾� = �޿� + ���ʽ���
              Alias�� �����ȣ(EMPLOYEE_ID), �����(EMP_NAME), �޿�(SALARY), ���ʽ�, ���޾��̸� �Ҽ��� ���ϴ� �ݿø��Ѵ�
              
              SELECT EMPLOYEE_ID AS �����ȣ,
                     EMP_NAME AS �����,
                     SALARY AS �޿�,
                     ROUND(SALARY * COMMISSION_PCT * 0.5) AS ���ʽ�,
                     SALARY + ROUND(SALARY * COMMISSION_PCT *0.5) AS ���޾�
                FROM HR.EMPLOYEES
              ORDER BY 5 DESC; -- = ORDER BY SALARY + ROUND(SALARY * COMMISSION_PCT *0.5) DESC;
              
              (��뿹)
              ��ٱ��� ���̺��� 2020�� 4�� ���ں� �Ǹűݾ��� ��ȸ�ϼ���
              Alias�� ��¥, �Ǹż����հ�, �Ǹűݾ��հ�
              
              SELECT TO_DATE(SUBSTR(A.CART_NO, 1, 8)) AS ��¥, 
                     SUM(A.CART_QTY) AS �Ǹż����հ�, 
                     SUM(A.CART_QTY * B.PROD_PRICE) AS �Ǹűݾ��հ�
                FROM CART A, PROD B
               WHERE A.CART_PROD = B.PROD_ID
                 AND A.CART_NO LIKE '202004%'
               GROUP BY TO_DATE(SUBSTR(A.CART_NO, 1, 8))
               ORDER BY 1;
               
               ����)
               ȸ�����̺��� ȸ������ �������� ������ ����Ͻÿ�
               
                SELECT DISTINCT(SUBSTR(MEM_ADD1, 1, 2)) AS ������
                  FROM MEMBER;
                  
          (2) ���迬����
              - �ַ� ���ǽ��� ������ �� ���
              - ���ǽ��� WHERE ���� ����
              
              (��뿹)
              ȸ�����̺��� ���ϸ����� 2000 �̻��� ȸ���� ȸ����ȣ, ȸ����, �ּ�, ���ϸ����� ����Ͻÿ� (��, ���ϸ����� ���� ȸ������ ���)
              
              SELECT MEM_ID AS ȸ����ȣ,
                     MEM_NAME AS ȸ����,
                     MEM_ADD1 || ' ' || MEM_ADD2 AS �ּ�,
                     MEM_MILEAGE AS ���ϸ���
                FROM MEMBER 
               WHERE MEM_MILEAGE >= 2000
               ORDER BY MEM_MILEAGE DESC;
                     
              
              (��뿹)
              ȸ�����̺��� ���ϸ����� 2000 �̻��̰� ������ ȸ���� ȸ����ȣ, ȸ����, �ֹε�Ϲ�ȣ, �ּ�, ���ϸ����� ����Ͻÿ�
              
              SELECT MEM_ID AS ȸ����ȣ,
                     MEM_NAME AS ȸ����,
                     MEM_REGNO1 || '-' || MEM_REGNO2 AS �ֹε�Ϲ�ȣ,
                     MEM_ADD1 || ' ' || MEM_ADD2 AS �ּ�,
                     MEM_MILEAGE AS ���ϸ���
                FROM MEMBER 
               WHERE MEM_MILEAGE >= 2000
                 AND (SUBSTR(MEM_REGNO2, 1 , 1) = '2' OR (SUBSTR(MEM_REGNO2, 1 , 1)) = '4');
              
              (��뿹)
              ��ǰ���̺��� ���Ⱑ���� 20������ ��ǰ ������ ��ȸ�Ͻÿ�
              Alias�� ��ǰ��ȣ, ��ǰ��, ���Դܰ�, ����ܰ�, �Ǹż���
              
              (��뿹)
              ȸ�����̺��� 20�� ȸ���� ��ȸ�Ͻÿ�
              Alias�� ȸ����ȣ, ȸ����, �ֹι�ȣ, ����, ���� (��, ���ж����� ������ ����)
              
              SELECT MEM_ID AS ȸ����ȣ,
                     MEM_NAME AS ȸ����,
                     MEM_REGNO1 || '-' || MEM_REGNO2 AS �ֹι�ȣ,
                     EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM MEM_BIR) AS ����,
                     CASE WHEN SUBSTR(MEM_REGNO2, 1, 1) = '2' OR
                               SUBSTR(MEM_REGNO2, 1, 1) = '4' THEN
                               '����ȸ��'
                          ELSE '����ȸ��' END AS ����    
                FROM MEMBER
               WHERE TRUNC((EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM MEM_BIR)) / 10) = 2;
            -- WHERE EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM MEM_BIR) >= 20
              -- AND EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM MEM_BIR) <= 29