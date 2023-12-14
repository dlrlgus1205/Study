2023-11-15-03

* ��ȯ�Լ�
    - TO_CHAR, TO_DATE, TO_NUMBER, CAST ������

1. CAST(expr AS type)
    'expr'�� 'type'���� ����� ����ȯ
    
    (��뿹)
    HR������ �μ� ���̺�(DEPARTMENTS)���� �μ��ڵ��� Ÿ���� �������� ���ڿ� Ÿ������ ��ȯ�Ͻÿ�
    
    SELECT DEPARTMENT_ID AS ���μ��ڵ�,
           CAST (DEPARTMENT_ID AS CHAR(8)) AS ��ȯ�μ��ڵ�,
           DEPARTMENT_NAME AS �μ���
      FROM HR.DEPARTMENTS;
    
    (��뿹)
    ��ٱ������̺��� 2020�� 7�� �Ǹ������� ��� ����Ͻÿ�
    Alias �� ��¥, ��ǰ�ڵ�, �Ǹż����̸� ���ڴ� ǥ�س�¥ ǥ���������� ���
    
    SELECT CAST(SUBSTR(CART_NO, 1 , 8) AS DATE) AS ��¥,
           CART_PROD AS ��ǰ�ڵ�,
           CART_QTY AS �Ǹż���
      FROM CART
     WHERE CART_NO LIKE '202007%';
     
2. TO_CHAR(����|����|��¥ ������ �ڷ� [, fmt])
    - ���ڿ� �ڷ�(CHAR, CLOB Ÿ��)�� ���ڿ� �ڷ�(VARCHAR2)�� ��ȯ
    - ��¥ �Ǵ� ���� �����͸� 'fmt' ������ ���ڿ��� ��ȯ
    - ���� ���� ����
    
(��¥�� ��ȯ Ÿ��)
-------------------------------------------------------------------------------------
���Ĺ��ڿ�           �ǹ�          ��뿹
-------------------------------------------------------------------------------------
BC, AD             ����         SELECT TO_CHAR(SYSDATE, 'BC') FROM DUAL;
                               SELECT TO_CHAR(SYSDATE, 'AD') FROM DUAL;
CC                 ����         SELECT TO_CHAR(SYSDATE, 'BC CC') || '����' FROM DUAL;
YYYY,YYY,YY,Y      �⵵         SELECT TO_CHAR(SYSDATE, 'YYYY'),
                                      TO_CHAR(SYSDATE, 'YYY'),
                                      TO_CHAR(SYSDATE, 'YY'),
                                      TO_CHAR(SYSDATE, 'Y')
                                 FROM DUAL;
MM                 ��(01~12��)  
MON, MONTH         ��           SELECT TO_CHAR(SYSDATE, 'YYYY-MM'),
                                       TO_CHAR(SYSDATE, 'YYYY-MON')
                                  FROM DUAL;
D                  ������ ��(1-7)
DD                 ������ ��(1-30(31, 28, 29))
DDD                ������ ��(1-365(366))
                                SELECT TO_CHAR(SYSDATE, 'YYYY-MM-D'),
                                       TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
                                       TO_CHAR(SYSDATE, 'YYYY-MM-DDD')
                                  FROM DUAL;
DY, DAY            ����ǥ��       SELECT TO_CHAR(SYSDATE, 'DY'),
                                       TO_CHAR(SYSDATE, 'DAY')
                                  FROM DUAL;
DL                 ���ڿ� ���� ǥ��
                                SELECT TO_CHAR(SYSDATE, 'DL')
                                  FROM DUAL;
WW                 �� �� ���� ǥ��
                                SELECT TO_CHAR(SYSDATE, 'WW'),
                                        TO_CHAR(SYSDATE, 'W')
                                  FROM DUAL;
AM, PM,           ����/����
A.M., P.M.          ǥ��         SELECT TO_CHAR(SYSDATE, 'AM'),
                                       TO_CHAR(SYSDATE, 'P.M.')
                                  FROM DUAL;
HH, HH12, HH24    �ð�           SELECT TO_CHAR(SYSDATE, 'HH'),
                                       TO_CHAR(SYSDATE, 'HH12'),
                                       TO_CHAR(SYSDATE, 'HH24')
                                  FROM DUAL;
MI                ��             SELECT TO_CHAR(SYSDATE, 'HH24:MI')
                                  FROM DUAL;
SS, SSSSS         ��             SELECT TO_CHAR(SYSDATE, 'HH24:MI:SS'),
                                        TO_CHAR(SYSDATE, 'HH24:MI:SSSSS')
                                  FROM DUAL;
-------------------------------------------------------------------------------------
(���ڿ� ��ȯ Ÿ��)
-------------------------------------------------------------------------------------
���Ĺ��ڿ�           �ǹ�          
-------------------------------------------------------------------------------------
9,                ���� ��ġ�� ���ڿ� ����. ���ڰ� ��ȿ�� 0�̸� ���� ���
0                 ���� ��ġ�� ���ڿ� ����. ���ڰ� ��ȿ�� 0�̸� 0 ���
-------------------------------------------------------------------------------------
(��뿹)
������ 2020�� 4�� 5���̰� ȸ����ȣ 'c001' ȸ���� ��ǰ�� �����Ϸ��Ѵ�. ��ٱ��� ��ȣ�� �����Ͻÿ�.

SELECT TO_CHAR(SYSDATE, 'YYYYMMDD') || 
       TRIM(TO_CHAR(TO_NUMBER(SUBSTR(MAX(CART_NO), 9)) + 1, '00000'))
  FROM CART
 WHERE SUBSTR(CART_NO, 1, 8) = TO_CHAR(SYSDATE, 'YYYYMMDD');
 
SELECT MAX(CART_NO) + 1
  FROM CART
 WHERE SUBSTR(CART_NO, 1, 8) = TO_CHAR(SYSDATE, 'YYYYMMDD');
-------------------------------------------------------------------------------------
. ,               '.' �Ҽ��� �ǹ� ',' 3�ڸ����� ����ϴ� �ڸ� ��

PR                ������ ��� '-' ��ȣ ��� '< >'�ȿ� ǥ��(�ַ� �繫��ǥ�� ���)
-------------------------------------------------------------------------------------
(��뿹)
SELECT TO_CHAR(-234567, '9,999,999'),
       TO_CHAR(-234567, '9,999,999PR'),
       TO_CHAR(234567, '9,999,999'),
       TO_CHAR(234567, '9,999,999PR')
  FROM DUAL;
-------------------------------------------------------------------------------------
$, L             ��ȭ��ȣ�� ������ ���� ���
-------------------------------------------------------------------------------------
(��뿹)
SELECT TO_CHAR(PROD_PRICE, 'L9,999,999'),
       TO_CHAR(PROD_PRICE, '$9,999,999')
  FROM PROD
 WHERE PROD_LGU = 'P101';
-------------------------------------------------------------------------------------
RN, rn           �θ��� ǥ��
-------------------------------------------------------------------------------------
SELECT TO_CHAR(14, 'RN'),
       TO_CHAR(14, 'rn')
  FROM DUAL;