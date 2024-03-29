from random import random
import sys

from PyQt5 import uic
from PyQt5.Qt import QMessageBox
from PyQt5.QtWidgets import QApplication, QMainWindow


form_class = uic.loadUiType("./pyqt11.ui")[0]

rnd = int(random() * 100 + 1)
class WindowClass(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)
    
    def star(self, cnt):
        ret = ""
        for i in range(cnt):
            ret += "*"
        ret += "\n"
        return ret

    def myclick(self) :
        f = self.le_first.text()
        l = self.le_last.text()
        
        fn = int(f)
        ln = int(l)
        
        txt = ""
        
        for i in range(fn, ln +1) :
            txt += self.star(i)
        
        self.pte.setPlainText(txt)
    
if __name__ == "__main__":
    app = QApplication(sys.argv)
    myWindow = WindowClass()
    myWindow.show()
    app.exec_()
