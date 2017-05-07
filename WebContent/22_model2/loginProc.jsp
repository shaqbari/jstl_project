<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="java.sql.*"
    import="java.io.IOException"
    import="javax.naming.*"
    import="javax.sql.DataSource"
    import="ch21_model1.*"
    %>
<!-- ·Î±×ÀÎ Á¤º¸¸¦ °¡Áö°í ºó¿¡ ´ã°í, db¿¡ ¿¬°áÇÏ¿© È¸¿øÀÎÁö È®ÀÎÇÏ´Â Äõ¸® ¼öÇà -->
<%!
Connection con;
PreparedStatement pstmt;
ResultSet rs;
%>
<%
	try {
		Context initCtx=new InitialContext();
		Context envCtx=(Context) initCtx.lookup("java:comp/env");
		DataSource ds=(DataSource) envCtx.lookup("jdbc/java");
		con=ds.getConnection();
		if (con!=null) {
			System.out.println("Ä¿³Ø¼Ç Ç®·ÎºÎÅÍ Ä¿³Ø¼Ç °´Ã¼ È¹µæ");				
		}
		
		//¾ÆÀÌµð ºñ¹ø ÀÌ¿ëÇØ Äõ¸® ¼öÇà		
		String sql="select * from tbl_user where user_id=? and user_pw=?";
		
		//Äõ¸®¸¦ ¼öÇà
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, request.getParameter("uid"));
		pstmt.setString(2, request.getParameter("upw"));
		rs=pstmt.executeQuery();
		
		User dto=null;
		
		if(rs.next()){
			dto=new User();
			dto.setIdx(rs.getInt("user_no"));
			dto.setUid(rs.getString("user_id"));
			dto.setUpw(rs.getString("user_pw"));
			dto.setRegdate(rs.getString("user_regdate"));
		}
		
		if(dto==null){
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			
		}else{		
			request.setAttribute("user", dto);
			RequestDispatcher rd=request.getRequestDispatcher("bbs.jsp");
			rd.forward(request, response);
		}
	} catch (NamingException e) {
		e.printStackTrace();
		System.out.println("Ä¿³Ø¼Ç °´Ã¼ È¹µæ ¿À·ù");
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		//¹Ý³³
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
				System.out.println("Ä¿³Ø¼Ç Ç®ºÎÅÍ Ä¿³Ø¼Ç °´Ã¼ ¹Ý³³");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
%>