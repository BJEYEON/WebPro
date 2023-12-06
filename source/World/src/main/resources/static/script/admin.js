function adminloginCheck(){  //관리자 로그인시 아이디 비번 입력 확인
	
	if(document.frm.id.value==""){
		   	alert("아이디를 입력하세요.");
		  	return false;
		}else if(document.frm.pwd.value==""){
		  	alert("비밀번호를 입력하세요.");
		   	return false;
		}else{
	document.frm.action = "adminlogin";
	document.frm.submit();
			return true;
		}  
}

function go_manage(comm){
	var url =  comm;   // 검색어로 검색한 결과의 1페이지로 이동
	document.frm.action = url;
	document.frm.submit();
}

function go_search(comm){
	 if( document.frm.key.value == "" ){
		alert("검색버튼 사용시에는 검색어 입력이 필수입니다");
	 	return;
	} 
	var url = comm + "?page=1";  
	document.frm.action = url;
	document.frm.submit();	
}

function go_total(comm ){
	document.frm.key.value = "";
	document.frm.action =  comm + "?page=1";  
	document.frm.submit();
}

function go_view( lqseq ){
	location.href = "adminQnaView?lqseq=" + lqseq;
}

function go_insertform(com){ 
	document.frm.action = com ;
	document.frm.submit();
}



//------ 공지사항 ------
function go_insertform(comm){ //공지추가 폼으로 이동
	document.frm.action = comm;
	document.frm.submit();
}

function go_insertnt(){ //공지추가 동작액션으로 이동
	if( document.insertnt.title.value==""){ 
		alert('제목을 입력하세요');
		document.insertnt.title.focus();
	}else if (document.insertnt.ncontent.value == "") {
		alert('공지할 사진을 입력하세요.'); 	
		document.insertnt.ncontent.focus();	
	}else{
	document.insertnt.action = "insertnotice";
	document.insertnt.submit();
	}
}

function go_detail(nseq){
	document.frm.action = "adminNoticeDetail?nseq=" + nseq;
	document.frm.submit();
}

function go_mov(com){ 
	location.href = com;
}

function go_deletent(nseq){ //공지 삭제
	if(confirm('정말 삭제하시겠습니까?')){
		var url="noticeDelete?nseq="+nseq;
		location.href=url;
	}
}

function go_modnt(nseq){ // 공지 수정폼으로 이동
	var url= "noticeUpdateForm?nseq=" + nseq;
	location.href=url;
}

function go_mod_savent(){ // 공지 수정 버튼 클릭
	if( document.frm.title.value==""){  
		alert('제목을 입력하세요');
		document.frm.title.focus();
	}else{
		if(confirm('수정하시겠습니까?')){
			document.frm.action = "noticeUpdate";
			document.frm.submit();
		}
	}
}

function goToDetail(nseq) {
	window.location.href = "/adminnoticeDetail?nseq=" + nseq;
}

// 놀이기구 ----------------------------------------------------------------------------
function go_insertat(){
	if( document.insertat.atname.value==""){ 
		alert('놀이기구 이름을 입력하세요');
		document.insertat.atname.focus();
		
	}else if (document.insertat.acontent.value == "") {
		alert('놀이기구 설명을 입력하세요.'); 	
		document.insertat.acontent.focus();	
		
	}else if (document.insertat.act1.value == "") {
		alert('카테고리 1을 입력하세요.'); 	
		document.insertat.act1.focus();	
		
	}else if (document.insertat.act2.value == "") {
		alert('카테고리 2를 입력하세요.'); 	
		document.inserinsertattnt.act2.focus();	
		
	}else if (document.insertat.image.value == "") {
		alert('놀이기구 사진을 입력하세요.'); 	
		document.insertat.image.focus();	
		
	}else if (document.insertat.acontent.value == "") {
		alert('놀이기구 설명을 입력하세요.'); 	
		document.insertat.acontent.focus();	
		
	}else if (document.insertat.pnum.value == "") {
		alert('탑승인원 입력하세요.'); 	
		document.insertat.pnum.focus();	
		
	}else if (document.insertat.limitkey.value == "") {
		alert('제한사항 1을 입력하세요'); 	
		document.insertat.limitkey.focus();	
		
	}else if (document.insertat.acontent.value == "") {
		alert('제한사항 2를 입력하세요'); 	
		document.insertat.acontent.focus();	
		
	}else if (document.insertat.bestat.value == "") {
		alert('놀이기구 베스트 정보를 설정하세요.'); 	
		document.insertat.bestat.focus();
		
	}else if (document.insertat.aresult.value == "") {
		alert('놀이기구 운휴 정보를 입력하세요.'); 	
		document.insertat.aresult.focus();			
	}else{
	document.insertat.action = "insertat";
	document.insertat.submit();
	}
	
}



