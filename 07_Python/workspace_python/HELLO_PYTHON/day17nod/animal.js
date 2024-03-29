class Animal {
	constructor() {
		this.x = 0;
		this.y = 0;
	}

	moveX(x){
		this.x += x;
	}
	
	moveY(y){
		this.y += y;
	}
}

module.exports = Animal;

if (require.main === module) {
	let ani = new Animal();
	console.log("x", ani.x);
	console.log("y", ani.y);
	
	ani.moveX(1);
	ani.moveY(5);
	
	console.log("x", ani.x);
	console.log("y", ani.y);
}
