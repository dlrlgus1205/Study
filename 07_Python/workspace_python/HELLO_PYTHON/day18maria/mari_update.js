var mysql = require('mysql');

var con = mysql.createConnection({
  host : 'localhost',  
  user : 'root',
  password : 'python',
  database : 'python',
  port : 3305
});

con.connect();

var e_name = 55;
var gen = 55;
var addr = 55;

var sql = `
	update emp set
	e_name = ${e_name}, gen = ${gen}, addr = ${addr}
	where e_id = 5;
`;
con.query(sql, function(err,rows, fields){
	console.log("rows", rows);
});

con.end();