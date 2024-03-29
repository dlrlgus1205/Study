from flask import Flask, jsonify
from flask.globals import request
from flask.templating import render_template

app = Flask(__name__)  # Flask 객체 생성
 
@app.route('/')
def main():
    return 'Hello World!'

@app.route('/ajax', methods=['POST'])
def ajax():
    data = request.get_json()
    print(data['menu'])

    return jsonify(result = "success")

@app.route('/fetch', methods=['POST'])
def fetch():
    # data = request.get_json()
    # print(data['menu'])
    menu = request.form['menu']
    print(menu)
    
    return jsonify(result = "success")

@app.route('/axios', methods=['POST'])
def axios():
    meta = request.get_json()
    print(meta['data']['menu'])

    return jsonify(result = "success")

if __name__ == "__main__":  # 모듈이 실행 됨을 알림
    app.run(host="0.0.0.0", debug=True)