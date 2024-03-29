var mysql = require('mysql');

var con = mysql.createConnection({
  host : 'localhost',  
  user : 'root',
  password : 'python',
  database : 'python',
  port : 3305
});

con.connect();

var sql = `
	select
		e_id, e_name, gen, addr
	from
		emp
`;
con.query(sql, function(err,rows, fields){
	console.log("rows", rows);
});

con.end();