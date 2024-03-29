import sqlite3
 
con = sqlite3.connect("sample.db")
 
cur = con.cursor()
sql = "insert into sample(col01, col02,col03) values (3, 3, 3)"
cur.execute(sql)
con.commit()
 
con.close()