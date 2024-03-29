var Mysql = require('sync-mysql');

class DaoEmp{
	constructor() {
		this.con = new Mysql({
			host : 'localhost',  
	  		user : 'root',
			password : 'python',
			database : 'python',
			port : 3305
		})
	}
	
	selectList(){
		var sql = `
			select
				e_id, e_name, gen, addr
			from
				emp
		`;

		return this.con.query(sql);
	}
	
	selectOne(e_id){
		var sql = `
			select
				e_id, e_name, gen, addr
			from
				emp
			where
				e_id = ${e_id}
		`;

		return this.con.query(sql)[0];
	}
	
	insert(e_id, e_name, gen, addr){
		var sql = `
			insert into emp
				(e_id, e_name, gen, addr)
			values(${e_id}, ${e_name}, ${gen}, ${addr})
		`;
		
		var result = this.con.query(sql);
	}
	
	update(e_name, gen, addr){
		var sql = `
			update emp set
			e_name = ${e_name}, gen = ${gen}, addr = ${addr}
			where e_id = 6;
		`;
		
		var result = this.con.query(sql);
	}
	
	delelte(e_id){
		var sql = `
			delete from emp
			where e_id = ${e_id};
		`;
		
		var result = this.con.query(sql);
	}
}

if(require.main == module){
	var de = new DaoEmp();
	var cnt = de.insert(7, 7, 7, 7);
	console.log("cnt", cnt);
}