import { Component } from "react";

class UpdateContent extends Component{
    constructor(props){
        super(props);
        this.state = {
            id : this.props.data.id,
            title : this.props.data.title,
            desc : this.props.data.desc,
        };
        this.inputFormHandler = this.inputFormHandler.bind(this);
    }
    inputFormHandler(e){
    //console.log(e.target.value);
     this.setState({
        [e.target.name]:e.target.value,
});
    }
    render(){
        return (
            <article>
                <h2>UPDATE</h2>
                <form onSubmit={function(e){
                  e.preventDefault();
                //   console.log(e.target.title.value);
                //   console.log(e.target.desc.value);
                //   debugger;
                  //this.props.onSubmitUpdate( e.target.id.value,e.target.title.value,e.target.desc.value);
                    this.props.onSubmitUpdate(this.state.id, this.state.title, this.state.desc);
                }.bind(this)}>
                    <p><input 
                    type="hidden"name="id" defaultValue={this.props.data.id}/></p>

                    <p><input type="text" 
                    name="title" 
                    //defaultValue={this.props.data.title}
                    value={this.state.title}
                    onChange={this.inputFormHandler}
                    /></p>
                    <p><textarea 
                        name="desc" 
                        //defaultValue={this.props.data.desc}
                        value={this.state.desc}
                        onChange={this.inputFormHandler}
                        ></textarea></p>

                    <p><input type="submit" value="수정"/></p>
                </form>
            </article>
        );
    }
}
export default UpdateContent;