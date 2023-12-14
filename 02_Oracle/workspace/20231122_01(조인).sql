2023-11-22-01

    3. �ܺ� ����
        - ���������� �������� �ڷ�(�������� ����)�� �������� ���� �ڷḦ ������ ����� ��ȯ
        - �ͺ������� �ڷ��� ������ ���� ���� �������� �����ʿ� NULL ���� ���� ���� �����Ͽ� ���� ����� ��ȯ
        - ����� ����� �ý����� ȿ���� ���Ͻ�Ű�Ƿ� �����Ͽ� ���
        - �Ϲ� �ܺ����ο����� ���� ������ ����� �� �ܺ����� ������ '(+)'�� ������ �ڷḦ ������ ���̺��� �÷��� �ڿ� �߰�
        - ���� ���� ���������� ��� �ܺ������� �����ؾ� �ϴ� ��� �ش��ϴ� �������� ��ο� �ܺ����� �����ڸ� �߰��ؾ� ��
        - �� ���̺��� �� ���� �ܺ����ο� ���� �� ����
          ��, A, B, C ���̺��� �ܺ����� �Ǵ� ��� A���̺��� �������� B���̺��� Ȯ��� ���εʰ� ���ÿ� C���̺��� �������� B���̺��� Ȯ��� ���� �� �� ����
          ex) WHERE A = B(+)
                AND C = B(+) �� ������ ����
        - �Ϲ� �ܺ������� �������� �̿��� ������ �ο��Ǹ� ���������� ����� ��ȯ
          �ذ�å���� ���������� ����ϰų� ANSI�ܺ������� ����ؾ� ��
          
        [ANSI �ܺ����� �������]
        
        SELECT �÷����
                  :
          FROM ���̺��1 ��Ī1
          LEFT|RIGHT|FULL OUTER JOIN ���̺��2 ��Ī2 ON(�������� [AND �Ϲ�����])
                                            :
        [WHERE �Ϲ�����];
        
        'LEFT'  : FROM ���� '���̺��1' �� �ڷᰡ '���̺��2' �� �ڷẸ�� ���� ���
        'RIGHT' : FROM ���� '���̺��1' �� �ڷᰡ '���̺��2' �� �ڷẸ�� ���� ���
        'FULL'  : FROM ���� '���̺��1' �� �ڷ�� '���̺��2' �� �ڷᰡ ��� ������ ���
        
        (��뿹)
        ��� �з��� ��ǰ�� ���� ��� �ǸŰ��� ��ȸ�Ͻÿ�
        Alias �� �з��ڵ�, �з���, ��ǰ�� ��, ����ǸŰ�
        
        SELECT A.LPROD_GU AS �з��ڵ�,
               A.LPROD_NM AS �з���,
               COUNT(B.PROD_ID) AS "��ǰ�� ��",
               ROUND(AVG(B.PROD_PRICE)) AS ����ǸŰ�
          FROM LPROD A, PROD B
         WHERE A.LPROD_GU = B.PROD_LGU(+)
         GROUP BY A.LPROD_GU, A.LPROD_NM
         ORDER BY 1;
        
        (ANSI ����)
        SELECT A.LPROD_GU AS �з��ڵ�,
               A.LPROD_NM AS �з���,
               COUNT(B.PROD_ID) AS "��ǰ�� ��",
               ROUND(AVG(B.PROD_PRICE)) AS ����ǸŰ�
          FROM LPROD A
          LEFT OUTER JOIN PROD B ON(A.LPROD_GU = B.PROD_LGU)
         GROUP BY A.LPROD_GU, A.LPROD_NM
         ORDER BY 1;
         
        (��뿹)
        2020�� 6�� ��� ��ǰ�� �Ǹ����踦 ��ȸ�Ͻÿ�
        Alias �� ��ǰ�ڵ�, ��ǰ��, �Ǹż����հ�, �Ǹűݾ��հ�
        
        SELECT (SELECT COUNT(*) FROM PROD) AS "PROD�� ��ǰ��",
               (SELECT COUNT(DISTINCT CART_PROD) FROM CART WHERE CART_NO LIKE '202006%') AS "CART�� ��ǰ��"
          FROM DUAL;
        
        SELECT A.PROD_ID AS ��ǰ�ڵ�,
               A.PROD_NAME AS ��ǰ��,
               SUM(B.CART_QTY) AS �Ǹż����հ�,
               SUM(A.PROD_PRICE * B.CART_QTY) AS �Ǹűݾ��հ�
          FROM PROD A, CART B
         WHERE A.PROD_ID = B.CART_PROD(+)
           AND B.CART_NO LIKE '2020%'
         GROUP BY A.PROD_ID, A.PROD_NAME
         ORDER BY 1;
         
        (ANSI OUTER JOIN)
        SELECT A.PROD_ID AS ��ǰ�ڵ�,
               A.PROD_NAME AS ��ǰ��,
               SUM(B.CART_QTY) AS �Ǹż����հ�,
               SUM(A.PROD_PRICE * B.CART_QTY) AS �Ǹűݾ��հ�
          FROM CART B
         RIGHT OUTER JOIN PROD A ON(B.CART_PROD = A.PROD_ID AND B.CART_NO LIKE '202006%')
         GROUP BY A.PROD_ID, A.PROD_NAME
         ORDER BY 1;
         
        (SUBQUERY �ذ�)
        SELECT A.PROD_ID AS ��ǰ�ڵ�,
               A.PROD_NAME AS ��ǰ��,
               NVL(D.QCNT, 0) AS �Ǹż����հ�,
               TO_CHAR(NVL(D.SCNT, 0), '99,999,999') AS �Ǹűݾ��հ�
          FROM PROD A,
               -- (2020�� 6�� ��ǰ�� �Ǹż����հ�, �Ǹűݾ��հ�)
               (SELECT C.CART_PROD AS CID,
                       SUM(C.CART_QTY) AS QCNT,
                       SUM(C.CART_QTY * B.PROD_PRICE) AS SCNT
                  FROM PROD B, CART C
                 WHERE C.CART_PROD = B.PROD_ID
                   AND C.CART_NO LIKE '202006%'
                 GROUP BY C.CART_PROD) D
         WHERE A.PROD_ID = D.CID(+)
         ORDER BY 1;
         
        (��뿹)
        2020�� 6�� ��� ��ǰ�� ���Ը��������� ��ȸ�Ͻÿ�
        Alias �� ��ǰ��ȣ, ��ǰ��, ���Լ���, ���Աݾ�, �������, ����ݾ�
        
        SELECT C.PROD_ID AS ��ǰ��ȣ,
               C.PROD_NAME AS ��ǰ��,
               SUM(A.BUY_QTY) AS ���Լ���,
               SUM(A.BUY_QTY * C.PROD_COST) AS ���Աݾ�,
               SUM(B.CART_QTY) AS �������,
               SUM(B.CART_QTY * C.PROD_PRICE) AS ����ݾ�
          FROM BUYPROD A, CART B, PROD C
         WHERE A.BUY_PROD(+) = C.PROD_ID
           AND C.PROD_ID = B.CART_PROD(+)
           AND A.BUY_DATE BETWEEN TO_DATE('20200601') AND TO_DATE('20200630')
           AND B.CART_NO LIKE '202006%'
         GROUP BY C.PROD_ID, C.PROD_NAME
         ORDER BY 1;
         
        ANSI FORMAT
        SELECT C.PROD_ID AS ��ǰ��ȣ,
               C.PROD_NAME AS ��ǰ��,
               SUM(A.BUY_QTY) AS ���Լ���,
               SUM(A.BUY_QTY * C.PROD_COST) AS ���Աݾ�,
               SUM(B.CART_QTY) AS �������,
               SUM(B.CART_QTY * C.PROD_PRICE) AS ����ݾ�
          FROM BUYPROD A
         RIGHT OUTER JOIN PROD C ON (A.BUY_PROD = C. PROD_ID
               AND A.BUY_DATE BETWEEN TO_DATE('20200601') AND TO_DATE('20200630'))
          LEFT OUTER JOIN CART B ON(C.PROD_ID = B.CART_PROD
               AND B.CART_NO LIKE '202006%')
         GROUP BY C.PROD_ID, C.PROD_NAME
         ORDER BY 1;
         
        (��뿹)
        ������̺��� ��� �μ��� ������� ��ȸ�Ͻÿ�
        Alias �μ���ȣ, �μ���, �����
        
        SELECT B.DEPARTMENT_ID AS �μ���ȣ,
               B.DEPARTMENT_NAME AS �μ���,
               COUNT(A.EMPLOYEE_ID) AS �����
          FROM HR.EMPLOYEES A
          FULL OUTER JOIN HR.DEPARTMENTS B ON(A.DEPARTMENT_ID = B.DEPARTMENT_ID)
         GROUP BY B.DEPARTMENT_ID, B.DEPARTMENT_NAME
         ORDER BY 1;
         
        (��뿹)
        2020�� ��� ����ó�� ���Աݾ� �հ踦 ��ȸ�Ͻÿ�
        Alias �� �ŷ�ó�ڵ�, �ŷ�ó��, ���Աݾ��հ�
        
        SELECT A.BUYER_ID AS �ŷ�ó�ڵ�,
               A.BUYER_NAME AS �ŷ�ó��,
               SUM(C.BUY_QTY * B.PROD_COST) AS ���Աݾ��հ�
          FROM BUYER A, PROD B, BUYPROD C
         WHERE C.BUY_PROD(+) = B.PROD_ID
           AND B.PROD_BUYER(+) = A.BUYER_ID
           AND EXTRACT(YEAR FROM C.BUY_DATE) = 2020
         GROUP BY A.BUYER_ID, A.BUYER_NAME
         ORDER BY 1;