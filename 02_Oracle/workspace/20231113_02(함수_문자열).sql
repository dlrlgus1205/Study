2023-11-13-02
    7) REPLACE
        - 문자열을 문자나 문자열로 치환
        
        [사용형식]
        REPLACE(c1, c2, [, c3])
            . 문자열 c1에서 c2문자열을 c3 문자열로 치환
            . c3가 생략되면 c2를 찾아 삭제함(공백 제거)
            
        (사용예)
        거래초테이블(BUYER)의 거래처명에서 '삼보'를 찾아 'APPLE'로 바꾸시오
        
        SELECT BUYER_NAME AS 구거래처명,
               REPLACE(BUYER_NAME, '삼보', 'APPLE') AS 신거래처명
          FROM BUYER;
          
        (사용예)
        상품테이블에서 상품명 컬럼의 내부에 존재하는 공백을 제거하시오
        
        SELECT PROD_NAME AS "변경 전 상품명",
               REPLACE(PROD_NAME, ' ') AS "변경 후 상품명"
          FROM PROD;
          
    8)LENGTH
        - 문자열 내부의 문자의 수를 반환
        
        [사용형식]
        LENGTH(c1)
            . c1 문자열에 포함된 문자의 수를 반환
            
        (사용예)
            SELECT LENGTH('Oracle SQL과 데이터 모델링') FROM DUAL;