2023-11-16-02

* 집계함수
    - 주어진 자료를 특정 컬럼 값을 기준으로 그룹으로 분리하여(같은 값을 갖는 자료들로 분리) 각 그룹을 대상으로 하는 함수
    - SUM(합계), AVG(평균), COUNT(자료의 수 또는 행의 수), MIN(최솟값), MAX(최댓값)
    - 집계함수는 집계함수를 포함할 수 없다.
    - SELECT 절에 집계함수만 사용되면 테이블이 하나의 그룹이 됨 => GROUP BY절 불필요
    - SELECT 절에 집계함수 이외의 컬럼이 기술되면 해당 컬럼을 기준으로 그룹이 형성되며 반드시 GROUP BY절이 기술돼야 하며 
      GROUP BY절에는 해당 일반 컬럼명을 기술해야 함
    - 집계함수가 사용된 컬럼에 조건 부여된 경우에는 HAVING절에서 조건 처리를 해야 함
      
    [기술형식]
    SELECT [컬럼명, ]
              :
           SUM(컬럼명) | AVG(컬럼명) | COUNT(컬럼명 | *) | MIN(컬럼명) | MAX(컬럼명)
              :
      FROM 테이블명
    [WHERE 조건]
    [GROUP BY 컬럼명[, 컬럼명, ...]]
   [HAVING 조건]
    [ORDER BY 컬럼명 | 컬럼인덱스 [[ASC] | DESC], ...];
    
    (사용예)
    HR 계정의 사원테이블에서 사원 전체의 평균급여, 급여합계, 인원수, 최고급여액, 최저급여액을 조회하시오
    
    SELECT ROUND(AVG(SALARY)) AS 평균급여,
           SUM(SALARY) AS 급여합계,
           COUNT(*) AS 인원수,
           MAX(SALARY) AS 최고급여액,
           MIN(SALARY) AS "최저 급여액"
      FROM HR.EMPLOYEES;
    
    (사용예)
    상품테이블에서 전체 상품의 수, 가장 큰 판매단가, 가장 작은 판매단가, 평균 판매 단가를 조회하시오
    
    SELECT COUNT(*) AS "전체 상품의 수",
           MAX(PROD_PRICE) AS "가장 큰 판매단가",
           MIN(PROD_PRICE) AS "가장 작은 판매단가",
           ROUND(AVG(PROD_PRICE), -1) AS "평균 판매 단가"
      FROM PROD;
      
(상품 명 출력)
    SELECT B.PROD_NAME AS 상품명,
           B.PROD_PRICE AS 판매단가
      FROM (SELECT MAX(PROD_PRICE) AS MP
              FROM PROD)A, PROD B
     WHERE A.MP = B.PROD_PRICE
