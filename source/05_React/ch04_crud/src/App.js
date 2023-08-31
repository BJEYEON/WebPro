import './App.css';
import { Component } from 'react';
import TOC from './components/TOC';
import Readcontent from './components/Readcontent';
import Subject from './components/Subject';
class App extends Component{
  constructor(props){
    super(props);
    this.state = {
      mode:'read',
      selceted_content_id : 2,
      Subject: {title:'web', sub:'world wide web'},
      Content: [
        {id:1, title:'HTML', desc: 'html is hypertect markup language.'},
        {id:2, title:'css', desc: 'css os for design'},
        {id:3, title:'javascript', desc: 'javascript is for interactive'},
        {id:4, title:'react', desc: 'react id for ui'}
      ],
      welcome: {title:'welcome', desc:'hellow, react!'},
      };
    }
  
  render(){
    var _title, _desc, _article = null;
    if (this.state.mode === 'welcome'){
      _title = this.state.welcome.title;
      _desc = this.state.welcome.desc;
      _article = <Readcontent title={_title} desc={_desc}></Readcontent>;

    }else if (this.state.mode === 'read'){
      for (var i=0; i<this.state.Content.length; i++){
        var data = this.state.Content[i];
        if (data.id === this.state.selceted_content_id){
          _title = data.title;
          _desc = data.desc;
          break;
        }
      }//for
      _article = <Readcontent title={_title} desc={_desc}></Readcontent>;
    }else if (this.state.mode === 'create'){
      //_article = <CreateContent></CreateContent>
    }else if(this.state.mode === 'update'){
      //_article = <CreateContent></CreateContent>
    }
    
    return(
      <div className='App'>
         <Subject title={this.state.Subject.title}
                  sub={this.state.Subject.sub}
                  onChangePage={function(){
                    this.setState({
                      mode:'welcome'
                    });
                  }.bind(this)} ></Subject>
        <TOC data={this.state.Content}
            onChangePage={function(id){
              this.setState({
                mode: 'read', 
                selceted_content_id: Number(id),
              });
            }.bind(this)}></TOC>
        {_article}
      </div>
    );
  }
}


export default App;
