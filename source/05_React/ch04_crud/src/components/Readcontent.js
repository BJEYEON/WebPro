import { Component } from "react";

class Readcontent extends Component{
    render(){
        return(
            <article>
                <h1>{this.props.title}</h1>
                {this.props.desc}
            </article>
        );
    }
}
export default Readcontent;