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

@WebServlet(name = "cs", description = "���� ��� ������", urlPatterns = { "/cs" })
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
		System.out.println("��� �ʱ�ȭ");
		
		//1.�ܰ� ����̹� �ε�
		try {
			Class.forName(driver);
			System.out.println("�ε强��");
			
			//����
			con=DriverManager.getConnection(url, user, password);
			if (con!=null) {
				System.out.println("���Ӽ���");
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("�ε����");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{				
			
		}
	}

	public void destroy() {
		System.out.println("��� ����");
		System.out.println("������� �ʱ�ȭ :  DB���� ����");
		try{
			if(con!=null){
				con.close();
				System.out.println("��������");
			}
		}catch(Exception e){			
			System.out.println("�����������");
		}		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("db���� ���࿹��");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
