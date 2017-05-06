<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

    1.db연결하는 구조 설정 -> maven project<br>
    2. 빈2개 로그인용, 게시물 용<br>
    3. jsp(로그인 처리) -> jsp(게시물 용)<br>
    	login-> loginProc -> bbs<br>
    	<br>
    	<br>
   model1의 서비스 흐름도 이해<br>
   <br>
   jsp자체에서 모든 처리를 담당<br>
   빠른개발, 초보자도 손쉽게 처리<br>
   java, html, jdbc처리등이 다 섞여 있어서 가독률이 떨어진다.<br>
   복잡하고, 유지보수가 쉽지 않다.