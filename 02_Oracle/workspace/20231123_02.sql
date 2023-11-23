    2023-11-23-02

    1. INSERT 문과 SUBQUERY
        - INSERT 문에 서브쿼리를 이용하여 데이터를 삽입
        - VALUES 절과 '( )'를 사용하지 않음
        
        [사용형식]
        INSERT INTO 테이블명[(컬럼명, ...)]
        SELECT 컬럼명, ...
          FROM 테이블명;
        - 'INSERT INTO' 절에 컬럼을 기술한 경우 서브쿼리인 SELECT 문의 SELECT 절 컬럼의 갯수, 타입이 일치해야함
        
        (사용예)
        상품테이블(PROD)의 모든 자료를 다음 조건을 만족하도록 연산하여 재고수불테이블에 저장하시오
        삽입할 자료
        1) 재고수불 년도 : '2020'
        2) 상품코드 : PROD테이블의 상품코드
        3) 기초재고 : 상품테이블의 PROD_PROPERSTOCK
        4) 입고/출고 수량 : 없음
        5) 현재고 : 상품테이블의 PROD_PROPERSTOCK
        6) 수정일 : '20200101'
        
        INSERT INTO REMAIN
        SELECT '2020', PROD_ID, PROD_PROPERSTOCK, 0, 0, PROD_PROPERSTOCK, TO_DATE('20200101')
          FROM PROD;
        
        COMMIT;
        
        SELECT * FROM REMAIN;