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

@WebServlet(description = "�α��� ó��", urlPatterns = { "/LoginProc2" })
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
				System.out.println("Ŀ�ؼ� Ǯ�κ��� Ŀ�ؼ� ��ü ȹ��");				
			}
			
			//���̵� ��� �̿��� ���� ����		
			String sql="select * from tbl_user where user_id=? and user_pw=?";
			
			//������ ����
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
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
