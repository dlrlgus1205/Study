from random import random

rnd = random()

a = input("홀짝 입력")
b = ""
c = ""

if rnd > 0.5 :
    b = "홀"
else :
    b = "짝"
    
if a == b :
    c = "승리"
else :
    c = "패배"
    
print(a)
print(b, rnd)
print(c)