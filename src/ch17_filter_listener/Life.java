package ch17_filter_listener;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "life", description = "����������Ŭ", urlPatterns = { "/life" })
public class Life extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Life() {
        super();
        
        System.out.println("���� ��ü ����");
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("���� �ʱ�ȭ");
	}
	public void destroy() {
		System.out.println("���� �Ҹ�");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("���� ��û");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
