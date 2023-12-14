2023-11-09-01

��Ÿ������
    - LIKE, BETWEEN, IN, ANY(SOME), ALL
    
    1) IN
        . �־��� �ټ��� �� �� ��� �ϳ��� ���� ��ġ�ϸ� ��ü ����� ���� �Ǵ� ������
        . �ݴ��� ��� NOT ������ ���
        
        [�������]
        expr IN(��1[, ��2, ...])
            - 'expr'�� ��� ����� '��1' ~ '��n' ���� �ϳ��� ��ġ�ϸ� TRUE ��ȯ
            - OR �����ڷ� �ٲپ� ����� �� �ִ�.
            - �ַ� �񿬼����� �ټ��� ���� �Ǻ��� �� ���
            
        (��뿹)
        HR ������ ������̺��� �μ���ȣ�� 30, 60, 80, 100�� ���� ����� �����ȣ, �����, �μ���ȣ, �޿��� ��ȸ�Ͻÿ�
        -- OR ������ ���
        SELECT EMPLOYEE_ID AS �����ȣ,
               EMP_NAME AS �����,
               DEPARTMENT_ID AS �μ���ȣ,
               SALARY AS �޿�
          FROM HR.EMPLOYEES
         WHERE DEPARTMENT_ID = 30
            OR DEPARTMENT_ID = 60
            OR DEPARTMENT_ID = 80
            OR DEPARTMENT_ID = 100
         ORDER BY 3;
         
         -- IN ������ ���
         SELECT EMPLOYEE_ID AS �����ȣ,
               EMP_NAME AS �����,
               DEPARTMENT_ID AS �μ���ȣ,
               SALARY AS �޿�
          FROM HR.EMPLOYEES
         WHERE DEPARTMENT_ID IN(30, 60, 80, 100)
         ORDER BY 3;
         
         -- ANY ������ ���
         SELECT EMPLOYEE_ID AS �����ȣ,
               EMP_NAME AS �����,
               DEPARTMENT_ID AS �μ���ȣ,
               SALARY AS �޿�
          FROM HR.EMPLOYEES
         WHERE DEPARTMENT_ID = ANY(30, 60, 80, 100)
         ORDER BY 3;
         
    2) ANY(SOME)
        . ANY�� SOME�� ���� ��� ����
        . �־��� �ټ��� �� �� ��� �ϳ��� ���� ���õ� ���� �������� ����� �����Ǹ� ��ü ����� ���� �Ǵ� ������
        . �ݴ��� ��� NOT ������ ���
        . OR �����ڷ� ��ȯ ����
        
        [�������]
        expr ���迬���� ANY(SOME) (��1[, ��2, ...])
        
        (��뿹)
        ȸ�����̺��� 1000, 1500, 2000 ���� ū ���ϸ����� �����ϴ� ȸ��� ��ȸ�Ͻÿ�
        Alias�� ȸ����ȣ, ȸ����, ��������, ���ϸ���
        
        SELECT MEM_ID AS ȸ����ȣ, 
               MEM_NAME AS ȸ����,
               SUBSTR(MEM_ADD1, 1, 2) AS ��������,
               MEM_MILEAGE AS ���ϸ���
          FROM MEMBER
         WHERE MEM_MILEAGE > ANY(1000, 1500, 2000)
         ORDER BY 4;
         
        ȸ�����̺��� �泲�� �����ϴ� ȸ������ ���ϸ������� ū ���ϸ����� �����ϴ� ȸ������ ��ȸ�Ͻÿ�
        Alias�� ȸ����ȣ, ȸ����, ��������, ���ϸ���
        --
        SELECT MEM_MILEAGE 
          FROM MEMBER
         WHERE SUBSTR(MEM_ADD1, 1, 2) = '�泲';
        --
        SELECT MEM_ID AS ȸ����ȣ, 
               MEM_NAME AS ȸ����,
               SUBSTR(MEM_ADD1, 1, 2) AS ��������,
               MEM_MILEAGE AS ���ϸ���
          FROM MEMBER
         WHERE MEM_MILEAGE > ANY(SELECT MEM_MILEAGE
                                   FROM MEMBER
                                  WHERE SUBSTR(MEM_ADD1, 1, 2) = '�泲')
         ORDER BY 4;  