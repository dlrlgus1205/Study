2023-11-20-02

* ����Ŭ ǥ����
    - SELECT ���� ����ϸ� DECODE �� CASE WHEN ~ THEN �� ������
    - ���߾� PL-SQL �� IF ���̳� SWICH ~ CASE �� ������ ����
    - PL-SQL ������ �ϳ��� ��ɹ����� ������
    
    1. DECODE(�÷�, ����1, ���1[, ����2, ���2, ...])
        . �÷��� ���� '����1' �� ������ (IF(�÷� = ����1)) '���1' ��ȯ, �׷��� ������ �÷��� ����2�� �� (IF(�÷� = ����2)) '���2' ��ȯ,
          ��� ������ ��ġ���� ������ '���n' �� ��ȯ
          
        (��뿹)
        HR������ �μ����̺��� ��ġ�ڵ尡 1700�̸� '�þ�Ʋ' �� 1500�̸� '�������ý���' �� �� �ܸ� 'NONE' �� ���� ���� ����Ͻÿ�
        Alias �� �μ��ڵ�, �μ���, ��ġ�ڵ�, ����
        
        SELECT DEPARTMENT_ID AS �μ��ڵ�,
               DEPARTMENT_NAME AS �μ���,
               LOCATION_ID AS ��ġ�ڵ�,
               DECODE(LOCATION_ID, 1700, '�þ�Ʋ', 1500, '�������ý���', 'NONE') AS ����
          FROM HR.DEPARTMENTS;
          
    2. CASE WHEN ����1 THEN ���1
            [WHEN ����2 THEN ���2
                    :
            ELSE ���n] END
       �Ǵ�
       CASE �� WHEN ��1 THEN ���2
              [WHEN ��2 THEN ���2
                      :
              [ELSE ���n] END
               
       (��뿹)
       HR������ �μ����̺��� ��ġ�ڵ尡 1700�̸� '�þ�Ʋ' �� 1500�̸� '�������ý���' �� �� �ܸ� 'NONE' �� ���� ���� ����Ͻÿ�
        Alias �� �μ��ڵ�, �μ���, ��ġ�ڵ�, ����
        
        SELECT DEPARTMENT_ID AS �μ��ڵ�,
               DEPARTMENT_NAME AS �μ���,
               LOCATION_ID AS ��ġ�ڵ�,
               CASE LOCATION_ID WHEN 1700 THEN '�þ�Ʋ'
                                WHEN 1500 THEN '�������ý���'
                                ELSE 'NONE' END AS ����
          FROM HR.DEPARTMENTS;
          
        SELECT DEPARTMENT_ID AS �μ��ڵ�,
               DEPARTMENT_NAME AS �μ���,
               LOCATION_ID AS ��ġ�ڵ�,
               CASE  WHEN LOCATION_ID = 1700 THEN '�þ�Ʋ'
                     WHEN LOCATION_ID = 1500 THEN '�������ý���'
                     ELSE 'NONE' END AS ����
          FROM HR.DEPARTMENTS;  