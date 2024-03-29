from flask import Flask, jsonify, redirect
from flask.globals import request
from day15.dao_exam import DaoExam

app = Flask(__name__)  # Flask 객체 생성
 
@app.route('/')
def main():
    return redirect('/static/exam.html')

@app.route('/examlist', methods=['POST'])
def examlist():
    de = DaoExam()
    list = de.selectList()
    
    return jsonify(list = list)

@app.route('/examone', methods=['POST'])
def examone():
    data = request.get_json()
    e_id = data['e_id']
    de = DaoExam()
    vo = de.selectOne(e_id)
    
    return jsonify(vo = vo)

@app.route('/examadd', methods=['POST'])
def examadd():
    data = request.get_json()
    e_id = data['e_id']
    e_que = data['e_que']
    e_ans1 = data['e_ans1']
    e_ans2 = data['e_ans2']
    e_ans3 = data['e_ans3']
    e_ans4 = data['e_ans4']
    e_ans = data['e_ans']
    de = DaoExam()
    cnt = de.insert(e_id, e_que, e_ans1, e_ans2, e_ans3, e_ans4, e_ans)
    
    return jsonify(cnt = cnt)

@app.route('/exammod', methods=['POST'])
def exammod():
    data = request.get_json()
    e_id = data['e_id']
    e_que = data['e_que']
    e_ans1 = data['e_ans1']
    e_ans2 = data['e_ans2']
    e_ans3 = data['e_ans3']
    e_ans4 = data['e_ans4']
    e_ans = data['e_ans']
    de = DaoExam()
    cnt = de.insert(e_id, e_que, e_ans1, e_ans2, e_ans3, e_ans4, e_ans)
    
    return jsonify(cnt = cnt)

@app.route('/examdel', methods=['POST'])
def examdel():
    data = request.get_json()
    e_id = data['e_id']
    de = DaoExam()
    cnt = de.delete(e_id)
    
    return jsonify(cnt = cnt)
    
@app.route('/ajax', methods=['POST'])
def ajax():
    data = request.get_json()
    print(data['menu'])

    return jsonify(result = "success")

if __name__ == "__main__":  # 모듈이 실행 됨을 알림
    app.run(host="0.0.0.0", debug=True)