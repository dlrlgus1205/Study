let Animal = require('./animal.js');

let ani = new Animal();

console.log("x", ani.x);
console.log("y", ani.y);

ani.moveX(1);
ani.moveY(5);

console.log("x", ani.x);
console.log("y", ani.y);