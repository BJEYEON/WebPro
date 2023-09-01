import './App.css';
import { Component } from 'react';
import Readcontent from './components/Readcontent';
import Subject from './components/Subject';
import TOC from './components/TOC';
import Control from './components/Control';
import CreateContent from './components/CreateContent';
import UpdateContent from './components/UpdateContent';
class App extends Component{
  constructor(props){
    super(props);
    this.maxId = 4; //state에 넣으면 불필요한 rendering이루어짐
    this.state = {
      mode:'welcome',
      selceted_content_id : 0,
      Subject: {title:'web', sub:'world wide web'},
      contents: [
        {id:1, title:'HTML', desc: 'html is hypertect markup language.'},
        {id:2, title:'css', desc: 'css os for design'},
        {id:3, title:'javascript', desc: 'javascript is for interactive'},
        {id:4, title:'react', desc: 'react id for ui'}
      ],
      welcome: {title:'welcome', desc:'hellow, react!'},
      };
    }
    getReadContent(){
      for (var i=0; i<this.state.contents.length; i++){
        var data = this.state.contents[i];
        if (data.id === this.state.selceted_content_id){
          return data;
        }
      }//for
    }
    getContent(){
      var _title, _desc, _article, _content = null;
      if (this.state.mode === 'welcome'){
        _title = this.state.welcome.title;
        _desc = this.state.welcome.desc;
        _article = <Readcontent title={_title} desc={_desc}></Readcontent>;
  
      }else if (this.state.mode === 'read'){
        _content = this.getReadContent();
        _article = <Readcontent title={_content.title} desc={_content.desc}></Readcontent>;
      }else if (this.state.mode === 'create'){
        _article = <CreateContent
                    onSubmitCreate = {function(_title, _desc){
                      this.maxId ++;
                      //alert(this.maxId + '/' +_title + '/' + _desc);
                      //_title과 _desc로 {id:5, title:_title, desc:_desc}를 this.state.contents추가
                      
                      _content = {id:this.maxId, title:_title, desc:_desc}; //content에 추가할 객체
                      //비추천
                      //this.state.Content.push(_content);
                      //-----------------------------------
                      // this.setState({
                      //   Content : this.state.Content,
                      // });
                      //비추천
                      var _contents = Array.from(this.state.contents); //복제
                      _contents.push(_content);
                     // var _contents = this.state.Content.push(_content); // this.state.contents변경안됨
                      this.setState({
                        contents :_contents,
                        mode : 'read',
                        selceted_content_id :this.maxId,
                      });
                    }.bind(this)}
                    ></CreateContent>
      }else if(this.state.mode === 'update'){
        _content = this.getReadContent();
        if (_content){
          _article = <UpdateContent data={_content}
                        onSubmitUpdate={function(_id, _title, _desc){
                          _content = {id:Number(_id), title:_title, desc:_desc};//바꿀내용
                          //alert(_id + ', 수정된title:' + _title + ', desc:' + _desc);
                          var _contents = Array.from(this.state.contents); //성능 튜닝할 지 모르니 복제
                          for (var i=0; i<_contents.length; i++){
                            if(_contents[i].id === Number(_id)){
                              _contents[i] = _content;
                              console.log(i, '번째 수정완료 수정된 데이터는', _contents[i]);
                              break;
                            }
                          }
                          this.setState({
                            contents : _contents, //원본 교체
                            mode : 'read',
                          });
                        }.bind(this)}
                      ></UpdateContent>
        }else{
          //alert('수정할 데이터를 선택 후 수정하세요');
          this.setState({
            mode:'welcome',
            welcome : {title:'수정유의사항', desc:'수정할 데이터를 선택 후 수정하세여'},

          });
        }
      }
      return _article;
    }
  
  render(){
    console.log('render');
    
    return(
      <div className='App'>
         <Subject title={this.state.Subject.title}
                  sub={this.state.Subject.sub}
                  onChangePage={function(){
                    this.setState({
                      mode:'welcome'
                    });
                  }.bind(this)} ></Subject>
        <Control 
          onChangeMode = {function(_mode){
            if(_mode === 'delete'){
              if(this.state.selceted_content_id!== 0 && window.confirm('정말로 삭제하시겠습니까?')){
                //selected_content_id가 id인 content 삭제
                var _contents = [...this.state.contents];
                for (var i=0; i<_contents.length; i++){
                  if(_contents[i].id === this.state.selceted_content_id){
                    _contents.splice(i, 1); //i번째부터1개 지움
                    alert(this.state.selceted_content_id + '데이터 삭제 완료');
                    break;
                  }//if
                }//for
                this.setState({
                  contents: _contents,
                  mode: 'welcome',
                  selceted_content_id:0,
                });
              }else if(this.state.selceted_content_id===0){
                alert('삭제할 데이터를 선택 후 삭제하세요');
              }


            }else{
              this.setState({
                mode : _mode,
              });
            }
            //state의 값을 바꾸려면 setstate이용
          }.bind(this)}
        ></Control>
        <TOC data={this.state.contents}
            onChangePage={function(id){
              this.setState({
                mode: 'read', 
                selceted_content_id: Number(id),
              });
            }.bind(this)}></TOC>
        {this.getContent()}
      </div>
    );
  }
}


export default App;
