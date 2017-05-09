package ch23_hybridApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/JoinProc")
public class JoinProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con; 
	PreparedStatement pstmt;
	
    public JoinProc() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Context initCtx=new InitialContext();
			Context envCtx=(Context) initCtx.lookup("java:comp/env");
			DataSource ds=(DataSource) envCtx.lookup("jdbc/java");
			con=ds.getConnection();
			if (con!=null) {
				System.out.println("Ä¿³Ø¼Ç Ç®·ÎºÎÅÍ Ä¿³Ø¼Ç °´Ã¼ È¹µæ");				
			}
			
			//¾ÆÀÌµð ºñ¹ø ÀÌ¿ëÇØ Äõ¸® ¼öÇà		
			String sql="insert into tbl_user(user_no, user_id) values(seq_tbl_user.nextVal, ?, ?)";
			
			//Äõ¸®¸¦ ¼öÇà
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("uid"));
			pstmt.setString(2, request.getParameter("upw"));
			int result=pstmt.executeUpdate();
			if (result==1) {
				request.setAttribute("code", "1");
			}else{
				request.setAttribute("code", "0");
								
			}
			
		} catch (NamingException e) {
			e.printStackTrace();
			System.out.println("Ä¿³Ø¼Ç °´Ã¼ È¹µæ ¿À·ù");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
			
			RequestDispatcher rd=request.getRequestDispatcher("/23_hybridApp/joinOk.jsp");
			rd.forward(request, response);
		}
		
	}	

}
