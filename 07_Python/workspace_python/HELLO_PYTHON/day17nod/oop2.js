let Human = require('./human.js');

let hum = new Human();

console.log("x", hum.x);
console.log("y", hum.y);
console.log("skill_cook", hum.skill_cook);

hum.moveX(1);
hum.moveY(5);
hum.element();

console.log("x", hum.x);
console.log("y", hum.y);
console.log("skill_cook", hum.skill_cook);