--1. 사용자 생성 및 권한 부여
/*
    1) 사용자 생성
        CREATE USER 사용자명 IDENTIFIED BY 암호;
    2) 권한 부여
        grant 권한명[, 권한명, ...] TO 사용자명;
            - 권한명 : RESOURCE, CONNECT, DBA, ...
*/
    CREATE USER LGH96 IDENTIFIED BY java;
    GRANT RESOURCE, CONNECT, DBA TO LGH96;

2. 사용자 계정 변경
    -ALTER USER 명령 사용
    
** HR 계정 활성화
    ALTER USER HR ACCOUNT UNLOCK;
    ALTER USER HR IDENTIFIED BY java;