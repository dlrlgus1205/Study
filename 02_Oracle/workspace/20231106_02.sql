2023-11-06-02
DDL(Date Definition Language)
  - 데이터 정의어
  - create, alter, drop 등의 명령이 제공
  1. 테이블 생성, 수정, 삭제
    1) 테이블 생성
       -CREATE TABLE 명령 사용
      
      [사용형식]
      CREATE TABLE 테이블명(
      컬럼명 데이터타입[(크기)] [NOT NULL] [DEFAULT 값][,]
      [컬럼명 데이터타입[(크기)] [NOT NULL] [DEFAULT 값][,]]
                    :
      [컬럼명 데이터타입[(크기)] [NOT NULL] [DEFAULT 값][,]]
      [CONSTRAINT 기본키설정명 PRIMARY KEY(컬럼명, [컬럼명, ...])[,]
      [CONSTRAINT 외래키설정명 FOREIGN KEY (컬럼명)
      REFERENCES 테이블명(컬럼명)][,] -- REFERENCE로 하면 오류 반드시 REFERENCES로 사용
                    :
      [CONSTRAINT 외래키 설정명 FOREIGN KEY (컬럼명)
      REFERENCES 테이블명(컬럼명)][,]);
      . 'NOT NULL' : 자료 삽입(INSERT INTO 명령)시 생략할 수 없다
      . 'DEFAULT 값' : 자료 삽입(INSERT INTO 명령)시 사용자가 데이터를 정의하지 않았을 때 자동으로 입력되는 값
        (ex : DEFAULT 0, DEFAULT SYSDATE, ...)
      . '기본키설정명', '외래키설정명' : 설정되는 기본키와 외래키 설정에 부여되는 이름으로 해당 데이터베이스의 WORKSPACE에서 절대 중복 사용할 수 없다
      . '기본키설정명'은 보통 'PK_테이블명'
      . '외래키설정명'은 보통 'FK_테이블_부모테이블명'
      . '테이블명(컬럼명)' : 외래키 설정 시 참조되는 테이블(부모테이블) 이름과 그 테이블에서 사용하는 컬럼명 기술
      
      (사용예)
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