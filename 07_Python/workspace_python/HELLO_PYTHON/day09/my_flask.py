from flask.app import Flask
from flask.globals import request
from flask.templating import render_template
from day08.dao_emp import DaoEmp
from day07.ora_delete import e_id

app = Flask(__name__)  # Flask 객체 생성
 
@app.route('/')
@app.route('/emp_list')
def emp_list():
    de = DaoEmp()
    list = de.selectList()
    return render_template('emp_list.html',list=list)

@app.route('/emp_detail')
def emp_detail():
    de = DaoEmp()
    e_id = request.args.get('e_id')
    vo = de.selectOne(e_id)
    return render_template('emp_detail.html',vo=vo)

@app.route('/emp_mod')
def emp_mod():
    de = DaoEmp()
    e_id = request.args.get('e_id')
    vo = de.selectOne(e_id)
    return render_template('emp_mod.html',vo=vo)

@app.route('/emp_mod_act', methods=['POST'])
def emp_mod_act():
    e_id = request.form['e_id']
    e_name = request.form['e_name']
    gen = request.form['gen']
    addr = request.form['addr']
    de = DaoEmp()
    cnt = de.update(e_id, e_name, gen, addr)
    return render_template('emp_mod_act.html',cnt=cnt)

@app.route('/emp_add')
def emp_add():
    return render_template('emp_add.html')

@app.route('/emp_add_act', methods=['POST'])
def emp_add_act():
    e_id = request.form['e_id']
    e_name = request.form['e_name']
    gen = request.form['gen']
    addr = request.form['addr']
    de = DaoEmp()
    cnt = de.insert(e_id, e_name, gen, addr)
    return render_template('emp_add_act.html',cnt=cnt)

@app.route('/emp_del')
def emp_del():
    e_id = request.args.get('e_id')
    de = DaoEmp()
    cnt = de.delete(e_id)
    return render_template('emp_del.html',cnt=cnt)

if __name__ == "__main__":
    app.run(host="0.0.0.0",debug=True) 