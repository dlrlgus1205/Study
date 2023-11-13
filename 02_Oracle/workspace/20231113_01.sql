2023-11-13-01
    
    3)LPAD, RPAD
        - 특정 문자열로 채울 때 사용
        
        (1) LPAD(c1, n [, c2])
            . 지정된 길이 n에 문자열 c1을 오른쪽부터 채우고 남는 공간에 문장려 c2를 채움
            . c2가 생략되면 공백을 채움
            . 문자열을 숫자처럼 오른쪽 정렬을 수행할 수 있음
            . 수표보호문자
            
            [사용형식]
            SELECT LPAD('Oracle SQL', 15, '*') AS COL1,
                   LPAD('Oracle SQL', 15) AS COL4,
                   12345 AS COL2,
                   23 AS COL3
              FROM DUAL;
              
            (사용예)
            상품테이블에서 'P201'분류에 속한 상품들의 정보를 조회하시오 (단, 상품명은 오른쪽 정렬하시오)
            Alias 는 상품코드, 상품명, 분류코드, 매입단가
            
            SELECT PROD_ID AS 상품코드, 
                   LENGTH(PROD_NAME) AS 길이,
                   LENGTHB(PROD_NAME) AS 바이트수,
                   LPAD(PROD_NAME, 35, '*') AS 상품명, 
                   PROD_LGU AS 분류코드, 
                   PROD_COST AS 매입단가
              FROM PROD
             WHERE PROD_LGU = 'P201';
            
        (2) RPAD(c1, n [, c2])
            - 지정된 길이 n에 문자열 c1을 왼쪽부터 채우고 남는 오른쪽 공간에 문자열 c2를 채움
            - c2가 생략되면 공백을 채움
            
            (사용예)
            HR 계정의 사원테이블에서 사원정보를 출력하시오 (단, 급여는 3자리마다 ','를 넣고 왼쪽정렬을 하시오)
            Alias 는 사원번호, 사원명, 부서코드, 급여
            
            SELECT EMPLOYEE_ID AS 사원번호, 
                   EMP_NAME AS 사원명, 
                   DEPARTMENT_ID AS 부서코드, 
                   RPAD(TO_CHAR(SALARY, '999,999'), 10, '*') AS 급여
              FROM HR.EMPLOYEES;
              
    4)LTRIM, RTRIM
        - 특정 문자열을 삭제할 때 사용
        
        [사용형식]
        LTRIM(c1 [, c2]), RTRIM(c1 [, c2])
            . 주어진 문자열 c1의 왼쪽(오른쪽)부터 c2문자열과 일치하는 패턴을 찾아 일치하면 삭제함
            . c2가 생략되면 공백을 삭제함
        
        (사용예)
        SELECT LTRIM('ABCABCABC', 'AB') AS 컬럼1,
               LTRIM('ABCABCABC', 'ABC') AS 컬럼2,
               LTRIM('      ABCABCABC') AS 컬럼3,
               RTRIM('ABCABCABC', 'ABC') AS 컬럼11,
               RTRIM('ABCABCABC', 'C') AS 컬럼12,
               RTRIM('ABCABCABC     ') AS 컬럼13
          FROM DUAL;
          
    5)TRIM
        - 단어 양쪽에 존재하는 공백 제거
        - 단어 내부의 공백은 제거할 수 없음(REPLACE 함수를 사용해야 함)
        - 주로 고정길이 컬럼의 갑과 특정 문자열 비교에 사용됨
        
        [사용형식]
        TRIM(c1)
        
        (사용예)
        회원테이블의 회원이름, 속성을 고정길이 문자열로 변경하시오
        변경 후 이름이 '오철희' 회원의 이름, 주소, 직업 및 마일리지 정보를 조회하시오
        
        COMMIT;
        
        SELECT MEM_NAME AS 이름, 
               MEM_ADD1 || ' ' || MEM_ADD2 AS 주소, 
               MEM_JOB AS 직업,
               MEM_MILEAGE AS 마일리지
          FROM MEMBER
         WHERE MEM_NAME = '오철희';
        
    6)SUBSTR
        - 부분문자열 추출
        
        [사용형식]
        SUBSTR(c1, n1 [, len])
            . 주어진 문자열 c1에서 n1번째에서 시작하여 len 갯수만큼의 문자열을 추출하여 변환
            . len이 생략되면 n1번째에서 시작하여 나머지 모든 문자 반환
            . n1이 0 또는 1 이면 첫 글자 의미
            . n1이 음수면 오른쪽부터 처리함
            
        (사용예)
        SELECT SUBSTR('무궁화 꽃이 피었습니다.', 5, 4) AS COL1,
               SUBSTR('무궁화 꽃이 피었습니다.', 5) AS COL2,
               SUBSTR('무궁화 꽃이 피었습니다.', 5, 14) AS COL3,
               SUBSTR('무궁화 꽃이 피었습니다.', -5, 4) AS COL4
          FROM DUAL;
          
        (사용예)
        회원테이블에서 주민등록번호 컬럼들을 활용하여 회원들의 나이를 구하시오 (단, 모든 여성회원만 조회하시오)
        Alias 는 회원번호, 회원명, 주민등록번호, 나이
        
        SELECT MEM_ID AS 회원번호, 
               MEM_NAME AS 회원명, 
               MEM_REGNO1 || '-' || MEM_REGNO2 AS 주민등록번호, 
               CASE WHEN SUBSTR(MEM_REGNO2, 1, 1) IN('3','4') THEN
               EXTRACT(YEAR FROM SYSDATE) - (2000 + TO_NUMBER(SUBSTR(MEM_REGNO1, 1, 2)))
               ELSE EXTRACT(YEAR FROM SYSDATE) - (1900 + TO_NUMBER(SUBSTR(MEM_REGNO1, 1, 2))) END AS 나이
          FROM MEMBER
         WHERE SUBSTR(MEM_REGNO2, 1, 1) IN('2', '4');
         
숙제] HR 계정의 사원테이블에서 11월 급여를 계산하시오
급여 = 기본급(SALARY) + 근속 수당
지급액 = 급여 - 세금
근속수당 = 근속년수가 5 ~ 10 : 기본급의 15%
         근속년수가 11 ~ 15 : 기본급의 17%
         근속년수가 16 ~ 20 : 기본급의 22%
         그 이상 : 기본급의 30%
         단 근속년수가 5년 미만은 근속 수당은 없음
세금 = 급여액이 4000 ~ 5999 : 급여액의 5%
             6000 ~ 8000 : 급여액의 7%
             8001 ~ 12000 : 급여액의 12%
             그 이상 : 급여액의 20%
             단 급여액이 4000미만인 경우 세금이 면제됨
조회할 자료는 사원번호, 사원명, 입사일, 근속년수, 근속수당, 기본급, 급여액, 세금, 지급액

SELECT EMPLOYEE_ID AS 사원번호, 
       EMP_NAME AS 사원명, 
       HIRE_DATE AS 입사일, 
       EXTRACT(YEAR FROM SYSDATE) - SUBSTR(HIRE_DATE, 1, 4) AS 근속년수, 
       근속수당, 
       SALARY AS 기본급, 급여액, 세금, 지급액