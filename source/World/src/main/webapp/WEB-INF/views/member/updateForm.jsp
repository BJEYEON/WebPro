<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<article>
<div class="join3">
	<div class="join_title">회원정보 수정</div>
	<form method="post" name="joinForm" >
		<input type="hidden" name="command" value="edit">
		<div class="basic_box">
			<div class="basic_box_text">
				<label>아이디</label><br>
				<input type="text" name="id" value="${loginUser.id}" class="dup" readonly><input type="hidden" name="reid">
			    <label>비밀번호</label><br><input type="password" name="pwd" class="dup"><br> 
			    <label>비밀번호 확인</label><br><input type="password" name="pwdCheck" class="dup"><br>
			    <label>이름</label><br><input type="text" name="name" class="dup" value="${loginUser.name}"><br>
			    <label id=last>휴대폰 번호</label><input type="text" name="phone" class="dup" value="${loginUser.phone}"><br>
			   
			     <label>우편번호</label><br><input type="text" class="dup"  id="sample6_postcode"   name="zip_num" value="${dto.zip_num}"  style="width:400px; " readonly>      
			    <input type="button" onclick="sample6_execDaumPostcode()" class="dup" value="우편번호 찾기" style="width:140px; float:right; text-align:center" ><br>
				<label>주소</label><br>
						<input type="text" class="dup"  id="sample6_address"  size="50" name="address1"  value="${dto.address1}" readonly><br><br>
				<label>상세주소</label><br>
						<input type="text"  class="dup" id="sample6_detailAddress"  name="address2"   value="${dto.address2}" size="50"><br>
						<input type="text"  class="dup" id="sample6_extraAddress"  name="address3"   value="${dto.address3}" readonly><br>
				
				<label>이메일</label><br><input type="text" name="email" class="dup" value="${loginUser.email}"><br>
			</div>
		</div>
		<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		
		<script>
		    function sample6_execDaumPostcode() {
		        new daum.Postcode( {
		            oncomplete: function(data) {
		                var addr = '';
		                var extraAddr = ''; 
		                if (data.userSelectedType === 'R') { 
		                    addr = data.roadAddress;
		                } else { 
		                    addr = data.jibunAddress;
		                }

		                if(data.userSelectedType === 'R'){
		                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
		                        extraAddr += data.bname;
		                    }
		                    if(data.buildingName !== '' && data.apartment === 'Y'){
		                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
		                    }
		                    if(extraAddr !== ''){
		                        extraAddr = ' (' + extraAddr + ')';
		                    }
		                    document.getElementById("sample6_extraAddress").value = extraAddr;
		                
		                } else {
		                    document.getElementById("sample6_extraAddress").value = '';
		                }

		                document.getElementById('sample6_postcode').value = data.zonecode;
		                document.getElementById("sample6_address").value = addr;
		                document.getElementById("sample6_detailAddress").focus();
		            }
		        }).open();
		    }
		</script><br><br><br><br>
		<div class="join_buttons">
			<div class="join_buttons_text">
			    <input type="button" value="정보수정" class="join_submit" onclick="go_update();"> 
			    <input type="reset" value="취소" class="join_cancel">
			    <input type="button" value="회원탈퇴" class="join_cancel" onclick="go_delete();">
			</div>
		</div>
	</form>
</div>
</article>
<br><br><br>
<%@ include file="../footer.jsp" %>