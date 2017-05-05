package ch17_filter_listener;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "life", description = "∂Û¿Ã«¡ªÁ¿Ã≈¨", urlPatterns = { "/life" })
public class Life extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Life() {
        super();
        
        System.out.println("º≠∫Ì∏¥ ∞¥√º ª˝º∫");
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("º≠∫Ì∏¥ √ ±‚»≠");
	}
	public void destroy() {
		System.out.println("º≠∫Ì∏¥ º“∏Í");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("º≠∫Ì∏¥ ø‰√ª");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
