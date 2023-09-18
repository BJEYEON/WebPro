<%@page import="com.lec.member.MemberDao"%>
<%@page import="com.lec.member.MemberDto"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%-- modifyOk.jsp에서 전달받은 파라미터: id, pw(바꾸고싶은 새비번), name, phone1, phone2, phone3, gender, email, address(MemberDto)
	oldPw(현비번), tempBirth (MemberDto에 없는 변수이름)
	--%>
	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.member.MemberDto"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		String tempBirth = request.getParameter("tempBirth");
		if(!tempBirth.equals("")){
			dto.setBirth(Date.valueOf(tempBirth));
		}
		MemberDto member = (MemberDto)session.getAttribute("member");
		String sessionPw = null;
		if(member!=null){
			sessionPw = member.getPw(); //member세션의pw
		}
		String oldPw = request.getParameter("oldPw");
		if(sessionPw.equals(oldPw)){
			//현비밀번호를 맞게 입력한 경우 정보 수정 진행
			if(dto.getPw() == null){ //새 비밀번호를 입력하지 않은 경우
				dto.setPw(oldPw); //새 비밀번호를 현 비밍번호롲
			}
			MemberDao mDao = MemberDao.getInstance();
			int result = mDao.modifyMember(dto);
			if(result == MemberDao.SUCCESS){
				//정보수정 성공
				session.setAttribute("member", dto);//수정된 정보를session속성으로도 수정
		%>
			<script>
				alert('정보수정이 완료되었습니다');
				location.href='main.jsp';
			</script>
		<% 	}else{ //수정실패%>
				<script>
					alert('정보수정이 실패 되었습니다. 정보가 너무 깁니다');
					location.href = 'modify.jsp';
				</script>
		<% 	}%>
		<% }else{ //현 비밀번호를 틀리게 입력한 경우 이전 페이지로%>
			<script>
				alert('현 비밀번호가 바르지 않습니다. 확인하세요');
				history.back();
			</script>
		<% }%>
	%>
</body>
</html>