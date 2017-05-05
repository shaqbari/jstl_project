<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="i" begin="1" end="10">
	<font size="${i} }">hi</font><br>
</c:forEach>

<c:forEach var="name" items="${NAME}">
	<li>${name}</li>
</c:forEach>