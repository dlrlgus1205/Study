# 첫번째 숫자 >> 1
# 두번째 숫자 >> 10
# 배수 입력 >> 5
# 1에서 10까지 5의 배수의 합은 15입니다

a = input("첫번째 숫자 >> ")
b = input("두번째 숫자 >> ")
c = input("배수 입력 >> ")
d = 0

aa = int(a)
bb = int(b)
cc = int(c)

for i in range(aa, bb + 1) :
    if i % cc == 0 :
        d += i

print("{}에서 {}까지 {}의 배수의 합은 {}입니다".format(aa, bb, cc, d))