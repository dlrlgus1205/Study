# 출력할 단수를 입력하세요 4
# 4 * 1 = 4
# 4 * 2 = 8
# 생략
# 4 * 9 = 36

gugu = input("단 입력")
arr = list(range(1,10))
dan = 0

for i in arr :
    dan = int(gugu) * i
    print(gugu, "*", i, "=", dan)  