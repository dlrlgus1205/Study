2023-11-07-01

-- STUDENT TABLE ����
  CREATE TABLE STUDENTS(
    SID NUMBER(10), 
    STU_NAME VARCHAR2(30), 
    DEPT_NAME VARCHAR2(50), 
    GRADE NUMBER(1),
    ADDRESS VARCHAR2(200),
            
    CONSTRAINT PK_STUDENTS PRIMARY KEY(SID));

-- LECTURE_TIME TABLE
  CREATE TABLE LECTURE_TIMETABLE(
    LEC_TIME_TABLE_CODE NUMBER(2),
    START_TIME CHAR(4),
          
    CONSTRAINT PK_LECTURE_TIMETABLE PRIMARY KEY(LEC_TIME_TABLE_CODE));
    
-- SUBJECT TABLE
  CREATE TABLE SUBJECTS(
    SUB_CODE CHAR(4),
    SUB_NAME VARCHAR2(30),
    CREDIT NUMBER(1),
    PRO_ID CHAR(5), -- FK
          
    CONSTRAINT PK_SUBJECTS PRIMARY KEY(SUB_CODE),
    CONSTRAINT FK_PROFESSOR_SUBJECTS FOREIGN KEY(PRO_ID)
    REFERENCES PROFESSOR(PRO_ID));
    
-- TAKING_SUBJECT TABLE
  CREATE TABLE TAKING_SUBJECT(
    SUB_CODE CHAR(4), 
    SID NUMBER(10), 
    COURSE_CREDIT NUMBER(3), 
    
    CONSTRAINT PK_TAKING_SUBJECT PRIMARY KEY(SUB_CODE, SID), 
    CONSTRAINT FK_SUBJECT_TAKING_SUBJECT FOREIGN KEY(SUB_CODE)
    REFERENCES SUBJECTS(SUB_CODE), 
    CONSTRAINT FK_STUDENTS_TAKING_SUBJECT FOREIGN KEY(SID)
    REFERENCES STUDENTS(SID));

-- LECTURE_INFO TABLE ����
  CREATE TABLE LECTURE_INFO(
    SUB_CODE CHAR(4), 
    LEC_TIME_TABLE_CODE NUMBER(2), 
    LEC_ROOM_NUM VARCHAR(10),
    
    CONSTRAINT PK_LEC_INFO PRIMARY KEY(SUB_CODE, LEC_TIME_TABLE_CODE),
    CONSTRAINT FK_LEC_TBL_LEC_INFO FOREIGN KEY(LEC_TIME_TABLE_CODE)
    REFERENCES LECTURE_TIMETABLE(LEC_TIME_TABLE_CODE),
    CONSTRAINT FK_SUB_LEC_INFO FOREIGN KEY(SUB_CODE)
    REFERENCES SUBJECTS(SUB_CODE));