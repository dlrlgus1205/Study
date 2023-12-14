2023-11-17-01

* CUBE ��  ROLLUP �Լ�
    - �����Լ��� ����ϸ� �׷캰 �հ踦 ���� �� ������ ���߱׷��� ��� �� �׷캰 �߰� ����� ������ ����
    - �پ��� �������� ���� �׷��� �����ϰ� �� �׷캰 �߰� ���踦 ��ȯ�� �� �ִ� �Լ�
    - ���������� �м� � �ַ� ���
    
    1. ROLLUP(�÷���1[, �÷���2, ... , �÷���n])
        . �ݵ�� GROUP BY ������ ����ؾ� ��
        . ROLLUP �� ���� '�÷���1' ���� '�÷���1 + �÷���2', ... '�÷���1 + �÷��� 2 + ... �÷���n' (�̸� �����̶� ��)�� ���� ������ ���踦 ��ȯ
        . ���� �÷��� ������ n���� �� ��ȯ�Ǵ� ������ ������ n + 1����
         
    (��뿹)
    2020�� ��ٱ������̺��� ����, ȸ����, ��ǰ��, �Ǹż����հ踦 ��ȸ�Ͻÿ�
    
    (GROUP BY ���� ���)
    SELECT SUBSTR(CART_NO, 5, 2) AS ��,
           CART_MEMBER AS ȸ��,
           CART_PROD AS ��ǰ,
           SUM(CART_QTY) AS �Ǹż����հ�
      FROM CART
     WHERE CART_NO LIKE '2020%'
     GROUP BY SUBSTR(CART_NO, 5, 2), CART_MEMBER, CART_PROD
     ORDER BY 1, 2, 3;
     
     (ROLLUP �� ���)
     SELECT SUBSTR(CART_NO, 5, 2) AS ��,
           CART_MEMBER AS ȸ��,
           CART_PROD AS ��ǰ,
           SUM(CART_QTY) AS �Ǹż����հ�
      FROM CART
     WHERE CART_NO LIKE '2020%'
     GROUP BY ROLLUP(SUBSTR(CART_NO, 5, 2), CART_MEMBER, CART_PROD)
     ORDER BY 1, 2, 3;
     
    SELECT SUM(CART_QTY)
      FROM CART
     WHERE CART_NO LIKE '2020%';
     
     2. CUBE(�÷���1[, �÷���2, ... �÷���n])
        . �ݵ�� GROUP BY ������ ����ؾ� ��
        . CUBE �� ���� �÷���� ������ �� �ִ� ��� ������ �������� ���踦 ��ȯ
        . ���� �÷��� ������ n���� �� ��ȯ�Ǵ� ������ ������ 2�� n�°��̴�.
        
     (��뿹)
     2020�� ��ٱ������̺��� ����, ȸ����, ��ǰ��, �Ǹż����հ踦 ��ȸ�Ͻÿ�   
        
     (CUBE �� ���)   
     SELECT SUBSTR(CART_NO, 5, 2) AS ��,
            CART_MEMBER AS ȸ��,
            CART_PROD AS ��ǰ,
            SUM(CART_QTY) AS �Ǹż����հ�
       FROM CART
      WHERE CART_NO LIKE '2020%'
      GROUP BY CUBE(SUBSTR(CART_NO, 5, 2), CART_MEMBER, CART_PROD)
      ORDER BY 1, 2, 3;
     
     3. �κ� ROLLUP(CUBE)
        - ROLLUP(CUBE) ��/�Ŀ� �÷��� ����� ���
        - ROLLUP(CUBE) �� �ۿ� ����� �÷��� �ܼ��� GROUP BY ������ �����
        
     (�κ� ROLLUP �� ���)   
     SELECT SUBSTR(CART_NO, 5, 2) AS ��,
            CART_MEMBER AS ȸ��,
            CART_PROD AS ��ǰ,
            SUM(CART_QTY) AS �Ǹż����հ�
       FROM CART
      WHERE CART_NO LIKE '2020%'
      GROUP BY SUBSTR(CART_NO, 5, 2), ROLLUP(CART_MEMBER, CART_PROD)
      ORDER BY 1, 2, 3;