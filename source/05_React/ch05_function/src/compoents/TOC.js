const TOC = props=>{
    var lists = [];
    var data = props.data;
    for (var i=0; i<data.length; i++){
        lists.push(<li key={data[i].id}>
            <a href="/" 
            data-id={data[i].id}
            id={data[i].id}
            onClick={function(e){
            e.preventDefault(); //본래a태그의 기능을 막음
            //props.onChangePage(data[i].id);
            props.onChangePage(Number(e.target.id));
        }}>
            {data[i].title}
            </a>
            </li>);
    }
    return (
        <nav>
            <ol>
                {lists}
            </ol>
        </nav>
    )
};
export default TOC;