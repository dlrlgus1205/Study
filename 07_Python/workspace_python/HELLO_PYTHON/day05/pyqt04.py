import sys
from PyQt5 import uic
from PyQt5.QtWidgets import QApplication, QMainWindow

form_class = uic.loadUiType("./pyqt04.ui")[0]


class WindowClass(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)

    def myclick(self) :
        n = self.le.text()
        num = int(n)
        txt = ""
        # txt += "{} * {} = {}\n".format(num, 1, num * 1)
        # txt += "{} * {} = {}\n".format(num, 2, num * 2)
        # txt += "{} * {} = {}\n".format(num, 3, num * 3)
        # txt += "{} * {} = {}\n".format(num, 4, num * 4)
        # txt += "{} * {} = {}\n".format(num, 5, num * 5)
        # txt += "{} * {} = {}\n".format(num, 6, num * 6)
        # txt += "{} * {} = {}\n".format(num, 7, num * 7)
        # txt += "{} * {} = {}\n".format(num, 8, num * 8)
        # txt += "{} * {} = {}\n".format(num, 9, num * 9)
        
        for i in range(1, 10) :
            txt += "{} * {} = {}\n".format(num, i, num * i)
        
        self.te.setText(txt)
        
if __name__ == "__main__":
    app = QApplication(sys.argv)
    myWindow = WindowClass()
    myWindow.show()
    app.exec_()
