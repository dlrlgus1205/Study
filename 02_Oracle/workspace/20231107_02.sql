2023-11-07-02

* ALTER ��
  - ���̺��� �̸� ����, �÷� �߰�, ����, ����
  - ��������� �߰�, ������ ���
  
  1) ���̺� �̸� ����
    ALTER TABLE �������̺�� RENAME TO �������̺��
    
    (��� ��)
    LECTURE_TIMETABLE ���̺��� LEC_TIMETBL�� �����Ͻÿ�
    ALTER TABLE LECTURE_TIMETABLE RENAME TO LEC_TIMETBL;

  2) �÷� �߰�
    - ADD ����� ���
    ALTER TABLE ���̺�� ADD(�÷��� ������Ÿ��[(ũ��)] [NOT NULL] [default ��]);
    
    (��뿹)
    STUDENTS ���̺��� ��ȭ��ȣ �÷�(TEL_NUM VARCHAR2(20))�� �߰��Ͻÿ�
    ALTER TABLE STUDENTS ADD(TEL_NUM VARCHAR2(20));
    
    COMMIT;
    
  3) �÷� ����
    - �÷� �̸� ������ ����
    - �÷��� ������ Ÿ���̳� ũ�� ���� ����
    - MODIFY ����� ���
    ALTER TABLE ���̺�� MODIFY(�÷��� ������Ÿ��[(ũ��)] [NOT NULL] [default ��]);
    
    (��뿹)
    STUDENTS ���̺��� TEL_NUM �÷��� �ڷ� Ÿ���� NUMBER(15)�� �����Ͻÿ�
    ALTER TABLE STUDENTS MODIFY(TEL_NUM NUMBER(15));
    
  4) �÷� ����
    - DROP COLUMN ����� ���
    ALTER TALBE ���̺�� DROP COLUMN �÷���;
    
    (��뿹)
    STUDENTS ���̺��� TEL_NUM �÷��� �����Ͻÿ�
    ALTER TABLE STUDENTS DROP COLUMN TEL_NUM;
    
    COMMIT;
    
  5) �÷��� ����
    ALTER TABLE ���̺�� RENAME COLUMN �����÷��� TO �����÷���;
    
    (��뿹)
    LEC_TIMETBL ���̺��� LEC_TIME_TABLE_CODE �÷����� LEC_TIME���� �����Ͻÿ�
    ALTER TABLE LEC_TIMETBL RENAME COLUMN LEC_TIME_TABLE_CODE TO LEC_TIME;
    
    ALTER TABLE LECTURE_INFO RENAME COLUMN LEC_TIME_TABLE_CODE TO LEC_TIME;
    
    COMMIT;

  6) ���� ���� �߰�
    - ADD �� DROP CONSTRAINT ����� ���
    - �߰�
      ALTER TABLE ���̺�� ADD CONSTRAINT(�����̸� ��������);
    - ����
      ALTER TABLE ���̺�� DROP CONSTRAINT�����̸�;
    - Ȱ��ȭ �� ��Ȱ��ȭ : ENABLE �� DISABLE ����� ���
      ALTER TABLE ���̺�� ENABLE | DISABLE ��������;
      
    (��뿹)
    STUDENTS ���̺��� �⺻Ű ������ �����Ͻÿ�
    ALTER TABLE STUDENTS DROP CONSTRAINT PK_STUDENTS; (���� ����)
    -- TAKING_SUBJECT�� �ܷ�Ű ���������� ���� �����ž� ��
        ALTER TABLE TAKING_SUBJECT DROP CONSTRAINT FK_STUDENTS_TAKING_SUBJECT;
        ALTER TABLE STUDENTS DROP CONSTRAINT PK_STUDENTS;
        
DROP TABLE PROFESSOR;
DROP TABLE STUDENTS;

    (��뿹)
    TAKING_SUBJECT ���̺� STUDENTS ���̺��� �⺻Ű�� �ܷ�Ű�� �����Ͻÿ�
    �ܷ�Ű �������� 'FK_STU_TAKE_SUB'�̴�
    ALTER TABLE TAKING_SUBJECT ADD CONSTRAINT FK_STU_TAKE_SUB FOREIGN KEY(SID) REFERENCES STUDENTS(SID);
    
* ���̺� ����
  DROP TABLE ���̺��;
  
  (��뿹)
  TEMP01 ~ TEMP11������ ���̺��� �����Ͻÿ�
  DROP TABLE TEMP01;
  DROP TABLE TEMP02;
  DROP TABLE TEMP03;
  DROP TABLE TEMP04;
  DROP TABLE TEMP05;
  DROP TABLE TEMP06;
  DROP TABLE TEMP07;
  DROP TABLE TEMP08;
  DROP TABLE TEMP09;
  DROP TABLE TEMP10;
  DROP TABLE TEMP11;
  
  COMMIT;