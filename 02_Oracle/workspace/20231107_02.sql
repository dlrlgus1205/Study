2023-11-07-02

* ALTER 문
  - 테이블의 이름 변경, 컬럼 추가, 변경, 삭제
  - 제약사항의 추가, 삭제에 사용
  
  1) 테이블 이름 변경
    ALTER TABLE 원본테이블명 RENAME TO 변경테이블명
    
    (사용 예)
    LECTURE_TIMETABLE 테이블을 LEC_TIMETBL로 변경하시오
    ALTER TABLE LECTURE_TIMETABLE RENAME TO LEC_TIMETBL;

  2) 컬럼 추가
    - ADD 예약어 사용
    ALTER TABLE 테이블명 ADD(컬럼명 데이터타입[(크기)] [NOT NULL] [default 값]);
    
    (사용예)
    STUDENTS 테이블의 전화번호 컬럼(TEL_NUM VARCHAR2(20))을 추가하시오
    ALTER TABLE STUDENTS ADD(TEL_NUM VARCHAR2(20));
    
    COMMIT;
    
  3) 컬럼 수정
    - 컬럼 이름 수정은 제외
    - 컬럼의 데이터 타입이나 크기 등을 수정
    - MODIFY 예약어 사용
    ALTER TABLE 테이블명 MODIFY(컬럼명 데이터타입[(크기)] [NOT NULL] [default 값]);
    
    (사용예)
    STUDENTS 테이블의 TEL_NUM 컬럼의 자료 타입을 NUMBER(15)로 변경하시오
    ALTER TABLE STUDENTS MODIFY(TEL_NUM NUMBER(15));
    
  4) 컬럼 삭제
    - DROP COLUMN 예약어 사용
    ALTER TALBE 테이블명 DROP COLUMN 컬럼명;
    
    (사용예)
    STUDENTS 테이블의 TEL_NUM 컬럼을 삭제하시오
    ALTER TABLE STUDENTS DROP COLUMN TEL_NUM;
    
    COMMIT;
    
  5) 컬럼명 변경
    ALTER TABLE 테이블명 RENAME COLUMN 원본컬럼명 TO 변경컬럼명;
    
    (사용예)
    LEC_TIMETBL 테이블의 LEC_TIME_TABLE_CODE 컬럼명을 LEC_TIME으로 변경하시오
    ALTER TABLE LEC_TIMETBL RENAME COLUMN LEC_TIME_TABLE_CODE TO LEC_TIME;
    
    ALTER TABLE LECTURE_INFO RENAME COLUMN LEC_TIME_TABLE_CODE TO LEC_TIME;
    
    COMMIT;

  6) 제약 조건 추가
    - ADD 및 DROP CONSTRAINT 예약어 사용
    - 추가
      ALTER TABLE 테이블명 ADD CONSTRAINT(제약이름 제약조건);
    - 삭제
      ALTER TABLE 테이블명 DROP CONSTRAINT제약이름;
    - 활성화 및 비활성화 : ENABLE 및 DISABLE 예약어 사용
      ALTER TABLE 테이블명 ENABLE | DISABLE 제약조건;
      
    (사용예)
    STUDENTS 테이블의 기본키 설정을 삭제하시오
    ALTER TABLE STUDENTS DROP CONSTRAINT PK_STUDENTS; (삭제 거절)
    -- TAKING_SUBJECT의 외래키 제약조건이 먼저 삭제돼야 함
        ALTER TABLE TAKING_SUBJECT DROP CONSTRAINT FK_STUDENTS_TAKING_SUBJECT;
        ALTER TABLE STUDENTS DROP CONSTRAINT PK_STUDENTS;
        
DROP TABLE PROFESSOR;
DROP TABLE STUDENTS;

    (사용예)
    TAKING_SUBJECT 테이블에 STUDENTS 테이블의 기본키를 외래키로 설정하시오
    외래키 설정명은 'FK_STU_TAKE_SUB'이다
    ALTER TABLE TAKING_SUBJECT ADD CONSTRAINT FK_STU_TAKE_SUB FOREIGN KEY(SID) REFERENCES STUDENTS(SID);
    
* 테이블 삭제
  DROP TABLE 테이블명;
  
  (사용예)
  TEMP01 ~ TEMP11까지의 테이블을 삭제하시오
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