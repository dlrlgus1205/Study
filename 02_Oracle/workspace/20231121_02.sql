2023-11-21-02

*조인(JOIN)
    - 관계형 데이터베이스의 핵심 연산
    - 테이블 사이에 존재하는 관계(Relationship)을 이용하여 다수 테이블에 분산된 정보를 조회하는 기법
    - 조인의 종류
        . 일반조인 vs ANSI조인
        . 동등조인 VS 비동등조인
        . 내부조인(Inner Join) VS 외부조인(Outer Join)
        . Self Join, Cross Join, Cartesian Product 등
        
    [일반조인 사용형식]
    
    1) 내부 조인
    SELECT [테이블별칭|테이블명].컬럼명,
                    :
      FROM 테이블명1 [별칭1], 테이블명2 [별칭2], [, ... 테이블명n [별칭n]]
     WHERE 별칭1.컬럼명 연산자 별칭2.컬럼명 -- 조인조건
      [AND 일반조건]
      
    2) 외부 조인
    SELECT [테이블별칭|테이블명].컬럼명,
                    :
      FROM 테이블명1 [별칭1], 테이블명2 [별칭2], [, ... 테이블명n [별칭n]]
     WHERE 별칭1.컬럼명[(+)] 연산자 별칭2.컬럼명[(+)] --외부조인조건
      
    [ANSI조인 사용형식]
    
    3) 내부 조인
    SELECT [테이블별칭|테이블명].컬럼명,
                    :
      FROM 테이블명1 [별칭1]
     INNER JOIN 테이블명2 [별칭2] ON(조인조건)[AND 일반조건]
                    :
    [INNER JOIN 테이블명n [별칭n] ON(조인조건)[AND 일반조건]]
    [WHERE 일반조건]
      
    4) 외부 조인
    SELECT [테이블별칭|테이블명].컬럼명,
                    :
      FROM 테이블명1 [별칭1]
      LEFT|RIGHT|FULL OUTER JOIN 테이블명2 [별칭2] ON(조인조건)[AND 일반조건]
                                :
      LEFT|RIGHT|FULL OUTER JOIN ... 테이블명n [별칭n] ON(조인조건)[AND 일반조건]]
    [WHERE 일반조건]
    
    1. Cartesian Product(Cross Join)
        - 조인조건이 없거나 조인조건을 잘못 사용한 경우 발생
        - 결과는 조인에 참여한 테이블의 모든 행을 곱한 결과 행과 조인에 참여한 테이블의 모든 열을 더한 열을 갖는 뷰(VIEW)를 반환
        - 특별한 목적이 아니면 사용을 자제해야 함
        
        [CROSS JOIN 사용형식]
        SELECT 컬럼정의
          FROM 테이블명1
         CROSS JOIN 테이블명2 [ON(조인조건)]
                    :
                    
        
        [사용예]
        
        SELECT COUNT(*) "상품 행의 수"
          FROM PROD;
          
        SELECT COUNT(*) "장바구니 행의 수"
          FROM CART;
          
        SELECT COUNT(*) "매입테이블 행의 수"
          FROM BUYPROD;
          
        SELECT COUNT(*)
          FROM PROD, CART, BUYPROD;
        
        [ANSI CROSS JOIN]
        
        SELECT COUNT(*)
          FROM PROD
         CROSS JOIN CART
         CROSS JOIN BUYPROD;