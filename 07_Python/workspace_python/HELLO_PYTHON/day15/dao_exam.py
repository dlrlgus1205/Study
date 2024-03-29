import sqlite3

class DaoExam:
    def __init__(self):
        self.con = sqlite3.connect("exam.db")
        self.cur = self.con.cursor()
    
    def selectList(self):
        sql = """
            select
               e_id, e_que, e_ans1, e_ans2, e_ans3, e_ans4, e_ans
            from
                exam
        """
        
        self.cur.execute(sql)
        list = self.cur.fetchall()
        
        ret = []
        for e in list:
            ret.append({'e_id' : e[0], 'e_que' : e[1], 'e_ans1' : e[2], 'e_ans2' : e[3], 'e_ans3' : e[4], 'e_ans4' : e[5], 'e_ans' : e[6]})
            
        return ret
    
    def selectOne(self, e_id):
        sql = f"""
            select
               e_id, e_que, e_ans1, e_ans2, e_ans3, e_ans4, e_ans
            from
                exam
            where
                e_id = '{e_id}'
        """
        
        self.cur.execute(sql)
        vo = self.cur.fetchone()
        
        return ({'e_id' : vo[0], 'e_que' : vo[1], 'e_ans1' : vo[2], 'e_ans2' : vo[3], 'e_ans3' : vo[4], 'e_ans4' : vo[5], 'e_ans' : vo[6]})
    
    def insert(self, e_id, e_que, e_ans1, e_ans2, e_ans3, e_ans4, e_ans):
        sql = f"""
            insert into exam
                (e_id, e_que, e_ans1, e_ans2, e_ans3, e_ans4, e_ans)
            values
                ('{e_id}', '{e_que}', '{e_ans1}', '{e_ans2}', '{e_ans3}', '{e_ans4}', '{e_ans}')
        """
        
        self.cur.execute(sql)
        self.con.commit()
        
        return self.cur.rowcount
    
    def update(self, e_id, e_que, e_ans1, e_ans2, e_ans3, e_ans4, e_ans):
        sql = f"""
            update exam set
                e_id = '{e_id}'
                , e_que = {e_que}
                ,     e_ans1 = {e_ans1}
                , e_ans2 = {e_ans2}
                , e_ans3 = {e_ans3}
                , e_ans4 = {e_ans4}
                , e_ans = {e_ans}
                
            where e_id = '{e_id}'
        """
    
        self.cur.execute(sql)
        self.con.commit()
        
        return self.con.rowcount
    
    def delete(self, e_id):
        sql = f"""
            delete from exam
            where e_id = '{e_id}'
        """
        
        self.cur.execute(sql)
        self.con.commit()
        
        return self.con.rowcount
    
    def __del__(self):
        self.cur.close()
        self.con.close()

if __name__ == '__main__':
    de = DaoExam()
    list = de.selectList()
    print(list)