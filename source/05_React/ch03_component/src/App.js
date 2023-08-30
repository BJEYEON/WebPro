import './App.css';
import { Component } from 'react';
class App extends Component{
  render(){
    return (
      <div className='App'>
        hello
        <Subject></Subject>
      </div>
    )
  }
}

class Subject extends Component{
    render(){
      return(<header>
          <h1>web</h1>
          world wide web! 
          {/* 주석 */}
      </header>);
    }
}
export default App;
