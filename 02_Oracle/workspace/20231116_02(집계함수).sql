2023-11-16-02

* �����Լ�
    - �־��� �ڷḦ Ư�� �÷� ���� �������� �׷����� �и��Ͽ�(���� ���� ���� �ڷ��� �и�) �� �׷��� ������� �ϴ� �Լ�
    - SUM(�հ�), AVG(���), COUNT(�ڷ��� �� �Ǵ� ���� ��), MIN(�ּڰ�), MAX(�ִ�)
    - �����Լ��� �����Լ��� ������ �� ����.
    - SELECT ���� �����Լ��� ���Ǹ� ���̺��� �ϳ��� �׷��� �� => GROUP BY�� ���ʿ�
    - SELECT ���� �����Լ� �̿��� �÷��� ����Ǹ� �ش� �÷��� �������� �׷��� �����Ǹ� �ݵ�� GROUP BY���� ����ž� �ϸ� 
      GROUP BY������ �ش� �Ϲ� �÷����� ����ؾ� ��
    - �����Լ��� ���� �÷��� ���� �ο��� ��쿡�� HAVING������ ���� ó���� �ؾ� ��
      
    [�������]
    SELECT [�÷���, ]
              :
           SUM(�÷���) | AVG(�÷���) | COUNT(�÷��� | *) | MIN(�÷���) | MAX(�÷���)
              :
      FROM ���̺��
    [WHERE ����]
    [GROUP BY �÷���[, �÷���, ...]]
   [HAVING ����]
    [ORDER BY �÷��� | �÷��ε��� [[ASC] | DESC], ...];
    
    (��뿹)
    HR ������ ������̺��� ��� ��ü�� ��ձ޿�, �޿��հ�, �ο���, �ְ�޿���, �����޿����� ��ȸ�Ͻÿ�
    
    SELECT ROUND(AVG(SALARY)) AS ��ձ޿�,
           SUM(SALARY) AS �޿��հ�,
           COUNT(*) AS �ο���,
           MAX(SALARY) AS �ְ�޿���,
           MIN(SALARY) AS "���� �޿���"
      FROM HR.EMPLOYEES;
    
    (��뿹)
    ��ǰ���̺��� ��ü ��ǰ�� ��, ���� ū �ǸŴܰ�, ���� ���� �ǸŴܰ�, ��� �Ǹ� �ܰ��� ��ȸ�Ͻÿ�
    
    SELECT COUNT(*) AS "��ü ��ǰ�� ��",
           MAX(PROD_PRICE) AS "���� ū �ǸŴܰ�",
           MIN(PROD_PRICE) AS "���� ���� �ǸŴܰ�",
           ROUND(AVG(PROD_PRICE), -1) AS "��� �Ǹ� �ܰ�"
      FROM PROD;
      
(��ǰ �� ���)
    SELECT B.PROD_NAME AS ��ǰ��,
           B.PROD_PRICE AS �ǸŴܰ�
      FROM (SELECT MAX(PROD_PRICE) AS MP
              FROM PROD)A, PROD B
     WHERE A.MP = B.PROD_PRICE
