<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 조건 -->
<c:if test="${param.num1-param.num2 >= 0}">
	결과=${param.num1-param.num2} : ${param.num1} 앞에값이 크다 ${param.num2}	
</c:if>
<!-- ""안에 공간이 있으면 안된다? -->
<c:if test="${param.num1-param.num2 < 0}">
	결과=${param.num1-param.num2} : ${param.num1} 앞에값이 작다 ${param.num2}	
</c:if>