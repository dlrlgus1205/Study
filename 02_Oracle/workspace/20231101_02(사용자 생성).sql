--1. ����� ���� �� ���� �ο�
/*
    1) ����� ����
        CREATE USER ����ڸ� IDENTIFIED BY ��ȣ;
    2) ���� �ο�
        grant ���Ѹ�[, ���Ѹ�, ...] TO ����ڸ�;
            - ���Ѹ� : RESOURCE, CONNECT, DBA, ...
*/
    CREATE USER LGH96 IDENTIFIED BY java;
    GRANT RESOURCE, CONNECT, DBA TO LGH96;

2. ����� ���� ����
    -ALTER USER ��� ���
    
** HR ���� Ȱ��ȭ
    ALTER USER HR ACCOUNT UNLOCK;
    ALTER USER HR IDENTIFIED BY java;