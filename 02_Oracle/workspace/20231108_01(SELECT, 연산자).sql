2023-11-08-01

데이터 검색 명령(SELECT 문)
    - 데이터 검색 명령
    
    [사용형식]
    SELECT * | [DISTINCT] 컬럼명 [AS 별칭][,]
            컬럼명 [AS 별칭][,]
                :
            컬럼명 [AS 별칭]
      FROM 테이블명 [별칭][, 테이블명 [별칭], ...]
    
    [WHERE 조건]
    [GROUP BY 컬럼명|컬럼인덱스[, 컬럼명|컬럼인덱스, ...]]
    
    [HAVING 조건]
    [ORDER BY 컬럼명|컬럼인덱스[DESC|[ASC]]
              [, 컬럼명|컬럼인덱스[DESC|[ASC], ...]];
              
    SELECT SALARY AS "본봉",
           SALARY + (SALARY * COMMISSION_PCT) AS "지급액(보너스 포함)",
           (SALARY + (SALARY * COMMISSION_PCT)) * 0.1 AS 세금,
           SALARY + (SALARY * COMMISSION_PCT - ((SALARY + (SALARY * COMMISSION_PCT)) * 0.1)) 실수령액
      FROM HR.EMPLOYEES;
      
      1) 연산자
          - 산술연산자(+, -, *, )
          - 비교(관계)연산자(>, <, >=, <=, !=(<>), =)
          - 논리연산자(NOT, AND, OR)
          - 기타연산자(LIKE, BETWEEN, IN, ANY(SOME), ALL)
          - 조건식 구성에 주로 사용
          
          (1) 산술연산자
              - +, -, *, / 기능 제공
              
              (사용예)
              HR 계정의 사원테이블(EMPLOYEES)에서 보너스와 지급액을 계산하시오
              단, 보너스는 급여(SALARY) * 영업실적코드(COMMISSION_PCT)의 50% 지급액 = 급여 + 보너스다
              Alias는 사원번호(EMPLOYEE_ID), 사원명(EMP_NAME), 급여(SALARY), 보너스, 지급액이며 소숫점 이하는 반올림한다
              
              SELECT EMPLOYEE_ID AS 사원번호,
                     EMP_NAME AS 사원명,
                     SALARY AS 급여,
                     ROUND(SALARY * COMMISSION_PCT * 0.5) AS 보너스,
                     SALARY + ROUND(SALARY * COMMISSION_PCT *0.5) AS 지급액
                FROM HR.EMPLOYEES
              ORDER BY 5 DESC; -- = ORDER BY SALARY + ROUND(SALARY * COMMISSION_PCT *0.5) DESC;
              
              (사용예)
              장바구니 테이블에서 2020년 4월 일자별 판매금액을 조회하세요
              Alias는 날짜, 판매수량합계, 판매금액합계
              
              SELECT TO_DATE(SUBSTR(A.CART_NO, 1, 8)) AS 날짜, 
                     SUM(A.CART_QTY) AS 판매수량합계, 
                     SUM(A.CART_QTY * B.PROD_PRICE) AS 판매금액합계
                FROM CART A, PROD B
               WHERE A.CART_PROD = B.PROD_ID
                 AND A.CART_NO LIKE '202004%'
               GROUP BY TO_DATE(SUBSTR(A.CART_NO, 1, 8))
               ORDER BY 1;
               
               예제)
               회원테이블에서 회원들의 거주지의 종류를 출력하시오
               
                SELECT DISTINCT(SUBSTR(MEM_ADD1, 1, 2)) AS 거주지
                  FROM MEMBER;
                  
          (2) 관계연산자
              - 주로 조건식을 구성할 때 사용
              - 조건식은 WHERE 절에 사용됨
              
              (사용예)
              회원테이블에서 마일리지가 2000 이상인 회원의 회원번호, 회원명, 주소, 마일리지를 출력하시오 (단, 마일리지가 많은 회원부터 출력)
              
              SELECT MEM_ID AS 회원번호,
                     MEM_NAME AS 회원명,
                     MEM_ADD1 || ' ' || MEM_ADD2 AS 주소,
                     MEM_MILEAGE AS 마일리지
                FROM MEMBER 
               WHERE MEM_MILEAGE >= 2000
               ORDER BY MEM_MILEAGE DESC;
                     
              
              (사용예)
              회원테이블에서 마일리지가 2000 이상이고 여성인 회원의 회원번호, 회원명, 주민등록번호, 주소, 마일리지를 출력하시오
              
              SELECT MEM_ID AS 회원번호,
                     MEM_NAME AS 회원명,
                     MEM_REGNO1 || '-' || MEM_REGNO2 AS 주민등록번호,
                     MEM_ADD1 || ' ' || MEM_ADD2 AS 주소,
                     MEM_MILEAGE AS 마일리지
                FROM MEMBER 
               WHERE MEM_MILEAGE >= 2000
                 AND (SUBSTR(MEM_REGNO2, 1 , 1) = '2' OR (SUBSTR(MEM_REGNO2, 1 , 1)) = '4');
              
              (사용예)
              상품테이블에서 매출가격이 20만원대 상품 정보를 조회하시오
              Alias는 상품번호, 상품명, 매입단가, 매출단가, 판매수익
              
              (사용예)
              회원테이블에서 20대 회원을 조회하시오
              Alias는 회원번호, 회원명, 주민번호, 나이, 구분 (단, 구분란에는 성별을 기입)
              
              SELECT MEM_ID AS 회원번호,
                     MEM_NAME AS 회원명,
                     MEM_REGNO1 || '-' || MEM_REGNO2 AS 주민번호,
                     EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM MEM_BIR) AS 나이,
                     CASE WHEN SUBSTR(MEM_REGNO2, 1, 1) = '2' OR
                               SUBSTR(MEM_REGNO2, 1, 1) = '4' THEN
                               '여성회원'
                          ELSE '남성회원' END AS 구분    
                FROM MEMBER
               WHERE TRUNC((EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM MEM_BIR)) / 10) = 2;
            -- WHERE EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM MEM_BIR) >= 20
              -- AND EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM MEM_BIR) <= 29