<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${param.num1>param.num2}">
		크다
	</c:when>
	<c:when test="${param.num1>param.num2}">
		작다
	</c:when>
	<c:otherwise>
		같다.
	</c:otherwise>
</c:choose>