from flask import Flask, jsonify, redirect
from flask.globals import request
from flask.templating import render_template

app = Flask(__name__)  # Flask 객체 생성
 
@app.route('/')
def main():
    return redirect('/static/fetch.html')

@app.route('/fetch1', methods=['POST'])
def fetch1():
    return jsonify(result = 1)

@app.route('/fetch2', methods=['POST'])
def fetch2():
    return jsonify(result = 2)

if __name__ == "__main__":  # 모듈이 실행 됨을 알림
    app.run(host="0.0.0.0", debug=True)