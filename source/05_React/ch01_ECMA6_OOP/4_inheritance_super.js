class person{
    constructor(name, first, second){ //생성자 함수의 이름은 무조건 constructor
        //console.log('생성자 함수 호출');
        this.name = name;
        this.first = first;
        this.second = second;
    }
    sum(){
        return this.first + this.second;
    }
}//class
var hong = new person("홍길동", 10, 90);
console.log('hong의 sum: ' + hong.sum());
class personplus extends person{
    constructor(name, first, second, third){
        super(name, first, second); //super():부모클래스 생성자 함수
        this.third = third;
    }
    sum(){
        return super.sum() + this.third; // super.sum(): 부모 클래스의 sum()
    }
    avg(){
        return this.sum()/3;
    }

}
var hong = new person("홍길동", 10, 90);
console.log('hong의 sum: ' + hong.sum());
var son = new personplus('손흥민', 100, 100, 100);
console.log('손 sum: ', son.sum());
console.log('손 avg: ', son.avg());