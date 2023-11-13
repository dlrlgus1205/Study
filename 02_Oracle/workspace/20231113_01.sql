2023-11-13-01
    
    3)LPAD, RPAD
        - Ư�� ���ڿ��� ä�� �� ���
        
        (1) LPAD(c1, n [, c2])
            . ������ ���� n�� ���ڿ� c1�� �����ʺ��� ä��� ���� ������ ����� c2�� ä��
            . c2�� �����Ǹ� ������ ä��
            . ���ڿ��� ����ó�� ������ ������ ������ �� ����
            . ��ǥ��ȣ����
            
            [�������]
            SELECT LPAD('Oracle SQL', 15, '*') AS COL1,
                   LPAD('Oracle SQL', 15) AS COL4,
                   12345 AS COL2,
                   23 AS COL3
              FROM DUAL;
              
            (��뿹)
            ��ǰ���̺��� 'P201'�з��� ���� ��ǰ���� ������ ��ȸ�Ͻÿ� (��, ��ǰ���� ������ �����Ͻÿ�)
            Alias �� ��ǰ�ڵ�, ��ǰ��, �з��ڵ�, ���Դܰ�
            
            SELECT PROD_ID AS ��ǰ�ڵ�, 
                   LENGTH(PROD_NAME) AS ����,
                   LENGTHB(PROD_NAME) AS ����Ʈ��,
                   LPAD(PROD_NAME, 35, '*') AS ��ǰ��, 
                   PROD_LGU AS �з��ڵ�, 
                   PROD_COST AS ���Դܰ�
              FROM PROD
             WHERE PROD_LGU = 'P201';
            
        (2) RPAD(c1, n [, c2])
            - ������ ���� n�� ���ڿ� c1�� ���ʺ��� ä��� ���� ������ ������ ���ڿ� c2�� ä��
            - c2�� �����Ǹ� ������ ä��
            
            (��뿹)
            HR ������ ������̺��� ��������� ����Ͻÿ� (��, �޿��� 3�ڸ����� ','�� �ְ� ���������� �Ͻÿ�)
            Alias �� �����ȣ, �����, �μ��ڵ�, �޿�
            
            SELECT EMPLOYEE_ID AS �����ȣ, 
                   EMP_NAME AS �����, 
                   DEPARTMENT_ID AS �μ��ڵ�, 
                   RPAD(TO_CHAR(SALARY, '999,999'), 10, '*') AS �޿�
              FROM HR.EMPLOYEES;
              
    4)LTRIM, RTRIM
        - Ư�� ���ڿ��� ������ �� ���
        
        [�������]
        LTRIM(c1 [, c2]), RTRIM(c1 [, c2])
            . �־��� ���ڿ� c1�� ����(������)���� c2���ڿ��� ��ġ�ϴ� ������ ã�� ��ġ�ϸ� ������
            . c2�� �����Ǹ� ������ ������
        
        (��뿹)
        SELECT LTRIM('ABCABCABC', 'AB') AS �÷�1,
               LTRIM('ABCABCABC', 'ABC') AS �÷�2,
               LTRIM('      ABCABCABC') AS �÷�3,
               RTRIM('ABCABCABC', 'ABC') AS �÷�11,
               RTRIM('ABCABCABC', 'C') AS �÷�12,
               RTRIM('ABCABCABC     ') AS �÷�13
          FROM DUAL;
          
    5)TRIM
        - �ܾ� ���ʿ� �����ϴ� ���� ����
        - �ܾ� ������ ������ ������ �� ����(REPLACE �Լ��� ����ؾ� ��)
        - �ַ� �������� �÷��� ���� Ư�� ���ڿ� �񱳿� ����
        
        [�������]
        TRIM(c1)
        
        (��뿹)
        ȸ�����̺��� ȸ���̸�, �Ӽ��� �������� ���ڿ��� �����Ͻÿ�
        ���� �� �̸��� '��ö��' ȸ���� �̸�, �ּ�, ���� �� ���ϸ��� ������ ��ȸ�Ͻÿ�
        
        COMMIT;
        
        SELECT MEM_NAME AS �̸�, 
               MEM_ADD1 || ' ' || MEM_ADD2 AS �ּ�, 
               MEM_JOB AS ����,
               MEM_MILEAGE AS ���ϸ���
          FROM MEMBER
         WHERE MEM_NAME = '��ö��';
        
    6)SUBSTR
        - �κй��ڿ� ����
        
        [�������]
        SUBSTR(c1, n1 [, len])
            . �־��� ���ڿ� c1���� n1��°���� �����Ͽ� len ������ŭ�� ���ڿ��� �����Ͽ� ��ȯ
            . len�� �����Ǹ� n1��°���� �����Ͽ� ������ ��� ���� ��ȯ
            . n1�� 0 �Ǵ� 1 �̸� ù ���� �ǹ�
            . n1�� ������ �����ʺ��� ó����
            
        (��뿹)
        SELECT SUBSTR('����ȭ ���� �Ǿ����ϴ�.', 5, 4) AS COL1,
               SUBSTR('����ȭ ���� �Ǿ����ϴ�.', 5) AS COL2,
               SUBSTR('����ȭ ���� �Ǿ����ϴ�.', 5, 14) AS COL3,
               SUBSTR('����ȭ ���� �Ǿ����ϴ�.', -5, 4) AS COL4
          FROM DUAL;
          
        (��뿹)
        ȸ�����̺��� �ֹε�Ϲ�ȣ �÷����� Ȱ���Ͽ� ȸ������ ���̸� ���Ͻÿ� (��, ��� ����ȸ���� ��ȸ�Ͻÿ�)
        Alias �� ȸ����ȣ, ȸ����, �ֹε�Ϲ�ȣ, ����
        
        SELECT MEM_ID AS ȸ����ȣ, 
               MEM_NAME AS ȸ����, 
               MEM_REGNO1 || '-' || MEM_REGNO2 AS �ֹε�Ϲ�ȣ, 
               CASE WHEN SUBSTR(MEM_REGNO2, 1, 1) IN('3','4') THEN
               EXTRACT(YEAR FROM SYSDATE) - (2000 + TO_NUMBER(SUBSTR(MEM_REGNO1, 1, 2)))
               ELSE EXTRACT(YEAR FROM SYSDATE) - (1900 + TO_NUMBER(SUBSTR(MEM_REGNO1, 1, 2))) END AS ����
          FROM MEMBER
         WHERE SUBSTR(MEM_REGNO2, 1, 1) IN('2', '4');
         
