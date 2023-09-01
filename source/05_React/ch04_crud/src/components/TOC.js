import { Component } from "react";
class TOC extends Component{
    shouldComponentUpdate(newProps/* 이전props값*/){
        //this.props가 변경될 때만 render실행
        // console.log('현재값:', this.props.data, '이전값:', newProps.data);
        if(this.props.data === newProps.data){
            return false; //shouldComponentUpdate수행후 render를 실행 되지 않도록 약속
        }
        return true; //shouldComponentUpdate수행후 render를 실행
    }
    render(){
        console.log('TOC render 실행');
        var lists = [];
        var data =this.props.data;
        for (var i=0; i<data.length; i++){
            lists.push(<li key={data[i].id}>
                <a href={data[i].id + ".html"}
                onClick={function(id, e){
                    e.preventDefault();
                    this.props.onChangePage(id);
                }.bind(this, data[i].id)}>
                    {data[i].title}
                </a></li>);
        }
        return(
            <nav>
                <ul>
                    {lists}
                </ul>
            </nav>
        );
    }
}
export default TOC;