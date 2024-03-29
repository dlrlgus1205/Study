import cx_Oracle
con = cx_Oracle.connect('python/py@localhost:1521/xe')
cur = con.cursor() 
e_id = 5
e_name = 5
gen = 5
addr = 5
sql = f"""
            insert into emp
                (e_id, e_name, gen, addr)
            values
                ('{e_id}','{e_name}','{gen}','{addr}')
    """

cur.execute(sql)
print(cur.rowcount)
con.commit()

cur.close()
con.close()