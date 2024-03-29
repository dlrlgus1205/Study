const express = require('express')
const bodyParser = require('body-parser');
const ejs = require('ejs')

const app = express()
const port = 3000

app.use('/static', express.static(__dirname + '/static'));
app.use(bodyParser.urlencoded({extended : true}));
app.set('view engine', 'ejs');
app.set('views', './views');

app.get('/', (req, res) => {
	res.send('Hello World!');
	res.redirect('static/jq01.html')
})

app.post('ajax/', (req, res) => {
	res.send('Hello World!');
	res.json({'result' : 'success'})
})

app.post('ajax/', (req, res) => {
	res.send('Hello World!');
	res.json({'result' : 'success'})
})

app.listen(port, () => {
	console.log(`Example app listening at http://localhost:${port}`)
})