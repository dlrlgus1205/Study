from random import random
import sys

from PyQt5 import uic
from PyQt5.Qt import QMessageBox
from PyQt5.QtWidgets import QApplication, QMainWindow


form_class = uic.loadUiType("./pyqt10.ui")[0]

rnd = int(random() * 100 + 1)
class WindowClass(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)
        # self.le_na.returnPressed.connect(self.myclick)

    def myclick(self) :
        sn = self.le.text()

        n = int(sn)
        new_txt = ""
        
        if n > rnd :
            new_txt += "{}\tDown\n".format(n)
        
        elif n == rnd :
            new_txt += "{}\t정답".format(n)
            QMessageBox.about(self, '정답', new_txt)
        
        elif n < rnd :
            new_txt += "{}\tUp\n".format(n)
        
        old_txt = self.te.toPlainText()
        self.te.setPlainText(old_txt + new_txt)
        
if __name__ == "__main__":
    app = QApplication(sys.argv)
    myWindow = WindowClass()
    myWindow.show()
    app.exec_()
