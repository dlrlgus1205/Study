from random import random


for i in range(2000):
    jumsu = int(random() * 100 + 1)
    print(jumsu)
    if jumsu == 0 :
        break