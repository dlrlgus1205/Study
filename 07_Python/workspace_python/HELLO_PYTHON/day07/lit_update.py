import sqlite3
 
con = sqlite3.connect("sample.db")
 
cur = con.cursor()
sql = "update sample set col02 = 6, col03 = 6 where col01 = 3"
cur.execute(sql)
con.commit()
 
con.close()