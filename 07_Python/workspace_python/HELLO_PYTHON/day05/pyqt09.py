import sys
from PyQt5 import uic
from PyQt5.QtWidgets import QApplication, QMainWindow
from random import random

form_class = uic.loadUiType("./pyqt09.ui")[0]


class WindowClass(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)
        self.le_na.returnPressed.connect(self.myclick)

    def myclick(self) :
        na = self.le_na.text()
        rnd = random()
        
        if rnd > 0.66 :
            self.le_com.setText("보")
            if na == "보" :
                self.le_res.setText("무승부")
            elif na == "바위" : 
                self.le_res.setText("패배")
            elif na == "가위" : 
                self.le_res.setText("승리")
                
        elif rnd > 0.33 :
            self.le_com.setText("바위")
            if na == "바위" :
                self.le_res.setText("무승부")
            elif na == "가위" : 
                self.le_res.setText("패배")
            elif na == "보" : 
                self.le_res.setText("승리")
                    
        else :
            self.le_com.setText("가위")
            if na == "가위" :
                self.le_res.setText("무승부")
            elif na == "보" : 
                self.le_res.setText("패배")
            elif na == "바위" : 
                self.le_res.setText("승리")
        
if __name__ == "__main__":
    app = QApplication(sys.argv)
    myWindow = WindowClass()
    myWindow.show()
    app.exec_()
