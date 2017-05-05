<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String names[]={"ABC", "123", "가나다"};
	request.setAttribute("NAME", names);
%>
<jsp:forward page="for.jsp"></jsp:forward>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>	
	<form action="send01.jsp">
		<input type="text" name="num1">
		<input type="text" name="num2">
		<input type="submit" value="send01전송">
	</form>
	<form action="send02.jsp">
		<input type="text" name="num1">
		<input type="text" name="num2">
		<input type="submit" value="send02전송">
	</form>
	<form action="if.jsp">
		<input type="text" name="num1">
		<input type="text" name="num2">
		<input type="submit" value="if전송">
	</form>
	<form action="choose.jsp">
		<input type="text" name="num1">
		<input type="text" name="num2">
		<input type="submit" value="choose전송">
	</form>
</body>
</html>