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
	${user.uid}�� �ݰ����ϴ�.<br>
	<table border="1">
		<thead>
			<tr>
				<td>�۹�ȣ</td>
				<td>�ۼ���</td>
				<td>����</td>
				<td>����</td>
				<td>�����</td>
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
			System.out.println("Ŀ�ؼ� Ǯ�κ��� Ŀ�ؼ� ��ü ȹ��");				
		}
		
		//���̵� ��� �̿��� ���� ����		
		String sql="select * from tbl_board order by bno asc";
		
		//������ ����
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
		System.out.println("Ŀ�ؼ� ��ü ȹ�� ����");
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		//�ݳ�
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
				System.out.println("Ŀ�ؼ� Ǯ���� Ŀ�ؼ� ��ü �ݳ�");
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