// 놀이기구 수정
function go_modat(aseq){ // 놀이기구 수정폼으로 이동
	var url="adminUpdateAttractionForm?aseq="+aseq;
	location.href=url;
}

// 놀이기구 수정버튼 클릭
function go_mod_saveat(){
	if( document.updateat.atname.value==""){ 
		alert('놀이기구 이름을 입력하세요');
		document.updateat.atname.focus();
		
	}else if (document.updateat.acontent.value == "") {
		alert('놀이기구 설명을 입력하세요.'); 	
		document.updateat.acontent.focus();	
		
	}else if (document.updateat.act1.value == "") {
		alert('카테고리 1을 입력하세요.'); 	
		document.updateat.act1.focus();	
		
	}else if (document.updateat.act2.value == "") {
		alert('카테고리 2를 입력하세요.'); 	
		document.updateat.act2.focus();	
		
	}else if (document.updateat.acontent.value == "") {
		alert('놀이기구 설명을 입력하세요.'); 	
		document.updateat.acontent.focus();	
		
	}else if (document.updateat.pnum.value == "") {
		alert('탑승인원 입력하세요.'); 	
		document.updateat.pnum.focus();	
		
	}else if (document.updateat.limitkey.value == "") {
		alert('제한사항 1을 입력하세요'); 	
		document.updateat.limitkey.focus();	
		
	}else if (document.updateat.acontent.value == "") {
		alert('제한사항 2를 입력하세요'); 	
		document.updateat.acontent.focus();		
	}else{
		if(confirm('수정하시겠습니까?')){
		document.updateat.action = "updateat";
		document.updateat.submit();
		}
	}
}

//놀이기구 삭제
function go_deleteat(aseq){
if(confirm('정말 삭제하시겠습니까?')){
	var url="deleteat?aseq=" +aseq ;
	location.href=url;
	}
}



//답글달기
function go_rep(lqseq){
	document.frm.action="adminQnaRepSave";
	document.frm.submit();
}






// --------------------------------------------배너
function change_order( bseq ){
	var selectTag = document.getElementById(bseq);  
	// 각 SELECT 태그의 ID를 BSEQ 값으로 설정해 놓았습니다. 따라서 방금 값이 바뀐 SELECT  태그는 매개변수로 전달된
	// BSEQ 값으로 식별하여 selectTag 변수에 저장할 수 있습니다
	 
	var selectVal = selectTag.options[ selectTag.selectedIndex ].value;
	// 식별한 SELECT 태그의 선택된 인덱스값으로 선택된 값을 추출합니다
	
	location.href='change_order?bseq=' + bseq + '&changeval=' + selectVal;
	// BSEQ 와 바꾸려는 값을 갖고 change_order 리퀘스트로 이동합니다
}

function go_insertBanner(){
	if(document.frm.subject.value==""){
		alert("제목을 입력해주세요");
	}else if(document.frm.order_seq.value==""){
		alert("순서를 정해주세요");
	}else if(document.frm.image.value==""){
		alert("이미지를 골라주세요");
	}else{
		document.frm.action="bannerWrite";
		document.frm.submit();
	}
}
function go_deleteBanner(bseq){
if(confirm('정말 삭제하시겠습니까?')){
	var url="deleteBanner?bseq=" + bseq; 
	location.href=url;
	}
}


function reInsert(id, useyn){
	location.href="memberReinsert?id=" + id + "&useyn=" + useyn;
}



function go_adminOrderList(id, name){
	location.href="adminOrderList?id=" + id+"&name="+name;
}



function showConfirmationPopup(message, callback) {
    var confirmation = confirm(message);

    if (confirmation) {
        callback(true); // 예 선택 시 콜백 함수 호출
    } else {
        callback(false); // 아니오 선택 시 콜백 함수 호출
    }
}

function go_admin_return(name, id) {
	
	var count=0;
	if(document.frm.cseq.length==undefined){
		//체크박스가 한개인 경우
		if(document.frm.cseq.checked==true)
			count++;
	}else{
		for(var i=0; i<document.frm.cseq.length; i++){
			if(document.frm.cseq[i].checked==true)
			count++;
		}
	}
	if(count ==0){
			alert("환불할 항목을 선택하세요");
	}else if(count ==1){
	    showConfirmationPopup("정말 환불하시겠습니까?", function(result) {
	        if (result) {
	            alert("환불이 완료되었습니다");
	            document.frm.action = "adminRefund?id=" + id+"&name="+name;
	            document.frm.submit();
	        } else {
	            alert("취소되었습니다");
	            return;
	        }
	    });
    }else{
		alert("한번에 하나만 환불 가능합니다");
		return;
	}
}

