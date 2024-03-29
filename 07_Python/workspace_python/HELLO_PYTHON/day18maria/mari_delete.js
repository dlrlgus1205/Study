var mysql = require('mysql');

var con = mysql.createConnection({
  host : 'localhost',  
  user : 'root',
  password : 'python',
  database : 'python',
  port : 3305
});

con.connect();

var e_id = 5;

var sql = `
	delete from emp
	where e_id = ${e_id};
`;
con.query(sql, function(err,rows, fields){
	console.log("rows", rows);
});

con.end();