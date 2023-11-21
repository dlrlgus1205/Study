2023-11-17-01

* CUBE와  ROLLUP 함수
    - 집계함수를 사용하면 그룹별 합계를 구할 수 있으나 다중그룹의 경우 각 그룹별 중간 집계는 구하지 못함
    - 다양한 구분으로 다중 그룹을 형성하고 각 그룹별 중간 집계를 반환할 수 있는 함수
    - 여론조사의 분석 등에 주로 사용
    
    1. ROLLUP(컬럼명1[, 컬럼명2, ... , 컬럼명n])
        . 반드시 GROUP BY 절에서 사용해야 함
        . ROLLUP 에 사용된 '컬럼명1' 부터 '컬럼명1 + 컬럼명2', ... '컬럼명1 + 컬럼명 2 + ... 컬럼명n' (이를 레벨이라 함)을 각각 정용한 집계를 반환
        . 사용된 컬럼의 갯수가 n개일 때 반환되는 집계의 종류는 n + 1개임
         
    (사용예)
    2020년 장바구니테이블에서 월별, 회원별, 제품별, 판매수량합계를 조회하시오
    
    (GROUP BY 절만 사용)
    SELECT SUBSTR(CART_NO, 5, 2) AS 월,
           CART_MEMBER AS 회원,
           CART_PROD AS 제품,
           SUM(CART_QTY) AS 판매수량합계
      FROM CART
     WHERE CART_NO LIKE '2020%'
     GROUP BY SUBSTR(CART_NO, 5, 2), CART_MEMBER, CART_PROD
     ORDER BY 1, 2, 3;
     
     (ROLLUP 절 사용)
     SELECT SUBSTR(CART_NO, 5, 2) AS 월,
           CART_MEMBER AS 회원,
           CART_PROD AS 제품,
           SUM(CART_QTY) AS 판매수량합계
      FROM CART
     WHERE CART_NO LIKE '2020%'
     GROUP BY ROLLUP(SUBSTR(CART_NO, 5, 2), CART_MEMBER, CART_PROD)
     ORDER BY 1, 2, 3;
     
    SELECT SUM(CART_QTY)
      FROM CART
     WHERE CART_NO LIKE '2020%';
     
     2. CUBE(컬럼명1[, 컬럼명2, ... 컬럼명n])
        . 반드시 GROUP BY 절에서 사용해야 함
        . CUBE 에 사용된 컬럼들로 구성할 수 있는 모든 가능한 조합으로 집계를 반환
        . 사용된 컬럼의 갯수가 n개일 때 반환되는 집계의 종류는 2의 n승개이다.
        
     (사용예)
     2020년 장바구니테이블에서 월별, 회원별, 제품별, 판매수량합계를 조회하시오   
        
     (CUBE 절 사용)   
     SELECT SUBSTR(CART_NO, 5, 2) AS 월,
            CART_MEMBER AS 회원,
            CART_PROD AS 제품,
            SUM(CART_QTY) AS 판매수량합계
       FROM CART
      WHERE CART_NO LIKE '2020%'
      GROUP BY CUBE(SUBSTR(CART_NO, 5, 2), CART_MEMBER, CART_PROD)
      ORDER BY 1, 2, 3;
     
     3. 부분 ROLLUP(CUBE)
        - ROLLUP(CUBE) 전/후에 컬럼이 기술된 경우
        - ROLLUP(CUBE) 절 밖에 기술된 컬럼은 단순히 GROUP BY 절에만 적용됨
        
     (부분 ROLLUP 절 사용)   
     SELECT SUBSTR(CART_NO, 5, 2) AS 월,
            CART_MEMBER AS 회원,
            CART_PROD AS 제품,
            SUM(CART_QTY) AS 판매수량합계
       FROM CART
      WHERE CART_NO LIKE '2020%'
      GROUP BY SUBSTR(CART_NO, 5, 2), ROLLUP(CART_MEMBER, CART_PROD)
      ORDER BY 1, 2, 3;