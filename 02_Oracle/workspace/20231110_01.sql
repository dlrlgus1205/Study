2023-11-10-01
    3) ALL 연산자
        . 주어진 복수 개의 자료 모두를 만족해야 결과가 참이 되는 연산자
        
        [사용형식]
        expr 관계연산자 ALL(값1[, 값2, ... 값n])
            . '관계연산자'에 '=' 연산자는 사용할 수 없음
        
        (사용예)
        HR 계정의  사원테이블에서 50번 부서에 속한 사원 중 가장 급여가 많은 사원보다 더 많은 급여를 받는 사원들을 조회하시오
        Alias 사원번호, 사원명, 부서번호, 급여
        
        (50번 부서에 속한 사원들의 급여)
        SELECT SALARY
          FROM HR.EMPLOYEES
         WHERE DEPARTMENT_ID = 50
         
        (결과)
        SELECT EMPLOYEE_ID AS 사원번호, 
               EMP_NAME AS 사원명, 
               DEPARTMENT_ID AS 부서번호, 
               SALARY AS 급여
          FROM HR.EMPLOYEES
         WHERE SALARY > ALL( SELECT SALARY
                               FROM HR.EMPLOYEES
                              WHERE DEPARTMENT_ID = 50)
         ORDER BY 4;
    
    4) LIKE 연산자
        . 문자열 비교 연산자
        . 형식지정 문자열(와일드카드 : '%', '_')을 사용하여 패턴 비교
        . '%' = 문자 시퀀스 '%'가 사용된 위치부터 나머지 모든 문자열과 대응
        ex) '대%' : '대'로 시작하는 모든 문자열과 대응
            '%대%' : 단어 중 '대'를 포함하는 모든 문자열과 대응
            '%대' : 대로 끝나는 모든 문자열과 대응
        . '_' = 문자 시퀀스가 '_'가 사용된 위치에서 한 문자와 대응
        ex) '대_' : 2글자이며, '대'로 시작하는 문자열과 대응
            '_대_'  3글자로 구성되며, 단어 중 '대'를 포함하는 문자열과 대응
            '_대' : '대'로 끝나는 2글자 문자열과 대응
        .날짜나 숫자자료에는 사용하지 말 것
        
        (사용예)
        상품테이블(PROD)에서 분류코드가 P100번대에 속한 상품들을 조회하시오 (분류코드 순으로 출력할 것)
        Alias는 상품 코드, 상품명, 분류코드, 매출가격
        
        SELECT PROD_ID AS "상품 코드", 
               PROD_NAME AS 상품명, 
               PROD_LGU AS 분류코드, 
               PROD_PRICE AS 매출가격
          FROM PROD
         WHERE PROD_LGU LIKE 'P1%'
        
        (사용예)
        회원테이블에서 대전에 거주하는 회원들을 조회하시오
        Alias는 회원번호, 회원명, 주소
        
        SELECT MEM_ID AS 회원번호,
               MEM_NAME AS 회원명,
               MEM_ADD1 || ' ' || MEM_ADD2 AS 주소
          FROM MEMBER
         WHERE MEM_ADD1 LIKE '대전%';
         
        (사용예)
        장바구니테이블(CART)에서 2020년 6월에 판매된 정보를 조회하시오
        Alias는 구매회원 번호, 구매일자, 제품코드, 구매 수량
        
        SELECT CART_MEMBER AS "구매회원 번호",
               TO_DATE(SUBSTR(CART_NO, 1, 8)) AS 구매일자,
               CART_PROD AS 제품코드,
               CART_QTY AS "구매 수량"
          FROM CART
         WHERE CART_NO LIKE '202006%';
        (사용예)
        매입테이블(BUYPROD)에서 2020년 2월 매입정보를 조회하시오
        Alias는 매입일, 매입상품 코드, 매입수량, 단가, 금액
        
        SELECT BUY_DATE AS 매입일, 
               BUY_PROD AS 매입상품코드, 
               BUY_QTY AS 매입수량, 
               BUY_COST AS 단가, 
               BUY_QTY * BUY_COST AS 금액
          FROM BUYPROD
         -- WHERE BUY_DATE BETWEEN '20200201' AND LAST_DAY('20200201');
         WHERE BUY_DATE >= '20200201' AND BUY_DATE <= LAST_DAY('20200201');
         
    5) BETWEEN 연산자
        . 범위를 지정할 때 사용
        . 모든 타입의 자료에 사용 가능
        . AND 연산자를 대신할 수 있음
        
        [사용형식]
        expr BETWEEN 값1 AND 값2;
            . '값1'과 '값2'는 같은 타입
            . '값1'에서 '값2'까지의 범위를 지정하여 비교
            . IN 연사자는 불연속 자료를 비교하고, AND와 BETWEEN연산자는 연속적 자료를 비교
        
        (사용예)
        상품테이블에서 'P100' ~ 'P200'번 대의 상품 중 판매가격이 50만원 이상인 상품만 조회하시오
        Alias 는 상품번호, 상품명, 분류코드, 판매가격
        
        -- AND 연산자 사용
        SELECT PROD_ID AS 상품번호, 
               PROD_NAME AS 상품명,
               PROD_LGU AS 분류코드,
               PROD_PRICE AS 판매가격
          FROM PROD
         WHERE PROD_LGU >= 'P100' AND PROD_LGU <= 'P299'
               AND PROD_PRICE > = 500000;
        -- BETWEEN 연산자 사용
        --  WHERE PROD_LGU BETWEEN 'P100' AND 'P299'
        --      AND PROD_PRICE > = 500000;         
        (사용예)
        회원테이블에서 보유 마일리지가 2000 ~ 3000인 회원들을 조회하시오
        Alias 는 회원번호, 회원명, 나이, 마일리지
        
        SELECT MEM_ID AS 회원번호, 
               MEM_NAME AS 회원명, 
               MEM_ AS 나이, 
               MEM_MILEAGE AS 마일리지
          FROM MEMBER    
         WHERE MEM_MILEAGE BETWEEN 2000 AND 3000;
        (사용예)
        HR 계정의 사원테이블에서 10 ~ 40번 부서에 속한 사원들을 조회하시오
        Alias 는 사원번호, 사원명, 입사일, 직무코드
        
        SELECT EMPLOYEE_ID AS 사원번호,
               EMP_NAME AS 사원명,
               HIRE_DATE AS 입사일,
               JOB_ID AS 직무코드
          FROM HR.EMPLOYEES
         WHERE  
        
        (사용예)
        매입테이블에서 2020년 1분기 자료 중 매입금액이 500만원 이상인 매입정보만 조회하시오
        Alias 는 매입월, 매입상품, 매입금액
        
        SELECT EXTRACT(MONTH FROM BUY_DATE) AS 매입월, 
               BUY_PROD AS 매입상품, 
               BUY_QTY * BUY_COST AS 매입금액
          FROM BUYPROD
         WHERE EXTRACT(MONTH FROM BUY_DATE) BETWEEN 1 AND 3
               AND BUY_QTY * BUY_COST >= 5000000
         ORDER BY 3 DESC;