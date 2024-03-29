import cx_Oracle
con = cx_Oracle.connect('python/py@localhost:1521/xe')
cur = con.cursor() 
e_id = 5
e_name = 6
gen = 6
addr = 6
sql = f"""
            update emp set
                e_name = '{e_name}',
                gen = '{gen}',
                addr ='{addr}'
            where e_id = '{e_id}'
    """

cur.execute(sql)
print(cur.rowcount)
con.commit()

cur.close()
con.close()