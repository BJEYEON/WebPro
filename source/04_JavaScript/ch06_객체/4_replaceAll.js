// var str = '안녕00방가00좋은 수요일00내일은 목요일'; // 00-> x교체
// console.log('원본:', str);
// var str_split = str.split('00');
// console.log('분할된 str:', str_split);
// var str_join = str_split.join('x');
// console.log('join된 str: ', str_join);

function replaceAll(str, str_old, str_new){ //str안에 str_old을 str_new로 교체한 문자 return
    // let str_split = str.str_split(str_old);
    // let joinResult = str_split.joinResult(str_new);
    // return joinResult;
    return str.split(str_old).join(str_new);
}
var str_replace = replaceAll('안녕xx방가xx잘가xx', 'xx', ',');
console.log(str_replace);