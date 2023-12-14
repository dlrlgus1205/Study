2023-11-21-02

*����(JOIN)
    - ������ �����ͺ��̽��� �ٽ� ����
    - ���̺� ���̿� �����ϴ� ����(Relationship)�� �̿��Ͽ� �ټ� ���̺� �л�� ������ ��ȸ�ϴ� ���
    - ������ ����
        . �Ϲ����� vs ANSI����
        . �������� VS �񵿵�����
        . ��������(Inner Join) VS �ܺ�����(Outer Join)
        . Self Join, Cross Join, Cartesian Product ��
        
    [�Ϲ����� �������]
    
    1) ���� ����
    SELECT [���̺�Ī|���̺��].�÷���,
                    :
      FROM ���̺��1 [��Ī1], ���̺��2 [��Ī2], [, ... ���̺��n [��Īn]]
     WHERE ��Ī1.�÷��� ������ ��Ī2.�÷��� -- ��������
      [AND �Ϲ�����]
      
    2) �ܺ� ����
    SELECT [���̺�Ī|���̺��].�÷���,
                    :
      FROM ���̺��1 [��Ī1], ���̺��2 [��Ī2], [, ... ���̺��n [��Īn]]
     WHERE ��Ī1.�÷���[(+)] ������ ��Ī2.�÷���[(+)] --�ܺ���������
      
    [ANSI���� �������]
    
    3) ���� ����
    SELECT [���̺�Ī|���̺��].�÷���,
                    :
      FROM ���̺��1 [��Ī1]
     INNER JOIN ���̺��2 [��Ī2] ON(��������)[AND �Ϲ�����]
                    :
    [INNER JOIN ���̺��n [��Īn] ON(��������)[AND �Ϲ�����]]
    [WHERE �Ϲ�����]
      
    4) �ܺ� ����
    SELECT [���̺�Ī|���̺��].�÷���,
                    :
      FROM ���̺��1 [��Ī1]
      LEFT|RIGHT|FULL OUTER JOIN ���̺��2 [��Ī2] ON(��������)[AND �Ϲ�����]
                                :
      LEFT|RIGHT|FULL OUTER JOIN ... ���̺��n [��Īn] ON(��������)[AND �Ϲ�����]]
    [WHERE �Ϲ�����]
    
    1. Cartesian Product(Cross Join)
        - ���������� ���ų� ���������� �߸� ����� ��� �߻�
        - ����� ���ο� ������ ���̺��� ��� ���� ���� ��� ��� ���ο� ������ ���̺��� ��� ���� ���� ���� ���� ��(VIEW)�� ��ȯ
        - Ư���� ������ �ƴϸ� ����� �����ؾ� ��
        
        [CROSS JOIN �������]
        SELECT �÷�����
          FROM ���̺��1
         CROSS JOIN ���̺��2 [ON(��������)]
                    :
                    
        
        [��뿹]
        
        SELECT COUNT(*) "��ǰ ���� ��"
          FROM PROD;
          
        SELECT COUNT(*) "��ٱ��� ���� ��"
          FROM CART;
          
        SELECT COUNT(*) "�������̺� ���� ��"
          FROM BUYPROD;
          
        SELECT COUNT(*)
          FROM PROD, CART, BUYPROD;
        
        [ANSI CROSS JOIN]
        
        SELECT COUNT(*)
          FROM PROD
         CROSS JOIN CART
         CROSS JOIN BUYPROD;