2023-11-20-01

* 순위함수
    - 오라클에서 순위를 반환할 때 사용하는 함수로 RANK OVER, DENSE_RANK OVER, ROW_NUMBER OVER 함수가 제공됨
    - RANK : 우리 보통 사용하는 등위 제공(같은 값이면 같은 순위 부여, 동일 등수가 복수개인 경우 다음 등수는 현재등수 + 같은 값의 갯수)
      ex) 95, 90, 85, 85, 85, 70, 60
          1   2   3   3   3   6   7
    - DENSE_RANK : 동일 값이면 동일 순위 부여하며 다음 자료는 같은 자료의 수에 관계없이 차례대로 1씩 증가된 값을 부여
      ex) 95, 90, 85, 85, 85, 70, 60
          1   2   3   3   3   4   5
    - ROW_NUMBER : 동일 값에 상관없이 차례대로 1씩 증가되는 값을 부여
      ex) 95, 90, 85, 85, 85, 70, 60
          1   2   3   4   5   6   7
    - 순위함수는 SELECT 절에 사용됨
    
    [사용형식]
    RANK() OVER(ORDER BY 컬럼명1[, 컬럼명2, ...] [DESC]) [AS 컬럼별칭]
    
    (사용예)
    회원테이블에서 회원들의 보유 마일리지가 많은 회원들부터 순위를 부여하시오
    Alias 는 회원번호, 회원명, 마일리지, 순위
    
    (RANK OVER)
    SELECT MEM_ID AS 회원번호,
           MEM_NAME AS 회원명,
           MEM_MILEAGE AS 마일리지,
           RANK() OVER(ORDER BY MEM_MILEAGE DESC) AS 순위
      FROM MEMBER;
      
    (DENSE_RANK OVER)
    SELECT MEM_ID AS 회원번호,
           MEM_NAME AS 회원명,
           MEM_MILEAGE AS 마일리지,
           DENSE_RANK() OVER(ORDER BY MEM_MILEAGE DESC) AS 순위
      FROM MEMBER;
      
    (ROW_NUMBER)
     SELECT MEM_ID AS 회원번호,
           MEM_NAME AS 회원명,
           MEM_MILEAGE AS 마일리지,
           ROW_NUMBER() OVER(ORDER BY MEM_MILEAGE DESC) AS 순위
      FROM MEMBER;
      
    ** 동일 마일리지를 보유한 경우 나이가 적은 회원부터 순위 부여
      
       SELECT MEM_ID AS 회원번호,
           MEM_NAME AS 회원명,
           MEM_MILEAGE AS 마일리지, 
            EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM MEM_BIR) AS 나이,
           RANK() OVER(ORDER BY MEM_MILEAGE DESC, 
           EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM MEM_BIR) ASC) AS 순위
      FROM MEMBER;
      
    ** 그룹별 순위
    - RANK(), DENSE_RANK(), ROW_NUMBER() 를  사용하여 각 그룹 내의 순위를 부여할 수 있음
      
    [사용형식]
    RANK() | DENSE_RANK | ROW_NUMBER() OVER
        (PARTITION BY 컬럼명1[, 컬럼명2, ...] ORDER BY 컬럼명1[, 컬럼명2, ...] [DESC]
    . 'PARTITION BY' 에 의해 그룹이 설정 되고 각 그룹에서 'ORDER BY' 에 의해 데이터가 정렬된 후 순위를 부여함
    
    (사용예)
    HR계정에서 부서별로 급여에 따라 순위를 부여하시오
    급여가 많은 사람부터 순위 부여
    Alias 는 사원번호, 사원명, 부서번호, 급여, 순위
    
    SELECT EMPLOYEE_ID AS 사원번호,
           EMP_NAME AS 사원명,
           DEPARTMENT_ID AS 부서번호, 
           SALARY AS 급여, 
           RANK() OVER(PARTITION BY DEPARTMENT_ID
                       ORDER BY SALARY DESC) AS 순위
      FROM HR.EMPLOYEES;