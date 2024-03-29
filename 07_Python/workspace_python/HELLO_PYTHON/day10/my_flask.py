from flask.app import Flask
from flask.globals import request
from flask.templating import render_template
from day10.dao_mem import Daomem

app = Flask(__name__)  # Flask 객체 생성
 
@app.route('/')
@app.route('/mem_list')
def mem_list():
    dm = Daomem()
    list = dm.selectList()
    return render_template('mem_list.html',list=list)

@app.route('/mem_detail')
def mem_detail():
    dm = Daomem()
    m_id = request.args.get('m_id')
    vo = dm.selectOne(m_id)
    return render_template('mem_detail.html',vo=vo)

@app.route('/mem_mod')
def mem_mod():
    dm = Daomem()
    m_id = request.args.get('m_id')
    vo = dm.selectOne(m_id)
    return render_template('mem_mod.html',vo=vo)

@app.route('/mem_mod_act', methods=['POST'])
def mem_mod_act():
    m_id = request.form['m_id']
    m_name = request.form['m_name']
    m_tel = request.form['m_tel']
    m_email = request.form['m_email']
    dm = Daomem()
    cnt = dm.update(m_id, m_name, m_tel, m_email)
    return render_template('mem_mod_act.html',cnt=cnt)

@app.route('/mem_add')
def mem_add():
    return render_template('mem_add.html')

@app.route('/mem_add_act', methods=['POST'])
def mem_add_act():
    m_id = request.form['m_id']
    m_name = request.form['m_name']
    m_tel = request.form['m_tel']
    m_email = request.form['m_email']
    dm = Daomem()
    cnt = dm.insert(m_id, m_name, m_tel, m_email)
    return render_template('mem_add_act.html',cnt=cnt)

@app.route('/mem_del')
def mem_del():
    m_id = request.args.get('m_id')
    dm = Daomem()
    cnt = dm.delete(m_id)
    return render_template('mem_del.html',cnt=cnt)

if __name__ == "__main__":
    app.run(host="0.0.0.0",debug=True) 