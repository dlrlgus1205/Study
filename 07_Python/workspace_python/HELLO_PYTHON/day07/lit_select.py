import sqlite3
 
# SQLite DB 연결
con = sqlite3.connect("sample.db")
 
# Connection 으로부터 Cursor 생성
cur = con.cursor()
 
# SQL 쿼리 실행
cur.execute("select * from sample")
 
# 데이타 Fetch
rows = cur.fetchall()
print(rows)
 
# Connection 닫기
con.close()