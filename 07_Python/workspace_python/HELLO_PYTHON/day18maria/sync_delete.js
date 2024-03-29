var mysql = require('sync-mysql');

var con = new mysql({
  host : 'localhost',  
  user : 'root',
  password : 'python',
  database : 'python',
  port : 3305
});

var e_id = 6;

var sql = `
	delete from emp
	where e_id = ${e_id};
`;

var result = con.query(sql);

console.log("result", result);