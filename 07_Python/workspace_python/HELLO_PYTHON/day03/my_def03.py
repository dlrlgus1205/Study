from random import random

def randomHoll():
    rnd = random()
    
    if rnd > 0.5 :
        return "홀"
    else :
        return "짝"

com = randomHoll()
print("com", com)