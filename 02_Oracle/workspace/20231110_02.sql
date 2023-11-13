2023-11-10-02

�Լ�(FUNCTION)
    - ����Ŭ �Լ��� API���� �����ϴ� �Լ��� ����� ���� �Լ�(USER DEFINED FUNCTION)�� ����
    - �Լ��� ��� �ڷ� Ÿ�Կ� ���� ���ڿ�, ����, ��¥, ��ȯ, ����(�׷�), ������ �Լ��� ����
    - �Լ��� ��ȯ���� ������(��ȯ ���� ���� ����� ���ν���(PROCEDURE)��)
    
    1. ���ڿ� �Լ�
        1) '||'�� CONCAT
            - ���ڿ� ���� ���
            - �ڹ��� ���ڿ� ���տ����� '+'�� ���� ���
            - '||'�� ���ڿ� ���� ��������
            
            (CONCAT �� �������)
            CONCAT(c1, c2)
                . ���ڿ� 'c1'�� 'c2'�� ������ ���ο� ���ڿ� ��ȯ
                
        (��뿹)
        SELECT LENGTH(CONCAT ('DB �𵨸��� ', '����Ŭ SQL'))
          FROM DUAL;
          
        (��뿹)
        ȸ�����̺��� '�泲'�� �����ϴ� ȸ���� ȸ����, �ֹε�Ϲ�ȣ, �ּҸ� ��ȸ�Ͻÿ�
        (��, �ֹε�Ϲ�ȣ�� XXXXXX-XXXXXXX��������, �ּҴ� �⺻�ּҿ� ���ּ� ���̿� ������ �־� ���(CONCAT �Լ� ���))
        Alias �� ȸ����, �ֹε�Ϲ�ȣ, �ּ�
        
        SELECT MEM_NAME AS ȸ����, 
               CONCAT(CONCAT(MEM_REGNO1,'-'), MEM_REGNO2) AS �ֹε�Ϲ�ȣ, 
               CONCAT(CONCAT(MEM_ADD1, ' '), MEM_ADD2) AS �ּ�
          FROM MEMBER
         WHERE MEM_ADD1 LIKE '�泲%';
        
        2) LOWER, UPPER, INITCAP
            - �빮��(UPPER), �ҹ���(LOWER), �ܾ��� ù���ڸ� �빮�ڷ� ��ȯ(INITCAP)�ϴ� �Լ�
            
        (��뿹)
        SELECT EMP_NAME AS �̸�1,
               LOWER(EMP_NAME) AS "LOWER",
               UPPER(EMP_NAME) AS "UPPER",
               INITCAP(LOWER(EMP_NAME)) AS "INITCAP"
          FROM HR.EMPLOYEES
         WHERE DEPARTMENT_ID = 80;