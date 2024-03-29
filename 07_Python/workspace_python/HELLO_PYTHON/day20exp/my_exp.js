const express = require('express')
const bodyParser = require('body-parser');
const ejs = require('ejs')

const app = express()
const port = 3000

app.use(bodyParser.urlencoded({extended : true}));
app.set('view engine', 'ejs');
app.set('views', './views');

app.get('/param', (req, res) => {
	var menu = req.param('menu');
	
	res.send('param:' + menu);
})

app.post('/post', (req, res) => {
	var menu = req.body.menu;
	
	res.send('post' + menu);
})

app.get('/forw', (req, res) => {
	var a = "홍길동";
	var b = ["전우치", "며루치"];
	res.render('forw', {a : a, b: b});
})

app.get('/emp', (req, res) => {
	var de = new DaoEmp();
	var list = de.selectList();
	
	res.render('emp',{list:list});
})

app.listen(port, () => {
	console.log(`Example app listening on port ${port}`)
})