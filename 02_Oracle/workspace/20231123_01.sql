2023-11-23-01

* 서브쿼리(SUBQUERY)
    - SQL 구문 안에 또 다른 SQL 구문이 포함된 형태
    - 많은 JOIN 연산을 대신할 수 있음
    - 알려지지 않은 조건에 근거한 값을 조회할 때 사용
    - INSERT, UPDATE, DELETE 와 같은 DML 문장과 SELECT 문, CREATE TABLE 문, VIEW 에서 사용
    - 메인 쿼리가 실행되기 전에 실행됨
    - 기술되는 위치에 따라
        . 일반서브쿼리(SELECT 절)
        . INLINE 서브쿼리(FROM 절 : 반드시 독립 실행돼야 함)
        . 중첩 서브쿼리(WHERE 절)
    - 메인쿼리와 서브쿼리의 사이의 참조 여부에 따라
        . 연관성 있는 서브쿼리, 연관성 없는 서브쿼리
    - 반환하는 행/열의 수에 따라 단일행/단일열, 단일행/다중열, 다중행/단일열, 다중행/다중열 로 구분
    - 서브쿼리는 특정 경우를 제외하고 '( )'에 기술해야 함
    - 연산자와 사용할 경우 연산자 오른쪽에 사용해야 함
    
    (사용예)
    사원테이블에서 평균급여보다 적은 급여를 받는 사원들을 조회하시오
    Alias 는 사원번호, 사원명, 급여, 평균급여
    
    1) 메인쿼리 : 사원번호, 사원명, 급여, 평사원번호, 사원명, 급여, 평균급여균급여 출력(조건 : 평균급여 이하)
    
    SELECT EMPLOYEE_ID AS 사원번호,
           EMP_NAME AS 사원명,
           SALARY AS 급여, 평균급여
      FROM HR.EMPLOYEES
     WHERE SALARY <= (서브쿼리 : 평균급여)
      
    2) 서브쿼리 : 평균급여 계산  
    SELECT AVG(SALARY)
      FROM HR.EMPLOYEES
      
    3) 결합
    
     SELECT EMPLOYEE_ID AS 사원번호,
           EMP_NAME AS 사원명,
           SALARY AS 급여,
           ROUND((SELECT AVG(SALARY)
                   FROM HR.EMPLOYEES)) AS 평균급여
      FROM HR.EMPLOYEES
     WHERE SALARY <= (SELECT AVG(SALARY)
                        FROM HR.EMPLOYEES);
                        
    (INLINE SUBQUERY 사용)
    SELECT A.EMPLOYEE_ID AS 사원번호,
           A.EMP_NAME AS 사원명,
           A.SALARY AS 급여,
           ROUND(B.ASAL) AS 평균급여
      FROM HR.EMPLOYEES A, (SELECT AVG(SALARY) AS ASAL
                              FROM HR.EMPLOYEES) B
     WHERE A.SALARY <= B.ASAL;
     
** 재고 수불테이블(REMAIN) 생성
------------------------------------------------------
컬럼명           데이터타입       제약사항      COMMIT
------------------------------------------------------
REMAIN_YEAR     CHAR(4)        PK          재고수불년도
PROD_ID         VARCHAR2(10)   PK&FK       상품코드
REMAIN_J_00     NUMBER(5)      0           기초재고
REMAIN_I        NUMBER(5)      0           입고수량
REMAIN_O        NUMBER(5)      0           출고수량
REMAIN_J_99     NUMBER(5)      0           현재고
REMAIN_DATE     DATE           SYSDATE     작업일

CREATE TABLE REMAIN(
       REMAIN_YEAR CHAR(4),
       PROD_ID     VARCHAR2(10),
       REMAIN_J_00 NUMBER(5) DEFAULT 0,
       REMAIN_I    NUMBER(5) DEFAULT 0,
       REMAIN_O    NUMBER(5) DEFAULT 0,
       REMAIN_J_99 NUMBER(5) DEFAULT 0,
       REMAIN_DATE DATE DEFAULT SYSDATE,
       
       CONSTRAINT PK_REMAIN PRIMARY KEY(REMAIN_YEAR, PROD_ID),
       CONSTRAINT FK_REMAIN_PROD FOREIGN KEY(PROD_ID)
       REFERENCES PROD(PROD_ID));