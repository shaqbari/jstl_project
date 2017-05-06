package ch19_jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "cs", description = "서블릿 디비 연결폼", urlPatterns = { "/cs" })
public class ConnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DBConnInfo connInfo=new DBConnInfo();
	String driver=connInfo.getDriver();
	String url= connInfo.getUrl();
	String user = connInfo.getUser();
	String password=connInfo.getPassword();
	
	Connection con=null;
	
    public ConnServlet() {
  
    	
    }
	public void init(ServletConfig config) throws ServletException {
		System.out.println("디비 초기화");
		
		//1.단계 드라이버 로드
		try {
			Class.forName(driver);
			System.out.println("로드성공");
			
			//접속
			con=DriverManager.getConnection(url, user, password);
			if (con!=null) {
				System.out.println("접속성공");
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("로드실패");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{				
			
		}
	}

	public void destroy() {
		System.out.println("디비 해제");
		System.out.println("멤버변수 초기화 :  DB연결 종료");
		try{
			if(con!=null){
				con.close();
				System.out.println("연결종료");
			}
		}catch(Exception e){			
			System.out.println("연결종료실패");
		}		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("db쿼리 수행예정");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
