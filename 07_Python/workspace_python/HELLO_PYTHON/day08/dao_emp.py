import cx_Oracle

class DaoEmp :
    def __init__(self):
        self.con = cx_Oracle.connect('python/py@localhost:1521/xe')
        self.cur = self.con.cursor()
        
    def selectList(self):
        self.cur.execute("select e_id, e_name, gen, addr from emp")
        
        rows = self.cur.fetchall()
        list = []
        for i in rows :
            list.append({'e_id' : i[0], 'e_name' : i[1], 'gen' : i[2], 'addr' : i[3]})
        return list
    
    def __del__(self):
        self.cur.close()
        self.con.close()

if __name__ == '__main__':
        de = DaoEmp()
        list = de.selectList()
        print("list", list)