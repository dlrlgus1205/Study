from day03.my_oop01 import Animal
class Human(Animal):
    def __init__(self):
        super().__init__()
        self.skill_cook = 0
        
    def element(self):
        self.skill_cook += 1
            
if __name__ == '__main__':
    hum = Human()
    print(hum.skill_cook)
    print(hum.x)
    print(hum.y)
    hum.element()
    hum.moveX(5)
    hum.moveY(-3)
    print(hum.skill_cook)
    print(hum.x)
    print(hum.y)