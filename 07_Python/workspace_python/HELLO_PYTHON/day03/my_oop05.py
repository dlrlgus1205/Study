class Dog:
    def __init__(self):
        self.name = "바둑이"
        
    def bark(self):
        print("멍멍")
        
    def __del__(self):
        print("소멸자")
        
    def __str__(self):
        return "Dog" + self.name
            
if __name__ == '__main__':
    dog = Dog()
    print(dog.name)
    dog.bark()