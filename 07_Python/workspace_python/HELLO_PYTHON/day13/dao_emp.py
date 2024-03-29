import cx_Oracle

class DaoEmp :
    def __init__(self):
        self.con = cx_Oracle.connect('python/py@localhost:1521/xe')
        self.cur = self.con.cursor()
        
    def selectList(self):
        self.cur.execute("select e_id, e_name, gen, addr from emp order by e_id desc")
        
        rows = self.cur.fetchall()
        list = []
        for i in rows :
            list.append({'e_id' : i[0], 'e_name' : i[1], 'gen' : i[2], 'addr' : i[3]})
        return list
    
    def selectOne(self, e_id):
        sql = f"""
            select
                e_id, e_name, gen, addr
            from
                emp
            where
                e_id = '{e_id}'
        """
 
        self.cur.execute(sql)
        vo = self.cur.fetchone()
        print(vo)
        return {'e_id' : vo[0], 'e_name' : vo[1], 'gen' : vo[2], 'addr' : vo[3]}
    
    def insert(self, e_id, e_name, gen, addr):
        sql = f"""
            insert into emp
                (e_id, e_name, gen, addr)
            values
                ('{e_id}','{e_name}','{gen}','{addr}')
        """
        
        self.cur.execute(sql)
        self.con.commit()
        
        return self.cur.rowcount
    
    def update(self, e_id, e_name, gen, addr):
        sql = f"""
            update emp set
                e_name = '{e_name}',
                gen = '{gen}',
                addr ='{addr}'
            where e_id = '{e_id}'
        """
    
        self.cur.execute(sql)
        self.con.commit()
        
        return self.con.rowcount
    
    def delete(self, e_id):
        sql = f"""
            delete from emp
            where e_id = '{e_id}'
        """
        
        self.cur.execute(sql)
        self.con.commit()
        
        return self.con.rowcount
        
    def __del__(self):
        self.cur.close()
        self.con.close()

if __name__ == '__main__':
        de = DaoEmp()
        cnt = de.delete('5', '5', '5', '5')
        print("cnt", cnt)