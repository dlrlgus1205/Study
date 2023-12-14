2023-11-16-01

3. TO_DATE(expr [, fmt])
    - 'expr' 자료를 날짜 형식의 자료로 변환
    - 사용하는 'fmt'는 TO_CHAR과 동일
    - 'fmt'는 'expr'이 형식이 지정된 날짜 형식인 경우 'expr'로 출력되는데 사용된 형식 지정 문자열을 기술하고 반환되는 데이터는 기본 날짜형 자료임
    
    (사용예)
    SELECT TO_DATE('20231116'),
           TO_DATE('20231116 오후', 'YYYYMMDD AM') + 10
      FROM DUAL;
      
    SELECT TO_DATE(20231116) FROM DUAL;
    
4. TO_NUMBER(expr [, fmt])
    - 문자열 'expr' 자료를 숫자 형식의 자료로 변환
    - 사용하는 'fmt'는 TO_CHAR과 동일
    - 'fmt'는 'expr'이 형식이 지정된 숫자 형식인 경우 'expr'로 출력되는데 사용된 형식 지정 문자열을 기술하고 반환되는 데이터는 기본 숫자형 자료임
    
    (사용예)
    SELECT TO_NUMBER('-1019'),
           -- TO_NUMBER(TO_DATE('20231116')) // 날짜 형식은 숫자로 변환활 수 없음
           TO_NUMBER('-1,019', '0,000'),
           TO_NUMBER('￦12,000', 'L99,999'),
           TO_NUMBER('<12,000>', '00,000PR'),
           TO_NUMBER('12.678')
      FROM DUAL;