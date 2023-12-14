2023-11-06-02
DDL(Date Definition Language)
  - ������ ���Ǿ�
  - create, alter, drop ���� ����� ����
  1. ���̺� ����, ����, ����
    1) ���̺� ����
       -CREATE TABLE ��� ���
      
      [�������]
      CREATE TABLE ���̺��(
      �÷��� ������Ÿ��[(ũ��)] [NOT NULL] [DEFAULT ��][,]
      [�÷��� ������Ÿ��[(ũ��)] [NOT NULL] [DEFAULT ��][,]]
                    :
      [�÷��� ������Ÿ��[(ũ��)] [NOT NULL] [DEFAULT ��][,]]
      [CONSTRAINT �⺻Ű������ PRIMARY KEY(�÷���, [�÷���, ...])[,]
      [CONSTRAINT �ܷ�Ű������ FOREIGN KEY (�÷���)
      REFERENCES ���̺��(�÷���)][,] -- REFERENCE�� �ϸ� ���� �ݵ�� REFERENCES�� ���
                    :
      [CONSTRAINT �ܷ�Ű ������ FOREIGN KEY (�÷���)
      REFERENCES ���̺��(�÷���)][,]);
      . 'NOT NULL' : �ڷ� ����(INSERT INTO ���)�� ������ �� ����
      . 'DEFAULT ��' : �ڷ� ����(INSERT INTO ���)�� ����ڰ� �����͸� �������� �ʾ��� �� �ڵ����� �ԷµǴ� ��
        (ex : DEFAULT 0, DEFAULT SYSDATE, ...)
      . '�⺻Ű������', '�ܷ�Ű������' : �����Ǵ� �⺻Ű�� �ܷ�Ű ������ �ο��Ǵ� �̸����� �ش� �����ͺ��̽��� WORKSPACE���� ���� �ߺ� ����� �� ����
      . '�⺻Ű������'�� ���� 'PK_���̺��'
      . '�ܷ�Ű������'�� ���� 'FK_���̺�_�θ����̺��'
      . '���̺��(�÷���)' : �ܷ�Ű ���� �� �����Ǵ� ���̺�(�θ����̺�) �̸��� �� ���̺��� ����ϴ� �÷��� ���
      
      (��뿹)
      CREATE TABLE PROFESSOR(
          PRO_ID CHAR(5), 
          PRO_NAME VARCHAR2(30),
          PRO_ROOM_NUM VARCHAR2(10),
          PRO_TEL_NUM VARCHAR2(20),
          
          CONSTRAINT PK_PROFESSOR PRIMARY KEY(PRO_ID));
          
      CREATE TABLE STUDENTS(
          SID NUMBER(10), 
          STU_NAME VARCHAR2(30), 
          DEPT_NAME VARCHAR2(50), 
          GRADE NUMBER(1),
          ADDRESS VARCHAR2(200),
            
          CONSTRAINT PK_STUDENTS PRIMARY KEY(SID));
      
      CREATE TABLE LECTURE_TIMETABLE(
          LEC_TIME_TABLE_CODE NUMBER(2),
          START_TIME CHAR(4),
          
          CONSTRAINT PK_LECTURE_TIMETABLE PRIMARY KEY(LEC_TIME_TABLE_CODE));
      
      CREATE TABLE SUBJECTS(
          SUB_CODE CHAR(4),
          SUB_NAME VARCHAR2(30),
          CREDIT NUMBER(1),
          PRO_ID CHAR(5),
          
          CONSTRAINT PK_SUBJECTS PRIMARY KEY(SUB_CODE),
          CONSTRAINT FK_SUBJECTS FOREIGN KEY(PRO_ID)
          REFERENCES PROFESSOR(PRO_ID));