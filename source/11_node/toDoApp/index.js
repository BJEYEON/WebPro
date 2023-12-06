const express = require('express'); //express라이브러리를 첨부
const app = express(); //express라이브러리를 이용한객체생성
//app.listen(서버를 띄울 포트번호8080, 서버 연동후 실행할 콜백함수)

const url = "mongodb+srv://jis12030:Y0zMH6wq4gA1n39E@cluster0.tmnd8fc.mongodb.net/?retryWrites=true&w=majority";
const MongoClient = require('mongodb').MongoClient;
var db;
MongoClient.connect(url, function(err, client){
    //몽고db연결 후 실행할 콜백 함수
    if(err){return console.log(err);}
    db = client.db('toDoApp');
    app.listen(8090, function(){
        console.log('listening on 8090');
    });
});


// app.get(요청경로, 요청이 들어올 경우 실행할 콜백함수)
// app.post(요청경로, 요청이 들어올 경우 실행할 콜백함수)
// app.put(요청경로, 요청이 들어올 경우 실행할 콜백함수)
// app.delete(요청경로, 요청이 들어올 경우 실행할 콜백함수)

app.use(express.static('public'));
app.set('view engine', 'ejs');
app.get('/', function(req,res){
    //res.sendFile(__dirname + '/index.html');
    res.render('index.ejs');
});

app.get('/write', (req, res)=>{
    //res.sendFile(__dirname + '/write.html');
    res.render('write.ejs');
});
app.use(express.urlencoded({extended:true})); //넘어온 파라미터 접근하기
app.post('/write', (req, res)=>{
    // 1. counter에서 post_sq를 가져옴
    db.collection('counter').findOne({name : '현재시퀀스'}, function(err, result){
        if(err) {return console.log(err);}
        //console.log(result);
        var post_sq = result.post_sq;
        //2. {_id:post_sq+1. title:req.body.title, date:req.body.date} 를 post에 insert
        db.collection('post').insertOne({_id:post_sq+1,
            title: req.body.title,
            date : req.body.date}, function(err, result){
            if(err) {return console.log(err);}
            // 3. counter의 post_sq를 1증가
            // updateOnde({조건}, {수정내용}, 콜백함수)
            // updateOnde({조건}, {${inc : {증가분}}, 콜백함수)
            // updateOnde({조건}, {${inc : {수정내용}}, 콜백함수)
            db.collection('counter').updateOne({name:'현재시퀀스'},
                                                {$inc: {post_sq:1}},
                                                function(err, result){
                if(err) {return console.log(err);}
                res.redirect('/list');    
            });
        });
    });
});
app.get('/list', (req, res)=>{
    
    //post에서 저장된 데이터로 view단(ejs)으로 출력
    db.collection('post').find().toArray(function(err, result){
        if(err) {return console.log(err);}
        //console.log(result);
        res.render('list.ejs', {posts:result}); //model.addAttribute("post", result) result가 배열임 여기선
    });
});