UNION
     SELECT B.PROD_NAME AS 상품명,
            B.PROD_PRICE AS 판매단가
       FROM  (SELECT MIN(PROD_PRICE) AS MP
                FROM PROD)A, PROD B
      WHERE A.MP = B.PROD_PRICE;
    (사용예)
    회원테이블에서 회원수, 평균보유마일리지를 조회하시오
    
    SELECT COUNT(*) AS 회원수,
           TRUNC(AVG(MEM_MILEAGE)) AS 평균보유마일리지
      FROM MEMBER;
    
    SELECT MEM_ID,
           MEM_NAME,
           MEM_MILEAGE
      FROM MEMBER
     WHERE MEM_MILEAGE > (SELECT TRUNC(AVG(MEM_MILEAGE)) AS 평균보유마일리지
                            FROM MEMBER);
    
    (사용예)
    사원테이블에서 각 부서별 인원수, 평균급여, 급여합계를 조회하시오
    Alias 는 부서번호, 인원수, 평균급여, 급여합계
    
    SELECT DEPARTMENT_ID AS 부서번호,
           COUNT(*) AS 인원수,
           ROUND(AVG(SALARY)) AS 평균급여,
           SUM(SALARY) AS 급여합계
      FROM HR.EMPLOYEES
     GROUP BY DEPARTMENT_ID
     ORDER BY 1;
    
    (사용예)
    장바구니테이블에서 2020년 월별 판매수량합계를 구하시오
    Alias 는 월, 판매수량합계
    
    SELECT SUBSTR(CART_NO, 5, 2) || '월' AS 월,
           SUM(CART_QTY) AS 판매수량합계
      FROM CART
     WHERE SUBSTR(CART_NO, 1, 4) = '2020'
     GROUP BY SUBSTR(CART_NO, 5, 2)
     ORDER BY 1;
    
    (사용예)
    장바구니테이블에서 2020년 제품별 판매수량합계를 구하시오
    Alias 는 제품코드, 판매수량합계
    
    SELECT CART_PROD AS 제품코드,
           SUM(CART_QTY) AS 판매수량합계
      FROM CART
     WHERE SUBSTR(CART_NO, 1, 4) = '2020'
     GROUP BY CART_PROD
     ORDER BY 1;
    
    (사용예)
    장바구니테이블에서 2020년 회원별 판매수량합계를 구하시오
    Alias 는 회원번호, 판매수량합계
    
    SELECT CART_MEMBER AS 회원번호,
           SUM(CART_QTY) AS 판매수량합계
      FROM CART
     WHERE SUBSTR(CART_NO, 1, 4) = '2020'
     GROUP BY CART_MEMBER
     ORDER BY 1;
    
    (사용예)
    회원테이블에서 남여회원별 인원수와 평균마일리지를 조회하시오 (단, 구분란에는 '여성회원', '남성회원'을 출력)
    Alias 는 구분, 인원수, 평균마일리지
    
    SELECT CASE WHEN SUBSTR(MEM_REGNO2, 1, 1) IN ('2', '4')
           THEN '여성회원'
           ELSE '남성회원' END AS 구분,
           COUNT(*) AS 인원수,
           ROUND(AVG(MEM_MILEAGE)) AS 평균마일리지
      FROM MEMBER
     GROUP BY CASE WHEN SUBSTR(MEM_REGNO2, 1, 1) IN ('2', '4')
              THEN '여성회원'
              ELSE '남성회원' END
     ORDER BY 1;
    
    (사용예)
    회원테이블에서 연령대별 평균마일리지를 조회하시오 (단, 평균마일리지는 정수만 출력할 것)
    Alias 는 연령대, 평균마일리지
    
    SELECT TRUNC((SUBSTR(SYSDATE, 1, 4) - SUBSTR(MEM_BIR, 1, 4)) / 10) * 10 || '대' AS 연령대,
           AVG(MEM_MILEAGE) AS 평균마일리지
      FROM MEMBER
     GROUP BY TRUNC((SUBSTR(SYSDATE, 1, 4) - SUBSTR(MEM_BIR, 1, 4)) / 10) * 10
     ORDER BY 1;
     
     SELECT TRUNC(EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM MEM_BIR), -1)  AS 연령대,
            AVG(MEM_MILEAGE) AS 평균마일리지
       FROM MEMBER
      GROUP BY TRUNC(EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM MEM_BIR), -1)
      ORDER BY 1;
      
    (사용예)
    매입테이블에서 2020년 상반기 월별 제품별 매입집계를 조회하시오
    Alias 는 월, 제품코드, 매입수량, 매입금액
    
    SELECT EXTRACT(MONTH FROM BUY_DATE) || '월' AS 월,
           BUY_PROD AS 제품코드,
           SUM(BUY_QTY) AS 매입수량합계,
           SUM(BUY_QTY * BUY_COST) AS 매입금액합계
      FROM BUYPROD
     WHERE BUY_DATE BETWEEN TO_DATE('20200101') AND TO_DATE('20200630')
     GROUP BY EXTRACT(MONTH FROM BUY_DATE), BUY_PROD
     ORDER BY 1, 2;
     
    (사용예)
    장바구니테이블에서 2020년 7월 회원별 구매수량합계를 구하시오
    구매수량합계가 20개 이상인 회원만 조회하시오
    
    SELECT CART_MEMBER AS 회원,
           SUM(CART_QTY) AS 구매수량합계
      FROM CART
     WHERE SUBSTR(CART_NO, 1, 6) = '202007'
     GROUP BY CART_MEMBER
    HAVING SUM(CART_QTY) > 19
     ORDER BY 2 DESC;
     
    (사용예)
    2020년 5월 회원별 구매수량합계를 구하되 상위 3명의 자료만 조회하시오
    Alias 는 회원번호, 회원명, 구매수량합계
    
    SELECT B.MEM_ID AS 회원번호, 
           B.MEM_NAME AS 회원명, 
           A.QAMT AS 구매수량합계
      FROM (SELECT CART_MEMBER,
                   SUM(CART_QTY) AS QAMT
              FROM CART
             WHERE SUBSTR(CART_NO, 1, 6) = '202005'
             GROUP BY CART_MEMBER
             ORDER BY 2 DESC) A, MEMBER B
     WHERE A.CART_MEMBER = B.MEM_ID
       AND ROWNUM <= 3;