UNION
     SELECT B.PROD_NAME AS ��ǰ��,
            B.PROD_PRICE AS �ǸŴܰ�
       FROM  (SELECT MIN(PROD_PRICE) AS MP
                FROM PROD)A, PROD B
      WHERE A.MP = B.PROD_PRICE;
    (��뿹)
    ȸ�����̺��� ȸ����, ��պ������ϸ����� ��ȸ�Ͻÿ�
    
    SELECT COUNT(*) AS ȸ����,
           TRUNC(AVG(MEM_MILEAGE)) AS ��պ������ϸ���
      FROM MEMBER;
    
    SELECT MEM_ID,
           MEM_NAME,
           MEM_MILEAGE
      FROM MEMBER
     WHERE MEM_MILEAGE > (SELECT TRUNC(AVG(MEM_MILEAGE)) AS ��պ������ϸ���
                            FROM MEMBER);
    
    (��뿹)
    ������̺��� �� �μ��� �ο���, ��ձ޿�, �޿��հ踦 ��ȸ�Ͻÿ�
    Alias �� �μ���ȣ, �ο���, ��ձ޿�, �޿��հ�
    
    SELECT DEPARTMENT_ID AS �μ���ȣ,
           COUNT(*) AS �ο���,
           ROUND(AVG(SALARY)) AS ��ձ޿�,
           SUM(SALARY) AS �޿��հ�
      FROM HR.EMPLOYEES
     GROUP BY DEPARTMENT_ID
     ORDER BY 1;
    
    (��뿹)
    ��ٱ������̺��� 2020�� ���� �Ǹż����հ踦 ���Ͻÿ�
    Alias �� ��, �Ǹż����հ�
    
    SELECT SUBSTR(CART_NO, 5, 2) || '��' AS ��,
           SUM(CART_QTY) AS �Ǹż����հ�
      FROM CART
     WHERE SUBSTR(CART_NO, 1, 4) = '2020'
     GROUP BY SUBSTR(CART_NO, 5, 2)
     ORDER BY 1;
    
    (��뿹)
    ��ٱ������̺��� 2020�� ��ǰ�� �Ǹż����հ踦 ���Ͻÿ�
    Alias �� ��ǰ�ڵ�, �Ǹż����հ�
    
    SELECT CART_PROD AS ��ǰ�ڵ�,
           SUM(CART_QTY) AS �Ǹż����հ�
      FROM CART
     WHERE SUBSTR(CART_NO, 1, 4) = '2020'
     GROUP BY CART_PROD
     ORDER BY 1;
    
    (��뿹)
    ��ٱ������̺��� 2020�� ȸ���� �Ǹż����հ踦 ���Ͻÿ�
    Alias �� ȸ����ȣ, �Ǹż����հ�
    
    SELECT CART_MEMBER AS ȸ����ȣ,
           SUM(CART_QTY) AS �Ǹż����հ�
      FROM CART
     WHERE SUBSTR(CART_NO, 1, 4) = '2020'
     GROUP BY CART_MEMBER
     ORDER BY 1;
    
    (��뿹)
    ȸ�����̺��� ����ȸ���� �ο����� ��ո��ϸ����� ��ȸ�Ͻÿ� (��, ���ж����� '����ȸ��', '����ȸ��'�� ���)
    Alias �� ����, �ο���, ��ո��ϸ���
    
    SELECT CASE WHEN SUBSTR(MEM_REGNO2, 1, 1) IN ('2', '4')
           THEN '����ȸ��'
           ELSE '����ȸ��' END AS ����,
           COUNT(*) AS �ο���,
           ROUND(AVG(MEM_MILEAGE)) AS ��ո��ϸ���
      FROM MEMBER
     GROUP BY CASE WHEN SUBSTR(MEM_REGNO2, 1, 1) IN ('2', '4')
              THEN '����ȸ��'
              ELSE '����ȸ��' END
     ORDER BY 1;
    
    (��뿹)
    ȸ�����̺��� ���ɴ뺰 ��ո��ϸ����� ��ȸ�Ͻÿ� (��, ��ո��ϸ����� ������ ����� ��)
    Alias �� ���ɴ�, ��ո��ϸ���
    
    SELECT TRUNC((SUBSTR(SYSDATE, 1, 4) - SUBSTR(MEM_BIR, 1, 4)) / 10) * 10 || '��' AS ���ɴ�,
           AVG(MEM_MILEAGE) AS ��ո��ϸ���
      FROM MEMBER
     GROUP BY TRUNC((SUBSTR(SYSDATE, 1, 4) - SUBSTR(MEM_BIR, 1, 4)) / 10) * 10
     ORDER BY 1;
     
     SELECT TRUNC(EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM MEM_BIR), -1)  AS ���ɴ�,
            AVG(MEM_MILEAGE) AS ��ո��ϸ���
       FROM MEMBER
      GROUP BY TRUNC(EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM MEM_BIR), -1)
      ORDER BY 1;
      
    (��뿹)
    �������̺��� 2020�� ��ݱ� ���� ��ǰ�� �������踦 ��ȸ�Ͻÿ�
    Alias �� ��, ��ǰ�ڵ�, ���Լ���, ���Աݾ�
    
    SELECT EXTRACT(MONTH FROM BUY_DATE) || '��' AS ��,
           BUY_PROD AS ��ǰ�ڵ�,
           SUM(BUY_QTY) AS ���Լ����հ�,
           SUM(BUY_QTY * BUY_COST) AS ���Աݾ��հ�
      FROM BUYPROD
     WHERE BUY_DATE BETWEEN TO_DATE('20200101') AND TO_DATE('20200630')
     GROUP BY EXTRACT(MONTH FROM BUY_DATE), BUY_PROD
     ORDER BY 1, 2;
     
    (��뿹)
    ��ٱ������̺��� 2020�� 7�� ȸ���� ���ż����հ踦 ���Ͻÿ�
    ���ż����հ谡 20�� �̻��� ȸ���� ��ȸ�Ͻÿ�
    
    SELECT CART_MEMBER AS ȸ��,
           SUM(CART_QTY) AS ���ż����հ�
      FROM CART
     WHERE SUBSTR(CART_NO, 1, 6) = '202007'
     GROUP BY CART_MEMBER
    HAVING SUM(CART_QTY) > 19
     ORDER BY 2 DESC;
     
    (��뿹)
    2020�� 5�� ȸ���� ���ż����հ踦 ���ϵ� ���� 3���� �ڷḸ ��ȸ�Ͻÿ�
    Alias �� ȸ����ȣ, ȸ����, ���ż����հ�
    
    SELECT B.MEM_ID AS ȸ����ȣ, 
           B.MEM_NAME AS ȸ����, 
           A.QAMT AS ���ż����հ�
      FROM (SELECT CART_MEMBER,
                   SUM(CART_QTY) AS QAMT
              FROM CART
             WHERE SUBSTR(CART_NO, 1, 6) = '202005'
             GROUP BY CART_MEMBER
             ORDER BY 2 DESC) A, MEMBER B
     WHERE A.CART_MEMBER = B.MEM_ID
       AND ROWNUM <= 3;