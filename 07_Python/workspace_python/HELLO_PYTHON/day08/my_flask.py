from flask.app import Flask
from flask.globals import request
from flask.templating import render_template

app = Flask(__name__)  # Flask 객체 생성
 
@app.route('/')
def main():
    return '<h1>Hello World!</h1>'

@app.route('/param')
def param():
    menu = request.args.get('menu',default="탕수육")
    print(menu)
    return 'param:'+menu

@app.route('/post', methods = ['POST','GET'])
def post():
    menu = request.form['menu']
    return 'post :'+menu

@app.route('/forw')
def forw():
    a = "홍길동"
    b = ["전우치", "임꺽정"]
    c = [
        {'e_id':1, 'e_name':1, 'gen':1, 'addr':1},
        {'e_id':2, 'e_name':2, 'gen':2, 'addr':2}
    ]
    return render_template('forw.html', a=a, b=b,c=c)
 
@app.route('/emp')
def emp():
    
    return render_template("emp.html")

if __name__ == "__main__":  # 모듈이 실행 됨을 알림
    app.run(host="0.0.0.0", debug=True)