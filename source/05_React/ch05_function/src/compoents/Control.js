import './Control.css';
const Control = props =>{
    return (
        <ul className="control">
            <li>
            <button onClick={function(){
                props.onChangeMode('create');
            }}>
                CREATE
            </button>
            </li>
            <li>
                <button onClick={function(){
                    props.onChangeMode('update');
                }}>
                    UPDATE
                </button>
            </li>
            <li>
                <button onClick={function(){
                    props.onChangeMode('delete');
                }}>
                    DELETE
                </button>
            </li>
        </ul>
    )
};
export default Control;