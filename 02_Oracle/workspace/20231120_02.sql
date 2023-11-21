2023-11-20-02

* 오라클 표현식
    - SELECT 절에 사용하며 DECODE 와 CASE WHEN ~ THEN 이 제공됨
    - 개발언어나 PL-SQL 의 IF 문이나 SWICH ~ CASE 와 유사기능 제공
    - PL-SQL 에서는 하나의 명령문으로 제공됨
    
    1. DECODE(컬럼, 조건1, 결과1[, 조건2, 결과2, ...])
        . 컬럼의 값이 '조건1' 과 같으면 (IF(컬럼 = 조건1)) '결과1' 반환, 그렇지 않으면 컬럼과 조건2를 비교 (IF(컬럼 = 조건2)) '결과2' 반환,
          모든 조건이 일치하지 않으면 '결과n' 을 반환
          
        (사용예)
        HR계정의 부서테이블에서 위치코드가 1700이면 '시애틀' 을 1500이면 '샌프란시스코' 를 그 외면 'NONE' 를 도시 란에 출력하시오
        Alias 는 부서코드, 부서명, 위치코드, 도시
        
        SELECT DEPARTMENT_ID AS 부서코드,
               DEPARTMENT_NAME AS 부서명,
               LOCATION_ID AS 위치코드,
               DECODE(LOCATION_ID, 1700, '시애틀', 1500, '샌프란시스코', 'NONE') AS 도시
          FROM HR.DEPARTMENTS;
          
    2. CASE WHEN 조건1 THEN 결과1
            [WHEN 조건2 THEN 결과2
                    :
            ELSE 결과n] END
       또는
       CASE 식 WHEN 값1 THEN 결과2
              [WHEN 값2 THEN 결과2
                      :
              [ELSE 결과n] END
               
       (사용예)
       HR계정의 부서테이블에서 위치코드가 1700이면 '시애틀' 을 1500이면 '샌프란시스코' 를 그 외면 'NONE' 를 도시 란에 출력하시오
        Alias 는 부서코드, 부서명, 위치코드, 도시
        
        SELECT DEPARTMENT_ID AS 부서코드,
               DEPARTMENT_NAME AS 부서명,
               LOCATION_ID AS 위치코드,
               CASE LOCATION_ID WHEN 1700 THEN '시애틀'
                                WHEN 1500 THEN '샌프란시스코'
                                ELSE 'NONE' END AS 도시
          FROM HR.DEPARTMENTS;
          
        SELECT DEPARTMENT_ID AS 부서코드,
               DEPARTMENT_NAME AS 부서명,
               LOCATION_ID AS 위치코드,
               CASE  WHEN LOCATION_ID = 1700 THEN '시애틀'
                     WHEN LOCATION_ID = 1500 THEN '샌프란시스코'
                     ELSE 'NONE' END AS 도시
          FROM HR.DEPARTMENTS;  