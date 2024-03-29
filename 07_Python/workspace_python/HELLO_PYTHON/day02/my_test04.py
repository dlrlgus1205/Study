# 가위바위보 입력 >> 가위
# 나 : 가위
# 컴 : 가위
# 결과 : 비김
from random import random

a = input("가위바위보 입력 >>")
b = ""
c = ""

rnd = random()

if rnd > 0.66 :
    b = "가위"
    if a == b :
        c = "무승부"
    elif a == "바위" :
        c = "승리"
    elif a == "보" :
        c = "패배"
        
elif rnd > 0.33 :
    b = "바위"
    if a == b :
        c = "무승부"
    elif a == "가위" :
        c = "패배"
    elif a == "보" :
        c = "승리"
else :
    b = "보"
    if a == b :
        c = "무승부"
    elif a == "바위" :
        c = "패배"
    elif a == "가위" :
        c = "승리"
        
print("나 : ", a)
print("컴 : ", b)
print("결과 : ", c)