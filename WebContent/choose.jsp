<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${param.num1>param.num2}">
		ũ��
	</c:when>
	<c:when test="${param.num1>param.num2}">
		�۴�
	</c:when>
	<c:otherwise>
		����.
	</c:otherwise>
</c:choose>