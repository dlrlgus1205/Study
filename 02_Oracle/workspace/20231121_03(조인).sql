2023-11-21-03

    2. 내부조인
    
    [일반조인]
    
    SELECT [테이블명|테이블별칭].컬럼명 [AS 별칭,]
                        :
      FROM 테이블명[별칭], 테이블명[별칭][, ...]
     WHERE 일반조건
       AND 조인조건
    
    . 고유한 컬럼명인 경우 테이블 별칭을 사용하지 않아도 됨
    . 조인조건은 사용된 테이블의 수가 n개일 때 적어도 n - 1개 이상이어야 함
    . 일반조건과 조인조건의 기술 순서는 상관없고 두 조건은 AND로 연결
    
    (사용예)
    HR계정에서 급여가 15000이상인 사원을 조회하시오
    Alias 는 사원번호, 사원명, 부서코드, 부서명, 급여
    부서코드 순으로 정렬하시오
    
    SELECT A.EMPLOYEE_ID AS 사원번호,
           A.EMP_NAME AS 사원명,
           -- HR.EMPLOYEES.DEPARTMENT_ID AS 부서코드,
           A.DEPARTMENT_ID AS 부서코드,
           B.DEPARTMENT_NAME AS 부서명,
           A.SALARY AS 급여
      FROM HR.EMPLOYEES A, HR.DEPARTMENTS B
     WHERE A.DEPARTMENT_ID = B.DEPARTMENT_ID
       AND A.SALARY >= 15000;
       
    (ANSI 사용)
     SELECT A.EMPLOYEE_ID AS 사원번호,
           A.EMP_NAME AS 사원명,
           A.DEPARTMENT_ID AS 부서코드,
           B.DEPARTMENT_NAME AS 부서명,
           A.SALARY AS 급여
      FROM HR.EMPLOYEES A
     INNER JOIN HR.DEPARTMENTS B ON(A.DEPARTMENT_ID = B.DEPARTMENT_ID)
     WHERE A.SALARY >= 15000;
       
    ** 매입테이블(BUYPROD)에서 매입단가컬럼(BUY_COST)를 삭제하시오
    ALTER TABLE BUYPROD DROP COLUMN BUY_COST;
    COMMIT;
       
    (사용예)
    2020년 1월 제품별 매입집계를 조회하시오
    Alias 는 상품코드, 상품명, 매입수량합계, 매입금액합계
    
    SELECT B.PROD_ID AS 상품코드,
           B.PROD_NAME AS 상품명,
           SUM(A.BUY_QTY) AS 매입수량합계,
           SUM(A.BUY_QTY * B.PROD_COST) AS 매입금액합계
      FROM BUYPROD A, PROD B
     WHERE BUY_DATE BETWEEN TO_DATE('20200101') AND TO_DATE('20200131')
       AND A.BUY_PROD = B.PROD_ID -- 조인조건
     GROUP BY B.PROD_ID, B.PROD_NAME
     ORDER BY 1;
    
    (ANSI 조인)
    SELECT B.PROD_ID AS 상품코드,
           B.PROD_NAME AS 상품명,
           SUM(A.BUY_QTY) AS 매입수량합계,
           SUM(A.BUY_QTY * B.PROD_COST) AS 매입금액합계
      FROM BUYPROD A
     INNER JOIN PROD B ON(A.BUY_PROD = B.PROD_ID)
     WHERE BUY_DATE BETWEEN TO_DATE('20200101') AND TO_DATE('20200131')
     GROUP BY B.PROD_ID, B.PROD_NAME
     ORDER BY 1;
    
    (사용예)
    2020년 6월 회원별 구매현황을 조회하시오
    Alias 는 회원번호, 회원명, 구매금액 합계
    
    SELECT A.MEM_ID AS 회원번호,
           A.MEM_NAME AS 회원명,
           SUM(B.CART_QTY * C.PROD_PRICE) AS "구매금액 합계"
      FROM MEMBER A, CART B, PROD C
     WHERE SUBSTR(B.CART_NO, 1, 6) = '202006'
       AND A.MEM_ID = B.CART_MEMBER
       AND B.CART_PROD = C.PROD_ID
     GROUP BY A.MEM_ID, A.MEM_NAME
     ORDER BY 1;
     
    (ANSI 조인)
    SELECT A.MEM_ID AS 회원번호,
           A.MEM_NAME AS 회원명,
           SUM(B.CART_QTY * C.PROD_PRICE) AS "구매금액 합계"
      FROM MEMBER A
     INNER JOIN CART B ON(A.MEM_ID = B.CART_MEMBER)
     INNER JOIN PROD C ON(B.CART_PROD = C.PROD_ID) AND SUBSTR(B.CART_NO, 1, 6) = '202006' 
     GROUP BY A.MEM_ID, A.MEM_NAME
     ORDER BY 1;
    
    (사용예)
    2020년 제품별 매출집계를 조회하시오
    Alias 는 상품코드, 상품명, 매출수량집계, 매출금액합계
    
    SELECT A.PROD_ID AS 상품코드,
           A.PROD_NAME AS 상품명,
           SUM(B.CART_QTY) AS 매출수량집계,
           SUM(B.CART_QTY * A.PROD_PRICE) AS 매출금액합계
      FROM PROD A, CART B
     WHERE B.CART_NO LIKE '2020%'
       AND A.PROD_ID = B.CART_PROD
     GROUP BY A.PROD_ID, A.PROD_NAME
     ORDER BY 1;
    
    (사용예)
    HR 계정에서 부서별 평균임금, 인원수를 조회하시오
    Alias 는 부서번호, 부서명, 인원수, 평균임금, 최고임금, 최저임금
    
    SELECT A.DEPARTMENT_ID AS 부서번호,
           A.DEPARTMENT_NAME AS 부서명,
           COUNT(B.EMPLOYEE_ID) AS 인원수,
           ROUND(AVG(B.SALARY)) AS 평균임금,
           MAX(B.SALARY) AS 최고임금,
           MIN(B.SALARY) AS 최저임금
      FROM HR.DEPARTMENTS A, HR.EMPLOYEES B
     WHERE A.DEPARTMENT_ID = B.DEPARTMENT_ID -- 조인조건
     GROUP BY A.DEPARTMENT_ID, A.DEPARTMENT_NAME
     ORDER BY 1;
     
    (ANSI 조인)
    SELECT A.DEPARTMENT_ID AS 부서번호,
           A.DEPARTMENT_NAME AS 부서명,
           COUNT(B.EMPLOYEE_ID) AS 인원수,
           ROUND(AVG(B.SALARY)) AS 평균임금,
           MAX(B.SALARY) AS 최고임금,
           MIN(B.SALARY) AS 최저임금
      FROM HR.DEPARTMENTS A
      FULL OUTER JOIN HR.EMPLOYEES B ON(A.DEPARTMENT_ID = B.DEPARTMENT_ID)
     GROUP BY A.DEPARTMENT_ID, A.DEPARTMENT_NAME
     ORDER BY 1;
    
    (사용예)
    2020년 구매액이 500만원 이상인 회원을 조회하시오
    Alias 는 회원번호, 회원명, 구매액
    
    SELECT A.MEM_ID AS 회원번호,
           A.MEM_NAME AS 회원명,
           SUM(B.CART_QTY * C.PROD_PRICE) AS 구매액
      FROM MEMBER A, CART B, PROD C
     WHERE B.CART_NO LIKE '2020%'
       AND A.MEM_ID = B.CART_MEMBER
       AND B.CART_PROD = C.PROD_ID
     GROUP BY A.MEM_ID, A.MEM_NAME
    HAVING SUM(B.CART_QTY * C.PROD_PRICE) >= 5000000
     ORDER BY 1;
    
    (사용예)
    2020년 구매액이 많은 10명의 회원을 조회하시오
    Alias 는 회원번호, 회원명, 구매액, 순위
    
    1) 2020년 회원별 구매액
    
    SELECT A.CART_MEMBER,
           SUM(A.CART_QTY * B.PROD_PRICE)
      FROM CART A, PROD B
     WHERE A.CART_PROD = B.PROD_ID
       AND A.CART_NO LIKE '2020%'
     GROUP BY A.CART_MEMBER
     ORDER BY 2 DESC;                                                                                                                                                                                                                                                                                                                                                                                                                                                          

    2) 상위 10명만 조회
    SELECT D.MID AS 회원번호,
           C.MEM_NAME AS 회원명,
           D.MSUM AS 금액,
           RANK() OVER(ORDER BY D.MSUM DESC) AS 순위
      FROM MEMBER C,
           (SELECT A.CART_MEMBER AS MID,
                   SUM(A.CART_QTY * B.PROD_PRICE) AS MSUM
              FROM CART A, PROD B
             WHERE A.CART_PROD = B.PROD_ID
               AND A.CART_NO LIKE '2020%'
             GROUP BY A.CART_MEMBER
             ORDER BY 2 DESC) D
     WHERE C.MEM_ID = D.MID
       AND ROWNUM <= 10;
    
    (사용예)
    HR계정에서 미국(국가코드 : 'US') 이외에 설치된 부서에 근무하는 사원을 조회하시오
    Alias 는 사원번호, 사원명, 부서번호, 부서명, 부서주소, 국가명
    
    SELECT A.EMPLOYEE_ID AS 사원번호,
           A.EMP_NAME AS 사원명,
           B.DEPARTMENT_ID AS 부서번호,
           B.DEPARTMENT_NAME AS 부서명,
           C.STREET_ADDRESS || ' ' || C.CITY || ' ' || C.STATE_PROVINCE AS 부서주소,
           D.COUNTRY_NAME AS 국가명
      FROM HR.EMPLOYEES A, HR.DEPARTMENTS B, HR.LOCATIONS C, HR.COUNTRIES D
     WHERE A.DEPARTMENT_ID = B.DEPARTMENT_ID -- 조인조건
       AND B.LOCATION_ID = C.LOCATION_ID -- 조인조건
       AND C.COUNTRY_ID = D.COUNTRY_ID -- 조인조건
       AND C.COUNTRY_ID != 'US'
     ORDER BY 3;
    
    (사용예)
    장바구니테이블을 이용하여 분류별 2020년 매출액 집계를 조회하시오
    Alias 는 분류코드, 분류명, 매출금액합계
    
    SELECT A.PROD_LGU AS 분류코드,
           CASE WHEN SUBSTR(A.PROD_LGU, 1, 2) = 'P1' THEN '컴퓨터 및 가전제품'
                WHEN SUBSTR(A.PROD_LGU, 1, 2) = 'P2' THEN '의류'
                WHEN SUBSTR(A.PROD_LGU, 1, 2) = 'P3' THEN '잡화'
                ELSE '기타' END AS 분류명,
           SUM(B.CART_QTY * A.PROD_PRICE) AS 매출금액합계
      FROM PROD A, CART B
     WHERE B.CART_NO LIKE '2020%'
       AND A.PROD_ID = B.CART_PROD
     GROUP BY A.PROD_LGU
     ORDER BY 1;
    
    -------------------------------------------------------
    SELECT B.PROD_LGU AS 분류코드
           A.LPROD_NM AS 분류명,
           SUM(B.CART_QTY * C.PROD_PRICE) AS 매출금액합계
      FROM LPROD A, CART B, PROD C
     WHERE B.CART_NO LIKE '2020%'
    
    (사용예)
    2020년 거래처별 매입현황을 조회하시오
    Alias 거래처코드, 거래처명, 매입금액합계
    
    SELECT A.BUYER_ID AS 거래처코드,
           A.BUYER_NAME AS 거래처명,
           SUM(B.BUY_QTY * C.PROD_COST) AS 매입금액합계
      FROM BUYER A, BUYPROD B, PROD C
     WHERE BUY_DATE BETWEEN TO_DATE('20200101') AND TO_DATE('20201231')
       AND B.BUY_PROD = C.PROD_ID
       AND A.BUYER_ID = C.PROD_BUYER
       AND A.BUYER_LGU = C.PROD_LGU
     GROUP BY A.BUYER_ID, A.BUYER_NAME
     ORDER BY 1;
     
    (ANSI 조인)
    SELECT A.BUYER_ID AS 거래처코드,
           A.BUYER_NAME AS 거래처명,
           SUM(B.BUY_QTY * C.PROD_COST) AS 매입금액합계
      FROM BUYER A
     INNER JOIN PROD C ON(A.BUYER_ID = C.PROD_BUYER)
     INNER JOIN BUYPROD B ON(B.BUY_PROD = C.PROD_ID)
     GROUP BY A.BUYER_ID, A.BUYER_NAME
     ORDER BY 1;