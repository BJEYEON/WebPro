var hong = {name:'hong', first:10, second:20};
var shin = {name:'shin', first:30, second:40};
first = 100;
second = 99;
function sum(prefix=' : '){ //prefix안써도 상관없음
    return prefix + (this.first + this.second);
}
console.log('외부 변수의 합 sum()', sum());
console.log('외부 변수의 합 sum("-")', sum('-'));
console.log('hong의 합 sum().call(hong)', sum.call(hong, '= ')); //sum내부의 this:hong
console.log('hong의 합 sum().call(hong)', sum.call(hong)); //sum내부의 this:hong
console.log('shin의 합 sum.call(shin, "~")', sum.call(shin, '~ '));
//**** */
var hongSum = sum.bind(hong); //this를 hong으로하는 새로운 함수
console.log('bind를 이용한 hong합', hongSum());
var shinSum = sum.bind(shin, "="); //this를 shin으로, prefix는 '='로 하는sum함수
console.log('bind를 이용한 shin합', shinSum());