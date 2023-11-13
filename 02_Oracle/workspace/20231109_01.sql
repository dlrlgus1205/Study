2023-11-09-01

기타연산자
    - LIKE, BETWEEN, IN, ANY(SOME), ALL
    
    1) IN
        . 주어진 다수의 값 중 어느 하나의 값과 일치하면 전체 결과가 참이 되는 연산자
        . 반대인 경우 NOT 연산자 사용
        
        [사용형식]
        expr IN(값1[, 값2, ...])
            - 'expr'의 평과 결과가 '값1' ~ '값n' 중의 하나와 일치하면 TRUE 반환
            - OR 연산자로 바꾸어 사용할 수 있다.
            - 주로 비연속적인 다수의 값을 판별할 때 사용
            
        (사용예)
        HR 계정의 사원테이블에서 부서번호가 30, 60, 80, 100에 속한 사원의 사원번호, 사원명, 부서번호, 급여를 조회하시오
        -- OR 연산자 사용
        SELECT EMPLOYEE_ID AS 사원번호,
               EMP_NAME AS 사원명,
               DEPARTMENT_ID AS 부서번호,
               SALARY AS 급여
          FROM HR.EMPLOYEES
         WHERE DEPARTMENT_ID = 30
            OR DEPARTMENT_ID = 60
            OR DEPARTMENT_ID = 80
            OR DEPARTMENT_ID = 100
         ORDER BY 3;
         
         -- IN 연산자 사용
         SELECT EMPLOYEE_ID AS 사원번호,
               EMP_NAME AS 사원명,
               DEPARTMENT_ID AS 부서번호,
               SALARY AS 급여
          FROM HR.EMPLOYEES
         WHERE DEPARTMENT_ID IN(30, 60, 80, 100)
         ORDER BY 3;
         
         -- ANY 연산자 사용
         SELECT EMPLOYEE_ID AS 사원번호,
               EMP_NAME AS 사원명,
               DEPARTMENT_ID AS 부서번호,
               SALARY AS 급여
          FROM HR.EMPLOYEES
         WHERE DEPARTMENT_ID = ANY(30, 60, 80, 100)
         ORDER BY 3;
         
    2) ANY(SOME)
        . ANY와 SOME은 동일 기능 제공
        . 주어진 다수의 값 중 어느 하나의 값과 제시된 관계 연산자의 결과가 만족되면 전체 결과가 참이 되는 연산자
        . 반대인 경우 NOT 연산자 사용
        . OR 연산자로 변환 가능
        
        [사용형식]
        expr 관계연산자 ANY(SOME) (값1[, 값2, ...])
        
        (사용예)
        회원테이블에서 1000, 1500, 2000 보다 큰 마일리지를 보유하는 회원등를 조회하시오
        Alias는 회원번호, 회원명, 거주지역, 마일리지
        
        SELECT MEM_ID AS 회원번호, 
               MEM_NAME AS 회원명,
               SUBSTR(MEM_ADD1, 1, 2) AS 거주지역,
               MEM_MILEAGE AS 마일리지
          FROM MEMBER
         WHERE MEM_MILEAGE > ANY(1000, 1500, 2000)
         ORDER BY 4;
         
        회원테이블에서 충남에 거주하는 회원들의 마일리지보다 큰 마일리지를 보유하는 회원들을 조회하시오
        Alias는 회원번호, 회원명, 거주지역, 마일리지
        --
        SELECT MEM_MILEAGE 
          FROM MEMBER
         WHERE SUBSTR(MEM_ADD1, 1, 2) = '충남';
        --
        SELECT MEM_ID AS 회원번호, 
               MEM_NAME AS 회원명,
               SUBSTR(MEM_ADD1, 1, 2) AS 거주지역,
               MEM_MILEAGE AS 마일리지
          FROM MEMBER
         WHERE MEM_MILEAGE > ANY(SELECT MEM_MILEAGE
                                   FROM MEMBER
                                  WHERE SUBSTR(MEM_ADD1, 1, 2) = '충남')
         ORDER BY 4;  