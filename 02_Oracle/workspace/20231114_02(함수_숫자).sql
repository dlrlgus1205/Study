2023-11-14-02

4. FLOOR, CEIL
    - 주어진 수와 가장 가까운 정수를 반환
    - 금액에 관련된 급여, 세금 등의 항목에 주로 사용
    
    [사용형식]
    FLOOR(n)
        . n과 같거나 작은 수 중 가장 큰 수
    CEIL(n)
        . n과 같거나 큰 수 중 가장 작은 수
        
    (사용예)
    SELECT FLOOR(20.99), FLOOR(200), FLOOR(-20.99) FROM DUAL;
    
    SELECT CEIL(20.99), CEIL(200), CEIL(-20.99) FROM DUAL;
    
5. MOD, REMAINDER
    - 나머지를 구하여 반환
    
    [사용형식]
    MOD(n, m)
        . 주어진 데이터 n을 m으로 나눈 나머지 반환
        . 내부적으로 FLOOR 함수가 사용
        
        ex) MOD(10, 3)
            = 10 - 3 * FLOOR(10 / 3)
            = 10 - 3 * FLOOR(3.3333..)
            = 10 - 3 * 3
            = 1
    REMAINDER(n, m)
        . 주어진 데이터 n을 m으로 나눈 나머지 반환
        . 내부적으로 ROUND 함수가 사용
        . 나머지가 젯수의 절반보다 크면 다음 몫이 되기 위하여 더해져야할 수가 음수로 반환
        
        ex) REMAINDER(20, 6)
            = 20 - 6 * ROUND(20 / 6)
            = 20 - 6 * ROUND(3.3333..)
            = 20 - 6 * 3
            = 2(MOD와 동일)
            
            REMAINDER(23, 6)
            = 23 - 6 * ROUND(23 / 6)
            = 23 - 6 * ROUND(3.8333..)
            = 23 - 6 * 4
            = -1

    SELECT MOD(20, 6), MOD(23, 6),
           REMAINDER(20, 6), REMAINDER(23, 6)
      FROM DUAL;
      
6. WIDTH_BUCKET
    - 구간값을 반환
    
    [사용형식]
    WIDTH_BUCKET(n, min, max, bcnt)
        - min에서 max를 bcnt갯수의 구간으로 나눌 때 주어진 수 n이 속한 구간의 순번(index)를 반환
        - 주의할 점
            . n이 각 구간에 포함되는 것을 판단할 때 min <= n < max
              즉, max는 구간 값에 포함 되지 않음
            . 반환 되는 구간의 갯수 bcnt + 2개(min보다 작은 값은 0번, max보다 큰 값은 bcnt + 1번 반환)