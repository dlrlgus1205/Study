2023-11-03-02
2] 숫자 자료
  - NUMBER(P,S) 형식으로 저장
  - 'P' : 정밀도(전체 공간의 크기)를 나타내며 1 ~ 38 사이의 정수
  - 'S' : 스케일(소숫점 이하의 자리수 표현) 값(-84 ~ 127, default는 0)
  
  [사용형식]
  컬럼명 NUMBER(P|*,[S]);
  
  (사용예)
  NUMBER - 크기를 시스템이 정의된 데이터의 크기에 알맞는 값으로 설정
  NUMBER(값) : '값'의 크기를 갖는 정수 자료 저장 가능
  NUMBER(값1, 값2) : '값1'  : 전체 자리수, '값2' : 소숫점 이하의 자리수
  
    데이터       데이터 타입      기억되는 값
  ----------------------------------------
  12345.6789    NUMBER        12345.6789
  12345.6789    NUMBER(4)     ERROR
  12345.6789    NUMBER(6)     12346
  12345.6789    NUMBER(7,2)   ERROR
  12345.6789    NUMBER(*,2)   12345.68
  12345.6789    NUMBER(8,2)   12345.68
  
  CREATE TABLE TEMP05(
    COL1 NUMBER,
    COL2 NUMBER(4),
    COL3 NUMBER(6),
    COL4 NUMBER(7,2),
    COL5 NUMBER(*,2),
    COL6 NUMBER(8,2));
  
  DELETE FROM TEMP05;
  
  ALTER TABLE TEMP05 MODIFY(COL4 NUMBER(7, 3));
  
  INSERT INTO TEMP05 VALUES(12345.6789, 
                            1234.6789, 
                            12345.6789, 
                            1234.6789, 
                            12345.6789, 
                            12345.6789);
  
  SELECT * FROM TEMP05;
  
  * '값1' < '값2'
    . '값2'는 저장될 소숫점 이하의 유효 자리수
    . '값2' - '값1'의 결과는 소숫점 이하에 나올 '0'의 숫자
    . '값1' : 소숫점 이하의 0이 아닌 유효숫자 갯수
    
    데이터       데이터 타입      기억되는 값
  ----------------------------------------
  124.5678     NUMBER(3,5)   ERROR
  0.04567      NUMBER(3,4)   0.0457
  0.004567     NUMBER(2,4)   0.0046
  
  CREATE TABLE TEMP06(
    COL1 NUMBER(3,4),
    COL2 NUMBER(2,4));
    
  INSERT INTO TEMP06 VALUES(0.04567, 0.004567);
  
  SELECT * FROM TEMP06;
  
  INSERT INTO TEMP06 VALUES(0.04567, 0.0004567);