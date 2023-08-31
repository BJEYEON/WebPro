import './App.css';
import { Component } from 'react';
import TOC from './components/TOC';
import ReadContent from './components/ReadContent';
import Subject from './components/Subject';
class App extends Component{
  constructor(props){
    super(props);
    this.state = {
      mode: 'read', 
      selected_content_id : 2,
      subject : {title:'web', sub:'world wide web'},
      Content: [
        {id:1, title:'html11', desc: 'html is hypertect markup language.'},
        {id:2, title:'css', desc: 'css os for design'},
        {id:3, title:'javascript', desc: 'javascript is for interactive'},
        {id:4, title:'react', desc: 'react id for ui'}
      ],
      welcome : {title:'welcome', desc:'hellow, react!'},
    };
  }
  render(){
    console.log('app render수행');
    var _title, _desc , _article= null;
    if (this.state.mode === 'welcome'){
      _title = this.state.welcome.title;
      _desc = this.state.welcome.desc;
      _article = <ReadContent title={_title} desc={_desc}></ReadContent>;

    }else if(this.state.mode === 'read'){
      // var data = this.state.Content[this.state.selected_content_id -1]; //id번호 가져오기
      // _title = data.title;
      // _desc = data.desc;
      for(var i=0; i<this.state.Content.length; i++){
        var data = this.state.Content[i];
        if(data.id === this.state.selected_content_id){
          _title = data.title;
          _desc = data.desc;

          break;
        }
      }//for
      _article = <ReadContent title={_title} desc={_desc}></ReadContent>;
    }else if(this.state.mode === 'create'){
      //_article = <CreateContent></CreateContent>
    }else if(this.state.mode === 'update'){
      //_article = <CreateContent></CreateContent>
    }
    return (
      <div className='App'>  
        <Subject title={this.state.subject.title} 
                 sub={this.state.subject.sub}
                 onChangePage={function(){
                  this.setState({
                    mode:'welcome'
                  });
                 }.bind(this)} ></Subject> 
        {/* <header>
          <h2>
            <a href="/" onClick={function(e){
              e.preventDefault(); //태그의 기본동작방법 막음
              // this.state.mode를 'welcome'으로
              //this.state.mode = 'welcome'; state값을 변경하려면 setState()함수이용
              this.setState({
                mode : 'welcome',
              });
              // console.log(this);
              // debugger;
            }.bind(this)}>
            {this.state.subject.title}
            </a>
            </h2>
          {this.state.subject.sub}
      </header> */}
        <TOC data={this.state.Content}
            onChangePage={function(id){
              this.setState({
                mode : 'read',
                selected_content_id : Number(id) ,
              });
            }.bind(this)} ></TOC>
        {_article}
      </div>
    );
  }
}
export default App;
