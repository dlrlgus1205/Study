2023-11-07-03

DML(Data Manipulation Language)
    - 데이터 조작어
    - insert, update, delete 명령 포함
    
    1. insert 명령
        - 테이블에 신규 데이터 삽입
        - 기본키에 해당하는 값이 존재하지 않아야 함
        
        [사용형식]
        INSERT INTO 테이블명[(컬럼명[, 컬럼명, ...])] VALUES(값[, 값, ...]); -- 컬럼명이 생략되면 컬럼의 갯수와 컬럼명 순서에 맞춰서 정렬
            - INTO 절과 VALUES 절로 구성
            - INTO 절에서 '(컬럼명[, 컬럼명, ...])'이 생략되면 VALUES 절에 모든 컬럼에 저장될 자료가 기술 돼야 함 
            - INTO 절에 '(컬럼명[, 컬럼명, ...])'이 기술될 때 컬럼 제약 사항 중 NOT NULL 항목은 생략될 수 없음
            - INTO 절의 '(컬럼명[, 컬럼명, ...])'에 기술된 컬럼의 갯수와 순서는 VALUES 절의 '값'의 갯수와 순서가 일치해야 함
            
        (사용예)
        STUDENTS 테이블에 다음 자료를 입력하시오
        ----------------------------------------------------------------------------
        학번              이름          학과          학년           주소
        ----------------------------------------------------------------------------
        2023020210      홍길동         경영학과        1           대전시 중구 영민동 500
        2020020201      정몽주         경영학과        
        2021010217      이성계                       3           대전시 대덕구 법동
        2021010111      강감찬         컴퓨터공학과     1
        2019100305                    연극영화       4
        ----------------------------------------------------------------------------
        
        INSERT INTO STUDENTS VALUES(2023020210, '홍길동', '경영학과', 1, '대전시 중구 대흥동 500');
        
        SELECT * FROM STUDENTS;
        COMMIT;
        
        INSERT INTO STUDENTS(DEPT_NAME, SID, STU_NAME) VALUES('경영학과', 2020020201, '정몽주'); -- 컬럼명만 안바뀌면 순서는 상관 없음
        
        INSERT INTO STUDENTS VALUES(2021010217, '이성계', NULL, 3, '대전시 대덕구 법동');  -- NULL == '' = WHITE SPACE
        
        INSERT INTO STUDENTS(SID, STU_NAME, DEPT_NAME, GRADE, ADDRESS) VALUES(2021010111, '강감찬', '컴퓨터공학과', 1, NULL);
        
        INSERT INTO STUDENTS(SID, DEPT_NAME, GRADE) VALUES(2019100305, '연극영화', 4);
        
    2. UPDATE 명령
        - 테이블에 존재(기본키를 기준)하는 자료의 값을 변경
        
        [사용형식]
        UPDATE 테이블명 [별칭]
        SET 컬럼명 = 값[,]
            [컬럼명 = 값[,]
                :
            컬럼명 = 값]
        [WHERE 조건];
        . '테이블명 [별칭]' : 변경 대상이 되는 테이블명과 별칭
        . SET 절은 변경할 컬럼과 변경할 값을 기술(하나 이상인 경우 ','로 구분)
        . WHERE 절은 변경할 데이터를 제한할 때 사용(생략되면 모든 행이 변경)
        
        (사용예)
        학번 2019100305 학생의 이름을 '이성계'로 변경하시오
        UPDATE STUDENTS 
           SET STU_NAME = '이성계';
        
        SELECT * FROM STUDENTS;
        
        COMMIT;
        
        학번 2020020201이고 이름이 '정몽주'인 학생의 학년(4학년), 주소('서울시 성북구 장위동')으로 변경하시오
        
        UPDATE STUDENTS 
           SET GRADE = 4, ADDRESS = '서울시 성북구 장위동'
         WHERE SID = 2020020201;
        
        문제]
        . 강감찬 학생의 주소가 다음과 같이 변경됐다. 이를 데이터베이스에 반영하시오
            이름 : 강감찬
            주소 : 대전시 유성구 죽동 100
            
            UPDATE STUDENTS 
               SET ADDRESS = '대전시 유성구 죽동 100'
             WHERE STU_NAME = '강감찬';
            
        . 이성계 학생의 학과는 '건축공학과'이다. 이를 TABLE에 저장하시오
            
            UPDATE STUDENTS 
               SET DEPT_NAME = '건축공학과'
             WHERE STU_NAME = '이성계';
            
        . 학번이 2019100305인 학생은 이름이 '박지원'이고 주소가 '청주시 청원구 복대동 200'이다.
            
            UPDATE STUDENTS 
               SET STU_NAME = '박지원', 
                   ADDRESS = '청주시 청원구 복대동 200'
             WHERE SID = 2019100305;
            
            SELECT * FROM STUDENTS;
            
            COMMIT;
    3. DELETE 명령
        - 테이블에 저장된 데이터를 행 단위로 삭제
        - WHERE 절이 생략되면 모든 행이 삭제
        - ROLLBACK 대상
        
        [사용형식]
        DELETE FROM 테이블명
        [WHERE 조건];
        
        (사용예)
        매입테이블에서 매입일자가 '2020/01/16'인 자료를 삭제하시오
        SELECT * FROM BUYPROD WHERE BUY_DATE = '2020/01/16';
        
        DELETE FROM BUYPROD WHERE BUY_DATE = '2020/01/16';
        
        SELECT * FROM BUYPROD;
        
        COMMIT;