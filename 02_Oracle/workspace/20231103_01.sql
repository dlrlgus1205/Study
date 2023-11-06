2023-11-03-01
1. 오라클 데이터 타입

1] 문자열 타입
  . ' '로 묶인 자료 : 문자열
  . 고정길이(CHAR)
  . 가변길이(VARCHAR, VARCHAR2, NVARCHAR, LONG, CLOB)
  
  1) CHAR
    - 고정길이 문자열 자료 저장
    - 최대 2000 BYTE 저장 가능(한글은 한 글자가 3BYTE)
    - 기본키나 길이가 고정된 자료(우편번호, 주민번호 등) 저장에 주로 사용
    
    [사용형식]
    컬럼명 CHAR(크기 [BYTE|CHAR]);
      SELECT * FROM TEMP01;

    (사용예)
    CREATE TABLE TEMP01(
        COL1 CHAR(10),
        COL2 CHAR(10 BYTE),
        COL3 CHAR(10 CHAR));
        
    INSERT INTO TEMP01(COL1, COL2, COL3) 
                VALUES('SEOUL', 
                       '대전시', 
                       '대전시 중구 계룡로');
        
    SELECT * FROM TEMP01;
    
  2) VARCHAR, VARCHAR2, NVARCHAR
    - 오라클에서는 VARCHAR2 사용을 권고함
    - VARCHAR와 VARCHAR2는 사용 방법과 저장 형식이 동일함
    - NVARCHAR는 데이터를 국제표준코드(UTF-8, UTF-16)방식으로 저장
    - 최대 4000BYTE까지 저장
    - 가변길이 문자열 저장(문자열의 길이만큼 기억공간 확보)
    
    [사용형식]
    컬럼명 VARCHAR2(크기 [BYTE|CHAR]);
      . 크기 : 확보되는 기억공간의 크기(1 ~ 4000)
      . BYTE|CHAR : 생략되면 (default) BYTE로 간주
                    'CHAR'를 기술하면 '크기'는 글자수를 의미(한글인 경우 1333이하의 값)
                    
    (사용예)
    CREATE TABLE TEMP02(
        COL1 CHAR(100),
        COL2 VARCHAR2(4000),
        COL3 VARCHAR2(4000 BYTE),
        COL4 VARCHAR2(4000 CHAR));
        
    INSERT INTO TEMP02 VALUES('IL POSTINO', 
                              'BOYHOOD', 
                              'BOYHOOD', 
                              '대전시 중구 계룡로 846');
    
    SELECT * FROM TEMP02;
    
    SELECT LENGTHB(COL1), 
           LENGTHB(COL2),
           LENGTHB(COL3),
           LENGTHB(COL4),
           LENGTH(COL4)
           FROM TEMP02;
           
  3) LONG
    - 대용량 자료를 저장하기 위한 자료타입(2GB)
    - 오라클 초창기부터 제공
    - 기능 개선이 종료됨 => CLOB(Character Large OBject) 제공
    - 한 테이블에 하나의 LONG 타입만 허용
    
    [사용형식]
    컬럼명 LONG;
    
    (사용예)
    CREATE TABLE TEMP03(
        COL1 VARCHAR2(2000),
        COL2 LONG,
        COL3 VARCHAR2(3000));
        
      INSERT INTO TEMP03(COL1, COL2) VALUES('IL POSTINO', 'BOYHOOD');
      
      SELECT * FROM TEMP03;
      
  4) CLOB(Character Large OBject)
    - 가변길이 데이터 저장
    - 최대 4GB 저장 가능
    - 한 테이블에 복수개의 CLOB 컬럼 사용 가능(LONG 타입의 기능을 개선)
    - 일부 가능은 DBMS_LOB API(Application Programming Interface) 기능을 사용해야 함
    
    [사용형식]
    컬럼명 CLOB;
    
    (사용예)
    CREATE TABLE TEMP04(
        COL1 CLOB,
        COL2 CLOB,
        COL3 CLOB);
        
      INSERT INTO TEMP04(COL1, COL2) 
                  VALUES('무궁화 꽃이 피었습니다.', 
                         '대전시 중구 계룡로 846');
      
      SELECT * FROM TEMP04;
      
      SELECT --LENGTHB(COL1), 
             LENGTH(COL2)
             FROM TEMP04;
             
      SELECT DBMS_LOB.GETLENGTH(COL1) FROM TEMP04;
      
      SELECT SUBSTR(COL1, 3, 4) AS 컬럼1,
             DBMS_LOB.SUBSTR(COL1, 3, 4) AS 컬럼2
             FROM TEMP04;