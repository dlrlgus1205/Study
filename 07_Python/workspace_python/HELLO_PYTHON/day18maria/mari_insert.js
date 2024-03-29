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
var e_name = 5;
var gen = 5;
var addr = 5;

var sql = `
	insert into emp(e_id, e_name, gen, addr)
	value(${e_id}, ${e_name}, ${gen}, ${addr})
`;
con.query(sql, function(err,rows, fields){
	console.log("rows", rows);
});

con.end();