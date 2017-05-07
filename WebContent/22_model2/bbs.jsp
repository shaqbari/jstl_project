<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	${user.uid}님 반갑습니다.<br>
	<!-- 게시물 내용 -->
	<table border="1">
		<thead>
			<tr>
				<td>글번호</td>
				<td>작성자</td>
				<td>제목</td>
				<td>내용</td>
				<td>등록일</td>
			</tr>
		</thead>
		<tbody>	
			<c:forEach var="board" items="${bbs}">
				<tr>
					<td>${board.bno}</td>
					<td>${board.writer}</td>
					<td>${board.title}</td>
					<td>${board.content}</td>
					<td>${board.regdate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>