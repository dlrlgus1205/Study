import cx_Oracle

con = cx_Oracle.connect('python/py@localhost:1521/xe')

#JDBC statement 느낌 한방에 데이터 넘김 자바는 하나하나 넘겨줬었음
cur = con.cursor() 

cur.execute("select * from emp")

rows = cur.fetchall()
print(rows)
    
cur.close()    
con.close()