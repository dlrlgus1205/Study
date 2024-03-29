import sys
from PyQt5 import uic
from PyQt5.QtWidgets import QApplication, QMainWindow

form_class = uic.loadUiType("./pyqt03.ui")[0]


class WindowClass(QMainWindow, form_class):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.myclick)

    def myclick(self) :
        fn = self.pte01.toPlainText()
        ln = self.pte02.toPlainText()
        
        mul = int(fn) * int(ln)
        
        self.pte03.setPlainText(str(mul))

if __name__ == "__main__":
    app = QApplication(sys.argv)
    myWindow = WindowClass()
    myWindow.show()
    app.exec_()
