from random import random

rnd = random()
a = input("홀짝")

if rnd > 0.5 :
    print("홀", rnd)
else :
    print("짝", rnd)