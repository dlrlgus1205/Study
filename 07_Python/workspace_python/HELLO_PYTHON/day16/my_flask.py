from flask import Flask,jsonify,redirect
from flask.globals import request
from flask.templating import render_template
from runpy import _TempModule
from day16.dao_exam import DaoExam

 
app = Flask(__name__)
 
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
    print("examone")
    meta = request.get_json()
    e_id = meta['data']['e_id']
    print(e_id)
    de = DaoExam()
    vo = de.selectOne(e_id)
    return jsonify(vo = vo)


@app.route('/examadd', methods=['POST'])
def examadd():
    meta = request.get_json()
    e_id = meta['data']['e_id']
    que = meta['data']['que']
    ans1 = meta['data']['ans1']
    ans2 = meta['data']['ans2']
    ans3 = meta['data']['ans3']
    ans4 = meta['data']['ans4']
    ans = meta['data']['ans']

    
    de = DaoExam()
    cnt = de.insert(e_id, que, ans1, ans2, ans3, ans4, ans)
    return jsonify(cnt = cnt)

@app.route('/exammod', methods=['POST'])
def exammod():
    meta = request.get_json()
    e_id = meta['data']['e_id']
    que = meta['data']['que']
    ans1 = meta['data']['ans1']
    ans2 = meta['data']['ans2']
    ans3 = meta['data']['ans3']
    ans4 = meta['data']['ans4']
    ans = meta['data']['ans']
    de = DaoExam()
    cnt = de.update(e_id, que, ans1, ans2, ans3, ans4, ans)
    return jsonify(cnt = cnt)

@app.route('/examdel', methods=['POST'])
def examdel():
    meta = request.get_json()
    e_id = meta['data']['e_id']
    de = DaoExam()
    cnt = de.delete(e_id)
    return jsonify(cnt = cnt)

@app.route('/ajax', methods=['POST'])
def ajax():
    data = request.get_json()
    print(data['menu'])
    return jsonify(result = "success")





if __name__ == '__main__':
    app.run(host="0.0.0.0",debug=True)
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    