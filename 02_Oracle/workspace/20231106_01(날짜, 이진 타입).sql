2023-11-06
3] 날짜 데이터 타입
  - DATE(기본타입), TIMESTAMP 제공
  
  1) DATE 타입
    - 기본 날짜형
    - 년, 월, 일, 시, 분, 초 정보 저장
    - 덧셈과 뺄셈의 대상이 됨
    
    [사용형식]
    컬럼명 DATE; -- 크기 지정 안함 자동으로 정해짐
    
    (사용예)
    CREATE TABLE TEMP07(
        COL1 DATE,
        COL2 DATE,
        COL3 DATE);
        
    ** SYSDATE : 시스템의 날짜 정보를 반환하는 날짜 함수
    INSERT INTO TEMP07 VALUES(SYSDATE, SYSDATE - 7, SYSDATE + 7);
    INSERT INTO TEMP07 VALUES(TO_DATE('20231101'), 
                              TO_DATE('20231101132517','YYYYMMDDHH24MISS'),
                              '2023-11-05');
    SELECT * FROM TEMP07;
    
    SELECT TO_CHAR(COL1,'YYYY-MM-DD HH24:MI:SS') AS "COL1", 
           TO_CHAR(COL2,'YYYY-MM-DD HH24:MI:SS') AS "COL2", 
           TO_CHAR(COL3,'YYYY-MM-DD HH24:MI:SS') AS "COL3"
    FROM TEMP07;
    
  2) TIMESTAMP 타입
    - 시간대(TIME ZONE : 대륙명/도시명)정보와 10억분의 1초 단위의 정교한 시각정보 저장
    - TIMESTAMP : 시간대 정보 없이 초 이하 9자리까지 표현
    - TIMESTAMP WITH LOCAL TIME ZONE : 현재 서버가 위치한 지역에 따라 자동으로 날짜 정보가 변환됨(시간대 정보 없음, TIMESTAMP와 같은 결과)
    - TIMESTAMP WITH TIME ZONE : 시간대 정보 표현
    
    (사용예)
    CREATE TABLE TEMP08(
        COL1 DATE,
        COL2 TIMESTAMP,
        COL3 TIMESTAMP WITH LOCAL TIME ZONE,
        COL4 TIMESTAMP WITH TIME ZONE);
        
    INSERT INTO TEMP08(COL1, COL2, COL3, COL4)
           VALUES(SYSDATE, SYSTIMESTAMP, SYSTIMESTAMP, SYSTIMESTAMP);
           
    SELECT * FROM TEMP08;

4] 이진 데이터 타입
  - RAW, LONG RAW, BLOB, BFILE
  - 자료 삽입이나 검색의 결과 해당 자료를 해석하거나 변환하여 출력하지 않음
  
  1) RAW
    . 최대 2000BYTE까지의 2진 정보 저장
    . 인덱스 처리 가능
    . 16진수와 2진수 형태로 저장
  
    [사용형식]
    컬럼명 RAW(크기);
  
    (사용예)
      CREATE TABLE TEMP09(
          COL1 RAW(2000));
    
      INSERT INTO TEMP09 VALUES('1100001111110001');
      INSERT INTO TEMP09 VALUES('C3F1');
    
      SELECT * FROM TEMP09;
    
  2) BFILE
    . 4GB까지 2진 자료 저장
    . 원본자료를 데이터베이스 밖에 저장하고 데이터베이스에는 경로와 파일명만 저장
    . 원본 데이터가 자주 변경되는 경우 효율적인 자료 타입
    
    [사용형식]
    컬럼명 BFILE; -- 한 테이블에 여러 컬럼 사용 가능
    
    (사용예)
    1. 자료 및 테이블 준비
    
    CREATE TABLE TEMP10(
        COL1 BFILE);
        
    2. 디렉토리 객체 생성
    
    CREATE DIRECTORY 디렉토리명 AS 경로명;
    
    CREATE DIRECTORY TEST_DIR AS 'D:\1.Oracle\util';
    
    3. 데이터 삽입
    INSERT INTO TEMP10 VALUES(BFILENAME('TEST_DIR', 'Cat03.jpg'));
    
    SELECT * FROM TEMP10;
    
  3) BLOB(Binary Large OBject)
    . 4GB까지의 이진 자료 저장
    . 원본 데이터를 데이터베이스 내부에 저장
    . 처리 속도는 빠름 변경이 많은 자료의 저장에는 부적절
    
    [사용형식]
    컬럼명 BLOB;
    
    (사용예)
    1. 테이블 생성
    
    CREATE TABLE TEMP11(
        COL1 BLOB);
        
    2. 디렉토리 객체 생성
      - 위에 생성한 TEST_DIR 사용
      
    3. 자료 삽입 => 익명 블록이나 프로시져로 구현
    
    DECLARE
      L_DIR VARCHAR2(20) := 'TEST_DIR';
      L_FILE VARCHAR2(30) := 'Cat03.jpg';
      L_BFILE BFILE;
      L_BLOB BLOB;
    BEGIN
        INSERT INTO TEMP11(COL1) VALUES(EMPTY_BLOB())
            RETURN COL1 INTO L_BLOB;
        
        L_BFILE := BFILENAME(L_DIR, L_FILE);
        DBMS_LOB.FILEOPEN(L_BFILE, DBMS_LOB.FILE_READONLY);
        DBMS_LOB.LOADFROMFILE(L_BLOB, L_BFILE, DBMS_LOB.GETLENGTH(L_BFILE));
        DBMS_LOB.FILECLOSE(L_BFILE);
    END;
    
    COMMIT;
    
    SELECT * FROM TEMP11;