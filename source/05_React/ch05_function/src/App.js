
import TOC from './compoents/TOC';
import Subject from './compoents/Subject';
import Control from './compoents/Control';
import ReadContent from './compoents/ReadContent';
import CreateContent from './compoents/CreateContent';
import { useState } from 'react';
import UpdateContent from './compoents/UpdateContent';
let maxId = 3;
function App() {
  //변수의 값이 바뀌면 rendering이 이루아져야할 변수(hooh이용 cf.class컴포넌트에서는 state)
  // const _mode = useState('read');
  // console.log(_mode);
  // const mode = _mode[0];
  // const setMode = _mode[1]; //상태(mode) 값을 변경할 때 사용할 함수
  const [mode, setMode] = useState('welcome');
  const [selectedId, setSelectedId] = useState(0);
  const [contents, setContents] = useState(
    [
       {id:1, title:'HTML', desc:'HTML is HyperText Markup Language.'},
       {id:2, title:'CSS', desc:'CSS is HyperText Markup Language.'},
       {id:3, title:'JS', desc:'DESC is HyperText Markup Language.'},
     ]
  );
  
  //redering과 무관한 변수
  
  const subject = "web";
  const welcome = {title:'Welcome', desc:'Hello, React!!'};
  let _article, _content = null;
  let getReadContent = () => {
    for(var i=0; i<contents.length; i++){
      if(contents[i].id === selectedId){
        return contents[i];
      }
    }
  }
  if(mode === 'welcome'){
    _article = <ReadContent title={welcome.title} desc={welcome.desc}></ReadContent>
  }else if (mode === 'read'){
    _content = getReadContent();
    //console.log('아래 출력될 content 객체:' , _content);
    _article = <ReadContent title={_content.title} desc={_content.desc}></ReadContent>
  }else if (mode === 'create'){
    _article = <CreateContent
                  onCreate = {(_title, _desc) => {
                    _content = {id:++maxId, title:_title, desc:_desc};
                    //console.log('추가할 데이터:', _content);
                    //let _contents = Array.from(contents); //복제
                    let _contents = [...contents]; //복제
                    _contents.push(_content);
                    setContents(_contents); //수행 후 자동rendering
                    setMode('read');
                    setSelectedId(maxId);
                  }}
                ></CreateContent>
  }else if (mode === 'update'){
    if(selectedId === 0){
      _article = <h4>수정할 데이터를 선택 후 update 기능을 이용허세요</h4>
    }else{
      //수정로직
      _content = getReadContent();
      _article = <UpdateContent
                      data={_content}
                      onUpdate = {(_id, _title, _desc)=>{
                        _content = {id:_id, title:_title, desc:_desc};
                        //console.log('수정할 데이터:', _content);
                        let _contents = Array.from(contents);//복제
                        for(var i=0; i<_contents.length; i++){
                          if(_contents[i].id === _id){
                            //_contents[i] = {id:_id, title:_title, desc:_desc};
                            _contents[i].title = _title;
                            _contents[i].desc = _desc;
                            break;
                          }//if
                        }//for - _contents 교체완료
                        setContents(_contents);
                        setMode('read');
                      }}
                  ></UpdateContent>
      
    }
    
  }
  return (
    <>
      <Subject title={subject} onChangePage = {function(){
        //alert('welcome모드로');
        //mode = 'welcome';에러
        setMode('welcome');
        //console.log('mode:', mode);//랜더링 안이우러짐
      }}></Subject>
      <TOC 
        data = {contents}
        onChangePage = {function(_id){
          setMode('read');
          setSelectedId(_id);
        }}

      ></TOC>
      <Control
        onChangeMode = {function(_mode){
          //alert(_mode);
          if (_mode === 'delete'){
            
            if(selectedId!== 0 && window.confirm('삭제시 복구 불가. 삭제하시겠습니까?')){
              //삭제로직
              let _contents = Array.from(contents); //복제
              for(var i=0; i<_contents.length; i++){
                if(_contents[i].id === selectedId){
                  // 지울 데이터 : _contents[i]
                  _contents.splice(i,1); //i번째1개제거
                  setContents(_contents); //hook변경
                  if(_contents.length > 0){ //_contents.length가 1이상: read모드
                    setMode('read'); //hook변경
                    setSelectedId(_contents[0].id); //맨처음으로
                    //setSelectedId(_contents[_contents.length-1].id);//마지막
                  }else{ //_content.length 가 0 :welcome모드
                    setMode('welcome');
                    setSelectedId(0);
                  }//if- 모드 변경
                  break;
                }//if
              }//for
            }else if (selectedId===0){
              alert('삭제할 데이터를 선택 후 delete하세요')
            }
          }else{
            setMode(_mode); //create, update모드
          }
        }}
      ></Control>
      {_article}
      
    </>
  );
}

export default App;
