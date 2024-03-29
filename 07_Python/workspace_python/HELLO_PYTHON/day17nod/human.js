let Animal = require('./animal.js');

class Human extends Animal {
	constructor() {
		super();
		this.skill_cook = 0;
	}
	element(){
		this.skill_cook++;
	}
}

module.exports = Human;