<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- ���� -->
<c:if test="${param.num1-param.num2 >= 0}">
	���=${param.num1-param.num2} : ${param.num1} �տ����� ũ�� ${param.num2}	
</c:if>
<!-- ""�ȿ� ������ ������ �ȵȴ�? -->
<c:if test="${param.num1-param.num2 < 0}">
	���=${param.num1-param.num2} : ${param.num1} �տ����� �۴� ${param.num2}	
</c:if>