����] HR ������ ������̺��� 11�� �޿��� ����Ͻÿ�
�޿� = �⺻��(SALARY) + �ټ� ����
���޾� = �޿� - ����
�ټӼ��� = �ټӳ���� 5 ~ 10 : �⺻���� 15%
         �ټӳ���� 11 ~ 15 : �⺻���� 17%
         �ټӳ���� 16 ~ 20 : �⺻���� 22%
         �� �̻� : �⺻���� 30%
         �� �ټӳ���� 5�� �̸��� �ټ� ������ ����
���� = �޿����� 4000 ~ 5999 : �޿����� 5%
             6000 ~ 8000 : �޿����� 7%
             8001 ~ 12000 : �޿����� 12%
             �� �̻� : �޿����� 20%
             �� �޿����� 4000�̸��� ��� ������ ������
��ȸ�� �ڷ�� �����ȣ, �����, �Ի���, �ټӳ��, �ټӼ���, �⺻��, �޿���, ����, ���޾�

SELECT EMPLOYEE_ID AS �����ȣ, 
       EMP_NAME AS �����, 
       HIRE_DATE AS �Ի���, 
       EXTRACT(YEAR FROM SYSDATE) - SUBSTR(HIRE_DATE, 1, 4) AS �ټӳ��, 
       �ټӼ���, 
       SALARY AS �⺻��, �޿���, ����, ���޾