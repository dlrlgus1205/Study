var mysql = require('sync-mysql');

var con = new mysql({
  host : 'localhost',  
  user : 'root',
  password : 'python',
  database : 'python',
  port : 3305
});

var e_id = 6;
var e_name = 6;
var gen = 6;
var addr = 6;

var sql = `
	insert into emp
		(e_id, e_name, gen, addr)
	value(${e_id}, ${e_name}, ${gen}, ${addr})
`;

var result = con.query(sql);

console.log("result", result);