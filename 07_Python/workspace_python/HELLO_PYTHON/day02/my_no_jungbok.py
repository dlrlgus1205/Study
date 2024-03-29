from random import random
arr = [1, 2, 3, 4, 5]

for i in range(10) :
    rnd = int(random() * 5)
    
    a = arr[0]
    arr[0] = arr[rnd]
    arr[rnd] = a

print(arr[0], arr[1], arr[2])
