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

@WebServlet(name = "dbConnect", description = "�����ͺ��̽� ���� �׽�Ʈ", urlPatterns = { "/dbConnect" })
public class DBTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DBTest() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//db���� Ȯ��
		DBConnInfo connInfo=new DBConnInfo();
		String driver=connInfo.getDriver();
		String url= connInfo.getUrl();
		String user = connInfo.getUser();
		String password=connInfo.getPassword();
		
		Connection con;
		PreparedStatement pstmt;
		
		//1.�ܰ� ����̹� �ε�
		try {
			Class.forName(driver);
			System.out.println("�ε强��");
			
			//����
			con=DriverManager.getConnection(url, user, password);
			if (con!=null) {
				System.out.println("���Ӽ���");
				//3.������ �ۼ�. ����
				
				//4. ���� ����	
				con.close();
				System.out.println("��������");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("�ε����");
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
