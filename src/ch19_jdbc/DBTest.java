package ch19_jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "dbConnect", description = "데이터베이스 접속 테스트", urlPatterns = { "/dbConnect" })
public class DBTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DBTest() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//db접속 확인
		DBConnInfo connInfo=new DBConnInfo();
		String driver=connInfo.getDriver();
		String url= connInfo.getUrl();
		String user = connInfo.getUser();
		String password=connInfo.getPassword();
		
		Connection con;
		PreparedStatement pstmt;
		
		//1.단계 드라이버 로드
		try {
			Class.forName(driver);
			System.out.println("로드성공");
			
			//접속
			con=DriverManager.getConnection(url, user, password);
			if (con!=null) {
				System.out.println("접속성공");
				//3.쿼리문 작성. 수행
				
				//4. 연결 종료	
				con.close();
				System.out.println("연결종료");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("로드실패");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{				
			
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
