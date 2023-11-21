2023-11-14-01

* ���� �Լ�

1. ������ �Լ�
    1)ABS(Absolute Value) : ABS(n1)
        - n1�� ���밪 ��ȯ
    2)SIGN(n)
        - n�� ��ȣ�� ���� -1(n�� ������ ��), 0(n�� 0�� ��), 1(n�� ����� ��)�� ��ȯ
        - n�� ũ��� ����� ����
    3)POWER(n,y)
        - n�� y�°��� ��ȯ(n�� y�� �ŵ� ���� ��)
    4)SQRT(n)
        - n�� ����(root) ��
    
    SELECT SIGN(-1000), SIGN(0), SIGN(0.0000005) FROM DUAL;
    SELECT POWER(2,10) FROM DUAL;
    SELECT SQRT(28.9, SQRT(3.3) FROM DUAL;
    
    ��뿹) ȸ�����̺��� ȸ���� ���ϸ��� ��հ��� ���ϰ� ȸ������ ���ϸ������� ������ ��ȸ�Ͻÿ� (��, ������ ��ȣ���� ������ ǥ���ϰ�, ��ո��ϸ����� ������ ǥ��)
    Alias �� ȸ����, ��ո��ϸ���, �������ϸ���, ����
    
    (ȸ���� ���ϸ��� ���)
    SELECT ROUND(AVG(MEM_MILEAGE)) AS A1
      FROM MEMBER;
    
    SELECT MEM_NAME AS ȸ����,
           (SELECT ROUND(AVG(MEM_MILEAGE))
             FROM MEMBER) AS ��ո��ϸ���,
           MEM_MILEAGE AS �������ϸ���,  
           ABS((SELECT ROUND(AVG(MEM_MILEAGE))
             FROM MEMBER) - MEM_MILEAGE) AS ����
      FROM MEMBER;
      
2. GREATEST, LEAST
    - �־��� �ڷ� �� �ִ밪(GREATEST)�� �ּҰ�(LEAST)�� ��ȯ
    
    [�������]
    GREATEST(n1, n2[, n3, ...]), 
    LEAST(n1, n2[, n3, ...])
    
    (��뿹)
    ��ǰ���̺��� ���Դܰ�, ����ܰ�, �����ǸŴܰ� �� ���� ū ���� ���� ���� ���� ��ȸ�Ͻÿ�
    
    SELECT PROD_COST AS ���԰�, 
           PROD_PRICE AS ���Ⱑ, 
           PROD_SALE AS ���ΰ�,
           GREATEST(PROD_COST, PROD_PRICE, PROD_SALE) AS �ִ밪,
           LEAST(PROD_COST, PROD_PRICE, PROD_SALE) AS ���ʰ�
      FROM PROD;
    
    (��뿹)
    ȸ�����̺��� ���ϸ����� 1000 �̸��� ȸ���� ���ϸ����� 1000���� �ο��Ͽ� ����ϰ� 1000 �̻��� ȸ���� �� ȸ���� ������ ���ϸ����� �״�� ����Ͻÿ�
    Alias �� ȸ����ȣ, ȸ����, �������ϸ���, ���渶�ϸ���
    
    SELECT MEM_ID AS ȸ����ȣ,
           MEM_NAME AS ȸ����,
           MEM_MILEAGE AS �������ϸ���,
           GREATEST(MEM_MILEAGE, 1000) AS ���渶�ϸ���
      FROM MEMBER;
      
      SELECT A.MEM_NAME AS ȸ����,
             A.MEM_MILEAGE AS ���ϸ���
        FROM MEMBER A
       WHERE A.MEM_MILEAGE = (SELECT MAX(MEM_MILEAGE)
                                FROM MEMBER);

3. ROUND, TRUNC
    - �ݿø�(ROUND)�� �ڸ�����(TRUNC) ��� ��ȯ
    
    [�������]
    ROUND(n1[, n2])
    TRUNC(n1[, n2])
        - n2�� ���� ������ ���
            . �־��� �� n1���� �Ҽ��� ���� n2 + 1��° �ڸ����� �ݿø�(ROUND) �Ǵ� �ڸ�����(TRUNC)�Ͽ� n2�ڸ����� ��Ÿ��
        - n2�� ���� ������ ���
            . �־��� �� n1���� �����κ� n2��° �ڸ����� �ݿø�(ROUND) �Ǵ� �ڸ�����(TRUNC)�Ͽ� n2�ڸ����� ��Ÿ��
    
    (��뿹)
    ��ǰ���̺��� 'P201' �з��� ���� ��ǰ���� �����ǸŰ��� �����Ͻÿ�
    ���� �ǸŰ� = �ǸŴܰ��� 73%�̰� ������(1�� �ڸ�)���� �ݿø��Ͽ� ������ ���
    
    SELECT PROD_NAME AS ��ǰ��,
           PROD_PRICE AS �ǸŰ�,
           PROD_SALE AS ���ΰ�,
           TRUNC(PROD_PRICE * 0.73, -2) AS �������ΰ�
      FROM PROD
     WHERE PROD_LGU = 'P201';
    
    (������ UPDATE)
    UPDATE PROD
       SET PROD_SALE = TRUNC(PROD_PRICE * 0.73, -2)
     WHERE PROD_LGU = 'P201';
       
    COMMIT;
    
    (��뿹)
    2020�� 6�� ��ǰ �� �Ǹűݾ� �հ踦 ���� �� �� �Ǹ� ��ǰ�� ���� �������� ��ȸ�Ͻÿ�
    Alias�� ��ǰ�ڵ�, �Ǹűݾ�, �������(%)
    
    1. 2020�� 6�� ��ü ���� �ݾ�
    SELECT SUM(A.CART_QTY * B.PROD_PRICE) AS CSUM
      FROM CART A, PROD B
     WHERE SUBSTR(A.CART_NO, 1, 6) = '202006'
       AND A.CART_PROD = B.PROD_ID;
       
    2. 2020�� 6�� �ǸŻ�ǰ �� ����ݾ�
    SELECT A.CART_PROD AS CID,
           SUM(A.CART_QTY * B.PROD_PRICE) AS BSUM
      FROM CART A, PROD B
     WHERE SUBSTR(A.CART_NO, 1, 6) = '202006'
       AND A.CART_PROD = B.PROD_ID
     GROUP BY A.CART_PROD;
     
    (���)
    SELECT TA.CID AS ��ǰ�ڵ�, 
           TA.BSUM AS �Ǹűݾ�, 
           TO_CHAR(ROUND((TA.BSUM / (SELECT SUM(A.CART_QTY * B.PROD_PRICE)
                                       FROM CART A, PROD B
                                      WHERE SUBSTR(A.CART_NO, 1, 6) = '202006'
                                        AND A.CART_PROD = B.PROD_ID)) * 100, 2), '999.99') || '%'
           AS "�������(%)"
      FROM (SELECT A.CART_PROD AS CID,
                   SUM(A.CART_QTY * B.PROD_PRICE) AS BSUM
              FROM CART A, PROD B
             WHERE SUBSTR(A.CART_NO, 1, 6) = '202006'
               AND A.CART_PROD = B.PROD_ID
             GROUP BY A.CART_PROD) TA