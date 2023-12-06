function go_cart_delete(){
	//자바스크립트에서 jsp페이지내에 있는 동일한 name의 두개 이상의 입력란(input 태그) 들은 하나의 이름의 배열로 인식합니다
	//document.formm.cseq[]
	
	//그말은 곧 배열의 크기를 나타내는 length 속성이 존재한다는 뜻이며, 배열내의 요소 객수를 저장하고 있습니다.
	//만약 같은 내임으 input태그가 여러개가 아니고 한개만 존재하는 상태라면 length 값은 undefined가 됩니다.
	
	//아래에서 몇개의 체크박스가 체크되었는지 검사를 하는데,
	// 이때 체크박스가 한개냐 아니면 두개 이상이냐를 length 값으로 구분해서 체크 갯수를 카운트
	var count=0;
	if(document.formm.cseq.length==undefined){
		//체크박스가 한개인 경우
		if(document.formm.cseq.checked==true)
			count++;
	}else{
		//체크박스가 두개 이상인 겨우 반복실행문을 이용하여 모든 체크박스를 하나씩 점검하여 체크된 갯수 카운트
		for(var i=0; i<document.formm.cseq.length; i++){
			if(document.formm.cseq[i].checked==true)
			count++;
		}
	}

	if(count ==0){
			alert("삭제할 항목을 선택하세요");
	}else{
			document.formm.action="cartDelete";
			document.formm.submit();
			//jsp파일에 있는 체크된 체크박스 들의 벨류 (cseq값들)이 배열로 전송된다.
		}

	}
	
	
function go_order(){
	var count=0;
	if(document.formm.cseq.length==undefined){
		//체크박스가 한개인 경우
		if(document.formm.cseq.checked==true)
			count++;
	}else{
		for(var i=0; i<document.formm.cseq.length; i++){
			if(document.formm.cseq[i].checked==true)
			count++;
		}
	}

	if(count ==0){
			alert("결제할 항목을 선택하세요");
	}else if(count ==1){
			document.formm.action="cartOrder";
			document.formm.submit();
			//jsp파일에 있는 체크된 체크박스 들의 벨류 (cseq값들)이 배열로 전송된다.
	}else{
		alert("한번에 하나만 결제 가능합니다");
		return;
	}
}
	
function showConfirmationPopup(message, callback) {
    var confirmation = confirm(message);

    if (confirmation) {
        callback(true); // 예 선택 시 콜백 함수 호출
    } else {
        callback(false); // 아니오 선택 시 콜백 함수 호출
    }
}

function go_cart_return() {
	
	var count=0;
	if(document.formm.cseq.length==undefined){
		//체크박스가 한개인 경우
		if(document.formm.cseq.checked==true)
			count++;
	}else{
		for(var i=0; i<document.formm.cseq.length; i++){
			if(document.formm.cseq[i].checked==true)
			count++;
		}
	}
	if(count ==0){
			alert("환불할 항목을 선택하세요");
	}else if(count ==1){
	    showConfirmationPopup("정말 환불하시겠습니까?", function(result) {
	        if (result) {
	            alert("환불이 완료되었습니다");
	            document.formm.action = "cartRefund";
	            document.formm.submit();
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
	
function go_cartList(){
	alert("장바구니로 이동합니다!");
	document.formm.action = "cartList";
	document.formm.submit();
}	

function go_orderList(){
	
	document.formm.action = "orderList";
	document.formm.submit();
	
}







