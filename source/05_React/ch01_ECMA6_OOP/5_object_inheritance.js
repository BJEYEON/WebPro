let superobj = {name : '손웅정'};
// let subobj = {age :32};
// subobj.__proto__ = superobj; //superobj의 name속성이 subobj로 상속
let subobj = Object.create(superobj); //객체끼리상속
subobj.age = 32;

console.log('superobj.name', superobj.name);

console.log('subobj.name', subobj.name);
console.log('subobj.__proto__.name: ', subobj.__proto__.name);
console.log('subobj.age:' , subobj.age);
debugger; //브라우저에서 일시중지하면서 객체 상태를 모니터링 
subobj.name = '손흥민';
console.log('subobj.name', subobj.name);
console.log('subobj.__proto__.name: ', subobj.__proto__.name);
console.log('subobj.age:' , subobj.age);
debugger; //일시중지