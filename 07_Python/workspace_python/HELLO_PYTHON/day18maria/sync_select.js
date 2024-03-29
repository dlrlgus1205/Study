var mysql = require('sync-mysql');

var con = new mysql({
  host : 'localhost',  
  user : 'root',
  password : 'python',
  database : 'python',
  port : 3305
});


var sql = `
	select
		e_id, e_name, gen, addr
	from
		emp
`;

var result = con.query(sql);

console.log("result", result);