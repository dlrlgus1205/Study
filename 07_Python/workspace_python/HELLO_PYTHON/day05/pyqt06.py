import sys
from PyQt5 import uic
from PyQt5.QtWidgets import QApplication, QMainWindow
from random import random

form_class = uic.loadUiType("./pyqt06.ui")[0]


class WindowClass(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)

    def myclick(self) :
        na = self.le_na.text()
        rnd = random()
        
        if rnd > 0.5 :
            self.le_com.setText("홀")
            if na == "홀" :
                self.le_res.setText("승리")
            else :
                self.le_res.setText("패배")
        else :
            self.le_com.setText("짝")
            if na == "짝" :
                self.le_res.setText("승리")
            else :
                self.le_res.setText("패배")
        
if __name__ == "__main__":
    app = QApplication(sys.argv)
    myWindow = WindowClass()
    myWindow.show()
    app.exec_()
