# 첫번째 숫자 >> 1
# 두번째 숫자 >> 4
# 1에서 4까지의 합은 10입니다

a = input("첫번째 숫자 >> ")
b = input("두번째 숫자 >> ")
c = 0

aa = int(a)
bb = int(b)

for i in range(aa, bb + 1):
    c += i
print("{}에서 {}까지의 합은 {}입니다".format(aa, bb, c))