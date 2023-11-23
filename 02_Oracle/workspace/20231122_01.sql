2023-11-22-01

    3. 외부 조인
        - 내부조인은 공통적인 자료(적은쪽을 기준)를 기준으로 남는 자료를 무시한 결과를 반환
        - 와부조인은 자료의 종류가 많은 쪽을 기준으로 적은쪽에 NULL 값을 갖는 행을 삽입하여 조인 결과를 반환
        - 빈번한 사용은 시스템의 효율을 저하시키므로 자제하여 사용
        - 일반 외부조인에서는 조인 조건을 기술할 때 외부조인 연산자 '(+)'를 부족한 자료를 보유한 테이블의 컬럼명 뒤에 추가
        - 여러 개의 조인조건이 모두 외부조인을 수행해야 하는 경우 해당하는 조인조건 모두에 외부조인 연산자를 추가해야 함
        - 한 테이블은 한 번만 외부조인에 사용될 수 있음
          즉, A, B, C 테이블이 외부조인 되는 경우 A테이블을 기준으로 B테이블이 확장돼 조인됨과 동시에 C테이블을 기준으로 B테이블이 확장돼 조인 될 수 없음
          ex) WHERE A = B(+)
                AND C = B(+) 는 허용되지 않음
        - 일반 외부조인은 조인조건 이외의 조건이 부여되면 내부조인의 결과를 반환
          해결책으로 서브쿼리를 사용하거나 ANSI외부조인을 사용해야 함
          
        [ANSI 외부조인 사용형식]
        
        SELECT 컬럼기술
                  :
          FROM 테이블명1 별칭1
          LEFT|RIGHT|FULL OUTER JOIN 테이블명2 별칭2 ON(조인조건 [AND 일반조건])
                                            :
        [WHERE 일반조건];
        
        'LEFT'  : FROM 절의 '테이블명1' 의 자료가 '테이블명2' 의 자료보다 많은 경우
        'RIGHT' : FROM 절의 '테이블명1' 의 자료가 '테이블명2' 의 자료보다 적은 경우
        'FULL'  : FROM 절의 '테이블명1' 의 자료와 '테이블명2' 의 자료가 모두 부족한 경우
        
        (사용예)
        모든 분류별 상품의 수와 평균 판매가를 조회하시오
        Alias 는 분류코드, 분류명, 상품의 수, 평균판매가
        
        SELECT A.LPROD_GU AS 분류코드,
               A.LPROD_NM AS 분류명,
               COUNT(B.PROD_ID) AS "상품의 수",
               ROUND(AVG(B.PROD_PRICE)) AS 평균판매가
          FROM LPROD A, PROD B
         WHERE A.LPROD_GU = B.PROD_LGU(+)
         GROUP BY A.LPROD_GU, A.LPROD_NM
         ORDER BY 1;
        
        (ANSI 조인)
        SELECT A.LPROD_GU AS 분류코드,
               A.LPROD_NM AS 분류명,
               COUNT(B.PROD_ID) AS "상품의 수",
               ROUND(AVG(B.PROD_PRICE)) AS 평균판매가
          FROM LPROD A
          LEFT OUTER JOIN PROD B ON(A.LPROD_GU = B.PROD_LGU)
         GROUP BY A.LPROD_GU, A.LPROD_NM
         ORDER BY 1;
         
        (사용예)
        2020년 6월 모든 상품별 판매집계를 조회하시오
        Alias 는 상품코드, 상품명, 판매수량합계, 판매금액합계
        
        SELECT (SELECT COUNT(*) FROM PROD) AS "PROD의 상품수",
               (SELECT COUNT(DISTINCT CART_PROD) FROM CART WHERE CART_NO LIKE '202006%') AS "CART의 상품수"
          FROM DUAL;
        
        SELECT A.PROD_ID AS 상품코드,
               A.PROD_NAME AS 상품명,
               SUM(B.CART_QTY) AS 판매수량합계,
               SUM(A.PROD_PRICE * B.CART_QTY) AS 판매금액합계
          FROM PROD A, CART B
         WHERE A.PROD_ID = B.CART_PROD(+)
           AND B.CART_NO LIKE '2020%'
         GROUP BY A.PROD_ID, A.PROD_NAME
         ORDER BY 1;
         
        (ANSI OUTER JOIN)
        SELECT A.PROD_ID AS 상품코드,
               A.PROD_NAME AS 상품명,
               SUM(B.CART_QTY) AS 판매수량합계,
               SUM(A.PROD_PRICE * B.CART_QTY) AS 판매금액합계
          FROM CART B
         RIGHT OUTER JOIN PROD A ON(B.CART_PROD = A.PROD_ID AND B.CART_NO LIKE '202006%')
         GROUP BY A.PROD_ID, A.PROD_NAME
         ORDER BY 1;
         
        (SUBQUERY 해결)
        SELECT A.PROD_ID AS 상품코드,
               A.PROD_NAME AS 상품명,
               NVL(D.QCNT, 0) AS 판매수량합계,
               TO_CHAR(NVL(D.SCNT, 0), '99,999,999') AS 판매금액합계
          FROM PROD A,
               -- (2020년 6월 상품별 판매수량합계, 판매금액합계)
               (SELECT C.CART_PROD AS CID,
                       SUM(C.CART_QTY) AS QCNT,
                       SUM(C.CART_QTY * B.PROD_PRICE) AS SCNT
                  FROM PROD B, CART C
                 WHERE C.CART_PROD = B.PROD_ID
                   AND C.CART_NO LIKE '202006%'
                 GROUP BY C.CART_PROD) D
         WHERE A.PROD_ID = D.CID(+)
         ORDER BY 1;
         
        (사용예)
        2020년 6월 모든 상품별 매입매출정보를 조회하시오
        Alias 는 상품번호, 상품명, 매입수량, 매입금액, 매출수량, 매출금액
        
        SELECT C.PROD_ID AS 상품번호,
               C.PROD_NAME AS 상품명,
               SUM(A.BUY_QTY) AS 매입수량,
               SUM(A.BUY_QTY * C.PROD_COST) AS 매입금액,
               SUM(B.CART_QTY) AS 매출수량,
               SUM(B.CART_QTY * C.PROD_PRICE) AS 매출금액
          FROM BUYPROD A, CART B, PROD C
         WHERE A.BUY_PROD(+) = C.PROD_ID
           AND C.PROD_ID = B.CART_PROD(+)
           AND A.BUY_DATE BETWEEN TO_DATE('20200601') AND TO_DATE('20200630')
           AND B.CART_NO LIKE '202006%'
         GROUP BY C.PROD_ID, C.PROD_NAME
         ORDER BY 1;
         
        ANSI FORMAT
        SELECT C.PROD_ID AS 상품번호,
               C.PROD_NAME AS 상품명,
               SUM(A.BUY_QTY) AS 매입수량,
               SUM(A.BUY_QTY * C.PROD_COST) AS 매입금액,
               SUM(B.CART_QTY) AS 매출수량,
               SUM(B.CART_QTY * C.PROD_PRICE) AS 매출금액
          FROM BUYPROD A
         RIGHT OUTER JOIN PROD C ON (A.BUY_PROD = C. PROD_ID
               AND A.BUY_DATE BETWEEN TO_DATE('20200601') AND TO_DATE('20200630'))
          LEFT OUTER JOIN CART B ON(C.PROD_ID = B.CART_PROD
               AND B.CART_NO LIKE '202006%')
         GROUP BY C.PROD_ID, C.PROD_NAME
         ORDER BY 1;
         
        (사용예)
        사원테이블에서 모든 부서별 사원수를 조회하시오
        Alias 부서번호, 부서명, 사원수
        
        SELECT B.DEPARTMENT_ID AS 부서번호,
               B.DEPARTMENT_NAME AS 부서명,
               COUNT(A.EMPLOYEE_ID) AS 사원수
          FROM HR.EMPLOYEES A
          FULL OUTER JOIN HR.DEPARTMENTS B ON(A.DEPARTMENT_ID = B.DEPARTMENT_ID)
         GROUP BY B.DEPARTMENT_ID, B.DEPARTMENT_NAME
         ORDER BY 1;
         
        (사용예)
        2020년 모든 매입처별 매입금액 합계를 조회하시오
        Alias 는 거래처코드, 거래처명, 매입금액합계
        
        SELECT A.BUYER_ID AS 거래처코드,
               A.BUYER_NAME AS 거래처명,
               SUM(C.BUY_QTY * B.PROD_COST) AS 매입금액합계
          FROM BUYER A, PROD B, BUYPROD C
         WHERE C.BUY_PROD(+) = B.PROD_ID
           AND B.PROD_BUYER(+) = A.BUYER_ID
           AND EXTRACT(YEAR FROM C.BUY_DATE) = 2020
         GROUP BY A.BUYER_ID, A.BUYER_NAME
         ORDER BY 1;