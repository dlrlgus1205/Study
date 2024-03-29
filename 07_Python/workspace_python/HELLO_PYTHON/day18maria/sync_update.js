var mysql = require('sync-mysql');

var con = new mysql({
  host : 'localhost',  
  user : 'root',
  password : 'python',
  database : 'python',
  port : 3305
});

var e_name = 66;
var gen = 66;
var addr = 66;

var sql = `
	update emp set
	e_name = ${e_name}, gen = ${gen}, addr = ${addr}
	where e_id = 6;
`;

var result = con.query(sql);

console.log("result", result);