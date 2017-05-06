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
 * Ç®¸µÅ×½ºÆ®
 * @author sakba
 *
 */
@WebServlet(name = "pt", description = "Ä¿³Ø¼Ç Ç®¸µ Å×½ºÆ®", urlPatterns = { "/pt" })
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
				System.out.println("Ä¿³Ø¼Ç Ç®·ÎºÎÅÍ Ä¿³Ø¼Ç °´Ã¼ È¹µæ");				
			}
			
			
		} catch (NamingException e) {
			e.printStackTrace();
			System.out.println("Ä¿³Ø¼Ç °´Ã¼ È¹µæ ¿À·ù");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//¹Ý³³
			if(con!=null){
				try {
					con.close();
					System.out.println("Ä¿³Ø¼Ç Ç®ºÎÅÍ Ä¿³Ø¼Ç °´Ã¼ ¹Ý³³");
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
