2023-11-21-01

        (사용예)
        상품테이블에서 분류코드를 조회해 
        'P1' 로 시작하는 상품은 '컴퓨터 및 가전제품'
        'P2' 로 시작하면 '의류'
        'P3' 으로 시작하면 '잡화'
        그 이외면 '기타' 를 구분 란에 출력하시오
        Alias 는 상품코드, 상품명, 구분
        DECODE 를 이용하여 코딩
        
        SELECT PROD_ID AS 상품코드,
               PROD_NAME AS 상품명, 
               DECODE(SUBSTR(PROD_ID, 1, 2), 
               'P1', '컴퓨터 및 가전제품', 
               'P2', '의류', 
               'P3', '잡화', 
               '기타') AS 구분
          FROM PROD;
        
        CASE WHEN ~  THEN 을 이용하여 코딩
        
        SELECT PROD_ID AS 상품코드,
               PROD_NAME AS 상품명, 
               CASE SUBSTR(PROD_ID, 1, 2)
                   WHEN 'P1' THEN '컴퓨터 및 가전제품'
                   WHEN 'P2' THEN '의류'
                   WHEN 'P3' THEN '잡화'
                   ELSE '기타' END AS 구분
          FROM PROD;
          
        SELECT PROD_ID AS 상품코드,
               PROD_NAME AS 상품명, 
               CASE WHEN SUBSTR(PROD_ID, 1, 2) = 'P1' THEN '컴퓨터 및 가전제품'
                    WHEN SUBSTR(PROD_ID, 1, 2) = 'P2' THEN '의류'
                    WHEN SUBSTR(PROD_ID, 1, 2) = 'P3' THEN '잡화'
                    ELSE '기타' END AS 구분
          FROM PROD;  