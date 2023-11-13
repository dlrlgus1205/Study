2023-11-10-02

함수(FUNCTION)
    - 오라클 함수는 API에서 제공하는 함수와 사용자 정의 함수(USER DEFINED FUNCTION)로 구분
    - 함수의 대상 자료 타입에 따라 문자열, 숫자, 날짜, 변환, 집합(그룹), 윈도우 함수로 구분
    - 함수는 반환값이 존재함(반환 값이 없는 모듈은 프로시져(PROCEDURE)임)
    
    1. 문자열 함수
        1) '||'와 CONCAT
            - 문자열 결합 기능
            - 자바의 문자열 결합연산자 '+'와 같은 기능
            - '||'는 문자열 결합 연산자임
            
            (CONCAT 의 사용형식)
            CONCAT(c1, c2)
                . 문자열 'c1'과 'c2'를 결합한 새로운 문자열 반환
                
        (사용예)
        SELECT LENGTH(CONCAT ('DB 모델링과 ', '오라클 SQL'))
          FROM DUAL;
          
        (사용예)
        회원테이블에서 '충남'에 거주하는 회원의 회원명, 주민등록번호, 주소를 조회하시오
        (단, 주민등록번호는 XXXXXX-XXXXXXX형식으로, 주소는 기본주소와 상세주소 사이에 공백을 넣어 출력(CONCAT 함수 사용))
        Alias 는 회원명, 주민등록번호, 주소
        
        SELECT MEM_NAME AS 회원명, 
               CONCAT(CONCAT(MEM_REGNO1,'-'), MEM_REGNO2) AS 주민등록번호, 
               CONCAT(CONCAT(MEM_ADD1, ' '), MEM_ADD2) AS 주소
          FROM MEMBER
         WHERE MEM_ADD1 LIKE '충남%';
        
        2) LOWER, UPPER, INITCAP
            - 대문자(UPPER), 소문자(LOWER), 단어의 첫글자만 대문자로 변환(INITCAP)하는 함수
            
        (사용예)
        SELECT EMP_NAME AS 이름1,
               LOWER(EMP_NAME) AS "LOWER",
               UPPER(EMP_NAME) AS "UPPER",
               INITCAP(LOWER(EMP_NAME)) AS "INITCAP"
          FROM HR.EMPLOYEES
         WHERE DEPARTMENT_ID = 80;