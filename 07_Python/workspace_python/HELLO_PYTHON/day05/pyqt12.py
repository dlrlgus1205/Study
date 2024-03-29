from random import random
import sys

from PyQt5 import uic
from PyQt5.Qt import QMessageBox
from PyQt5.QtWidgets import QApplication, QMainWindow


form_class = uic.loadUiType("./pyqt12.ui")[0]

arr_com = list(range(1, 9 + 1))
for i in range(1000) :
    rnd = int(random() * 8)
    temp = arr_com[0]
    arr_com[0] = arr_com[rnd]
    arr_com[rnd] = temp
class WindowClass(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)
    
    def myclick(self) :
        sn = self.le.text()
        
        sn1 = sn[0:1]
        sn2 = sn[1:2]
        sn3 = sn[2:3]
        
        n1 = int(sn1)
        n2 = int(sn2)
        n3 = int(sn3)
        
        new_txt = ""
        old_txt = self.te.toPlainText()
        
        s = 0
        b = 0
    
        if n1 == arr_com[0] :
            s += 1
        elif n1 == arr_com[1] :
            b += 1
        elif n1 == arr_com[2] :
            b += 1
            
        if n2 == arr_com[1] :
            s += 1
        elif n2 == arr_com[0] :
            b += 1
        elif n2 == arr_com[2] :
            b += 1
            
        if n3 == arr_com[2] :
            s += 1
        elif n3 == arr_com[0] :
            b += 1
        elif n3 == arr_com[1] :
            b += 1
        
        new_txt = sn + "\t {}S {}B \n".format(s, b)
        
        self.te.setPlainText(old_txt + new_txt)
        
        if s == 3:
            QMessageBox.about(self, '정답', new_txt)
            
if __name__ == "__main__":
    app = QApplication(sys.argv)
    myWindow = WindowClass()
    myWindow.show()
    app.exec_()
