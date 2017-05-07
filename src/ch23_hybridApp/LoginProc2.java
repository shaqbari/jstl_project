package ch23_hybridApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

@WebServlet(description = "·Î±×ÀÎ Ã³¸®", urlPatterns = { "/LoginProc2" })
public class LoginProc2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;   
   
    public LoginProc2() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			
			//model
			User dto=null;
			
			if(rs.next()){
				dto=new User();
				dto.setIdx(rs.getInt("user_no"));
				dto.setUid(rs.getString("user_id"));
				dto.setUpw(rs.getString("user_pw"));
				dto.setRegdate(rs.getString("user_regdate"));
			}
			
			if(dto==null){
				RequestDispatcher rd=request.getRequestDispatcher("23_hybridApp/login.html");
				rd.forward(request, response);
				
			}else{		
				request.setAttribute("user", dto);
				RequestDispatcher rd=request.getRequestDispatcher("23_hybridApp/loginOk.jsp");
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
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
