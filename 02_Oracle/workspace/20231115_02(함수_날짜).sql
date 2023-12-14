2023-11-15-02

* 날짜 함수

1. SYSDATE
    - 시스템이 제공하는 현재의 날짜/시간 정보 반환
    - '+', '-' 연산의 대상이 됨
    - 날짜데이터 - 날짜데이터 = 경과된 일수
    - 날짜데이터 +(-) 정수 => 날짜로 반환
    
    (사용예)
    SELECT SYSDATE, SYSDATE - 10, SYSDATE + 10 FROM DUAL;
    
    SELECT TO_CHAR(ROUND(SYSDATE), 'YYYY-MM-DD HH24:MI:SS'),TRUNC(SYSDATE) FROM DUAL;
    
    SELECT TO_CHAR(TO_DATE('00010101'), 'YYYY-MM-DD HH24:MI:SS') FROM DUAL;
    
    SELECT MOD(TO_DATE('19961205') - TO_DATE('00010101') - 1, 7) FROM DUAL;
    
2. ADD_MONTHS
    - 주어진 날짜에 정의한 정수만큼의 월을 더한 날짜 반환
    
    [사용형식]
    ADD_MONTHS(d1, n)
        .날짜 d1에 포함된 월에 n을 더한 날짜를 반환
        
    (사용예)
    SELECT ADD_MONTHS(SYSDATE, 3) FROM DUAL;
    
3. NEXT_DAY
    - 해당 날짜 이후 가장 빠른 정의된 요일의 날짜 반환
    
    [사용형식]
    NEXT_DAY(d1, c)
        . 'c' : 요일을 나타내는 문자열 ex) '월', '월요일' ~ '일요일'
        . 날짜 d1 이후에 처음 만나는 c 요일의 날짜 반환
        
    (사용예)
    SELECT NEXT_DAY(SYSDATE, '수'), 
           NEXT_DAY(SYSDATE, '목요일')
      FROM DUAL;

4. LAST_DAY
    
    [사용형식]
    LAST_DAY(d)
        . 주어진 날짜 d에 포함된 월의 마지막 일을 반환
        
    (사용예)
    매입테이블에서 2020년 2월 매입금액 합계를 조회하시오
    
    SELECT TO_CHAR(SUM(BUY_QTY * BUY_COST), '9,999,999,999') AS "매입금액 합계"
      FROM BUYPROD
     WHERE BUY_DATE BETWEEN TO_DATE('20200201') AND 
                            LAST_DAY(TO_DATE('20200201'));
                            
    (사용예)
    키보드로 월을 입력 받아 해당 월에 발생한 매입금액합계를 출력하시오
    
    ACCEPT P_MONTH PROMPT '조회할 월을 2자리로 입력하시오 : '
    DECLARE
        L_SDATE DATE := TO_DATE('2020' || TRIM('&P_MONTH') || TRIM('01'));
        L_EDATE DATE := LAST_DAY(L_SDATE);
        L_AMT NUMBER := 0;
    BEGIN
        SELECT SUM(BUY_QTY * BUY_COST) INTO L_AMT
          FROM BUYPROD
         WHERE BUY_DATE BETWEEN L_SDATE AND L_EDATE;
         
         DBMS_OUTPUT.PUT_LINE('2020년 &P_MONTH 월의 매입 합계 : ' ||
                         TO_CHAR(L_AMT, '999,999,999') || '원');
         
    END;

5. MONTHS_BETWEEN(d1, d2)
    - 두 날짜 데이터 사이의 달 수를 숫자로 반환
    
    SELECT TRUNC(MONTHS_BETWEEN(SYSDATE, '20211224')) FROM DUAL;

6. EXTRACT(fmt FROM d1)
    - 날짜 데이터 d1에서 'fmt' 자료를 숫자로 반환
    - 'fmt' 는 YEAR, MONTH, DAY, HOUR, MINUTE, SECOND 를 사용
    
    (사용예)
    회원테이블에서 이번달에 생일이 있는 회원정보를 추출하시오
    Alias 는 회원번호, 회원명, 생년월일, 직업, 마일리지
    
    SELECT MEM_ID AS 회원번호,
           MEM_NAME AS 회원명,
           MEM_BIR AS 생년월일,
           MEM_JOB AS 직업,
           MEM_MILEAGE AS 마일리지
      FROM MEMBER
     WHERE EXTRACT(MONTH FROM SYSDATE) = EXTRACT(MONTH FROM MEM_BIR);