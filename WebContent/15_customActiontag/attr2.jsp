<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<u:dyAttr size="20" color="red" ch="#"/><!-- 속성을 써도 dynamic에서 처리하지 않으면 소용없다. -->
		<h3>속성을 부여한 커스텀 태그</h3>
	<u:dyAttr size="25" color="blue"/>
</body>
</html>