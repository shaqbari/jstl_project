<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="java.sql.*"
    import="java.io.IOException"
    import="javax.naming.*"
    import="javax.sql.DataSource"
    import="ch21_model1.*"
    %>
<%!
Connection con;
PreparedStatement pstmt;
ResultSet rs;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	${user.uid}님 반갑습니다.<br>
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
<%
	try {
		Context initCtx=new InitialContext();
		Context envCtx=(Context) initCtx.lookup("java:comp/env");
		DataSource ds=(DataSource) envCtx.lookup("jdbc/java");
		con=ds.getConnection();
		if (con!=null) {
			System.out.println("커넥션 풀로부터 커넥션 객체 획득");				
		}
		
		//아이디 비번 이용해 쿼리 수행		
		String sql="select * from tbl_board order by bno asc";
		
		//쿼리를 수행
		pstmt=con.prepareStatement(sql);	
		rs=pstmt.executeQuery();		
		while(rs.next()){
%>
			<tr>
				<td><%=rs.getInt("bno")%></td>
				<td><%=rs.getString("writer")%></td>
				<td><%=rs.getString("title")%></td>
				<td><%=rs.getString("content")%></td>
				<td><%=rs.getString("regdate")%></td>
			</tr>
<%	
		}
	} catch (NamingException e) {
		e.printStackTrace();
		System.out.println("커넥션 객체 획득 오류");
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		//반납
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
				System.out.println("커넥션 풀부터 커넥션 객체 반납");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
%>		
		</tbody>
	</table>	
</body>
</html>