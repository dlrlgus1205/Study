import sqlite3

class DaoExam:
    def __init__(self):
        self.con = sqlite3.connect("exam.db")
        self.cur = self.con.cursor() 
        
    def selectList(self):
        sql = """
            select 
                e_id,que,ans1,ans2,ans3,ans4,ans
            from 
                exam
        """
        
        self.cur.execute(sql)
        list = self.cur.fetchall()
        ret = []
        for e in list:
            ret.append({'e_id':e[0],'que':e[1],'ans1':e[2],'ans2':e[3],'ans3':e[4],'ans4':e[5],'ans':e[6]})
        
        return ret
        
        
    def selectOne(self,e_id):
        sql = f"""
            select 
                e_id,que,ans1,ans2,ans3,ans4,ans
            from 
                exam
            where
                e_id = '{e_id}'
        """
        
        self.cur.execute(sql)
        vo = self.cur.fetchone()

        return {'e_id':vo[0],'que':vo[1],'ans1':vo[2],'ans2':vo[3],'ans3':vo[4],'ans4':vo[5],'ans':vo[6]}
        
    def insert(self,e_id,que,ans1,ans2,ans3,ans4,ans):
        sql = f"""
                insert into exam 
                    (e_id,que,ans1,ans2,ans3,ans4,ans)
                values 
                    ('{e_id}','{que}','{ans1}','{ans2}','{ans3}','{ans4}','{ans}')
            """
        self.cur.execute(sql)
        self.con.commit()
        return self.cur.rowcount
        
    def update(self,e_id,que,ans1,ans2,ans3,ans4,ans):
        sql = f"""
            update exam
            set
                que = '{que}',
                ans1 = '{ans1}',
                ans2 = '{ans2}',
                ans3 = '{ans3}',
                ans4 = '{ans4}',
                ans = '{ans}'
            where
                e_id = '{e_id}'
        """
        self.cur.execute(sql)
        self.con.commit()
        return self.cur.rowcount
    
    def delete(self,e_id):
        sql = f"""
            delete from exam
            where
                e_id = '{e_id}'
        """
        self.cur.execute(sql)
        self.con.commit()
        return self.cur.rowcount
        
    def __del__(self):
        self.cur.close()
        self.con.close()
        
        
if __name__ == '__main__':
    de = DaoExam()
    cnt = de.delete('4')
    print(cnt)
        
        
        
        
        
        