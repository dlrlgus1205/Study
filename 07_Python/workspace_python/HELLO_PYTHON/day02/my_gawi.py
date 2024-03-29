from random import random

rnd = random()

if rnd < 0.33 :
    print("가위", rnd)
elif rnd < 0.66 :
    print("바위", rnd)
else :
    print("보", rnd)