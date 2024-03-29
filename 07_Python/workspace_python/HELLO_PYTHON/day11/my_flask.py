from flask.app import Flask
from flask.globals import request
from flask.templating import render_template

app = Flask(__name__)  # Flask 객체 생성
 
@app.route('/')
def main():
    return 'Hello World!'

if __name__ == "__main__":  # 모듈이 실행 됨을 알림
    app.run(host="0.0.0.0", debug=True)