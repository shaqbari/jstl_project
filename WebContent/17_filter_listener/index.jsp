<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	Hello 필터
	<form action="/jstl_project/MyServlet"> <!-- 서블릿에 정보보낼때는 /프로젝트명/.class파일의 이름을 써야한다. -->
		<input type="text" name="uid">
		<input type="submit" value="전송">		
	</form>
</body>
</html>