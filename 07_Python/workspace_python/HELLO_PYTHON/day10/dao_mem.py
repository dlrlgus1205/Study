import cx_Oracle

class Daomem :
    def __init__(self):
        self.con = cx_Oracle.connect('python/py@localhost:1521/xe')
        self.cur = self.con.cursor()
        
    def selectList(self):
        self.cur.execute("select m_id, m_name, m_tel, m_email from mem")
        
        rows = self.cur.fetchall()
        list = []
        for i in rows :
            list.append({'m_id' : i[0], 'm_name' : i[1], 'm_tel' : i[2], 'm_email' : i[3]})
        return list
    
    def selectOne(self, m_id):
        sql = f"""
            select
                m_id, m_name, m_tel, m_email
            from
                mem
            where
                m_id = '{m_id}'
        """
        
        self.cur.execute(sql)
        vo = self.cur.fetchone()
        print(vo)
        return {'m_id' : vo[0], 'm_name' : vo[1], 'm_tel' : vo[2], 'm_email' : vo[3]}
    
    def insert(self, m_id, m_name, m_tel, m_email):
        sql = f"""
            insert into mem
                (m_id, m_name, m_tel, m_email)
            values
                ('{m_id}','{m_name}','{m_tel}','{m_email}')
        """
        
        self.cur.execute(sql)
        self.con.commit()
        
        return self.cur.rowcount
    
    def update(self, m_id, m_name, m_tel, m_email):
        sql = f"""
            update mem set
                m_name = '{m_name}',
                m_tel = '{m_tel}',
                m_email ='{m_email}'
            where m_id = '{m_id}'
        """
    
        self.cur.execute(sql)
        self.con.commit()
        
        return self.con.rowcount
    
    def delete(self, m_id):
        sql = f"""
            delete from mem
            where m_id = '{m_id}'
        """
        
        self.cur.execute(sql)
        self.con.commit()
        
        return self.con.rowcount
        
    def __del__(self):
        self.cur.close()
        self.con.close()

if __name__ == '__main__':
        de = Daomem()
        cnt = de.delete('5', '5', '5', '5')
        print("cnt", cnt)