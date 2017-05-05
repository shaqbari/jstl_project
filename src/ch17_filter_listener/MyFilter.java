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

@WebFilter(description = "나의 필터", urlPatterns = { "/MyFilter" })
public class MyFilter implements Filter {

    public MyFilter() {
    	System.out.println("필터생성자");
    }
	public void destroy() {
		System.out.println("필터 소멸");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("필터 구현(요청, 응답)");
		//세션이 없으면 MyServlet으로 갈수 없다
		
		System.out.println("["+request.getParameter("uid")+"]");
		//if(request.getParameter("uid")==null){
		if(request.getParameter("uid").length()==0){
			//포워딩
			RequestDispatcher rd= request.getRequestDispatcher("/17_filter_listener/acessError.jsp");
			rd.forward(request, response);
		}
		
		//특정값이 포함된 요청이 아니면 해당 페이지로 갈 수 없다.
		
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("필터 초기화");
	}

}
