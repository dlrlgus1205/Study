class Trump :
    def __init__(self):
        self.money = 1000
    
    def you_fire(self):
        self.money += 1

class Biden :
    def __init__(self):
        self.memory = 100
        
    def alz(self):
        self.memory /= 2
        
class You(Trump, Biden) : 
    def __init__(self):
        Trump.__init__(self)
        Biden.__init__(self)
        
you = You()

print(you.money)
print(you.memory)

you.you_fire()
you.alz()

print(you.money)
print(you.memory)