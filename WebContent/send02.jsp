<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="n1" value="${param.num1}" scope="request"></c:set>
<c:set var="n2" value="${param.num2}" scope="request"></c:set>
<jsp:forward page="result01.jsp"></jsp:forward>