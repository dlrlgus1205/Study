2023-11-15-03

* 변환함수
    - TO_CHAR, TO_DATE, TO_NUMBER, CAST 제공됨

1. CAST(expr AS type)
    'expr'을 'type'으로 명시적 형변환
    
    (사용예)
    HR계정의 부서 테이블(DEPARTMENTS)에서 부서코드의 타입을 고정길이 문자열 타입으로 변환하시오
    
    SELECT DEPARTMENT_ID AS 원부서코드,
           CAST (DEPARTMENT_ID AS CHAR(8)) AS 변환부서코드,
           DEPARTMENT_NAME AS 부서명
      FROM HR.DEPARTMENTS;
    
    (사용예)
    장바구니테이블에서 2020년 7월 판매정보를 모두 출력하시오
    Alias 는 날짜, 상품코드, 판매수량이며 날자는 표준날짜 표현형식으로 출력
    
    SELECT CAST(SUBSTR(CART_NO, 1 , 8) AS DATE) AS 날짜,
           CART_PROD AS 상품코드,
           CART_QTY AS 판매수량
      FROM CART
     WHERE CART_NO LIKE '202007%';
     
2. TO_CHAR(문자|숫자|날짜 형식의 자료 [, fmt])
    - 문자열 자료(CHAR, CLOB 타입)를 문자열 자료(VARCHAR2)로 변환
    - 날짜 또는 숫자 데이터를 'fmt' 형식의 문자열로 변환
    - 가장 많이 사용됨
    
(날짜용 변환 타입)
-------------------------------------------------------------------------------------
형식문자열           의미          사용예
-------------------------------------------------------------------------------------
BC, AD             서기         SELECT TO_CHAR(SYSDATE, 'BC') FROM DUAL;
                               SELECT TO_CHAR(SYSDATE, 'AD') FROM DUAL;
CC                 세기         SELECT TO_CHAR(SYSDATE, 'BC CC') || '세기' FROM DUAL;
YYYY,YYY,YY,Y      년도         SELECT TO_CHAR(SYSDATE, 'YYYY'),
                                      TO_CHAR(SYSDATE, 'YYY'),
                                      TO_CHAR(SYSDATE, 'YY'),
                                      TO_CHAR(SYSDATE, 'Y')
                                 FROM DUAL;
MM                 월(01~12월)  
MON, MONTH         월           SELECT TO_CHAR(SYSDATE, 'YYYY-MM'),
                                       TO_CHAR(SYSDATE, 'YYYY-MON')
                                  FROM DUAL;
D                  주중의 일(1-7)
DD                 월중의 일(1-30(31, 28, 29))
DDD                년중의 일(1-365(366))
                                SELECT TO_CHAR(SYSDATE, 'YYYY-MM-D'),
                                       TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
                                       TO_CHAR(SYSDATE, 'YYYY-MM-DDD')
                                  FROM DUAL;
DY, DAY            요일표시       SELECT TO_CHAR(SYSDATE, 'DY'),
                                       TO_CHAR(SYSDATE, 'DAY')
                                  FROM DUAL;
DL                 일자와 요일 표시
                                SELECT TO_CHAR(SYSDATE, 'DL')
                                  FROM DUAL;
WW                 년 중 주차 표시
                                SELECT TO_CHAR(SYSDATE, 'WW'),
                                        TO_CHAR(SYSDATE, 'W')
                                  FROM DUAL;
AM, PM,           오전/오후
A.M., P.M.          표시         SELECT TO_CHAR(SYSDATE, 'AM'),
                                       TO_CHAR(SYSDATE, 'P.M.')
                                  FROM DUAL;
HH, HH12, HH24    시간           SELECT TO_CHAR(SYSDATE, 'HH'),
                                       TO_CHAR(SYSDATE, 'HH12'),
                                       TO_CHAR(SYSDATE, 'HH24')
                                  FROM DUAL;
MI                분             SELECT TO_CHAR(SYSDATE, 'HH24:MI')
                                  FROM DUAL;
SS, SSSSS         초             SELECT TO_CHAR(SYSDATE, 'HH24:MI:SS'),
                                        TO_CHAR(SYSDATE, 'HH24:MI:SSSSS')
                                  FROM DUAL;
-------------------------------------------------------------------------------------
(숫자용 변환 타입)
-------------------------------------------------------------------------------------
형식문자열           의미          
-------------------------------------------------------------------------------------
9,                같은 위치의 숫자와 대응. 숫자가 무효의 0이면 공백 출력
0                 같은 위치의 숫자와 대응. 숫자가 무효의 0이면 0 출력
-------------------------------------------------------------------------------------
(사용예)
오늘이 2020년 4월 5일이고 회원번호 'c001' 회원이 상품을 구매하려한다. 장바구니 번호를 생성하시오.

SELECT TO_CHAR(SYSDATE, 'YYYYMMDD') || 
       TRIM(TO_CHAR(TO_NUMBER(SUBSTR(MAX(CART_NO), 9)) + 1, '00000'))
  FROM CART
 WHERE SUBSTR(CART_NO, 1, 8) = TO_CHAR(SYSDATE, 'YYYYMMDD');
 
SELECT MAX(CART_NO) + 1
  FROM CART
 WHERE SUBSTR(CART_NO, 1, 8) = TO_CHAR(SYSDATE, 'YYYYMMDD');
-------------------------------------------------------------------------------------
. ,               '.' 소숫점 의미 ',' 3자리마다 사용하는 자리 점

PR                음수인 경우 '-' 부호 대신 '< >'안에 표시(주로 재무제표에 사용)
-------------------------------------------------------------------------------------
(사용예)
SELECT TO_CHAR(-234567, '9,999,999'),
       TO_CHAR(-234567, '9,999,999PR'),
       TO_CHAR(234567, '9,999,999'),
       TO_CHAR(234567, '9,999,999PR')
  FROM DUAL;
-------------------------------------------------------------------------------------
$, L             통화기호를 데이터 왼편에 출력
-------------------------------------------------------------------------------------
(사용예)
SELECT TO_CHAR(PROD_PRICE, 'L9,999,999'),
       TO_CHAR(PROD_PRICE, '$9,999,999')
  FROM PROD
 WHERE PROD_LGU = 'P101';
-------------------------------------------------------------------------------------
RN, rn           로마자 표시
-------------------------------------------------------------------------------------
SELECT TO_CHAR(14, 'RN'),
       TO_CHAR(14, 'rn')
  FROM DUAL;