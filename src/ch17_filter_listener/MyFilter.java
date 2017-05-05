package ch17_filter_listener;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(description = "���� ����", urlPatterns = { "/MyFilter" })
public class MyFilter implements Filter {

    public MyFilter() {
    	System.out.println("���ͻ�����");
    }
	public void destroy() {
		System.out.println("���� �Ҹ�");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("���� ����(��û, ����)");
		//������ ������ MyServlet���� ���� ����
		
		System.out.println("["+request.getParameter("uid")+"]");
		//if(request.getParameter("uid")==null){
		if(request.getParameter("uid").length()==0){
			//������
			RequestDispatcher rd= request.getRequestDispatcher("/17_filter_listener/acessError.jsp");
			rd.forward(request, response);
		}
		
		//Ư������ ���Ե� ��û�� �ƴϸ� �ش� �������� �� �� ����.
		
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("���� �ʱ�ȭ");
	}

}
