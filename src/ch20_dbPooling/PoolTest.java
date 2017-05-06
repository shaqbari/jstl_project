package ch20_dbPooling;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
/**
 * Ǯ���׽�Ʈ
 * @author sakba
 *
 */
@WebServlet(name = "pt", description = "Ŀ�ؼ� Ǯ�� �׽�Ʈ", urlPatterns = { "/pt" })
public class PoolTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con;
	
    public PoolTest() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		
	}

	public void destroy() {
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
			
			
		} catch (NamingException e) {
			e.printStackTrace();
			System.out.println("Ŀ�ؼ� ��ü ȹ�� ����");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//�ݳ�
			if(con!=null){
				try {
					con.close();
					System.out.println("Ŀ�ؼ� Ǯ���� Ŀ�ؼ� ��ü �ݳ�");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
