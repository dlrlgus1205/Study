import sys
from PyQt5 import uic
from PyQt5.QtWidgets import QApplication, QMainWindow
from random import random
from PyQt5.Qt import QMessageBox

form_class = uic.loadUiType("./pyqt08.ui")[0]


class WindowClass(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)
        
    def myclick(self) :
        f = self.le1.text()
        l = self.le2.text()
        
        fn = int(f)
        ln = int(l)
        
        s = 0
        
        for i in range(fn, ln + 1) :
            s += i
        
        self.le3.setText(str(s))
        
if __name__ == "__main__":
    app = QApplication(sys.argv)
    myWindow = WindowClass()
    myWindow.show()
    app.exec_()
