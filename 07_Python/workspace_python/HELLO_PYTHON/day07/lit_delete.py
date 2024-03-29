import sqlite3
 
con = sqlite3.connect("sample.db")
 
cur = con.cursor()
sql = "delete from sample where col01 = 3"
cur.execute(sql)
con.commit()
 
con.close()