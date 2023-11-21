2023-11-20-01

* �����Լ�
    - ����Ŭ���� ������ ��ȯ�� �� ����ϴ� �Լ��� RANK OVER, DENSE_RANK OVER, ROW_NUMBER OVER �Լ��� ������
    - RANK : �츮 ���� ����ϴ� ���� ����(���� ���̸� ���� ���� �ο�, ���� ����� �������� ��� ���� ����� ������ + ���� ���� ����)
      ex) 95, 90, 85, 85, 85, 70, 60
          1   2   3   3   3   6   7
    - DENSE_RANK : ���� ���̸� ���� ���� �ο��ϸ� ���� �ڷ�� ���� �ڷ��� ���� ������� ���ʴ�� 1�� ������ ���� �ο�
      ex) 95, 90, 85, 85, 85, 70, 60
          1   2   3   3   3   4   5
    - ROW_NUMBER : ���� ���� ������� ���ʴ�� 1�� �����Ǵ� ���� �ο�
      ex) 95, 90, 85, 85, 85, 70, 60
          1   2   3   4   5   6   7
    - �����Լ��� SELECT ���� ����
    
    [�������]
    RANK() OVER(ORDER BY �÷���1[, �÷���2, ...] [DESC]) [AS �÷���Ī]
    
    (��뿹)
    ȸ�����̺��� ȸ������ ���� ���ϸ����� ���� ȸ������� ������ �ο��Ͻÿ�
    Alias �� ȸ����ȣ, ȸ����, ���ϸ���, ����
    
    (RANK OVER)
    SELECT MEM_ID AS ȸ����ȣ,
           MEM_NAME AS ȸ����,
           MEM_MILEAGE AS ���ϸ���,
           RANK() OVER(ORDER BY MEM_MILEAGE DESC) AS ����
      FROM MEMBER;
      
    (DENSE_RANK OVER)
    SELECT MEM_ID AS ȸ����ȣ,
           MEM_NAME AS ȸ����,
           MEM_MILEAGE AS ���ϸ���,
           DENSE_RANK() OVER(ORDER BY MEM_MILEAGE DESC) AS ����
      FROM MEMBER;
      
    (ROW_NUMBER)
     SELECT MEM_ID AS ȸ����ȣ,
           MEM_NAME AS ȸ����,
           MEM_MILEAGE AS ���ϸ���,
           ROW_NUMBER() OVER(ORDER BY MEM_MILEAGE DESC) AS ����
      FROM MEMBER;
      
    ** ���� ���ϸ����� ������ ��� ���̰� ���� ȸ������ ���� �ο�
      
       SELECT MEM_ID AS ȸ����ȣ,
           MEM_NAME AS ȸ����,
           MEM_MILEAGE AS ���ϸ���, 
            EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM MEM_BIR) AS ����,
           RANK() OVER(ORDER BY MEM_MILEAGE DESC, 
           EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM MEM_BIR) ASC) AS ����
      FROM MEMBER;
      
    ** �׷캰 ����
    - RANK(), DENSE_RANK(), ROW_NUMBER() ��  ����Ͽ� �� �׷� ���� ������ �ο��� �� ����
      
    [�������]
    RANK() | DENSE_RANK | ROW_NUMBER() OVER
        (PARTITION BY �÷���1[, �÷���2, ...] ORDER BY �÷���1[, �÷���2, ...] [DESC]
    . 'PARTITION BY' �� ���� �׷��� ���� �ǰ� �� �׷쿡�� 'ORDER BY' �� ���� �����Ͱ� ���ĵ� �� ������ �ο���
    
    (��뿹)
    HR�������� �μ����� �޿��� ���� ������ �ο��Ͻÿ�
    �޿��� ���� ������� ���� �ο�
    Alias �� �����ȣ, �����, �μ���ȣ, �޿�, ����
    
    SELECT EMPLOYEE_ID AS �����ȣ,
           EMP_NAME AS �����,
           DEPARTMENT_ID AS �μ���ȣ, 
           SALARY AS �޿�, 
           RANK() OVER(PARTITION BY DEPARTMENT_ID
                       ORDER BY SALARY DESC) AS ����
      FROM HR.EMPLOYEES;