2023-11-14-01

* 숫자 함수

1. 수학적 함수
    1)ABS(Absolute Value) : ABS(n1)
        - n1의 절대값 반환
    2)SIGN(n)
        - n의 부호에 따라 -1(n이 음수일 때), 0(n이 0일 때), 1(n이 양수일 때)을 반환
        - n의 크기는 결과와 무관
    3)POWER(n,y)
        - n의 y승값을 반환(n을 y번 거듭 곱한 값)
    4)SQRT(n)
        - n의 평방근(root) 값
    
    SELECT SIGN(-1000), SIGN(0), SIGN(0.0000005) FROM DUAL;
    SELECT POWER(2,10) FROM DUAL;
    SELECT SQRT(28.9, SQRT(3.3) FROM DUAL;
    
    사용예) 회원테이블에서 회원의 마일리지 평균값을 구하고 회원들의 마일리지와의 편차를 조회하시오 (단, 편차는 부호없는 정수로 표현하고, 평균마일리지도 정수로 표현)
    Alias 는 회원명, 평균마일리지, 보유마일리지, 편차
    
    (회원의 마일리지 평균)
    SELECT ROUND(AVG(MEM_MILEAGE)) AS A1
      FROM MEMBER;
    
    SELECT MEM_NAME AS 회원명,
           (SELECT ROUND(AVG(MEM_MILEAGE))
             FROM MEMBER) AS 평균마일리지,
           MEM_MILEAGE AS 보유마일리지,  
           ABS((SELECT ROUND(AVG(MEM_MILEAGE))
             FROM MEMBER) - MEM_MILEAGE) AS 편차
      FROM MEMBER;
      
2. GREATEST, LEAST
    - 주어진 자료 중 최대값(GREATEST)과 최소값(LEAST)을 반환
    
    [사용형식]
    GREATEST(n1, n2[, n3, ...]), 
    LEAST(n1, n2[, n3, ...])
    
    (사용예)
    상품테이블에서 매입단가, 매출단가, 할인판매단가 중 가장 큰 값과 가장 작은 값을 조회하시오
    
    SELECT PROD_COST AS 매입가, 
           PROD_PRICE AS 매출가, 
           PROD_SALE AS 할인가,
           GREATEST(PROD_COST, PROD_PRICE, PROD_SALE) AS 최대값,
           LEAST(PROD_COST, PROD_PRICE, PROD_SALE) AS 최초값
      FROM PROD;
    
    (사용예)
    회원테이블에서 마일리지가 1000 미만인 회원의 마일리지는 1000으로 부여하여 출력하고 1000 이상인 회원은 그 회원이 보유한 마일리지를 그대로 출력하시오
    Alias 는 회원번호, 회원명, 보유마일리지, 변경마일리지
    
    SELECT MEM_ID AS 회원번호,
           MEM_NAME AS 회원명,
           MEM_MILEAGE AS 보유마일리지,
           GREATEST(MEM_MILEAGE, 1000) AS 변경마일리지
      FROM MEMBER;
      
      SELECT A.MEM_NAME AS 회원명,
             A.MEM_MILEAGE AS 마일리지
        FROM MEMBER A
       WHERE A.MEM_MILEAGE = (SELECT MAX(MEM_MILEAGE)
                                FROM MEMBER);

3. ROUND, TRUNC
    - 반올림(ROUND)과 자리버림(TRUNC) 결과 반환
    
    [사용형식]
    ROUND(n1[, n2])
    TRUNC(n1[, n2])
        - n2가 양의 정수인 경우
            . 주어진 수 n1에서 소숫점 이하 n2 + 1번째 자리에서 반올림(ROUND) 또는 자리버림(TRUNC)하여 n2자리까지 나타냄
        - n2가 음의 정수인 경우
            . 주어진 수 n1에서 정수부분 n2번째 자리에서 반올림(ROUND) 또는 자리버림(TRUNC)하여 n2자리까지 나타냄
    
    (사용예)
    상품테이블에서 'P201' 분류에 속한 상품들의 할인판매가를 변경하시오
    할인 판매가 = 판매단가의 73%이고 원단위(1의 자리)에서 반올림하여 정수만 출력
    
    SELECT PROD_NAME AS 상품명,
           PROD_PRICE AS 판매가,
           PROD_SALE AS 할인가,
           TRUNC(PROD_PRICE * 0.73, -2) AS 변경할인가
      FROM PROD
     WHERE PROD_LGU = 'P201';
    
    (데이터 UPDATE)
    UPDATE PROD
       SET PROD_SALE = TRUNC(PROD_PRICE * 0.73, -2)
     WHERE PROD_LGU = 'P201';
       
    COMMIT;
    
    (사용예)
    2020년 6월 상품 별 판매금액 합계를 구한 후 각 판매 사품의 매출 점유율을 조회하시오
    Alias는 상품코드, 판매금액, 매출비율(%)
    
    1. 2020년 6월 전체 매출 금액
    SELECT SUM(A.CART_QTY * B.PROD_PRICE) AS CSUM
      FROM CART A, PROD B
     WHERE SUBSTR(A.CART_NO, 1, 6) = '202006'
       AND A.CART_PROD = B.PROD_ID;
       
    2. 2020년 6월 판매상품 별 매출금액
    SELECT A.CART_PROD AS CID,
           SUM(A.CART_QTY * B.PROD_PRICE) AS BSUM
      FROM CART A, PROD B
     WHERE SUBSTR(A.CART_NO, 1, 6) = '202006'
       AND A.CART_PROD = B.PROD_ID
     GROUP BY A.CART_PROD;
     
    (결과)
    SELECT TA.CID AS 상품코드, 
           TA.BSUM AS 판매금액, 
           TO_CHAR(ROUND((TA.BSUM / (SELECT SUM(A.CART_QTY * B.PROD_PRICE)
                                       FROM CART A, PROD B
                                      WHERE SUBSTR(A.CART_NO, 1, 6) = '202006'
                                        AND A.CART_PROD = B.PROD_ID)) * 100, 2), '999.99') || '%'
           AS "매출비율(%)"
      FROM (SELECT A.CART_PROD AS CID,
                   SUM(A.CART_QTY * B.PROD_PRICE) AS BSUM
              FROM CART A, PROD B
             WHERE SUBSTR(A.CART_NO, 1, 6) = '202006'
               AND A.CART_PROD = B.PROD_ID
             GROUP BY A.CART_PROD) TA