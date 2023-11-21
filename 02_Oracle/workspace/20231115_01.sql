2023-11-15-01

(사용예)
회원테이블에서 회원의 보유 마일리지가 다음 조건으로 구간을 설정한 경우 어느 구간에 속한지를 조회하시오
    . 구간의 범위 : 1000 ~ 8000
    . 구간의 갯수 : 8개
    . Alias 는 회원번호, 회원명, 마일리지, 구간의 INDEX

SELECT MEM_ID AS 회원번호,
       MEM_NAME AS 회원명,
       MEM_MILEAGE AS 마일리지,
       WIDTH_BUCKET(MEM_MILEAGE, 1000, 8000, 8) AS "구간의 INDEX"
  FROM MEMBER;

SELECT WIDTH_BUCKET(100, 100, 499, 1),
       WIDTH_BUCKET(499, 100, 499, 1)
  FROM DUAL;
  
(사용예)
회원테이블에서 마일리지로 다음 조건으로 구간을 설정한 후 가장 큰 구간값을 1등급으로 부여하고 차례대로 등급을 부여하시오
    . 구간의 범위 : 1000 ~ 8000
    . 구간의 갯수 : 8개
    . Alias 는 회원번호, 회원명, 마일리지, 회원등급

SELECT MEM_ID AS 회원번호,
       MEM_NAME AS 회원명,
       MEM_MILEAGE AS 마일리지,
       10 - WIDTH_BUCKET(MEM_MILEAGE, 1000, 8000, 8) ||'등급' AS "구간의 INDEX"
  FROM MEMBER;
