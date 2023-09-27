<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	
	<form action="">
		<tr>
			<td><input type="number" name="su1" value="<%=(int)(Math.random()*9+1)%>" readonly="readonly"></td>
			<td>*<input type="number" name="su2" value="<%=(int)(Math.random()*9+1)%>" readonly="readonly"></td>
			<td>=<input type="number" name="su3" ></td>
		</tr>
		<tr>
		<p>
			<td><input type="submit" value="확인" >
		</tr>
	</form>
	<p>
		${param.su1 } * ${param.su2 } = ${param.su3 }는
		${param.su1*param.su2 eq param.su3 }
		${not empty param.su3 ? (param.su1*param.su2 eq param.su3 ? "정답" : "오답") : "" }
</body>
</html>