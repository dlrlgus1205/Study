2023-11-17-02

* NULL 처리 함수
    - 오라클의 모든 컬럼은 값을 배정 받지 못하면 데이터 타입에 상관 없이 NULL 값으로 초기화 됨(DEFAULT 옵션 사용은 예외)
    - 이 NULL 값을 갖는 컬럼이 연산에 사용되면 경과는 모두 NULL 이 돼 데이터의 왜곡이 발생될 위험성이 상존
    - NULL 자료 처리를 위해 NVL, NVL2, NULLIF 등의 함수가 제공됨
    ** - 컬럼의 값이 NULL 값인지를 판단하는 조건문에서도 '=' 연산자는 NULL 여부를 판단하지 못함
    
    1. IS NULL, IS NOT NULL
        - NULL 여부 판단을 위해 조건문에 사용되는 연산자
        
        (사용예)
        HR 계정의 사원테이블에서 영업실적코드가 NULL이 아닌 사원수를 조회하시오
        
        SELECT COUNT(*) AS 사원수
          FROM HR.EMPLOYEES
         WHERE COMMISSION_PCT IS NULL;
        
    2. NVL(expr, VAL1)
        - NULL 처리함수 중 가장 널리 사용되는 함수
        - 'expr'의 값이 NULL 이면 'VAL1' 값을 반환하고 NULL 이 아니면 'expr' 값을 반환
        - 'expr' 과 'VAL1' 은 같은 데이터 타입이어야 함
        
        (사용예)
        2020년 6월 모든 상품별 판매수량합계를 조회하시오
        Alias 는 상품번호, 상품명, 판매수량합계, 판매금액합계
        
        SELECT B.PROD_ID AS 상품번호,
               B.PROD_NAME AS 상품명,
               NVL(SUM(A.CART_QTY), 0) AS 판매수량합계,
               NVL(SUM(A.CART_QTY * B.PROD_PRICE), 0) AS 판매금액합계
          FROM CART A
         RIGHT OUTER JOIN PROD B ON(A.CART_PROD = PROD_ID AND
               A.CART_NO LIKE '202006%')
         GROUP BY B.PROD_ID, B.PROD_NAME
         ORDER BY 1;
        
        (사용예)
        HR 계정 사원테이블에서 영업실적에 따른 보너스를 계산하여 지급액을 조회하시오
        Alias 는 사원번호, 사원명, 기본급, 영업실적코드, 보너스, 지급액
        보너스 = 기본급 * 영업실적코드 * 0.6
        지급액 = 기본급 + 보너스
        영업실적코드가 NULL 이면 '영업실적 없음' 출력
        
        SELECT EMPLOYEE_ID AS 사원번호,
               EMP_NAME AS 사원명, 
               SALARY AS 기본급,
               DEPARTMENT_ID AS 부서코드, 
               NVL(TO_CHAR(COMMISSION_PCT, '990.99'), '영업실적 없음') AS 영업실적코드,
               NVL(ROUND(SALARY * COMMISSION_PCT * 0.6), 0) AS 보너스, 
               SALARY + NVL(ROUND(SALARY * COMMISSION_PCT * 0.6), 0) AS 지급액
          FROM HR.EMPLOYEES
         ORDER BY 부서코드;
         
    3. NVL2(expr, VAL1, VAL2)
        - 'expr' 이 NULL 이 아니면 VAL1 을 NULL 이면 VAL2 를 반환
        - VAL1 과 VAL2 는 반드시 같은 타입의 자료여야 함
        
        (사용예)
        상품테이블에서 상품의 색상정보(PROD_COLOR)가 NULL 이면 '색상정보 없음' NULL 이 아니면 해당 색상정보를 출력하시오 (단, NVL2 를 사용하시오)
        Alias 는 상품코드, 상품명, 색상
        
        SELECT PROD_LGU AS 상품코드, 
               PROD_NAME AS 상품명, 
               NVL2(PROD_COLOR, PROD_COLOR, '색상정보 없음') AS 색상
          FROM PROD;
          
        **상품테이블에서 분류번호 'P102' 에 속한 상품들의 판매가를 매입가로 변경하시오
        
        UPDATE PROD
           SET PROD_PRICE = PROD_COST
         WHERE PROD_LGU = 'P102';
         
         COMMIT;
         
    4. NULLIF(col1, col2)
        - 'col1' 과 'col2' 를 비교하여 같은 값이면 NULL 을 반환하고 다른 값이면 'col1'을 반환
        
        (사용예)
        상품테이블에서 매입가와 판매가가 같은 상품을 찾아 비고 란에 '단종예정상품' 이라는 문자열을 출력하고, 같지 않으면 판매가를 출력하시오
        Alias 는 상품번호, 상품명, 비고
        
        SELECT PROD_ID AS 상품번호,
               PROD_NAME AS 상품명, 
               NVL(TO_CHAR(NULLIF(PROD_PRICE, PROD_COST), '9,999,999'), '단종예정상품') AS "비고(판매가)"
          FROM PROD;