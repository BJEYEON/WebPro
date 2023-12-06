function go_next(){
	// 자바스크립트에서 jsp 페이지 내의 radio 버튼을 바라볼때, 같은 name의 okon 인것이 여러개라면 
	// name  값에 의한 배열로 자동 인식되어 사용됩니다.
	// 동의함 버튼 : okon[0],  동의안함  버튼 : okon[1]
	
	if( document.contractFrm.okon[1].checked == true ){
		// 동의 안함이 선택되었다면
		alert('회원 약관에 동의 하셔야 회원으로 가입이 가능합니다');
	}else{
		document.contractFrm.action = "/joinForm";
		document.contractFrm.submit();
		// contractFrm 폼에  action 도 없고 submit 버튼도 없는 것을 스크립트 명령으로 action 값을 설정하고 
		// submit() 메서드로 이동까지 실행합니다
	}
}


function loginCheck(){
	if(document.loginFrm.id.value==""){
		alert("아이디는 필수 입력사항 입니다");
		document.loginFrm.id.focus();
		return false;
	}else if(document.loginFrm.pwd.value==""){
		alert("비밀번호 필수 입력사항 입니다");
		document.loginFrm.pwd.focus();
		return false;
	}else{
		document.loginFrm.action = "login";
		document.loginFrm.submit();
		return true;
	}
}

function go_contract(){
	document.loginFrm.action = "/contract";
	document.loginFrm.submit();
}



function go_save(){
	if(document.joinForm.id.value==""){
		alert("아이디는 필수 입력사항 입니다");
		document.joinForm.id.focus();
	}else if(document.joinForm.reid.value != document.joinForm.id.value){
		alert("아이디 중복확인을 하지 않았습니다");		
		document.joinForm.id.focus();
	} else if(document.joinForm.pwd.value == "") {
	    alert("비밀번호를 입력해 주세요.");	    
	    document.joinForm.pwd.focus();
	} else if(document.joinForm.pwd.value != document.joinForm.pwdCheck.value) {
	    alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");	    
	    document.joinForm.pwd.focus();
	}else if(document.joinForm.name.value == "") {
	    alert("이름을  입력해 주세요.");	    
	    document.joinForm.name.focus();
	}else if(document.joinForm.phone.value == "") {
		alert("전화번호를  입력해 주세요.");	    
	    document.joinForm.phone.focus();
	}else{
		document.joinForm.action = "/join";
	    document.joinForm.submit();
	    }
	
}


function idcheck(){
	if( document.joinForm.id.value=="" ){
		alert("아이디를 입력하고 중복체크를 진행하세요" );
		documnet.joinForm.id.focus();
		return;
	}
	var url = "idCheckForm?id=" + document.joinForm.id.value;
	var opt = "toolbar=no, menubar=no, resizable=no, width=500, height=250, scrollbars=no";
	window.open(url, "IdCheck", opt);	
}


function post_zip(){
	var url ="world.do?command=findZipNum";
	var opt ="toolbar=no, menubar=no, scrollbars=no, resizable=no, width=550,";
	opt=opt+"height=300, top=300, left=300";
	window.open(url,"우편번호찾기",opt);
}

function result(zip_num, sido, gugun, dong){
	//  함수 호출 형태 - result( '123-123', '서울시', '서대문구',  '대현동')
	opener.document.joinForm.zip_num.value=zip_num;
	opener.document.joinForm.address1.value=sido+" "+gugun+" "+dong;
	self.close();
}

function idok( userid ){
	opener.joinForm.id.value = userid;
	opener.joinForm.reid.value = userid;
	self.close();
}



function go_update(){
	if(document.joinForm.pwd.value == "") {
	    alert("비밀번호를 입력해 주세요.");
	    document.joinForm.pwd.focus();
	}else if ((document.joinForm.pwd.value != document.joinForm.pwdCheck.value)) {
	    alert("비밀번호가 일치하지 않습니다.");
	    document.joinForm.pwd.focus();
	}else if (document.joinForm.name.value == "") {
	    alert("이름을 입력해 주세요.");
	    document.joinForm.name.focus();
	} else if (document.joinForm.phone.value == "") {
	    alert("이메일을 입력해 주세요.");
	    document.joinForm.phone.focus();
	}else {
	    document.joinForm.action = "memberUpdate";
	    document.joinForm.submit();
	}
}

function go_delete(){
	var a = confirm("정말로 탈퇴하시겠습니까?");
	if(a){
		location.href='deleteMember';
	}
}

function find_Id() {
   if (document.formm.name.value === "") {
      alert("이름을 입력해 주세요.");
      document.formm.name.focus();
   } else if (document.formm.phone.value === "") {
      alert("전화번호를 입력해 주세요.");
      document.formm.phone.focus();
   } else {
      document.formm.action = "re";
      document.formm.submit();
   }
}

function find_Pwd() {
   if (document.formm.id.value === "") {
      alert("아이디을 입력해 주세요.");
      document.formm.id.focus();
   } else if (document.formm.name.value === "") {
      alert("이름을 입력해 주세요.");
      document.formm.name.focus();
   } else if (document.formm.phone.value === "") {
      alert("전화번호를 입력해 주세요.");
      document.formm.phone.focus();
   } else {
      document.formm.action = "re2";
      document.formm.submit();
   }
}

function checkPwd() {
   if (document.joinForm.pwd.value === "") {
      alert("비밀번호를 입력해 주세요.");
      document.joinForm.pwd.focus();
   } else if (document.joinForm.pwd.value !== document.joinForm.pwdCheck.value) {
      alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
      document.joinForm.pwd.focus();
   } else {
      document.joinForm.action = "re3";
      document.joinForm.submit();
      
   }
}

function findId() {
   let url = "selectId";
   let opt = "toolbar=no, menubar=no, resizable=no, scrollbars=no, width=550, height=300, top=300, left=300";
   window.open(url, "아이디(ID) 찾기", opt);
}

function findPwd() {
   let url = "selectPwd";
   let opt = "toolbar=no, menubar=no, resizable=no, scrollbars=no, width=550, height=400, top=300, left=300";
   window.open(url, "비밀번호 찾기", opt);
}

function resetPwd(){
	document.formm.action = "resetPwdForm";
	document.formm.submit();
}

