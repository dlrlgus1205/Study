class Animal:
    def __init__(self):
        self.x = 0
        self.y = 0
        
    def moveX(self, x):
        self.x += x
    
    def moveY(self, y):
        self.y += y
    
ani = Animal()

if __name__ == '__main__':
    ani = Animal()
    print("1",ani.x)
    print("1",ani.y)
    ani.moveX(5)
    ani.moveY(-3)
    print("1",ani.x)
    print("1",ani.y)